package ca.queensu.cs.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/*

Developers:
Majid Babaei (babaei@cs.queensu.ca): Initial development - 120918

 */

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Semaphore;

import org.apache.tools.ant.DefaultLogger;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import ca.queensu.cs.compression.Profiling;
import ca.queensu.cs.graph.viewController;
import ca.queensu.cs.outlook.MRegressionPanel;
import ca.queensu.cs.outlook.MReplayerPanel;
import ca.queensu.cs.server.Event;
import ca.queensu.cs.server.Server;
import ca.queensu.cs.server.Server.RunnableImpl;
import ca.queensu.cs.umlrtParser.PES;
import ca.queensu.cs.umlrtParser.ParserEngine;
import ca.queensu.cs.umlrtParser.TableDataMember;
import ca.queensu.cs.umlrtParser.UmlrtParser;


public class Controller {

	public static UmlrtParser umlrtParser;
	public static viewController viewer;
	public static Server server;
	public static Event event;
	public static Semaphore semServer;
	public static Map<String, List<TableDataMember>> listTableData;
	public static String args0;
	public static HashMap<String, String> mapCapInstIdx, mapIdxCapInst;
	public PES pes;
	public static int WEBSERVER_PORT;
	public static int MAX_TRY_TO_SEND;
	public static String selectedModelPath;


	
	

	public Controller(String args0) {
		this.selectedModelPath = "";
		this.MAX_TRY_TO_SEND = 2;
		this.WEBSERVER_PORT = 8090;
		this.pes = new PES();
		this.args0 = args0;
		this.mapCapInstIdx = new HashMap<String, String>();
		this.mapIdxCapInst = new HashMap<String, String>();
		viewer = new viewController();
		this.semServer = new Semaphore(1); 
		Event event = new Event();
		
		this.listTableData = null;
		
		//for(int i = 0; i<Controller.trackers.length;i++) {if (Controller.trackers[i].getCapsuleInstance() != null) this.trackerCount++;}
	}


	
	
	public static void startCollector() {
		try {
			server = new Server("127.0.0.1",8001, semServer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread serverT = new Thread(server.new RunnableImpl()); 
		serverT.start(); 
	}
	
	public static void startController(String args0) {
		umlrtParser = new UmlrtParser();
		Thread umlrtParserT = new Thread(umlrtParser.new RunnableImpl()); 
		umlrtParserT.start();
		//--------------------------------------------------------------------------
		Thread controllerT = new Thread(new Controller(args0).new RunnableImpl()); 
		controllerT.start(); 
	}
	
	public static void startReplayer(String args0) {
		System.out.println("\n in startReplayer():"+ MReplayerPanel.getOrgModelPath());

		ModifyIndexFile();
		
		File buildFile = new File("./mxgraph/java/build.xml");
		   Project p = new Project();
		   p.setUserProperty("ant.file", buildFile.getAbsolutePath());
			//System.out.println("\n buildFile.getAbsolutePath():"+ buildFile.getAbsolutePath());

		   p.init();
		   
		   ProjectHelper helper = ProjectHelper.getProjectHelper();
		   p.addReference("ant.projectHelper", helper);
		   
		   helper.parse(p, buildFile);
			//System.out.println("\n p.getDefaultTarget():"+ p.getDefaultTarget());
					  
		   
		   DefaultLogger consoleLogger = new DefaultLogger();
		   consoleLogger.setErrorPrintStream(System.err);
		   consoleLogger.setOutputPrintStream(System.out);
		   consoleLogger.setMessageOutputLevel(Project.MSG_INFO);
		   
		   p.addBuildListener(consoleLogger);

		   //grapheditor
		   p.setDefaultTarget("grapheditor");
		   p.executeTarget(p.getDefaultTarget());
			
	}
	
	public static void ModifyIndexFile() {
		//System.out.println("\n 2 in startReplayer():"+ MRegressionPanel.getOrgModelPath());
		//System.out.println("\n 2 in startReplayer():"+ MRegressionPanel.getModifiedModelPath());
		System.out.println("\n 2 in startReplayer():"+ MReplayerPanel.getModifiedModelPath());
		//String [] pathSplit = MRegressionPanel.getModifiedModelPath().split("\\/");
		String add = "/home/babaei/workspace/RegressionTesting/src/main/resources/umlrtModels/BankATM.uml";
		String [] pathSplit = add.split("\\/");
		String modelName = pathSplit[pathSplit.length -1];
		System.out.println("\n 2 in startReplayer(): modelName : "+ modelName);
		String [] modelNameSplit = modelName.split("\\.");

		//https://regex101.com/
		String pattern = "localModel_[A-Za-z0-9]*(_*[A-Za-z0-9]+).xml";
		String localModelName = "localModel_"+modelNameSplit[0]+".xml";
		
		modifyFile("./mxgraph/javascript/examples/grapheditor/www/index.html", pattern, localModelName);
	}
	
	//--
		public static void modifyFile(String filePath, String oldString, String newString)
	    {
	        File fileToBeModified = new File(filePath);
	         
	        String oldContent = "";
	         
	        BufferedReader reader = null;
	         
	        FileWriter writer = null;
	         
	        try
	        {
	            reader = new BufferedReader(new FileReader(fileToBeModified));
	             
	            //Reading all the lines of input text file into oldContent
	             
	            String line = reader.readLine();
	             
	            while (line != null) 
	            {
	                oldContent = oldContent + line + System.lineSeparator();
	                 
	                line = reader.readLine();
	            }
	             
	            //Replacing oldString with newString in the oldContent
	             
	            String newContent = oldContent.replaceAll(oldString, newString);
	             
	            //Rewriting the input text file with newContent
	             
	            writer = new FileWriter(fileToBeModified);
	             
	            writer.write(newContent);
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            try
	            {
	                //Closing the resources
	                 
	                reader.close();
	                 
	                writer.close();
	            } 
	            catch (IOException e) 
	            {
	                e.printStackTrace();
	            }
	        }
	    }
	

	
	

	public class RunnableImpl implements Runnable {

		public void run() {
			long t1 = System.currentTimeMillis();
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<[Starting Data Process]>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n");
			System.out.println("Waiting for the UmlrtParsing thread complete the process ....");
			while (true) {if (umlrtParser.getUmlrtParsingDone()) break; else System.out.print(""); }
			pes.makeMapRegionPaths();
			System.out.println("\n\n<<<<<<<<<<<<<<<[Parsing process has been completed successfully]>>>>>>>>>>>>>>>>>\n\n");
			//Profiling.refineParsing();
			long t2 = System.currentTimeMillis();
			 System.out.println("UmlrtParsingTime: "+ (t2-t1));
			
			
			Controller.listTableData = umlrtParser.getlistTableData();
			viewer.setListTableData(umlrtParser.getlistTableData());
			int numberOfRegions =  countRegions();
			
			
			//REGIONS
			System.out.println("\n\n<<<<<<<<<<<<<<<[numberOfCapsules]>>>>>>>>>>>>>>>>>\n\n"+numberOfRegions);

			
			//Message msg = new Message("process it", event);
			
			/* TRACKER IS DISABLED NOW![27/03/2020] [NOTRACKER MODE]
			TrackerMaker trackerMaker = new TrackerMaker(semServer, numberOfRegions);
			new Thread(trackerMaker,"waiter").start();
			*/
			
			//Notifier notifier = new Notifier(msg, Controller.sem);
			//new Thread(notifier, "notifier").start();


			if (args0 != null)
				if (args0.contentEquals("view")) {
					//Staring view thread to make a mxGraph for the given model
					//--------------------------------------------------------------------------
					Thread viewerT = new Thread(viewer.new RunnableImpl()); 
					viewerT.start();
					//--------------------------------------------------------------------------
				}
		}
	}
	
	//==================================================================	
		//==============================================[countRegions]
		//==================================================================			

		public int countRegions()  
		{
			int countRegions = 0;
			for (Entry<String, List<String>> entry  : pes.mapRegionPaths.entrySet()) {

				if (entry.getKey().contains(",")) {

					String [] spiltCapsuleFullname = entry.getKey().split("\\,");
					countRegions = countRegions + spiltCapsuleFullname.length;
				}else {
					countRegions++;
				}
			}
			return countRegions;
		}

	//==================================================================	
	//==============================================[countCapsule]
	//==================================================================			

	public int countCapsule()  
	{
		int numberOfCapsules = 0;
		for (Map.Entry<String, List<TableDataMember>> entry  : Controller.listTableData.entrySet()) {

			if (entry.getKey().contains(",")) {

				String [] spiltCapsuleFullname = entry.getKey().split("\\,");
				for (String str: spiltCapsuleFullname)
					if (!str.isEmpty()) numberOfCapsules++;
				//numberOfCapsules = numberOfCapsules + spiltCapsuleFullname.length;
			}else {
				numberOfCapsules++;
			}

		}
		return numberOfCapsules;
	}
}