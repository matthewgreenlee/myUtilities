package com.goldenpond.process;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import com.goldenpond.utils.Print;

public class Executor {

	public boolean runCommand(String[] command, File workingDir, String[] responses) throws IOException {
		ProcessBuilder pb = new ProcessBuilder();
		pb.command(command);
		pb.directory(workingDir);
		pb.redirectErrorStream(true);

		Process proc = pb.start();

		OutputStream outputStream = proc.getOutputStream();
		typeIn(outputStream, responses);
		outputStream.close();

		InputStream inputStream = proc.getInputStream();
		printOut(inputStream);
		inputStream.close();

		try {
			proc.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}

		if (proc.exitValue() == 0) {
			return true;
		} else {
			return false;
		}
	}

	private void typeIn(OutputStream outputStream, String[] responses) throws IOException {
		if (responses == null) {
			return;
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
		for (String resp : responses) {
			Print.ln(resp);
			bw.write(resp);
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}

	private void printOut(InputStream inputStream) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		String line;
		while ((line = br.readLine()) != null) {
			Print.ln(line);
		}
		br.close();
	}
}
