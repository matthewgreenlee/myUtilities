package com.goldenpond.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Loader {

	public Properties load(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		Properties props = new Properties();
		props.load(fis);
		return props;
	}

	public Properties load(String resource) throws IOException {
		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(resource);
		Properties props = new Properties();
		props.load(is);
		return props;
	}
}
