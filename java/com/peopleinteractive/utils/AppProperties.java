package com.peopleinteractive.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppProperties {


	/*
	 * AppProperties is basically used to get configuration inputs from the user
	 * before running the automation process the app.properties file is loaded into
	 * the project using this and it consist of various parameters like
	 * deviceName,deviceID ,PlatformType etc.
	 */
	private static AppProperties appProperties;

	public static final String PROPERTY_FILE_NAME = "app.properties";

	private static Properties properties = new Properties();

	/*
	 * This method is used to load the properties file from the system
	 * properties.load(is) is used in this method to load the actual file
	 */
	private AppProperties() {

		InputStream is = null;
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			is = loader.getResourceAsStream(PROPERTY_FILE_NAME);

			properties.load(is);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception Occured " + e.getMessage());
			} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					System.out.println("Exception Occured " + e.getMessage());
					}
			}
		}

	}

	public static AppProperties getInstance() {
		if (appProperties == null) {
			appProperties = new AppProperties();
		}
		return appProperties;
	}

	/*
	 * The getProperty() method of java is used here to pass the key and default
	 * value ,in order to set the parameters sepcified by the endUser if the key
	 * value has not been defined into the property files,the application then
	 * starts to work with the deafult values specified in the programme code
	 */
	public static String getProperty(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}
	

	public static void setProperty(String key, String value) throws IOException {
		File file = new File(System.getProperty("user.dir") + "/src/main/resources/app.properties");
        FileOutputStream fos = new FileOutputStream(file);

		 properties.setProperty(key, value);
		 properties.store(fos , "Updated properties file");
		 //System.out.println(properties);

	}

	// TODO add other methods to get individual datatype properties like
	// getInteger, etc

}
