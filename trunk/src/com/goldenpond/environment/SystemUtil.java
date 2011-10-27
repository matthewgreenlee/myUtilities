package com.goldenpond.environment;

import com.goldenpond.utils.Print;

public class SystemUtil {

	public static final boolean isWindows() {
		return System.getProperty("os.name").contains("Windows");
	}

	public static final boolean isLinux() {
		return System.getProperty("os.name").contains("Linux");
	}

	public static final boolean is32Bit() {
		return System.getProperty("sun.arch.data.model").equals("32");
	}

	public static final boolean is64Bit() {
		return System.getProperty("sun.arch.data.model").equals("64");
	}

	public static final String getOsArch() {
		return System.getProperty("os.arch");
	}

	public static final String getJavaHome() {
		return System.getProperty("java.home");
	}

	public static void main(String[] args) throws Exception {
		Print.ln("isWindows: " + isWindows());
		Print.ln("isLinux: " + isLinux());
		Print.ln("is32Bit: " + is32Bit());
		Print.ln("is64Bit: " + is64Bit());
		Print.ln("OsArch: " + getOsArch());
		Print.ln("JavaHome: " + getJavaHome());
	}
}
