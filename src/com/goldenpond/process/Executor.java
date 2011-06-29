package com.goldenpond.process;

import java.io.File;
import java.io.IOException;

import com.goldenpond.utils.Print;

public class Executor {

	public boolean runCommand(String[] command, File workingDir) {
		try {
			Runtime.getRuntime().exec(command, null, workingDir);
		} catch (IOException e) {
			Print.ln(e.getMessage());
			return false;
		}
		return true;
	}
}
