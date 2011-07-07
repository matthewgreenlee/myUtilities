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
	private String resource;
	private String dest;
	
	@Before
	public void setUp() {
		extractor = new JarExtractor();
		dest = "./";
		resource = "A.txt";
		jarPath = "bin/com/goldenpond/extraction/resource.jar";
	}

	@Test
	public void testExtract() throws IOException {
		extractor.extract(jarPath, resource, dest);
		assertTrue(new File(dest + File.separator + resource).exists());
	}

	@Test
	public void testExtractAll() throws IOException {
		extractor.extractAll(jarPath, dest);
	}

	@After
	public void tearDown() {
		new File(dest + File.separator + resource).delete();
	}
}
