package com.goldenpond.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author GoldenPond
 * 
 */
public class ByteCopy {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

		FileInputStream in = null;
		FileOutputStream out = null;

		try {
			in = new FileInputStream("src/com/goldenpond/io/source.txt");
			out = new FileOutputStream("src/com/goldenpond/io/bytes.txt");
			
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

}
