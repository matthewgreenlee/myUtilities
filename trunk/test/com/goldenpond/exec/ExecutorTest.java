package com.goldenpond.exec;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.Executor;
import org.junit.Before;
import org.junit.Test;

public class ExecutorTest {

	private Executor executor;
	private CommandLine command;
	private DefaultExecuteResultHandler handler;

	@Before
	public void setUp() {
		executor = new DefaultExecutor();
		executor.setWorkingDirectory(new File("F:\\workspace\\GCode\\commons-utilities\\bin"));
		command = new CommandLine("java");
		command.addArgument("com.goldenpond.process.NativeProcess");
		handler = new DefaultExecuteResultHandler();
	}

	@Test
	public void testSynchronousExecution() throws IOException {
		assertEquals(0, executor.execute(command));
	}

	@Test
	public void testAsynchronousExecution() throws IOException, InterruptedException {
		executor.execute(command, handler);
		handler.waitFor();
	}
}
