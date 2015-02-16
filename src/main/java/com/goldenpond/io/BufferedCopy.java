package com.goldenpond.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author GoldenPond
 *
 */
public class BufferedCopy {

	public static void copy(String sourcePath, String targetPath) throws IOException {

		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		
		int b;

		try {
			in = new BufferedInputStream(new FileInputStream(sourcePath));
			out = new BufferedOutputStream(new FileOutputStream(targetPath));
			
			while ((b = in.read()) != -1) {
				out.write(b);
			}

		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		final String sourcePath = "src/com/goldenpond/io/source.txt";
		final String targetPath = "src/com/goldenpond/io/buffered.txt";
		copy(sourcePath, targetPath);
	}
}
