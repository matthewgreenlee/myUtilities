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
		String[] commandLine;
		File workingDir;
		
		workingDir = new File("F:\\workspace\\GCode\\commons-utilities\\bin");
		commandLine = new String[]{"java", "com.goldenpond.process.NativeProcess"};
		assertTrue(executor.runCommand(commandLine, workingDir));
		
		commandLine = new String[]{"java", "com.goldenpond.process.NativeProcess", "throw exception"};
		assertFalse(executor.runCommand(commandLine, workingDir));
	}
}
