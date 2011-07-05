package com.goldenpond.process;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class ExecutorTest {

	private Executor executor;

	@Before
	public void setUp() {
		executor = new Executor();
	}

	@Test
	public void testRunCommandTrue() throws IOException {
		File workingDir = new File("F:\\workspace\\GCode\\commons-utilities\\bin");
		String[] commandLine = new String[]{"java", "com.goldenpond.process.NativeProcess"};
		String[] response = new String[]{"Shanghai"};
		assertTrue(executor.runCommand(commandLine, workingDir, response ));		
	}

	@Test
	public void testRunCommandFalse() throws IOException {
		File workingDir = new File("F:\\workspace\\GCode\\commons-utilities\\bin");
		String[] commandLine = new String[]{"java", "com.goldenpond.process.NativeProcess", "throw exception"};
		assertFalse(executor.runCommand(commandLine, workingDir, new String[]{}));
	}
}
