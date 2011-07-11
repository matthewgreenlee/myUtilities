package com.goldenpond.extraction;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JarExtractorTest {

	private JarExtractor extractor;
	private String jarPath;
	private String dest;
	
	@Before
	public void setUp() {
		extractor = new JarExtractor();
		dest = "./extractionDest";
		jarPath = "bin/com/goldenpond/extraction/resource.jar";
	}

	@Test
	public void testExtract() throws IOException {
		String resource = "OutOfFolder.txt";
		extractor.extract(jarPath, resource, dest);
		assertTrue(new File(dest + File.separator + resource).exists());
	}

	@Test
	public void testExtractAll() throws IOException {
		extractor.extract(jarPath, dest);
	}

	@After
	public void tearDown() {
		extractor = null;
		new File(dest).delete();
	}
}
