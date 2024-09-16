package com.peopleinteractive.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ROGChecker {

	public static int counter;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			Map<String, String> userlist = JSONUtils.getUserList();// get the username and password from UserData.xlsx
																	// file
			Iterator<Entry<String, String>> itr = userlist.entrySet().iterator();
			while (itr.hasNext()) {
				Entry<String, String> pair = itr.next();
				postTest(pair.getKey().toString(), pair.getValue().toString());

			}

			if (counter >= 1) {

				throw new Error("*");
			}

		} catch (IOException | JSONException | ParseException e) {
			e.printStackTrace();

			System.out.println("Exception occured " + e.getMessage());
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void postTest(String Username, String pass)
			throws ClientProtocolException, IOException, JSONException, ParseException {

		// Create a Json payload with the provided Username and password
		HashMap<Object, Object> requestParams = new HashMap<Object, Object>();
		requestParams.put("username", Username);
		requestParams.put("password", pass);
		JSONObject userCreds = new JSONObject(requestParams);

		JSONObject finalJsonPayload = new JSONObject();
		finalJsonPayload.put("data", userCreds);

		// Call to Login API to check the current status of the profile
		HttpClient httpClient = HttpClientBuilder.create().build();
		StringEntity params = new StringEntity(finalJsonPayload.toString());
		HttpPost request = new HttpPost("http://ww4.shaadi.com/api/users/login");
		request.addHeader("Content-Type", "application/json");
		request.addHeader("X-APP-KEY", "69c3f1c1ea31d60aa5516a439bb65949cf3f8a1330679fa7ff91fc9a5681b564");
		request.addHeader("X-Platform", "web");
		request.setEntity(params);
		HttpResponse response = httpClient.execute(request);

		HttpEntity entity = response.getEntity();

		if (entity != null) {

			// A Simple JSON Response Read
			InputStream instream = entity.getContent();

			// Json Object to parse the response from API
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(new InputStreamReader(instream, "UTF-8"));

			Map data = ((Map) jsonObject.get("data"));

			if (data == null) {
				System.out.println("Data is null for username " +Username);
			}

			if(data!=null) {
			Iterator<Map.Entry> itr1 = data.entrySet().iterator();
			while (itr1.hasNext()) {
				Map.Entry pair = itr1.next();
				if (pair.getKey().toString().equals("next_action")) {
					// Print the profiles which are not in active state
					if (!pair.getValue().toString().equalsIgnoreCase("PROFILE_ACTIVE")) {
						System.out.println(
								"The Status of the User - " + Username + " is : " + pair.getValue().toString() + " ");
						counter++;
					}
				}
			}
			}

			instream.close();

		}

	}

}
