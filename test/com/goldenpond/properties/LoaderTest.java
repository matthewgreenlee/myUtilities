package com.goldenpond.properties;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

public class LoaderTest {

	private Loader loader;

	@Before
	public void setUp() {
		loader = new Loader();
	}

	@Test
	public void testLoadFile() throws IOException {
		File file = new File("F:\\workspace\\GCode\\commons-utilities\\test\\com\\goldenpond\\properties\\goldenpond.properties");
		Properties properties = loader.load(file);
		String actual = properties.getProperty("name");
		assertEquals("goldenpond", actual);
	}

	@Test
	public void testLoadResource() throws IOException {
		Properties properties = loader.load("com/goldenpond/properties/goldenpond.properties");
		String actual = properties.getProperty("name");
		assertEquals("goldenpond", actual);
	}
}
