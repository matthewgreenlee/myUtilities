package com.goldenpond.extraction;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ZipUtilTest {

	private ZipUtil util;
	private String jarPath;
	private String dest;
	
	@Before
	public void setUp() {
		util = new ZipUtil();
		dest = "./extractionDest";
		jarPath = "bin/com/goldenpond/extraction/resource.jar";
	}

	@Test
	public void testExtract() throws IOException {
		String resource = "OutOfFolder.txt";
		util.extract(jarPath, resource, dest);
		assertTrue(new File(dest + File.separator + resource).exists());
	}

	@Test
	public void testListEntries() throws IOException {
	    util.listEntries(jarPath);
	}

	@Test
	public void testExtractAll() throws IOException {
		util.extract(jarPath, dest);
	}

	@After
	public void tearDown() {
		util = null;
		new File(dest).delete();
	}
}
