package com.peopleinteractive.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONUtils {

	public static String JSON_FILE_PATH = System.getProperty("user.dir") + "/Report/output.json";

	public static String USERDATA_JSON_FILE_PATH = System.getProperty("user.dir") + "/src/main/resources/UserData.json";

	public static String TESTMAPPING_JSON_FILE_PATH = System.getProperty("user.dir")
			+ "/src/main/resources/TestMapping.json";

	@SuppressWarnings("unchecked")
	public static void insertDataToJSON(String testScenario, String testDesription, String testName, String error) {

		try {
			// Creating a JSONObject object
			JSONParser jsonParser = new JSONParser();
			Object obj = jsonParser.parse(new FileReader(JSON_FILE_PATH));

			JSONObject finalOutput = new JSONObject();

			finalOutput = (JSONObject) obj;

			JSONArray solutions = new JSONArray();

			solutions = (JSONArray) finalOutput.get("Report data");

			JSONObject jsonObject = new JSONObject();
			// Inserting key-value pairs into the json object
			jsonObject.put("testScenario", testScenario);
			jsonObject.put("testDesription", testDesription);
			jsonObject.put("testName", testName);
			jsonObject.put("error", error);

			solutions.add(jsonObject);

			finalOutput.put("Report data", solutions);
			FileWriter file = new FileWriter(JSON_FILE_PATH);
			file.write(finalOutput.toJSONString());
			file.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some issues while writing json File");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Some issues while parsing json File");

		}

	}

	public static JSONArray readJSONArray() {
		// Creating a JSONObject object
		JSONArray solutions = new JSONArray();

		try {
			JSONParser jsonParser = new JSONParser();
			Object obj = jsonParser.parse(new FileReader(JSON_FILE_PATH));

			JSONObject finalOutput = new JSONObject();

			finalOutput = (JSONObject) obj;

			solutions = (JSONArray) finalOutput.get("Report data");
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Some issues while JSON parsing");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("JSON file not found");

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Some issues while reading JSON file");

		}

		return solutions;
	}

	@SuppressWarnings("unchecked")
	public static void emptyJSOnArray() {
		try {
			JSONParser jsonParser = new JSONParser();
			Object obj = jsonParser.parse(new FileReader(JSON_FILE_PATH));

			JSONObject finalOutput = new JSONObject();

			finalOutput = (JSONObject) obj;

			JSONArray solutions = new JSONArray();

			solutions = (JSONArray) finalOutput.get("Report data");

			solutions.clear();

			finalOutput.put("Report data", solutions);

			FileWriter file = new FileWriter(JSON_FILE_PATH);
			file.write(finalOutput.toJSONString());
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<String> getuserData(String UserType) {
		List<String> userdata = new ArrayList<String>();

		try {
			JSONParser jsonParser = new JSONParser();
			Object obj = jsonParser.parse(new FileReader(USERDATA_JSON_FILE_PATH));

			JSONObject finalOutput = new JSONObject();

			finalOutput = (JSONObject) obj;

			JSONArray solutions = new JSONArray();

			solutions = (JSONArray) finalOutput.get("dataSet");

			for (int i = 0; i < solutions.size(); i++) {
				JSONObject objects = (JSONObject) solutions.get(i);
				if (objects.get("UserType").toString().equalsIgnoreCase(UserType)) {
					userdata.add(objects.get("username").toString());
					userdata.add(objects.get("password").toString());
					userdata.add(objects.get("Userstatus").toString());
					userdata.add(objects.get("SHID").toString());
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		if(userdata == null || userdata.isEmpty()) {
			System.out.println("No Matching usertype found in the json file.Please check the UserType or add a new entry to UserData.json");
		}
		
		return userdata;
	}

	public static List<String> getuserType(String testname) throws FileNotFoundException, IOException, ParseException {
		List<String> userdata = new ArrayList<String>();
		try {
			JSONParser jsonParser = new JSONParser();
			Object obj = jsonParser.parse(new FileReader(TESTMAPPING_JSON_FILE_PATH));

			JSONObject finalOutput = new JSONObject();

			finalOutput = (JSONObject) obj;

			JSONArray solutions = new JSONArray();

			solutions = (JSONArray) finalOutput.get("dataSet");

			for (int i = 0; i < solutions.size(); i++) {
				JSONObject objects = (JSONObject) solutions.get(i);
				if (objects.get("TestName").toString().equalsIgnoreCase(testname)) {
					userdata.add(objects.get("UserType").toString());
					userdata.add(objects.get("pod").toString());
					userdata.add(objects.get("suite").toString());
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(userdata == null || userdata.isEmpty()) {
			System.out.println("No Matching Testname found in the json file.Please check the UserType or add a new entry to TestMapping.json");
		}

		
		return userdata;
	}

	
	
	
	
	public static Map<String, String> getUserList() throws IOException {

		Map<String, String> userdata = new HashMap<>();

		try {

			JSONParser jsonParser = new JSONParser();
			Object obj = jsonParser.parse(new FileReader(USERDATA_JSON_FILE_PATH));

			JSONObject finalOutput = new JSONObject();

			finalOutput = (JSONObject) obj;

			JSONArray solutions = new JSONArray();

			solutions = (JSONArray) finalOutput.get("dataSet");

			for (int i = 0; i < solutions.size(); i++) {
				JSONObject objects = (JSONObject) solutions.get(i);
				userdata.put(objects.get("username").toString(), objects.get("password").toString());
			}

		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());
		}
		return userdata;

	}

}
