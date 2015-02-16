package com.goldenpond.process;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.goldenpond.utils.Print;

public class NativeProcess {

	public static void main(String[] args) throws Exception {
		Print.ln("native process start");
		if (args.length == 0) {
			Print.ln("please input your name");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input = br.readLine();
			Print.ln("hello " + input);
			Print.ln("native process end");
			br.close();
			return;
		}
		Thread.sleep(3 * 1000);
		throw new RuntimeException("self-defined runtime exception");
	}
}
