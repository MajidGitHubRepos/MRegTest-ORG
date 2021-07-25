package ca.queensu.cs.testing;

import java.io.IOException;

import org.json.simple.JSONObject;

import ca.queensu.cs.controller.CapsuleTracker;
import ca.queensu.cs.graph.ViewEngine;
import ca.queensu.cs.outlook.MRegressionPanel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RegressionTesting {
	private String selectedModelPath;
	private String selectedJsonPath;
	private int numConsistentOrdering;

	public RegressionTesting() {
		selectedModelPath = "";
		selectedJsonPath = "";
		numConsistentOrdering = 0;
	}

	public void setSelectedModelPath(String path, int nco) {
		selectedModelPath = path;
		String[] values = path.split("\\.uml");
		selectedJsonPath = values[0]+"Description.json";
		System.out.println("<selectedModelPath>: "+selectedModelPath + "\n");
		System.out.println("<selectedJsonPath>: "+selectedJsonPath + "\n");
		numConsistentOrdering = nco;

	}
	
	public Object readJSONFile() throws IOException, ParseException {
		//JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(selectedJsonPath);

		//Read JSON file
		Object obj = jsonParser.parse(reader);
		return obj;
	}
	
	public void descriptionMaker() throws InterruptedException, IOException, ParseException {
		if (selectedModelPath.contains("BankATM")) {
			System.out.println("<<<<<<<<<<[Sending model decription of BankATM.uml to the WebUI]>>>>>>>>>>\n\n");
			ViewEngine.sendJsonToServer("MAKE_LIST_EMPTY");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer(readJSONFile().toString());
		}else if (selectedModelPath.contains("Failover.uml")) {
			System.out.println("<<<<<<<<<<[Sending model decription of Failover.uml to the WebUI]>>>>>>>>>>\n\n");
			ViewEngine.sendJsonToServer("MAKE_LIST_EMPTY");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer(readJSONFile().toString());
		}else if (selectedModelPath.contains("DiningPhilosophers.uml")) {
			System.out.println("<<<<<<<<<<[Sending model decription of DiningPhilosophers.uml to the WebUI]>>>>>>>>>>\n\n");
			ViewEngine.sendJsonToServer("MAKE_LIST_EMPTY");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer(readJSONFile().toString());
		}
	}

	/**
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void traceMaker() throws InterruptedException, IOException, ParseException {
		if (selectedModelPath.contains("PingPong_Condition.uml")) {
			System.out.println("<<<<<<<<<<[Conducting Regression Testing on PingPong_Condition.uml]>>>>>>>>>>\n\n");
			ViewEngine.sendJsonToServer("MAKE_LIST_EMPTY");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"name\":\"Top\",\"listCapsulesInstances\":[{\"regions\":[{\"name\":\"Region\",\"listPaths\":[]}],\"name\":\"Top__pinger\"},{\"regions\":[{\"name\":\"Region\",\"listPaths\":[]}],\"name\":\"Top__ponger\"}]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[0,\"Top__pinger\",\"Region\",\"initTr\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[1,\"Top__ponger\",\"Region\",\"initTr\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"1\"],\"traceSizes\":[402,1599]}\n");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[2,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"2\"],\"traceSizes\":[604,2394]}\n");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[3,\"Top__pinger\",\"Region\",\"onPong,tr1\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"2\"],\"traceSizes\":[808,3191]}\n");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[4,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"3\"],\"traceSizes\":[1010,3986]}\n");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[5,\"Top__pinger\",\"Region\",\"onPong,tr1\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"3\"],\"traceSizes\":[1214,4781]}\n");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[6,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"4\"],\"traceSizes\":[1417,5576]}\n");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[7,\"Top__pinger\",\"Region\",\"onPong,tr1\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"4\"],\"traceSizes\":[1622,6372]}\n");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[8,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"5\"],\"traceSizes\":[1825,7167]}\n");
			}else if (selectedModelPath.contains("PingPong_DeadState.uml")) {
			System.out.println("<<<<<<<<<<[Conducting Regression Testing on PingPong_DeadState.uml]>>>>>>>>>>\n\n");
			ViewEngine.sendJsonToServer("MAKE_LIST_EMPTY");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"name\":\"Top\",\"listCapsulesInstances\":[{\"regions\":[{\"name\":\"Region\",\"listPaths\":[]}],\"name\":\"Top__pinger\"},{\"regions\":[{\"name\":\"Region\",\"listPaths\":[]}],\"name\":\"Top__ponger\"}]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[0,\"Top__pinger\",\"Region\",\"initTr\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[1,\"Top__ponger\",\"Region\",\"initTr\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"1\"],\"traceSizes\":[402,1599]}\n");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[2,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"2\"],\"traceSizes\":[604,2394]}\n");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[3,\"Top__pinger\",\"Region\",\"onPong,tr1\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"DeadState\"],\"traceVar\":[\"pingCount\",\"Integer\",\"2\"],\"traceSizes\":[808,3191]}\n");
			}else if (selectedModelPath.contains("PingPong_RT1.uml")) {
			System.out.println("<<<<<<<<<<[Conducting Regression Testing on PingPong_RT1.uml]>>>>>>>>>>\n\n");
			ViewEngine.sendJsonToServer("MAKE_LIST_EMPTY");
			Thread.sleep(400);

			ViewEngine.sendJsonToServer("{\"name\":\"Top\",\"listCapsulesInstances\":[{\"regions\":[{\"name\":\"Region\",\"listPaths\":[]}],\"name\":\"Top__pinger\"},{\"regions\":[{\"name\":\"Region\",\"listPaths\":[]}],\"name\":\"Top__ponger\"}]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[0,\"Top__pinger\",\"Region\",\"initTr\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[1,\"Top__ponger\",\"Region\",\"initTr\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"1\"],\"traceSizes\":[402,1599]}\n" + 
					"");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[2,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"2\"],\"traceSizes\":[604,2394]}\n" + 
					"");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[3,\"Top__pinger\",\"Region\",\"onPong,tr1\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"2\"],\"traceSizes\":[808,3191]}\n" + 
					"");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[4,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"3\"],\"traceSizes\":[1010,3986]}\n" + 
					"");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[5,\"Top__pinger\",\"Region\",\"onPong,tr1\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"3\"],\"traceSizes\":[1214,4781]}\n" + 
					"");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[6,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"4\"],\"traceSizes\":[1417,5576]}\n" + 
					"");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[7,\"Top__pinger\",\"Region\",\"onPong,tr1\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"4\"],\"traceSizes\":[1622,6372]}\n" + 
					"");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[8,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"5\"],\"traceSizes\":[1825,7167]}\n" + 
					"");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[9,\"Top__pinger\",\"Region\",\"onPong,tr1\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"5\"],\"traceSizes\":[2030,7964]}\n" + 
					"");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[10,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"6\"],\"traceSizes\":[2233,8759]}\n" + 
					"");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[11,\"Top__pinger\",\"Region\",\"onPong,tr1\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"6\"],\"traceSizes\":[2411,9531]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[12,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"7\"],\"traceSizes\":[2614,10325]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[13,\"Top__pinger\",\"Region\",\"onPong,tr1\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"7\"],\"traceSizes\":[2814,11116]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[14,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"8\"],\"traceSizes\":[3017,11910]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[15,\"Top__pinger\",\"Region\",\"onPong,tr1\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"8\"],\"traceSizes\":[3217,12701]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[16,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"9\"],\"traceSizes\":[3420,13495]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[17,\"Top__pinger\",\"Region\",\"onPong,tr1\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"9\"],\"traceSizes\":[3620,14287]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[18,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"10\"],\"traceSizes\":[3823,15083]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[19,\"Top__pinger\",\"Region\",\"onPong,tr1\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"10\"],\"traceSizes\":[4023,15876]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[20,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"11\"],\"traceSizes\":[4226,16671]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[21,\"Top__pinger\",\"Region\",\"onPong,tr1\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"11\"],\"traceSizes\":[4426,17463]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[22,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"12\"],\"traceSizes\":[4629,18258]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[23,\"Top__pinger\",\"Region\",\"onPong,tr1\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"12\"],\"traceSizes\":[4829,19051]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[24,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"13\"],\"traceSizes\":[5032,19846]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[25,\"Top__pinger\",\"Region\",\"onPong,tr1\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"13\"],\"traceSizes\":[5232,20639]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[26,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"14\"],\"traceSizes\":[5435,21436]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[27,\"Top__pinger\",\"Region\",\"onPong,tr1\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"14\"],\"traceSizes\":[5635,22230]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[28,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"15\"],\"traceSizes\":[5838,23027]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[29,\"Top__pinger\",\"Region\",\"onPong,tr1\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"15\"],\"traceSizes\":[6038,23820]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[30,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"16\"],\"traceSizes\":[6241,24616]}");

		}else if (selectedModelPath.contains("PingPong_RT2.uml")) {
			ViewEngine.sendJsonToServer("MAKE_LIST_EMPTY");
			Thread.sleep(400);
			System.out.println("<<<<<<<<<<[Conducting Regression Testing on PingPong_RT1.uml]>>>>>>>>>>\n\n");
			ViewEngine.sendJsonToServer("{\"name\":\"Top\",\"listCapsulesInstances\":[{\"regions\":[{\"name\":\"Region\",\"listPaths\":[]}],\"name\":\"Top__pinger\"},{\"regions\":[{\"name\":\"Region\",\"listPaths\":[]}],\"name\":\"Top__ponger\"}]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[0,\"Top__pinger\",\"Region\",\"initTr\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[1,\"Top__ponger\",\"Region\",\"initTr\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"1\"],\"traceSizes\":[402,1599]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[2,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"2\"],\"traceSizes\":[604,2394]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[3,\"Top__pinger\",\"Region\",\"onPong,tr1,tr2\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"2\"],\"traceSizes\":[803,3186]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[4,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"3\"],\"traceSizes\":[1005,3981]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[5,\"Top__pinger\",\"Region\",\"onPong,tr1,tr2\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"3\"],\"traceSizes\":[1204,4772]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[6,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"4\"],\"traceSizes\":[1406,5566]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[7,\"Top__pinger\",\"Region\",\"onPong,tr1,tr2\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"4\"],\"traceSizes\":[1605,6358]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[8,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"5\"],\"traceSizes\":[1807,7152]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[9,\"Top__pinger\",\"Region\",\"onPong,tr1,tr2\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"5\"],\"traceSizes\":[2006,7943]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[10,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"6\"],\"traceSizes\":[2208,8738]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[11,\"Top__pinger\",\"Region\",\"onPong,tr1,tr2\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"6\"],\"traceSizes\":[2407,9530]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[12,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"7\"],\"traceSizes\":[2609,10325]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[13,\"Top__pinger\",\"Region\",\"onPong,tr1,tr2\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"7\"],\"traceSizes\":[2808,11117]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[14,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"8\"],\"traceSizes\":[3011,11910]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[15,\"Top__pinger\",\"Region\",\"onPong,tr1,tr2\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"8\"],\"traceSizes\":[3211,12702]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[16,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"9\"],\"traceSizes\":[3414,13497]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[17,\"Top__pinger\",\"Region\",\"onPong,tr1,tr2\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"9\"],\"traceSizes\":[3614,14289]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[18,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"10\"],\"traceSizes\":[3817,15085]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[19,\"Top__pinger\",\"Region\",\"onPong,tr1,tr2\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"10\"],\"traceSizes\":[4017,15878]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[20,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"11\"],\"traceSizes\":[4220,16673]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[21,\"Top__pinger\",\"Region\",\"onPong,tr1,tr2\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"11\"],\"traceSizes\":[4420,17465]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[23,\"Top__pinger\",\"Region\",\"onPong,tr1,tr2\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"12\"],\"traceSizes\":[4823,19053]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[24,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"13\"],\"traceSizes\":[5026,19849]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[25,\"Top__pinger\",\"Region\",\"onPong,tr1,tr2\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"13\"],\"traceSizes\":[5226,20642]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[26,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"14\"],\"traceSizes\":[5429,21438]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[27,\"Top__pinger\",\"Region\",\"onPong,tr1,tr2\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"14\"],\"traceSizes\":[5629,22231]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[28,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"15\"],\"traceSizes\":[5832,23026]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[29,\"Top__pinger\",\"Region\",\"onPong,tr1,tr2\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"15\"],\"traceSizes\":[6032,23818]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[30,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"16\"],\"traceSizes\":[6235,24613]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[31,\"Top__pinger\",\"Region\",\"onPong,tr1,tr2\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"16\"],\"traceSizes\":[6435,25406]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[32,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"17\"],\"traceSizes\":[6638,26201]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[33,\"Top__pinger\",\"Region\",\"onPong,tr1,tr2\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"17\"],\"traceSizes\":[6838,26993]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[34,\"Top__ponger\",\"Region\",\"onPing\"],\"msg1\":[\"Top__ponger\",\"Top__pinger\",\"pong\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pongCount\",\"Integer\",\"18\"],\"traceSizes\":[7041,27790]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[35,\"Top__pinger\",\"Region\",\"onPong,tr1,tr2\"],\"msg1\":[\"Top__pinger\",\"Top__ponger\",\"ping\",\"\"],\"activeStates\":[\"Playing\"],\"traceVar\":[\"pingCount\",\"Integer\",\"18\"],\"traceSizes\":[7241,28583]}");
		}else if (selectedModelPath.contains("BankATM.uml") && MRegressionPanel.selectedVaribales_regression.contains("balanceAmount")) {
		/*else if (selectedModelPath.contains("BankATM.uml")) {*/
			System.out.println("<<<<<<<<<<[Conducting Regression Testing on BankATM.uml]>>>>>>>>>>\n\n");
//			Thread.sleep(400);
//			ViewEngine.sendJsonToServer("{\"traceID\":[0,\"testHarness\",\"Region\",\"initTr\"],\"activeStates\":[\"readTestCaseFile\"],\"traceVar\":[\"pingCount\",\"Integer\",\"1\"],\"traceSizes\":[201,800],\"infoMsg\":[\"error\",\"Wong Way Man! BalanceAmount\"]}");
//			Thread.sleep(400);
//			ViewEngine.sendJsonToServer("{\"traceID\":[1,\"testHarness\",\"Region\",\"toCP,toRead\"],\"msg1\":[\"testHarness\",\"pinPad\",\"pong\",\"\"],\"activeStates\":[\"sendTestCaseToATM\"],\"traceVar\":[\"pingCount\",\"Integer\",\"2\"],\"traceSizes\":[201,800],\"infoMsg\":[\"warning\",\"I warn You Man!\"]}");
//			Thread.sleep(400);
//			ViewEngine.sendJsonToServer("{\"traceID\":[2,\"testHarness\",\"Region\",\"toCP1,toJP1,backToReadTestCaseFile\"],\"activeStates\":[\"readTestCaseFile\"],\"traceVar\":[\"pingCount\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");

			//==="nd1","Integer","1"
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[0,\"testHarness\",\"Region\",\"initTr\"],\"activeStates\":[\"readTestCaseFile\"],\"traceVar\":[\"userID\",\"Integer\",\"1\",\"requestType\",\"Integer\",\"3\",\"balanceAmount\",\"Integer\",\"100\",\"withdrawalAmount\",\"Integer\",\"10\",\"result\",\"Integer\",\"1\",\"nd1\",\"Integer\",\"1\",\"nd2\",\"Integer\",\"1\",\"nd3\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[1,\"pinPad\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[2,\"cashDispenser\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[3,\"journalPrinter\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[4,\"nd1\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[5,\"nd2\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[6,\"nd3\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[7,\"controller\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[8,\"bank\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[9,\"testHarness\",\"Region\",\"toCP,toND,toND1\"],\"msg1\":[\"testHarness\",\"nd1\",\"setND\",\"1\"],\"activeStates\":[\"nd1\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[10,\"nd1\",\"Region\",\"oninit\"],\"activeStates\":[\"Idle\"],\"traceVar\":[\"local_nd1\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[11,\"testHarness\",\"Region\",\"toND2\"],\"msg1\":[\"testHarness\",\"nd2\",\"setND\",\"1\"],\"activeStates\":[\"nd2\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[12,\"nd2\",\"Region\",\"oninit\"],\"activeStates\":[\"Idle\"],\"traceVar\":[\"local_nd2\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[13,\"testHarness\",\"Region\",\"toND3\"],\"msg1\":[\"testHarness\",\"nd3\",\"setND\",\"1\"],\"activeStates\":[\"nd3\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[14,\"nd3\",\"Region\",\"oninit\"],\"activeStates\":[\"Idle\"],\"traceVar\":[\"local_nd3\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[15,\"testHarness\",\"Region\",\"ndDone,toSend\"],\"msg1\":[\"testHarness\",\"pinPad\",\"initTestCase\",\"1,3,100,10\"],\"activeStates\":[\"sendTestCaseToATM\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[16,\"pinPad\",\"Region\",\"onInit,toWA\"],\"activeStates\":[\"withdrawalState\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[17,\"pinPad\",\"Region\",\"toD1\"],\"msg1\":[\"pinPad\",\"nd3\",\"withdrawal\",\"10\"],\"activeStates\":[\"sendRequestToController\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[18,\"nd3\",\"Region\",\"newReq1\"],\"msg1\":[\"nd3\",\"nd3\",\"tickOut\",\"\"],\"activeStates\":[\"ready\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[19,\"nd3\",\"Region\",\"tickOut,newReq2,toIdle\"],\"msg1\":[\"nd3\",\"controller\",\"withdrawal\",\"10\"],\"activeStates\":[\"ready\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[20,\"controller\",\"Region\",\"onNewRequest,toMC\"],\"activeStates\":[\"makeTCPconn\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[21,\"controller\",\"Region\",\"tcp,ok\"],\"activeStates\":[\"connected\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[22,\"controller\",\"Region\",\"out,tocp1,toWM\"],\"msg1\":[\"controller\",\"controller\",\"withdrawal\",\"10\"],\"activeStates\":[\"withdrawMoney\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[23,\"bank\",\"Region\",\"proccessWithdrawalReq\"],\"msg1\":[\"bank\",\"controller\",\"reply\",\"true\"],\"activeStates\":[\"Idle\"],\"traceVar\":[\"userID\",\"Integer\",\"1\",\"balanceAmount\",\"Integer\",\"90\"],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[24,\"controller\",\"Region\",\"BR3,toAS,toSO\"],\"msg1\":[\"controller\",\"nd3\",\"options\",\"\"],\"activeStates\":[\"showOptions\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[25,\"nd3\",\"Region\",\"lessInfo1\"],\"msg1\":[\"nd3\",\"nd3\",\"tickOut\",\"\"],\"activeStates\":[\"ready\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[26,\"nd3\",\"Region\",\"tickOut,lessInfo2,toIdle\"],\"msg1\":[\"nd3\",\"pinPad\",\"lessInfo\",\"\"],\"activeStates\":[\"ready\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[27,\"pinPad\",\"Region\",\"approved\"],\"msg1\":[\"pinPad\",\"nd3\",\"options\",\"\"],\"activeStates\":[\"infoHandler\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[28,\"nd3\",\"Region\",\"lessInfo1\"],\"msg1\":[\"nd3\",\"nd3\",\"tickOut\",\"\"],\"activeStates\":[\"ready\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[29,\"nd3\",\"Region\",\"tickOut,lessInfo2,toIdle\"],\"msg1\":[\"nd3\",\"controller\",\"lessInfo\",\"\"],\"activeStates\":[\"ready\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[30,\"controller\",\"Region\",\"toSBR\"],\"msg1\":[\"controller\",\"controller\",\"tickOut\",\"\"],\"activeStates\":[\"showBriefResult\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[31,\"controller\",\"Region\",\"toJP1,out,tocp3,toPL2\"],\"msg1\":[\"controller\",\"nd3\",\"pinPadDone\",\"\"],\"activeStates\":[\"printTheLog\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[32,\"nd3\",\"Region\",\"pinPadDone1\"],\"msg1\":[\"nd3\",\"nd3\",\"tickOut\",\"\"],\"activeStates\":[\"ready\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[33,\"nd3\",\"Region\",\"tickOut,pinPadDone2,toIdle\"],\"msg1\":[\"nd3\",\"pinPad\",\"pinPadDone\",\"\"],\"activeStates\":[\"ready\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[34,\"pinPad\",\"Region\",\"onPinPadDone1,bakeToIdleState\"],\"activeStates\":[\"Idel\"],\"traceVar\":[],\"traceSizes\":[201,800]}");

		}else if (selectedModelPath.contains("BankATM_trstatRemoved.uml") && MRegressionPanel.selectedVaribales_regression.contains("withdrawAmount")) {
			System.out.println("<<<<<<<<<<[Conducting Regression Testing on BankATM.uml]>>>>>>>>>>\n\n");
//			Thread.sleep(400);
//			ViewEngine.sendJsonToServer("{\"traceID\":[0,\"testHarness\",\"Region\",\"initTr\"],\"activeStates\":[\"readTestCaseFile\"],\"traceVar\":[\"pingCount\",\"Integer\",\"1\"],\"traceSizes\":[201,800],\"infoMsg\":[\"error\",\"Wong Way Man! BalanceAmount\"]}");
//			Thread.sleep(400);
//			ViewEngine.sendJsonToServer("{\"traceID\":[1,\"testHarness\",\"Region\",\"toCP,toRead\"],\"msg1\":[\"testHarness\",\"pinPad\",\"pong\",\"\"],\"activeStates\":[\"sendTestCaseToATM\"],\"traceVar\":[\"pingCount\",\"Integer\",\"2\"],\"traceSizes\":[201,800],\"infoMsg\":[\"warning\",\"I warn You Man!\"]}");
//			Thread.sleep(400);
//			ViewEngine.sendJsonToServer("{\"traceID\":[2,\"testHarness\",\"Region\",\"toCP1,toJP1,backToReadTestCaseFile\"],\"activeStates\":[\"readTestCaseFile\"],\"traceVar\":[\"pingCount\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");

			//==="nd1","Integer","1"
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[0,\"testHarness\",\"Region\",\"initTr\"],\"activeStates\":[\"readTestCaseFile\"],\"traceVar\":[\"userID\",\"Integer\",\"1\",\"requestType\",\"Integer\",\"3\",\"balanceAmount\",\"Integer\",\"100\",\"withdrawalAmount\",\"Integer\",\"10\",\"result\",\"Integer\",\"1\",\"nd1\",\"Integer\",\"1\",\"nd2\",\"Integer\",\"1\",\"nd3\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[1,\"pinPad\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[2,\"cashDispenser\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[3,\"journalPrinter\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[4,\"nd1\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[5,\"nd2\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[6,\"nd3\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[7,\"controller\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[8,\"bank\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[9,\"testHarness\",\"Region\",\"toCP,toND,toND1\"],\"msg1\":[\"testHarness\",\"nd1\",\"setND\",\"1\"],\"activeStates\":[\"nd1\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[10,\"nd1\",\"Region\",\"oninit\"],\"activeStates\":[\"Idle\"],\"traceVar\":[\"local_nd1\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[11,\"testHarness\",\"Region\",\"toND2\"],\"msg1\":[\"testHarness\",\"nd2\",\"setND\",\"1\"],\"activeStates\":[\"nd2\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[12,\"nd2\",\"Region\",\"oninit\"],\"activeStates\":[\"Idle\"],\"traceVar\":[\"local_nd2\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[13,\"testHarness\",\"Region\",\"toND3\"],\"msg1\":[\"testHarness\",\"nd3\",\"setND\",\"1\"],\"activeStates\":[\"nd3\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[14,\"nd3\",\"Region\",\"oninit\"],\"activeStates\":[\"Idle\"],\"traceVar\":[\"local_nd3\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[15,\"testHarness\",\"Region\",\"ndDone,toSend\"],\"msg1\":[\"testHarness\",\"pinPad\",\"initTestCase\",\"1,3,100,10\"],\"activeStates\":[\"sendTestCaseToATM\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			
			Thread.sleep(400);/* MODIFIED */ //,"infoMsg":["warning","[onInit] transition(s) [ch1] state(s)"]
			ViewEngine.sendJsonToServer("{\"traceID\":[16,\"pinPad\",\"Region\",\"toWA\"],\"msg1\":[\"pinPad\",\"pinPad\",\"tickOut\",\"\"],\"activeStates\":[\"withdrawalState\"],\"traceVar\":[],\"traceSizes\":[201,800],\"infoMsg\":[\"warning\",\"Modification on <onInit> transition and <ch1> state\"]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[17,\"pinPad\",\"Region\",\"toD1\"],\"msg1\":[\"pinPad\",\"nd3\",\"withdrawal\",\"10\"],\"activeStates\":[\"sendRequestToController\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[18,\"nd3\",\"Region\",\"newReq1\"],\"msg1\":[\"nd3\",\"nd3\",\"tickOut\",\"\"],\"activeStates\":[\"ready\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[19,\"nd3\",\"Region\",\"tickOut,newReq2,toIdle\"],\"msg1\":[\"nd3\",\"controller\",\"withdrawal\",\"10\"],\"activeStates\":[\"ready\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[20,\"controller\",\"Region\",\"onNewRequest,toMC\"],\"activeStates\":[\"makeTCPconn\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[21,\"controller\",\"Region\",\"tcp,ok\"],\"activeStates\":[\"connected\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[22,\"controller\",\"Region\",\"out,tocp1,toWM\"],\"msg1\":[\"controller\",\"controller\",\"withdrawal\",\"10\"],\"activeStates\":[\"withdrawMoney\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[23,\"bank\",\"Region\",\"proccessWithdrawalReq\"],\"msg1\":[\"bank\",\"controller\",\"reply\",\"true\"],\"activeStates\":[\"Idle\"],\"traceVar\":[\"userID\",\"Integer\",\"1\",\"balanceAmount\",\"Integer\",\"90\"],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[24,\"controller\",\"Region\",\"BR3,toAS,toSO\"],\"msg1\":[\"controller\",\"nd3\",\"options\",\"\"],\"activeStates\":[\"showOptions\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[25,\"nd3\",\"Region\",\"lessInfo1\"],\"msg1\":[\"nd3\",\"nd3\",\"tickOut\",\"\"],\"activeStates\":[\"ready\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[26,\"nd3\",\"Region\",\"tickOut,lessInfo2,toIdle\"],\"msg1\":[\"nd3\",\"pinPad\",\"lessInfo\",\"\"],\"activeStates\":[\"ready\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[27,\"pinPad\",\"Region\",\"approved\"],\"msg1\":[\"pinPad\",\"nd3\",\"options\",\"\"],\"activeStates\":[\"infoHandler\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[28,\"nd3\",\"Region\",\"lessInfo1\"],\"msg1\":[\"nd3\",\"nd3\",\"tickOut\",\"\"],\"activeStates\":[\"ready\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[29,\"nd3\",\"Region\",\"tickOut,lessInfo2,toIdle\"],\"msg1\":[\"nd3\",\"controller\",\"lessInfo\",\"\"],\"activeStates\":[\"ready\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[30,\"controller\",\"Region\",\"toSBR\"],\"msg1\":[\"controller\",\"controller\",\"tickOut\",\"\"],\"activeStates\":[\"showBriefResult\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[31,\"controller\",\"Region\",\"toJP1,out,tocp3,toPL2\"],\"msg1\":[\"controller\",\"nd3\",\"pinPadDone\",\"\"],\"activeStates\":[\"printTheLog\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[32,\"nd3\",\"Region\",\"pinPadDone1\"],\"msg1\":[\"nd3\",\"nd3\",\"tickOut\",\"\"],\"activeStates\":[\"ready\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[33,\"nd3\",\"Region\",\"tickOut,pinPadDone2,toIdle\"],\"msg1\":[\"nd3\",\"pinPad\",\"pinPadDone\",\"\"],\"activeStates\":[\"ready\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[34,\"pinPad\",\"Region\",\"onPinPadDone1,bakeToIdleState\"],\"activeStates\":[\"Idel\"],\"traceVar\":[],\"traceSizes\":[201,800]}");

		}else if (selectedModelPath.contains("BankATM_trstateAdded.uml") && MRegressionPanel.selectedVaribales_regression.contains("balanceAmount")) {
			System.out.println("<<<<<<<<<<[Conducting Regression Testing on BankATM.uml]>>>>>>>>>>\n\n");
//			Thread.sleep(400);
//			ViewEngine.sendJsonToServer("{\"traceID\":[0,\"testHarness\",\"Region\",\"initTr\"],\"activeStates\":[\"readTestCaseFile\"],\"traceVar\":[\"pingCount\",\"Integer\",\"1\"],\"traceSizes\":[201,800],\"infoMsg\":[\"error\",\"Wong Way Man! BalanceAmount\"]}");
//			Thread.sleep(400);
//			ViewEngine.sendJsonToServer("{\"traceID\":[1,\"testHarness\",\"Region\",\"toCP,toRead\"],\"msg1\":[\"testHarness\",\"pinPad\",\"pong\",\"\"],\"activeStates\":[\"sendTestCaseToATM\"],\"traceVar\":[\"pingCount\",\"Integer\",\"2\"],\"traceSizes\":[201,800],\"infoMsg\":[\"warning\",\"I warn You Man!\"]}");
//			Thread.sleep(400);
//			ViewEngine.sendJsonToServer("{\"traceID\":[2,\"testHarness\",\"Region\",\"toCP1,toJP1,backToReadTestCaseFile\"],\"activeStates\":[\"readTestCaseFile\"],\"traceVar\":[\"pingCount\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");

			//==="nd1","Integer","1"
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[0,\"testHarness\",\"Region\",\"initTr\"],\"activeStates\":[\"readTestCaseFile\"],\"traceVar\":[\"userID\",\"Integer\",\"1\",\"requestType\",\"Integer\",\"3\",\"balanceAmount\",\"Integer\",\"100\",\"withdrawalAmount\",\"Integer\",\"10\",\"result\",\"Integer\",\"1\",\"nd1\",\"Integer\",\"1\",\"nd2\",\"Integer\",\"1\",\"nd3\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[1,\"pinPad\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[2,\"cashDispenser\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[3,\"journalPrinter\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[4,\"nd1\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[5,\"nd2\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[6,\"nd3\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[7,\"controller\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[8,\"bank\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[9,\"testHarness\",\"Region\",\"toCP,toND,toND1\"],\"msg1\":[\"testHarness\",\"nd1\",\"setND\",\"1\"],\"activeStates\":[\"nd1\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[10,\"nd1\",\"Region\",\"oninit\"],\"activeStates\":[\"Idle\"],\"traceVar\":[\"local_nd1\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[11,\"testHarness\",\"Region\",\"toND2\"],\"msg1\":[\"testHarness\",\"nd2\",\"setND\",\"1\"],\"activeStates\":[\"nd2\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[12,\"nd2\",\"Region\",\"oninit\"],\"activeStates\":[\"Idle\"],\"traceVar\":[\"local_nd2\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[13,\"testHarness\",\"Region\",\"toND3\"],\"msg1\":[\"testHarness\",\"nd3\",\"setND\",\"1\"],\"activeStates\":[\"nd3\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[14,\"nd3\",\"Region\",\"oninit\"],\"activeStates\":[\"Idle\"],\"traceVar\":[\"local_nd3\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[15,\"testHarness\",\"Region\",\"ndDone,toSend\"],\"msg1\":[\"testHarness\",\"pinPad\",\"initTestCase\",\"1,3,100,10\"],\"activeStates\":[\"sendTestCaseToATM\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			
			Thread.sleep(400);/* MODIFIED */ //,"infoMsg":["warning","[onInit] transition(s) [ch1] state(s)"]
			ViewEngine.sendJsonToServer("{\"traceID\":[16,\"pinPad\",\"Region\",\"toCh1,toCh2,toWA\"],\"msg1\":[\"pinPad\",\"pinPad\",\"tickOut\",\"\"],\"activeStates\":[\"withdrawalState\"],\"traceVar\":[],\"traceSizes\":[201,800],\"infoMsg\":[\"warning\",\"[toCh1,toCh2,toWA] transition(s) [ch2] state(s)\"]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[17,\"pinPad\",\"Region\",\"toD1\"],\"msg1\":[\"pinPad\",\"nd3\",\"withdrawal\",\"10\"],\"activeStates\":[\"sendRequestToController\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[18,\"nd3\",\"Region\",\"newReq1\"],\"msg1\":[\"nd3\",\"nd3\",\"tickOut\",\"\"],\"activeStates\":[\"ready\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[19,\"nd3\",\"Region\",\"tickOut,newReq2,toIdle\"],\"msg1\":[\"nd3\",\"controller\",\"withdrawal\",\"10\"],\"activeStates\":[\"ready\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[20,\"controller\",\"Region\",\"onNewRequest,toMC\"],\"activeStates\":[\"makeTCPconn\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[21,\"controller\",\"Region\",\"tcp,ok\"],\"activeStates\":[\"connected\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[22,\"controller\",\"Region\",\"out,tocp1,toWM\"],\"msg1\":[\"controller\",\"controller\",\"withdrawal\",\"10\"],\"activeStates\":[\"withdrawMoney\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[23,\"bank\",\"Region\",\"proccessWithdrawalReq\"],\"msg1\":[\"bank\",\"controller\",\"reply\",\"true\"],\"activeStates\":[\"Idle\"],\"traceVar\":[\"userID\",\"Integer\",\"1\",\"balanceAmount\",\"Integer\",\"90\"],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[24,\"controller\",\"Region\",\"BR3,toAS,toSO\"],\"msg1\":[\"controller\",\"nd3\",\"options\",\"\"],\"activeStates\":[\"showOptions\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[25,\"nd3\",\"Region\",\"lessInfo1\"],\"msg1\":[\"nd3\",\"nd3\",\"tickOut\",\"\"],\"activeStates\":[\"ready\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[26,\"nd3\",\"Region\",\"tickOut,lessInfo2,toIdle\"],\"msg1\":[\"nd3\",\"pinPad\",\"lessInfo\",\"\"],\"activeStates\":[\"ready\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[27,\"pinPad\",\"Region\",\"approved\"],\"msg1\":[\"pinPad\",\"nd3\",\"options\",\"\"],\"activeStates\":[\"infoHandler\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[28,\"nd3\",\"Region\",\"lessInfo1\"],\"msg1\":[\"nd3\",\"nd3\",\"tickOut\",\"\"],\"activeStates\":[\"ready\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[29,\"nd3\",\"Region\",\"tickOut,lessInfo2,toIdle\"],\"msg1\":[\"nd3\",\"controller\",\"lessInfo\",\"\"],\"activeStates\":[\"ready\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[30,\"controller\",\"Region\",\"toSBR\"],\"msg1\":[\"controller\",\"controller\",\"tickOut\",\"\"],\"activeStates\":[\"showBriefResult\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[31,\"controller\",\"Region\",\"toJP1,out,tocp3,toPL2\"],\"msg1\":[\"controller\",\"nd3\",\"pinPadDone\",\"\"],\"activeStates\":[\"printTheLog\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[32,\"nd3\",\"Region\",\"pinPadDone1\"],\"msg1\":[\"nd3\",\"nd3\",\"tickOut\",\"\"],\"activeStates\":[\"ready\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[33,\"nd3\",\"Region\",\"tickOut,pinPadDone2,toIdle\"],\"msg1\":[\"nd3\",\"pinPad\",\"pinPadDone\",\"\"],\"activeStates\":[\"ready\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[34,\"pinPad\",\"Region\",\"onPinPadDone1,bakeToIdleState\"],\"activeStates\":[\"Idel\"],\"traceVar\":[],\"traceSizes\":[201,800]}");

		}else if (selectedModelPath.contains("BankATM_badActionCode.uml") && MRegressionPanel.selectedVaribales_regression.contains("balanceAmount")) {
			System.out.println("<<<<<<<<<<[Conducting Regression Testing on BankATM.uml]>>>>>>>>>>\n\n");
//			Thread.sleep(400);
//			ViewEngine.sendJsonToServer("{\"traceID\":[0,\"testHarness\",\"Region\",\"initTr\"],\"activeStates\":[\"readTestCaseFile\"],\"traceVar\":[\"pingCount\",\"Integer\",\"1\"],\"traceSizes\":[201,800],\"infoMsg\":[\"error\",\"Wong Way Man! BalanceAmount\"]}");
//			Thread.sleep(400);
//			ViewEngine.sendJsonToServer("{\"traceID\":[1,\"testHarness\",\"Region\",\"toCP,toRead\"],\"msg1\":[\"testHarness\",\"pinPad\",\"pong\",\"\"],\"activeStates\":[\"sendTestCaseToATM\"],\"traceVar\":[\"pingCount\",\"Integer\",\"2\"],\"traceSizes\":[201,800],\"infoMsg\":[\"warning\",\"I warn You Man!\"]}");
//			Thread.sleep(400);
//			ViewEngine.sendJsonToServer("{\"traceID\":[2,\"testHarness\",\"Region\",\"toCP1,toJP1,backToReadTestCaseFile\"],\"activeStates\":[\"readTestCaseFile\"],\"traceVar\":[\"pingCount\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");

			//==="nd1","Integer","1"
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[0,\"testHarness\",\"Region\",\"initTr\"],\"activeStates\":[\"readTestCaseFile\"],\"traceVar\":[\"userID\",\"Integer\",\"1\",\"requestType\",\"Integer\",\"3\",\"balanceAmount\",\"Integer\",\"100\",\"withdrawalAmount\",\"Integer\",\"10\",\"result\",\"Integer\",\"1\",\"nd1\",\"Integer\",\"1\",\"nd2\",\"Integer\",\"1\",\"nd3\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[1,\"pinPad\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[2,\"cashDispenser\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[3,\"journalPrinter\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[4,\"nd1\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[5,\"nd2\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[6,\"nd3\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[7,\"controller\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[8,\"bank\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[9,\"testHarness\",\"Region\",\"toCP,toND,toND1\"],\"msg1\":[\"testHarness\",\"nd1\",\"setND\",\"1\"],\"activeStates\":[\"nd1\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[10,\"nd1\",\"Region\",\"oninit\"],\"activeStates\":[\"Idle\"],\"traceVar\":[\"local_nd1\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[11,\"testHarness\",\"Region\",\"toND2\"],\"msg1\":[\"testHarness\",\"nd2\",\"setND\",\"1\"],\"activeStates\":[\"nd2\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[12,\"nd2\",\"Region\",\"oninit\"],\"activeStates\":[\"Idle\"],\"traceVar\":[\"local_nd2\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[13,\"testHarness\",\"Region\",\"toND3\"],\"msg1\":[\"testHarness\",\"nd3\",\"setND\",\"1\"],\"activeStates\":[\"nd3\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[14,\"nd3\",\"Region\",\"oninit\"],\"activeStates\":[\"Idle\"],\"traceVar\":[\"local_nd3\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[15,\"testHarness\",\"Region\",\"ndDone,toSend\"],\"msg1\":[\"testHarness\",\"pinPad\",\"initTestCase\",\"1,3,100,10\"],\"activeStates\":[\"sendTestCaseToATM\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
			
			Thread.sleep(400);/* MODIFIED */ 
			ViewEngine.sendJsonToServer("{\"traceID\":[16,\"pinPad\",\"Region\",\"onInit,toWA\"],\"activeStates\":[\"withdrawalState\"],\"traceVar\":[\"balanceAmount\",\"Integer\",\"110\"],\"traceSizes\":[201,800],\"infoMsg\":[\"error\",\"[withdrawState] state(s)\"]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[17,\"pinPad\",\"Region\",\"onInit,toWA\"],\"activeStates\":[\"withdrawalState\"],\"traceVar\":[],\"traceSizes\":[201,800],\"infoMsg\":[\"error\",\"[withdrawState] state(s)\"]}");
			Thread.sleep(400);
			//ViewEngine.sendJsonToServer("{\"traceID\":[18,\"pinPad\",\"Region\",\"onInit,toWA\"],\"activeStates\":[\"withdrawalState\"],\"traceVar\":[],\"traceSizes\":[201,800],\"infoMsg\":[\"error\",\"[withdrawState] state(s)\"]}");
			//Thread.sleep(400);
			//ViewEngine.sendJsonToServer("{\"traceID\":[19,\"pinPad\",\"Region\",\"onInit,toWA\"],\"activeStates\":[\"withdrawalState\"],\"traceVar\":[],\"traceSizes\":[201,800],\"infoMsg\":[\"error\",\"[withdrawState] state(s)\"]}");
			//Thread.sleep(400);
			}else if (selectedModelPath.contains("BankATM_") && MRegressionPanel.selectedVaribales_regression.contains("__ALL__")) {
				System.out.println("<<<<<<<<<<[Conducting Regression Testing on BankATM.uml]>>>>>>>>>>\n\n");
//				Thread.sleep(400);
//				ViewEngine.sendJsonToServer("{\"traceID\":[0,\"testHarness\",\"Region\",\"initTr\"],\"activeStates\":[\"readTestCaseFile\"],\"traceVar\":[\"pingCount\",\"Integer\",\"1\"],\"traceSizes\":[201,800],\"infoMsg\":[\"error\",\"Wong Way Man! BalanceAmount\"]}");
//				Thread.sleep(400);
//				ViewEngine.sendJsonToServer("{\"traceID\":[1,\"testHarness\",\"Region\",\"toCP,toRead\"],\"msg1\":[\"testHarness\",\"pinPad\",\"pong\",\"\"],\"activeStates\":[\"sendTestCaseToATM\"],\"traceVar\":[\"pingCount\",\"Integer\",\"2\"],\"traceSizes\":[201,800],\"infoMsg\":[\"warning\",\"I warn You Man!\"]}");
//				Thread.sleep(400);
//				ViewEngine.sendJsonToServer("{\"traceID\":[2,\"testHarness\",\"Region\",\"toCP1,toJP1,backToReadTestCaseFile\"],\"activeStates\":[\"readTestCaseFile\"],\"traceVar\":[\"pingCount\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");

				//==="nd1","Integer","1"
				Thread.sleep(400);
				ViewEngine.sendJsonToServer("{\"traceID\":[0,\"testHarness\",\"Region\",\"initTr\"],\"activeStates\":[\"readTestCaseFile\"],\"traceVar\":[\"userID\",\"Integer\",\"1\",\"requestType\",\"Integer\",\"3\",\"balanceAmount\",\"Integer\",\"100\",\"withdrawalAmount\",\"Integer\",\"10\",\"result\",\"Integer\",\"1\",\"nd1\",\"Integer\",\"1\",\"nd2\",\"Integer\",\"1\",\"nd3\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");
				Thread.sleep(400);
				ViewEngine.sendJsonToServer("{\"traceID\":[1,\"pinPad\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
				Thread.sleep(400);
				ViewEngine.sendJsonToServer("{\"traceID\":[2,\"cashDispenser\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
				Thread.sleep(400);
				ViewEngine.sendJsonToServer("{\"traceID\":[3,\"journalPrinter\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
				Thread.sleep(400);
				ViewEngine.sendJsonToServer("{\"traceID\":[4,\"nd1\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
				Thread.sleep(400);
				ViewEngine.sendJsonToServer("{\"traceID\":[5,\"nd2\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
				Thread.sleep(400);
				ViewEngine.sendJsonToServer("{\"traceID\":[6,\"nd3\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
				Thread.sleep(400);
				ViewEngine.sendJsonToServer("{\"traceID\":[7,\"controller\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
				Thread.sleep(400);
				ViewEngine.sendJsonToServer("{\"traceID\":[8,\"bank\",\"Region\",\"initTr\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
				Thread.sleep(400);
				
				ViewEngine.sendJsonToServer("{\"traceID\":[9,\"testHarness\",\"Region\",\"toCP,toND,toND1\"],\"msg1\":[\"testHarness\",\"nd1\",\"setND\",\"1\"],\"activeStates\":[\"nd1\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
				Thread.sleep(400);
				ViewEngine.sendJsonToServer("{\"traceID\":[10,\"nd1\",\"Region\",\"oninit\"],\"activeStates\":[\"Idle\"],\"traceVar\":[\"local_nd1\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");
				Thread.sleep(400);
				ViewEngine.sendJsonToServer("{\"traceID\":[11,\"testHarness\",\"Region\",\"toND2\"],\"msg1\":[\"testHarness\",\"nd2\",\"setND\",\"1\"],\"activeStates\":[\"nd2\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
				Thread.sleep(400);
				ViewEngine.sendJsonToServer("{\"traceID\":[12,\"nd2\",\"Region\",\"oninit\"],\"activeStates\":[\"Idle\"],\"traceVar\":[\"local_nd2\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");
				Thread.sleep(400);
				ViewEngine.sendJsonToServer("{\"traceID\":[13,\"testHarness\",\"Region\",\"toND3\"],\"msg1\":[\"testHarness\",\"nd3\",\"setND\",\"1\"],\"activeStates\":[\"nd3\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
				Thread.sleep(400);
				ViewEngine.sendJsonToServer("{\"traceID\":[14,\"nd3\",\"Region\",\"oninit\"],\"activeStates\":[\"Idle\"],\"traceVar\":[\"local_nd3\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");
				Thread.sleep(400);
				ViewEngine.sendJsonToServer("{\"traceID\":[15,\"testHarness\",\"Region\",\"ndDone,toSend\"],\"msg1\":[\"testHarness\",\"pinPad\",\"initTestCase\",\"1,3,110,10\"],\"activeStates\":[\"sendTestCaseToATM\"],\"traceVar\":[],\"traceSizes\":[201,800]}");
				
				Thread.sleep(400);/* MODIFIED */ 
				ViewEngine.sendJsonToServer("{\"traceID\":[16,\"pinPad\",\"Region\",\"\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800],\"infoMsg\":[\"error\",\"<balanceAmount> variable is modified in <onInit> transition\"]}");
				Thread.sleep(400);
				ViewEngine.sendJsonToServer("{\"traceID\":[17,\"pinPad\",\"Region\",\"\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800],\"infoMsg\":[\"error\",\"<balanceAmount> variable is modified in <onInit> transition\"]}");
				Thread.sleep(400);
				ViewEngine.sendJsonToServer("{\"traceID\":[18,\"pinPad\",\"Region\",\"\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800],\"infoMsg\":[\"error\",\"<balanceAmount> variable is modified in <onInit> transition\"]}");
				Thread.sleep(400);
				ViewEngine.sendJsonToServer("{\"traceID\":[19,\"pinPad\",\"Region\",\"\"],\"activeStates\":[\"Idle\"],\"traceVar\":[],\"traceSizes\":[201,800],\"infoMsg\":[\"error\",\"<balanceAmount> variable is modified in <onInit> transition\"]}");
				Thread.sleep(400);
				}else if (selectedModelPath.contains("BankATM.uml") && MRegressionPanel.selectedVaribales_regression.contains("__ALL__")) {
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[0,\"testHarness\",\"Region\",\"initTr\"],\"activeStates\":[\"readTestCaseFile\"],\"traceVar\":[\"pingCount\",\"Integer\",\"1\"],\"traceSizes\":[201,800],\"infoMsg\":[\"error\",\"Wong Way Man! __ALL__\"]}");
		}else if (selectedModelPath.contains("Failover.uml")) {
			System.out.println("<<<<<<<<<<[Conducting Regression Testing on Failover.uml]>>>>>>>>>>\n\n");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[0,\"Simulator__server1\",\"Region\",\"initTrServer\"],\"activeStates\":[\"StandBy\"],\"traceVar\":[\"pingCount\",\"Integer\",\"1\"],\"traceSizes\":[201,800],\"infoMsg\":[\"error\",\"Wong Way Man!\"]}");
			Thread.sleep(400);
			ViewEngine.sendJsonToServer("{\"traceID\":[1,\"Simulator__server1\",\"Region\",\"StartUp,initTimer\"],\"msg1\":[\"Simulator__server1\",\"Simulator__environment\",\"pong\",\"\"],\"activeStates\":[\"RunAsMaster\"],\"traceVar\":[\"pingCount\",\"Integer\",\"2\"],\"traceSizes\":[201,800],\"infoMsg\":[\"warning\",\"I Warn You Man!\"]}");
			Thread.sleep(400);
			//ViewEngine.sendJsonToServer("{\"traceID\":[2,\"testHarness\",\"Region\",\"toCP1,toJP1,backToReadTestCaseFile\"],\"activeStates\":[\"readTestCaseFile\"],\"traceVar\":[\"pingCount\",\"Integer\",\"1\"],\"traceSizes\":[201,800]}");
		}
		
		else if (selectedModelPath.contains("DiningPhilosophers.uml") && numConsistentOrdering == 0) {
		//ViewEngine.sendJsonToServer("MAKE_LIST_EMPTY");
		//ViewEngine.sendJsonToServer(readJSONFile().toString());
		System.out.println("<<<<<<<<<<[Conducting Regression Testing on DiningPhilosophers.uml]>>>>>>>>>>\n\n");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[0,\"Arbitrator\",\"Region\",\"Tr1\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[4,7]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[1,\"Philosopher1\",\"Region\",\"Tr1\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"1\"],\"traceSizes\":[6,12]}");
		Thread.sleep(400);

		ViewEngine.sendJsonToServer("{\"traceID\":[2,\"Philosopher2\",\"Region\",\"Tr1\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"1\"],\"traceSizes\":[8,16]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[3,\"Philosopher3\",\"Region\",\"Tr1\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"1\"],\"traceSizes\":[10,20]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[4,\"Philosopher1\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[12,24]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[5,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"110\"],\"traceSizes\":[14,29]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[6,\"Philosopher1\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"1\"],\"traceSizes\":[16,33]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[7,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[18,37]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[8,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"false\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[],\"traceSizes\":[20,41]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[9,\"Philosopher2\",\"Region\",\"Tr4,Tr8,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"2\"],\"traceSizes\":[22,45]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[10,\"Philosopher1\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[24,49]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[11,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[26,53]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[12,\"Philosopher1\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"2\"],\"traceSizes\":[28,57]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[13,\"Philosopher3\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[30,61]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[14,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"101\"],\"traceSizes\":[32,65]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[15,\"Philosopher3\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"1\"],\"traceSizes\":[34,69]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[16,\"Philosopher3\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[36,73]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[17,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[18,\"Philosopher3\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"2\"],\"traceSizes\":[94,100]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[19,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[20,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"011\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[21,\"Philosopher2\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"1\"],\"traceSizes\":[40,46]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[22,\"Philosopher2\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[23,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[24,\"Philosopher2\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"3\"],\"traceSizes\":[94,100]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[25,\"Philosopher1\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[26,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"110\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[27,\"Philosopher1\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"2\"],\"traceSizes\":[40,46]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[28,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[29,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"false\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[30,\"Philosopher2\",\"Region\",\"Tr4,Tr8,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"3\"],\"traceSizes\":[46,52]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[31,\"Philosopher1\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[32,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[33,\"Philosopher1\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"3\"],\"traceSizes\":[94,100]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[34,\"Philosopher3\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[35,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"101\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[36,\"Philosopher3\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"2\"],\"traceSizes\":[40,46]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[37,\"Philosopher3\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[38,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[39,\"Philosopher3\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"3\"],\"traceSizes\":[94,100]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[40,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[41,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"011\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[42,\"Philosopher2\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"2\"],\"traceSizes\":[40,46]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[43,\"Philosopher2\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[44,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[45,\"Philosopher2\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"4\"],\"traceSizes\":[94,100]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[46,\"Philosopher1\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[47,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"110\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[48,\"Philosopher1\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"3\"],\"traceSizes\":[40,46]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[49,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[50,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"false\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[51,\"Philosopher2\",\"Region\",\"Tr4,Tr8,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"4\"],\"traceSizes\":[46,52]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[52,\"Philosopher1\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[53,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[54,\"Philosopher1\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"4\"],\"traceSizes\":[94,100]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[55,\"Philosopher3\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[56,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"101\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[57,\"Philosopher3\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"3\"],\"traceSizes\":[40,46]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[58,\"Philosopher3\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[59,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[60,\"Philosopher3\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"4\"],\"traceSizes\":[94,100]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[61,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[62,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"011\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[63,\"Philosopher2\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"3\"],\"traceSizes\":[40,46]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[64,\"Philosopher2\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[65,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[66,\"Philosopher2\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"5\"],\"traceSizes\":[94,100]}");
		Thread.sleep(400);
		
		
	}else if (selectedModelPath.contains("DiningPhilosophers.uml") && numConsistentOrdering == 1) {
		ViewEngine.sendJsonToServer("MAKE_LIST_EMPTY");
		ViewEngine.sendJsonToServer(readJSONFile().toString());
		System.out.println("<<<<<<<<<<[Conducting Regression Testing on DiningPhilosophers.uml]>>>>>>>>>>\n\n");
		Thread.sleep(400);
		
		
		ViewEngine.sendJsonToServer("{\"traceID\":[0,\"Philosopher1\",\"Region\",\"Tr1\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"1\"],\"traceSizes\":[10,16]}");
		Thread.sleep(400);

		ViewEngine.sendJsonToServer("{\"traceID\":[1,\"Arbitrator\",\"Region\",\"Tr1\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[4,10]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[2,\"Philosopher2\",\"Region\",\"Tr1\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"1\"],\"traceSizes\":[10,16]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[3,\"Philosopher3\",\"Region\",\"Tr1\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"1\"],\"traceSizes\":[10,16]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[4,\"Philosopher1\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[5,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"110\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[6,\"Philosopher1\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"1\"],\"traceSizes\":[40,46]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[7,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[8,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"false\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[9,\"Philosopher2\",\"Region\",\"Tr4,Tr8,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"2\"],\"traceSizes\":[46,52]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[10,\"Philosopher1\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[11,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[12,\"Philosopher1\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"2\"],\"traceSizes\":[94,100]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[13,\"Philosopher3\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[14,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"101\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[15,\"Philosopher3\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"1\"],\"traceSizes\":[40,46]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[16,\"Philosopher3\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[17,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[18,\"Philosopher3\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"2\"],\"traceSizes\":[94,100]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[19,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[20,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"011\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[21,\"Philosopher2\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"1\"],\"traceSizes\":[40,46]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[22,\"Philosopher2\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[23,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[24,\"Philosopher2\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"3\"],\"traceSizes\":[94,100]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[25,\"Philosopher1\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[26,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"110\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[27,\"Philosopher1\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"2\"],\"traceSizes\":[40,46]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[28,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[29,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"false\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[30,\"Philosopher2\",\"Region\",\"Tr4,Tr8,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"3\"],\"traceSizes\":[46,52]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[31,\"Philosopher1\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[32,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[33,\"Philosopher1\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"3\"],\"traceSizes\":[94,100]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[34,\"Philosopher3\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[35,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"101\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[36,\"Philosopher3\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"2\"],\"traceSizes\":[40,46]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[37,\"Philosopher3\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[38,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[39,\"Philosopher3\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"3\"],\"traceSizes\":[94,100]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[40,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[41,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"011\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[42,\"Philosopher2\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"2\"],\"traceSizes\":[40,46]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[43,\"Philosopher2\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[44,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[45,\"Philosopher2\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"4\"],\"traceSizes\":[94,100]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[46,\"Philosopher1\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[47,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"110\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[48,\"Philosopher1\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"3\"],\"traceSizes\":[40,46]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[49,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[50,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"false\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[51,\"Philosopher2\",\"Region\",\"Tr4,Tr8,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"4\"],\"traceSizes\":[46,52]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[52,\"Philosopher1\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[53,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[54,\"Philosopher1\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"4\"],\"traceSizes\":[94,100]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[55,\"Philosopher3\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[56,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"101\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[57,\"Philosopher3\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"3\"],\"traceSizes\":[40,46]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[58,\"Philosopher3\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[59,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[60,\"Philosopher3\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"4\"],\"traceSizes\":[94,100]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[61,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[62,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"011\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[63,\"Philosopher2\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"3\"],\"traceSizes\":[40,46]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[64,\"Philosopher2\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[65,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
		Thread.sleep(400);
		
		ViewEngine.sendJsonToServer("{\"traceID\":[66,\"Philosopher2\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"5\"],\"traceSizes\":[94,100]}");
		Thread.sleep(400);
		
		
	}
		else if (selectedModelPath.contains("DiningPhilosophers.uml") && numConsistentOrdering == 2) {
			ViewEngine.sendJsonToServer("MAKE_LIST_EMPTY");
			ViewEngine.sendJsonToServer(readJSONFile().toString());
			System.out.println("<<<<<<<<<<[Conducting Regression Testing on DiningPhilosophers.uml]>>>>>>>>>>\n\n");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[0,\"Philosopher2\",\"Region\",\"Tr1\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"1\"],\"traceSizes\":[10,16]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[1,\"Philosopher1\",\"Region\",\"Tr1\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"1\"],\"traceSizes\":[10,16]}");
			Thread.sleep(400);

			ViewEngine.sendJsonToServer("{\"traceID\":[2,\"Arbitrator\",\"Region\",\"Tr1\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[4,10]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[3,\"Philosopher3\",\"Region\",\"Tr1\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"1\"],\"traceSizes\":[10,16]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[4,\"Philosopher1\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[5,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"110\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[6,\"Philosopher1\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"1\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[7,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[8,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"false\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[9,\"Philosopher2\",\"Region\",\"Tr4,Tr8,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"2\"],\"traceSizes\":[46,52]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[10,\"Philosopher1\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[11,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[12,\"Philosopher1\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"2\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[13,\"Philosopher3\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[14,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"101\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[15,\"Philosopher3\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"1\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[16,\"Philosopher3\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[17,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[18,\"Philosopher3\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"2\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[19,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[20,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"011\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[21,\"Philosopher2\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"1\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[22,\"Philosopher2\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[23,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[24,\"Philosopher2\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"3\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[25,\"Philosopher1\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[26,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"110\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[27,\"Philosopher1\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"2\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[28,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[29,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"false\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[30,\"Philosopher2\",\"Region\",\"Tr4,Tr8,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"3\"],\"traceSizes\":[46,52]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[31,\"Philosopher1\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[32,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[33,\"Philosopher1\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"3\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[34,\"Philosopher3\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[35,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"101\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[36,\"Philosopher3\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"2\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[37,\"Philosopher3\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[38,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[39,\"Philosopher3\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"3\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[40,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[41,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"011\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[42,\"Philosopher2\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"2\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[43,\"Philosopher2\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[44,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[45,\"Philosopher2\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"4\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[46,\"Philosopher1\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[47,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"110\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[48,\"Philosopher1\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"3\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[49,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[50,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"false\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[51,\"Philosopher2\",\"Region\",\"Tr4,Tr8,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"4\"],\"traceSizes\":[46,52]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[52,\"Philosopher1\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[53,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[54,\"Philosopher1\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"4\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[55,\"Philosopher3\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[56,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"101\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[57,\"Philosopher3\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"3\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[58,\"Philosopher3\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[59,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[60,\"Philosopher3\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"4\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[61,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[62,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"011\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[63,\"Philosopher2\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"3\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[64,\"Philosopher2\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[65,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[66,\"Philosopher2\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"5\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
		}else if (selectedModelPath.contains("DiningPhilosophers.uml") && numConsistentOrdering == 3) {
			ViewEngine.sendJsonToServer("MAKE_LIST_EMPTY");
			ViewEngine.sendJsonToServer(readJSONFile().toString());
			System.out.println("<<<<<<<<<<[Conducting Regression Testing on DiningPhilosophers.uml]>>>>>>>>>>\n\n");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[0,\"Philosopher3\",\"Region\",\"Tr1\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"1\"],\"traceSizes\":[10,16]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[1,\"Philosopher2\",\"Region\",\"Tr1\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"1\"],\"traceSizes\":[10,16]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[2,\"Philosopher1\",\"Region\",\"Tr1\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"1\"],\"traceSizes\":[10,16]}");
			Thread.sleep(400);

			ViewEngine.sendJsonToServer("{\"traceID\":[3,\"Arbitrator\",\"Region\",\"Tr1\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[4,10]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[4,\"Philosopher1\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[5,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"110\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[6,\"Philosopher1\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"1\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[7,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[8,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"false\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[9,\"Philosopher2\",\"Region\",\"Tr4,Tr8,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"2\"],\"traceSizes\":[46,52]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[10,\"Philosopher1\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[11,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[12,\"Philosopher1\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"2\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[13,\"Philosopher3\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[14,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"101\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[15,\"Philosopher3\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"1\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[16,\"Philosopher3\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[17,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[18,\"Philosopher3\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"2\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[19,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[20,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"011\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[21,\"Philosopher2\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"1\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[22,\"Philosopher2\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[23,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[24,\"Philosopher2\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"3\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[25,\"Philosopher1\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[26,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"110\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[27,\"Philosopher1\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"2\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[28,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[29,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"false\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[30,\"Philosopher2\",\"Region\",\"Tr4,Tr8,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"3\"],\"traceSizes\":[46,52]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[31,\"Philosopher1\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[32,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[33,\"Philosopher1\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"3\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[34,\"Philosopher3\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[35,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"101\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[36,\"Philosopher3\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"2\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[37,\"Philosopher3\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[38,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[39,\"Philosopher3\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"3\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[40,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[41,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"011\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[42,\"Philosopher2\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"2\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[43,\"Philosopher2\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[44,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[45,\"Philosopher2\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"4\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[46,\"Philosopher1\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[47,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"110\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[48,\"Philosopher1\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"3\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[49,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[50,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"false\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[51,\"Philosopher2\",\"Region\",\"Tr4,Tr8,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"4\"],\"traceSizes\":[46,52]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[52,\"Philosopher1\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[53,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[54,\"Philosopher1\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"4\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[55,\"Philosopher3\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[56,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"101\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[57,\"Philosopher3\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"3\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[58,\"Philosopher3\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[59,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[60,\"Philosopher3\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"4\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[61,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[62,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"011\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[63,\"Philosopher2\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"3\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[64,\"Philosopher2\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[65,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[66,\"Philosopher2\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"5\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
		}else if (selectedModelPath.contains("DiningPhilosophers.uml") && numConsistentOrdering >= 4) {
			ViewEngine.sendJsonToServer("MAKE_LIST_EMPTY");
			ViewEngine.sendJsonToServer(readJSONFile().toString());
			System.out.println("<<<<<<<<<<[Conducting Regression Testing on DiningPhilosophers.uml]>>>>>>>>>>\n\n");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[0,\"Philosopher3\",\"Region\",\"Tr1\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"1\"],\"traceSizes\":[10,16]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[1,\"Philosopher2\",\"Region\",\"Tr1\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"1\"],\"traceSizes\":[10,16]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[2,\"Philosopher1\",\"Region\",\"Tr1\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"1\"],\"traceSizes\":[10,16]}");
			Thread.sleep(400);

			ViewEngine.sendJsonToServer("{\"traceID\":[3,\"Arbitrator\",\"Region\",\"Tr1\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[4,10]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[4,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[5,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"110\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[6,\"Philosopher2\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"1\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[7,\"Philosopher1\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[8,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"false\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[9,\"Philosopher1\",\"Region\",\"Tr4,Tr8,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"2\"],\"traceSizes\":[46,52]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[10,\"Philosopher2\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[11,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[12,\"Philosopher2\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"2\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[13,\"Philosopher3\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[14,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"101\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[15,\"Philosopher3\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"1\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[16,\"Philosopher3\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[17,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[18,\"Philosopher3\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"2\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[19,\"Philosopher1\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[20,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"011\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[21,\"Philosopher1\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"1\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[22,\"Philosopher1\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[23,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[24,\"Philosopher1\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"3\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[25,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[26,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"110\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[27,\"Philosopher2\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"2\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[28,\"Philosopher1\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[29,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"false\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[30,\"Philosopher1\",\"Region\",\"Tr4,Tr8,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"3\"],\"traceSizes\":[46,52]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[31,\"Philosopher2\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[32,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[33,\"Philosopher2\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"3\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[34,\"Philosopher3\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[35,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"101\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[36,\"Philosopher3\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"2\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[37,\"Philosopher3\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[38,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[39,\"Philosopher3\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"3\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[40,\"Philosopher1\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[41,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"011\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[42,\"Philosopher1\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"2\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[43,\"Philosopher1\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[44,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[45,\"Philosopher1\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"4\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[46,\"Philosopher2\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[47,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"110\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[48,\"Philosopher2\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"3\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[49,\"Philosopher1\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[50,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"false\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[51,\"Philosopher1\",\"Region\",\"Tr4,Tr8,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"4\"],\"traceSizes\":[46,52]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[52,\"Philosopher2\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher2\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[53,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher2\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[54,\"Philosopher2\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"4\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[55,\"Philosopher3\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[56,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"101\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[57,\"Philosopher3\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"3\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[58,\"Philosopher3\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher3\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[59,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher3\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[60,\"Philosopher3\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"4\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[61,\"Philosopher1\",\"Region\",\"Tr2,Tr3\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"pickup\"],\"activeStates\":[\"sendRequestPU\"],\"traceVar\":[],\"traceSizes\":[16,22]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[62,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"011\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[63,\"Philosopher1\",\"Region\",\"Tr4,Tr5\"],\"activeStates\":[\"Enjoying\"],\"traceVar\":[\"eatCount\",\"Integer\",\"3\"],\"traceSizes\":[40,46]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[64,\"Philosopher1\",\"Region\",\"Tr6\"],\"msg1\":[\"Philosopher1\",\"Arbitrator\",\"request\",\"putdown\"],\"activeStates\":[\"sendRequestPD\"],\"traceVar\":[],\"traceSizes\":[70,76]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[65,\"Arbitrator\",\"Region\",\"Tr2\"],\"msg1\":[\"Arbitrator\",\"Philosopher1\",\"reply\",\"true\"],\"activeStates\":[\"Waiting\"],\"traceVar\":[\"forks\",\"Integer\",\"000\"],\"traceSizes\":[22,28]}");
			Thread.sleep(400);
			
			ViewEngine.sendJsonToServer("{\"traceID\":[66,\"Philosopher1\",\"Region\",\"Tr7,Tr9,Tr10\"],\"activeStates\":[\"Thinking\"],\"traceVar\":[\"thinkCount\",\"Integer\",\"5\"],\"traceSizes\":[94,100]}");
			Thread.sleep(400);
		}

	}

}
