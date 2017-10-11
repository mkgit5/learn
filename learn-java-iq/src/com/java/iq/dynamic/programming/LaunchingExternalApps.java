package com.java.iq.dynamic.programming;

import java.io.IOException;

public class LaunchingExternalApps {

	public static void main(String[] args) {
		// Getting Runtime object
		Runtime runtime = Runtime.getRuntime();
		try {
			// Opens new notepad instance
			runtime.exec("notepad.exe");
			// OR runtime.exec("notepad");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}