package com.java.iq.dynamic.programming;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ReadWriteFile {

	public static void main(String[] args) {
		writeToPropertiesFile();
		readFromPropertiesFile();
		deleteFile();
	}

	private static void writeToPropertiesFile() {
		OutputStream output = null;
		try {
			final Properties prop = new Properties();
			// set the properties value
			prop.setProperty("database", "localhost");
			prop.setProperty("dbuser", "mkyong");
			prop.setProperty("dbpassword", "password");

			// save properties to project root folder
			output = new FileOutputStream("config.properties", true);
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	private static void readFromPropertiesFile() {
		InputStream input = null;
		try {
			input = new FileInputStream("config.properties");

			// Read file from classpath
			// input = App.class.getClassLoader().getResourceAsStream(filename);
			// if(input == null) {
			// System.out.println("Sorry, unable to find " + filename);
			// return;
			// }

			// load a properties file
			final Properties prop = new Properties();
			prop.load(input);

			// get the property value and print it out
			System.out.println(prop.getProperty("database"));
			System.out.println(prop.getProperty("dbuser"));
			System.out.println(prop.getProperty("dbpassword"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void deleteFile() {
		try {
			File file = new File("config.properties");
			// Safe way to delete a file
			// if(Files.deleteIfExists(file.toPath())) {
			if (file.delete()) {
				System.out.println(file.getName() + " is deleted!");
			} else {
				System.out.println("Delete operation is failed.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
