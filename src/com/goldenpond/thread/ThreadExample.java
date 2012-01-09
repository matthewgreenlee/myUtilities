package com.goldenpond.thread;

import com.goldenpond.utils.Print;

public class ThreadExample {

	public static void main(String[] args) {
		Print.ln("Main thread is saying hello");
		new Thread(new HelloRunnable()).start();
		new Thread(new HelloThread()).start();
	}
}

class HelloRunnable implements Runnable {

	@Override
	public void run() {
		Print.ln("HelloRunnable is saying hello");
	}
}

class HelloThread extends Thread {

	@Override
	public void run() {
		Print.ln("HelloThread is saying hello");
	}
}
