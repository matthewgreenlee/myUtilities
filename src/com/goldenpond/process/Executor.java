package com.goldenpond.process;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import com.goldenpond.utils.Print;

public class Executor {

	public boolean runCommand(String[] command, File workingDir) {
		ProcessBuilder pb = new ProcessBuilder();
		pb.command(command);
		pb.directory(workingDir);
		pb.redirectErrorStream(true);
		try {
			Process proc = pb.start();
			InputStream is = proc.getInputStream();
		} catch (IOException e) {
			Print.ln(e.getMessage());
			return false;
		}
		return true;
	}
}
