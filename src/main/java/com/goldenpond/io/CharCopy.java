package com.goldenpond.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author GoldenPond
 *
 */
public class CharCopy {

	/**
	 * @param sourcePath TODO
	 * @param targetPath TODO
	 */
	public static void copy(String sourcePath, String targetPath) throws IOException {

		FileReader reader = null;
		FileWriter writer = null;
		
		try {
			reader = new FileReader(sourcePath);
			writer = new FileWriter(targetPath);
			
			int c;
			while ((c = reader.read()) != -1) {
				writer.write(c);
			}

		} finally {
			if (reader != null) {
				reader.close();
			}
			if (writer != null) {
				writer.close();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		copy("src/com/goldenpond/io/source.txt", "src/com/goldenpond/io/chars.txt");
	}
}
