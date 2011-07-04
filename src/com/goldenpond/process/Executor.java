package com.goldenpond.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import com.goldenpond.utils.Print;

public class Executor {

	public boolean runCommand(String[] command, File workingDir) {
		ProcessBuilder pb = new ProcessBuilder();
		pb.command(command);
		pb.directory(workingDir);
		pb.redirectErrorStream(true);
		Process proc;
		try {
			proc = pb.start();
			proc.waitFor();
		} catch (IOException e) {
			Print.ln(e.getMessage());
			return false;
		} catch (InterruptedException e) {
			Print.ln(e.getMessage());
			return false;
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		String line;
		try {
			while ((line = br.readLine()) != null) {
				Print.ln(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (proc.exitValue() == 0) {
			return true;
		} else {
			return false;
		}
	}
}
