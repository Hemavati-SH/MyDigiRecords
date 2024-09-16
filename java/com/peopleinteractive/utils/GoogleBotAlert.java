package com.peopleinteractive.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;
import org.testng.ITestResult;

public class GoogleBotAlert {

	public static void sendData(String pod, ITestResult result) throws ClientProtocolException, IOException {

		BufferedReader rd = null;

		try {
			String A1 = "https://chat.googleapis.com/v1/spaces/AAAA8bXDDuY/messages?key=AIzaSyDdI0hCZtE6vySjMm-WEfRq3CPzqKqqsHI&token=fjUJtoIleVKyXy9E69q6cewcehvi4GdmumiClgNTcMM%3D";
			String A2 = "https://chat.googleapis.com/v1/spaces/AAAA8bXDDuY/messages?key=AIzaSyDdI0hCZtE6vySjMm-WEfRq3CPzqKqqsHI&token=EUmubnw44ZTmc_GCdnQ5OPYIQFhpwhAVnNad4oX-YHg%3D";
			String A3 = "https://chat.googleapis.com/v1/spaces/AAAA8bXDDuY/messages?key=AIzaSyDdI0hCZtE6vySjMm-WEfRq3CPzqKqqsHI&token=TyMkvQQGOW7imb12fiEPla0Dn8tKALOp2uqpsdAYGwY%3D";
			String url = "";
			String failmessage = "";
			if (result.getThrowable() != null) {
				final Throwable testResultThrowable = result.getThrowable();
				failmessage = testResultThrowable.getMessage() != null ? testResultThrowable.getMessage()
						: testResultThrowable.getCause().getMessage();

				if (failmessage == null) {
					failmessage = "Test failed";
				}

			}

			if (pod.equals("acquisition"))
				url = A1;
			else if (pod.equals("matchmaking"))
				url = A2;
			else
				url = A3;

			String s = "[TEST FAILURE ALERT]\n"
					+ "-------------------------------------------------------------------------------------------------\n"
					+ "[SUITE NAME] ---  " + result.getTestContext().getCurrentXmlTest().getSuite().getName() + "\n"
					+ "-------------------------------------------------------------------------------------------------\n"
					+ "[CLASS NAME] ---  " + result.getInstanceName() + "\n"
					+ "-------------------------------------------------------------------------------------------------\n"
					+ "[METHOD NAME] ---  " + result.getName() + "\n"
					+ "-------------------------------------------------------------------------------------------------\n"
					+ "[ERROR MESSAGE] ---  " + failmessage + "\n"
					+ "-------------------------------------------------------------------------------------------------\n";

//
//
//			ObjectMapper mapper = new ObjectMapper();
//			String json = "{\r\n" + "	\"cards\": [{\r\n" + "		\"sections\": [{\r\n"
//					+ "			\"widgets\": [{\r\n" + "				\"keyValue\": {\r\n"
//					+ "					\"topLabel\": \"[FAIL]\",\r\n" + "					\"content\": \"failure message\",\r\n"
//					+ "					\"contentMultiline\": \"true\",\r\n"
//					+ "					\"bottomLabel\": \"Delayed\",\r\n" + "					\"icon\": \"TICKET\"\r\n"
//					+ "\r\n" + "				}\r\n" + "			}]\r\n" + "		}]\r\n" + "	}]\r\n" + "}";
//
//			// convert JSON string to Map
//			Map<Object, Object> map = mapper.readValue(json, Map.class);
//
//			Object obj = new JSONParser().parse(json);
//	        JSONObject jo = JSONObject(obj); 
//	        Map cards = (Map) ((Map)jo.get("keyValue")); 
//	        Iterator<Map.Entry> itr1 = cards.entrySet().iterator(); 
//	        while (itr1.hasNext()) { 
//	            Map.Entry pair = itr1.next(); 
//	            System.out.println(pair.getKey() + " : " + pair.getValue()); 
//	        } 

			// HashMap<Object, Object> card = new HashMap<Object, Object>();

			HashMap<Object, Object> map = new HashMap<Object, Object>();
			map.put("text", s);
			JSONObject requestParamsJson = new JSONObject(map);

			final HttpClient client = HttpClientBuilder.create().build();
			final HttpPost request = new HttpPost(url);
			// final StringEntity params = new StringEntity("{\"text\":\"[FAIL]\"}");

			final StringEntity params = new StringEntity(requestParamsJson.toString());
			// request.addHeader("Content-Type", "application/json; charset=UTF-8");
			request.addHeader("Content-Type", "application/json");
			request.setEntity(params);
			final HttpResponse response = client.execute(request);
			System.out.println(response.getStatusLine().getStatusCode());

			rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result1 = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				result1.append(line);
			}

			System.out.println(result1.toString());
		} catch (Exception e) {
			System.out.println("Exception Occured " + e.getMessage());
		}

		finally {
			if (rd != null) {
				rd.close();
			}
		}
	}
}
