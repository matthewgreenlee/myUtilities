package com.goldenpond.utils;

import java.util.Arrays;

public class Print {

	public static void ln(String x) {
		System.out.println(x);
	}

	public static void ln(boolean x) {
		System.out.println(x);
	}

	public static void ln(int x) {
		System.out.println(x);
	}

	public static void ln(long x) {
		System.out.println(x);
	}

	public static void ln(Object x) {
		System.out.println(x);
	}

	public static void ln(String[] x) {
		ln(Arrays.toString(x));
	}

	public static void ln(int[] x) {
		ln(Arrays.toString(x));
	}

	public static void ln(Object[] x) {
		ln(Arrays.toString(x));
	}

	public static void main(String[] args) {
		ln("x");
		ln(true);
		ln(65536);
		ln(Long.valueOf(1234567890).longValue());
		ln(new Object());
		ln(new String[]{"a", "b", "c"});
		ln(new int[]{3, 4, 5});
		ln(new Object[]{new Object(), new Object()});
	}
}
