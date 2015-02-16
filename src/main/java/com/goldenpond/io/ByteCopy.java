package com.goldenpond.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author GoldenPond
 * 
 */
public class ByteCopy {

	public static void copy(String sourcePath, String targetPath) throws IOException {

		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			in = new FileInputStream(sourcePath);
			out = new FileOutputStream(targetPath);
			
			int b;
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
		copy("src/com/goldenpond/io/source.txt", "src/com/goldenpond/io/bytes.txt");
	}
}
