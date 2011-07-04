package com.goldenpond.process;

import com.goldenpond.utils.Print;

public class NativeProcess {

	public static void main(String[] args) throws Exception {
		Print.ln("native process start");
		if (args.length == 0) {
			Print.ln("native process end");
			return;
		}
		Thread.sleep(3 * 1000);
		throw new RuntimeException("self-defined runtime exception");
	}
}
