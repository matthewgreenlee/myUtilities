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
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

		FileReader reader = null;
		FileWriter writer = null;
		
		try {
			reader = new FileReader("src/com/goldenpond/io/source.txt");
			writer = new FileWriter("src/com/goldenpond/io/chars.txt");
			
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

}
