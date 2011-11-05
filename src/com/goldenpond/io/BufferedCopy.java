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

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		
		int b;

		try {
			in = new BufferedInputStream(new FileInputStream("src/com/goldenpond/io/source.txt"));
			out = new BufferedOutputStream(new FileOutputStream("src/com/goldenpond/io/buffered.txt"));
			
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
