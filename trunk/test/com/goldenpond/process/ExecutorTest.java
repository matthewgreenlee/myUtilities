package com.goldenpond.process;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class ExecutorTest {

	private Executor executor;

	@Before
	public void setUp() {
		executor = new Executor();
	}

	@Test
	public void testRunCommand() {
		String[] commandLine = new String[]{"wbemtest.exe",};
		File workingDir = new File(System.getProperty("java.io.tmpdir"));
		assertTrue(executor.runCommand(commandLine , workingDir));
		
		commandLine = new String[]{"unknown"};
		assertFalse(executor.runCommand(commandLine, workingDir));
	}
}
