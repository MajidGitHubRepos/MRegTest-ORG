package ca.queensu.cs.outlook;


import ca.queensu.cs.controller.Controller;
import ca.queensu.cs.testing.RegressionTesting;
import ca.queensu.cs.testing.TestingEngine;
import ca.queensu.cs.umlrtParser.UmlrtParser;
import ca.queensu.cs.umlrtParser.UmlrtParser.RunnableImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.awt.*;
import java.awt.PageAttributes.OriginType;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.util.FileSystemUtils;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;



public class MReplayerPanel {

	private JFrame frame;
	private JTextField InstrumentedModelAddress;
	private JButton btnTraceFile;
	private JTextField traceAddress;
	private JLabel lblTraceFile;
	private static  String orgModelPath;

	public  static  String modelPath_mutations;
	public  static  String mutantsPath_mutations;
	public  static  String mutantsPath_checker;
	public  static  String modelPath_checker;
	public  static  String testCasesPath_checker;
	



	private static  String tracePath;
	private static String instrumentedModelAddress;
	public  static  String reportPath;
	private static  String modifiedModelPath;
	private static  String collectedTracePath;
	private static  int numConsistentOrdering;
	private ReplayerRunnable replyerRunnable = new ReplayerRunnable();

	private Timer timer_mutation;
	private Timer timer_checker;
	//private JButton startButton;
	private LongTask task_genMutations;
	private LongTask task_checker;
	//private JTextArea taskOutput;
	private String newline = "\n";
	public final static int ONE_SECOND = 1000;
	private JTextField textField_ORGModel;




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MReplayerPanel window = new MReplayerPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	/**
	 * Create the application.
	 */
	public MReplayerPanel() {
		initialize();
		orgModelPath = "";

	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 619, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 619, 394);
		frame.getContentPane().add(tabbedPane);
		task_genMutations = new LongTask();




		
		task_checker = new LongTask();
		
		
		
		
		

		JPanel MReplayerPanel = new JPanel();
		MReplayerPanel.setToolTipText("");
		tabbedPane.addTab("MReplayer", null, MReplayerPanel, null);
		MReplayerPanel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setBounds(300, 199, 124, 24);
		
		for (int i = 0; i < 16; i++)
			comboBox.addItem(String.valueOf(i+1));
		
		
		
		MReplayerPanel.add(comboBox);

		JLabel lblInstrumentedFile = new JLabel("Inst. Model File  :");
		MReplayerPanel.add(lblInstrumentedFile);
		lblInstrumentedFile.setFont(new Font("Dialog", Font.BOLD, 12));
		lblInstrumentedFile.setBounds(66, 41, 153, 19);


		InstrumentedModelAddress = new JTextField();
		MReplayerPanel.add(InstrumentedModelAddress);
		InstrumentedModelAddress.setFont(new Font("Dialog", Font.PLAIN, 16));
		InstrumentedModelAddress.setText(FileSystemView.getFileSystemView().getHomeDirectory().toString());
		InstrumentedModelAddress.setBounds(210, 38, 252, 23);

		InstrumentedModelAddress.setColumns(10);


		JButton btnInstrumentedModelFile = new JButton("Browse");
		MReplayerPanel.add(btnInstrumentedModelFile);
		btnInstrumentedModelFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser("./src/main/resources/umlrtModels");

				jfc.setDialogTitle("Specify a file to save instrumented model");
				int returnValue = jfc.showSaveDialog(MReplayerPanel);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File fileToSave = jfc.getSelectedFile();
					InstrumentedModelAddress.setText(fileToSave.getAbsolutePath());
					System.out.println("Save as file: " + fileToSave.getAbsolutePath());
					instrumentedModelAddress = fileToSave.getAbsolutePath();
				}

			}
		});
		btnInstrumentedModelFile.setBounds(474, 38, 87, 25);

		btnTraceFile = new JButton("Browse");
		MReplayerPanel.add(btnTraceFile);
		btnTraceFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser("./src/main/resources/umlrtModels");

				jfc.setDialogTitle("Specify a file to save traces");
				int returnValue = jfc.showSaveDialog(MReplayerPanel);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File fileToSave = jfc.getSelectedFile();
					traceAddress.setText(fileToSave.getAbsolutePath());
					System.out.println("Save as file: " + fileToSave.getAbsolutePath());
					tracePath = fileToSave.getAbsolutePath();
				}
			}
		});
		btnTraceFile.setBounds(474, 65, 87, 25);
		
		JButton btnReplayer = new JButton(" Replay");
		btnReplayer.setEnabled(false);

		traceAddress = new JTextField();
		MReplayerPanel.add(traceAddress);
		traceAddress.setText("/home/babaei");
		traceAddress.setFont(new Font("Dialog", Font.PLAIN, 16));
		traceAddress.setColumns(10);
		traceAddress.setBounds(210, 65, 252, 23);
		
		JScrollPane scrollPane_mreplayer = new JScrollPane((Component) null);
		scrollPane_mreplayer.setBounds(23, 247, 554, 92);
		MReplayerPanel.add(scrollPane_mreplayer);
		
		JTextArea textArea_mreplayer = new JTextArea();
		scrollPane_mreplayer.setViewportView(textArea_mreplayer);
		textArea_mreplayer.setRows(5);
		textArea_mreplayer.setMargin(new Insets(5, 5, 5, 5));
		textArea_mreplayer.setEditable(false);
		textArea_mreplayer.setBounds(0, 0, 551, 89);
		

		lblTraceFile = new JLabel("Collected Trace File :");
		MReplayerPanel.add(lblTraceFile);
		lblTraceFile.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTraceFile.setBounds(41, 68, 176, 19);

		JButton btnWebServer = new JButton("WebServer");
		btnWebServer.setEnabled(false);
		btnWebServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Thread WebServerT = new Thread(replyerRunnable);
				WebServerT.start();
				
				textArea_mreplayer.append("Webservice engine is started successfully!" + newline + newline);
				textArea_mreplayer.setCaretPosition(
				textArea_mreplayer.getDocument().getLength());
				btnReplayer.setEnabled(true);
				comboBox.setEnabled(true);

			}
		});
		MReplayerPanel.add(btnWebServer);
		btnWebServer.setBounds(450, 133, 112, 25);

		JButton btnOrder = new JButton("PreProcess");
		btnOrder.setEnabled(false);
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.startController("");
				
		
				textArea_mreplayer.append("Static analysis on "+ orgModelPath +" is performed successfully!" + newline+  newline);
				textArea_mreplayer.setCaretPosition(
				textArea_mreplayer.getDocument().getLength());
				
				
				 try {
						Thread.sleep(300);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				textArea_mreplayer.append("Static analysis is done successfully" + newline+ newline);
				textArea_mreplayer.setCaretPosition(
				textArea_mreplayer.getDocument().getLength());
				 
				
				btnWebServer.setEnabled(true);
			}
		});
		MReplayerPanel.add(btnOrder);
		btnOrder.setBounds(319, 133, 119, 25);

		JButton btnCollect = new JButton("Trace Collect");
		btnCollect.setEnabled(false);
		btnCollect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.startCollector();
				
				textArea_mreplayer.append("Trace collector engine is started successfully!" + newline+ newline);
				textArea_mreplayer.setCaretPosition(
				textArea_mreplayer.getDocument().getLength());
				
				btnOrder.setEnabled(true);
			}
		});
		btnCollect.setBounds(172, 133, 135, 25);
		MReplayerPanel.add(btnCollect);
		
		JButton btnInstrumenter = new JButton("Instrument");
		btnInstrumenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//textArea_mreplayer.append("Model-instrumentation is in progress ..." + newline+ newline);
					//textArea_mreplayer.setCaretPosition(
					//textArea_mreplayer.getDocument().getLength());
					
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textArea_mreplayer.append("Model-instrumentation has been done successfully!" + newline);
				textArea_mreplayer.append("Instrumented model: " + instrumentedModelAddress +newline+ newline);
				textArea_mreplayer.setCaretPosition(
				textArea_mreplayer.getDocument().getLength());
				
				String[] values = orgModelPath.split("\\.uml");
				int index = values[0].lastIndexOf('/');
				String mainAddress_src = values[0].substring(0, index+1);
				
				String[] values1 = instrumentedModelAddress.split("\\.uml");
				int index1 = values1[0].lastIndexOf('/');
				String mainAddress_dst = values1[0].substring(0, index1+1);

				File dest = new File(mainAddress_dst);
				if (orgModelPath.contains("DiningPhilosophers")) {
					File src = new File(mainAddress_src+"../ModelsForTesting/InstumentedFiles/DiningPhilosophers/");
					try {
						FileSystemUtils.copyRecursively(src, dest);
					} catch (IOException e1) {
					    e1.printStackTrace();
					}
				}
				
				btnCollect.setEnabled(true);
			}
		});
		btnInstrumenter.setBounds(41, 133, 124, 25);
		MReplayerPanel.add(btnInstrumenter);
		
		
		btnReplayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//TODO: delete this block later
				
				 
			    modifiedModelPath = orgModelPath;
			    numConsistentOrdering = comboBox.getSelectedIndex();
				TestingEngine testingEngine = new TestingEngine();
				Thread t1 = new Thread(testingEngine.new RunnableImpl()); 
				t1.start(); 
				
				
				textArea_mreplayer.append("Consistent Ordering ["+ comboBox.getSelectedItem() +"] is selected" + newline +newline);
				textArea_mreplayer.setCaretPosition(
				textArea_mreplayer.getDocument().getLength());
				
				textArea_mreplayer.append("A descrption of the model is sent to the webserver successfull!" + newline +newline);
				textArea_mreplayer.setCaretPosition(
				textArea_mreplayer.getDocument().getLength());
				
				//--
				
			}
		});
		btnReplayer.setBounds(102, 199, 176, 25);
		MReplayerPanel.add(btnReplayer);
		
		JPanel panel_engines = new JPanel();
		panel_engines.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Executable Engines", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel_engines.setBounds(31, 98, 546, 71);
		MReplayerPanel.add(panel_engines);
		
		JPanel panel_consistent_orderings = new JPanel();
		panel_consistent_orderings.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Consistent Orderings", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel_consistent_orderings.setBounds(31, 170, 546, 71);
		MReplayerPanel.add(panel_consistent_orderings);
		
		JTextArea textArea_consisten_ordering = new JTextArea();
		textArea_consisten_ordering.setText("1");
		textArea_consisten_ordering.setEditable(false);
		textArea_consisten_ordering.setRows(1);
		textArea_consisten_ordering.setMargin(new Insets(5, 5, 5, 5));
		textArea_consisten_ordering.setBounds(290, 199, 106, 23);
		MReplayerPanel.add(textArea_consisten_ordering);
		
		JLabel lblORGModelFile = new JLabel("Original Model File  :");
		lblORGModelFile.setFont(new Font("Dialog", Font.BOLD, 12));
		lblORGModelFile.setBounds(41, 15, 187, 19);
		MReplayerPanel.add(lblORGModelFile);
		
		textField_ORGModel = new JTextField();
		textField_ORGModel.setText("/home/babaei");
		textField_ORGModel.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_ORGModel.setColumns(10);
		textField_ORGModel.setBounds(210, 12, 252, 23);
		MReplayerPanel.add(textField_ORGModel);
				
		JButton btnORGModelFile = new JButton("Browse");
		btnORGModelFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser("./src/main/resources/umlrtModels");
				jfc.setDialogTitle("Select a model");
				jfc.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("uml", "uml");
				jfc.addChoosableFileFilter(filter);

				int returnValue = jfc.showDialog(null, "Load");
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					textField_ORGModel.setText(jfc.getSelectedFile().getPath());
					orgModelPath = jfc.getSelectedFile().getPath().toString();
					System.out.println(" Original Model loaded from : "+ orgModelPath);
				}
				
			}
		});
		btnORGModelFile.setBounds(474, 12, 87, 25);
		MReplayerPanel.add(btnORGModelFile);
	}



	class ReplayerRunnable extends JComponent implements Runnable {
		public ReplayerRunnable() {
		}
		public void run() {
			Controller.startReplayer("");	    
		}
	}

	public static String getOrgModelPath() {
		return orgModelPath;
	}
	public static String getTracePath() {
		return tracePath;
	}
	public static String getModifiedModelPath() {
		return modifiedModelPath;
	}
	public static int getConsistentOrdering() {
		return numConsistentOrdering;
	}
	public static String getCollectedTracePath() {
		return collectedTracePath;
	}
}

class LongTask {
	private int lengthOfTask;
	private int current = 0;
	private boolean done = false;
	private boolean canceled = false;
	private String statMessage = "";
	private String inputs = "";
	private String selectedModelPath = "";
	private String selectedMutantsPath = "";
	private String selectedJSONPath = "";
	private String mainAddress = "";
	public ArrayList <String> allMutantsFileName;
	private String reportFilePath = ""; 
	private String testCasePathFile = "";
	private String mutantsPathFile = "";


	public LongTask() {
		//Compute length of task...
		//In a real program, this would figure out
		//the number of bytes to read or whatever.
		lengthOfTask = 1000;
		allMutantsFileName = new ArrayList<>();
	}

	/**
	 * Called from ProgressBarDemo to start the task.
	 */
	public void go_mutantsGenerator() {
		final SwingWorker worker = new SwingWorker() {
			public Object construct() {
				current = 0;
				done = false;
				canceled = false;
				statMessage = "";
				try {
					return new GenerateMutants();
				} catch (IOException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return new Object();
			}
		};
		worker.start();
	}
	
	/**
	 * Called from ProgressBarDemo to start the task.
	 */
	public void go_testCaseChecker() {
		final SwingWorker worker = new SwingWorker() {
			public Object construct() {
				current = 0;
				done = false;
				canceled = false;
				statMessage = "";
				return new TestCaseChecker();
			}
		};
		worker.start();
	}

	/**
	 * Called from ProgressBarDemo to find out how much work needs
	 * to be done.
	 */
	public int getLengthOfTask() {
		return lengthOfTask;
	}

	/**
	 * Called from ProgressBarDemo to find out how much has been done.
	 */
	public int getCurrent() {
		return current;
	}

	public void stop() {
		canceled = true;
		statMessage = null;
	}

	/**
	 * Called from ProgressBarDemo to find out if the task has completed.
	 */
	public boolean isDone() {
		return done;
	}

	/**
	 * Returns the most recent status message, or null
	 * if there is no current status message.
	 */
	public String getMessage() {
		return statMessage;
	}

	public String getInputs() {
		return inputs;
	}
                                                                      
	public void setInputs(String in) {
		inputs = in;
	}
	
	public void setMutantsName(String name) {
		allMutantsFileName.add(name);
	}
	public void setReportFilePath(String path) {
		reportFilePath = path;
	}
	public void setTestCasePathFile(String path) {
		testCasePathFile = path;
	}
	public String getTestCasePathFile() {
		return testCasePathFile;
	}
	public void setMutantsPathFile(String path) {
		mutantsPathFile = path;
	}
	public String getMutantsPathFile() {
		return mutantsPathFile;
	}


	/**
	 * The actual long running task.  This runs in a SwingWorker thread.
	 */
	public Object readJSONFile() throws IOException, ParseException {
		//JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
		System.out.println("selectedJSONPath: "+ selectedJSONPath);
		FileReader reader = new FileReader(selectedJSONPath);

		//Read JSON file
		Object obj = jsonParser.parse(reader);
		return obj;
	}

	public void setSelectedModelPath(String path) {
		selectedModelPath = path;
		String[] values = path.split("\\.uml");
		selectedJSONPath = values[0]+"Description.json";
		System.out.println("<selectedModelPath>: "+selectedModelPath + "\n");
		System.out.println("<selectedJsonPath>: "+selectedJSONPath + "\n");
		
		int index = values[0].lastIndexOf('/');
		mainAddress = values[0].substring(0, index+1);
		System.out.println("<mainAddress>: "+mainAddress + "\n");

	}
	
	public void setSelectedMutantsPath(String path) {
		selectedMutantsPath = path;
	}


	class GenerateMutants {
		GenerateMutants() throws IOException, ParseException {
			//---COPY FILES [START]
			File dest = new File(selectedMutantsPath);
			if (inputs.contentEquals("all")) {
				File src = new File(mainAddress+"../ModelsForTesting/tmp/AllMutants/");
				try {
					FileSystemUtils.copyRecursively(src, dest);
				} catch (IOException e) {
				    e.printStackTrace();
				}
			}if (inputs.contains("withdraw")) {
				File src = new File(mainAddress+"../ModelsForTesting/tmp/WithdrawMutants/");
				try {
					FileSystemUtils.copyRecursively(src, dest);
				} catch (IOException e) {
				    e.printStackTrace();
				}
			}if (inputs.contains("balance")) {
				File src = new File(mainAddress+"../ModelsForTesting/tmp/BalanceMutants/");
				try {
					FileSystemUtils.copyRecursively(src, dest);
				} catch (IOException e) {
				    e.printStackTrace();
				}
			}if (inputs.contains("deposit")) {
				File src = new File(mainAddress+"../ModelsForTesting/tmp/DepositMutants/");
				try {
					FileSystemUtils.copyRecursively(src, dest);
				} catch (IOException e) {
				    e.printStackTrace();
				}
			}if (inputs.contains("cashTransfer")) {
				File src = new File(mainAddress+"../ModelsForTesting/tmp/CashTransferMutants/");
				try {
					FileSystemUtils.copyRecursively(src, dest);
				} catch (IOException e) {
				    e.printStackTrace();
				}
			}if (inputs.contains("bill")) {
				File src = new File(mainAddress+"../ModelsForTesting/tmp/BillMutants/");
				try {
					FileSystemUtils.copyRecursively(src, dest);
				} catch (IOException e) {
				    e.printStackTrace();
				}
			}
			
				
			//else
				
			//---COPY FILES [END]
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(selectedJSONPath));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray listCapsulesInstances = (JSONArray) jsonObject.get("listCapsulesInstances");

			current = 0; 				
			Iterator<JSONObject> iterator1 = listCapsulesInstances.iterator();
			while (iterator1.hasNext()) {
				//System.out.println("------->"+iterator1.next().get("name"));
				JSONObject jsonObject_capInstance =  (JSONObject) iterator1.next();
				//System.out.println("------->"+jsonObject_capInstance.get("name"));

				//System.out.println(iterator1.next().get("children"));
				JSONArray children = (JSONArray) jsonObject_capInstance.get("children");
				Iterator<JSONObject> iterator2 = children.iterator();
				while (iterator2.hasNext()) {
					JSONObject jsonObject_children =  (JSONObject) iterator2.next();
					System.out.println(jsonObject_children.get("name"));
					statMessage = "Component's name: "+ jsonObject_children.get("name") +
							" in capsule instance's name: " + jsonObject_capInstance.get("name") + ".";
					//System.out.println(iterator2.next().get("name"));
					try {
						if (inputs.contentEquals("all"))
							Thread.sleep(50);
						else 
							Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				current +=100;

			}
			if (current == 1000) {
				done = true;
			}
		}
	}
	
	class TestCaseChecker {
		TestCaseChecker() {
			//TODO: add diff testcase by reading testCasePathFile
			ArrayList<String> survivedMutantsList = new ArrayList<>();
			
			File file = new File(reportFilePath);
			FileOutputStream oFile = null;
			try {
				file.createNewFile(); // if file already exists will do nothing 
				oFile = new FileOutputStream(file, false);
				
				oFile.write("---------------[ALL Mutants]---------------------".getBytes());
				oFile.write(System.getProperty("line.separator").getBytes());
			
				 Iterator<String> iter 
		            = allMutantsFileName.iterator(); 
			while (iter.hasNext()) {
				try {
					Thread.sleep(100);
					String mutantName = iter.next();
						
					if (testCasePathFile.contains("LIMITED") && mutantName.contains("deposit"))
						statMessage = mutantName +" ---> SURVIVED.";
					else
						statMessage = mutantName +" ---> KILLED.";

					oFile.write(statMessage.getBytes());
					oFile.write(System.getProperty("line.separator").getBytes());
					if (statMessage.contains("SURVIVED")) {
						survivedMutantsList.add(statMessage);
						survivedMutantsList.add(System.getProperty("line.separator"));
					}
				} catch (InterruptedException | IOException e) {
					System.out.println("ActualTask interrupted");
				}
			}
			
			oFile.write(System.getProperty("line.separator").getBytes());
			oFile.write("---------------[Survived Mutants]---------------------".getBytes());
			oFile.write(System.getProperty("line.separator").getBytes());
			
			for (String sm : survivedMutantsList) {
				oFile.write(sm.getBytes());
			}
			
			oFile.close();
			done = true;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}
	}

	class ORG_GenerateMutants {
		ORG_GenerateMutants() {
			//Fake a long task,
			//making a random amount of progress every second.
			while (!canceled && !done) {
				try {
					Thread.sleep(1000); //sleep for a second
					current += Math.random() * 100; //make some progress
					if (current >= lengthOfTask) {
						done = true;
						current = lengthOfTask;
					}
					statMessage = "Completed " + current +
							" out of " + lengthOfTask + ".";
				} catch (InterruptedException e) {
					System.out.println("ActualTask interrupted");
				}
			}
		}
	}
}
/**
 * This is the 3rd version of SwingWorker (also known as
 * SwingWorker 3), an abstract class that you subclass to
 * perform GUI-related work in a dedicated thread.  For
 * instructions on and examples of using this class, see:
 * 
 * http://java.sun.com/docs/books/tutorial/uiswing/misc/threads.html
 *
 * Note that the API changed slightly in the 3rd version:
 * You must now invoke start() on the SwingWorker after
 * creating it.
 */
abstract class SwingWorker {
	private Object value;  // see getValue(), setValue()

	/** 
	 * Class to maintain reference to current worker thread
	 * under separate synchronization control.
	 */
	public static class ThreadVar {
		private Thread thread;
		ThreadVar(Thread t) { thread = t; }
		synchronized Thread get() { return thread; }
		synchronized void clear() { thread = null; }
	}

	private ThreadVar threadVar;

	/** 
	 * Get the value produced by the worker thread, or null if it 
	 * hasn't been constructed yet.
	 */
	protected synchronized Object getValue() { 
		return value; 
	}

	/** 
	 * Set the value produced by worker thread 
	 */
	private synchronized void setValue(Object x) { 
		value = x; 
	}

	/** 
	 * Compute the value to be returned by the <code>get</code> method. 
	 */
	public abstract Object construct();

	/**
	 * Called on the event dispatching thread (not on the worker thread)
	 * after the <code>construct</code> method has returned.
	 */
	public void finished() {
	}

	/**
	 * A new method that interrupts the worker thread.  Call this method
	 * to force the worker to stop what it's doing.
	 */
	public void interrupt() {
		Thread t = threadVar.get();
		if (t != null) {
			t.interrupt();
		}
		threadVar.clear();
	}

	/**
	 * Return the value created by the <code>construct</code> method.  
	 * Returns null if either the constructing thread or the current
	 * thread was interrupted before a value was produced.
	 * 
	 * @return the value created by the <code>construct</code> method
	 */
	public Object get() {
		while (true) {  
			Thread t = threadVar.get();
			if (t == null) {
				return getValue();
			}
			try {
				t.join();
			}
			catch (InterruptedException e) {
				Thread.currentThread().interrupt(); // propagate
				return null;
			}
		}
	}


	/**
	 * Start a thread that will call the <code>construct</code> method
	 * and then exit.
	 */
	public SwingWorker() {
		final Runnable doFinished = new Runnable() {
			public void run() { finished(); }
		};

		Runnable doConstruct = new Runnable() { 
			public void run() {
				try {
					setValue(construct());
				}
				finally {
					threadVar.clear();
				}

				SwingUtilities.invokeLater(doFinished);
			}
		};

		Thread t = new Thread(doConstruct);
		threadVar = new ThreadVar(t);
	}

	/**
	 * Start the worker thread.
	 */
	public void start() {
		Thread t = threadVar.get();
		if (t != null) {
			t.start();
		}
	}
}