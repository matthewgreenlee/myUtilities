package com.goldenpond.environment;


import java.util.Locale;


public final class LocalOs {
	private static final String OS_NAME = System.getProperty("os.name")
			.toLowerCase(Locale.US);

	private static final String OS_ARCH = System.getProperty("os.arch")
			.toLowerCase(Locale.US);

	private static final String OS_VERSION = System.getProperty("os.version")
			.toLowerCase(Locale.US);

	private static final String PATH_SEP = System.getProperty("path.separator");

	private static boolean isFamily(String family) {
		return isOs(family, null, null, null);
	}

	public static boolean isFamilyDOS() {
		return isFamily("dos");
	}

	public static boolean isFamilyMac() {
		return isFamily("mac");
	}

	public static boolean isFamilyNetware() {
		return isFamily("netware");
	}

	public static boolean isFamilyOS2() {
		return isFamily("os/2");
	}

	public static boolean isFamilyTandem() {
		return isFamily("tandem");
	}

	public static boolean isFamilyUnix() {
		return isFamily("unix");
	}

	public static boolean isFamilyWindows() {
		return isFamily("windows");
	}

	public static boolean isFamilyWin9x() {
		return isFamily("win9x");
	}

	public static boolean isFamilyZOS() {
		return isFamily("z/os");
	}

	public static boolean isFamilyOS400() {
		return isFamily("os/400");
	}

	public static boolean isFamilyOpenVms() {
		return isFamily("openvms");
	}

	public static boolean isFamilyLinux() {
		return isFamily("linux");
	}

	public static boolean isFamilyAix() {
		return isFamily("aix");
	}

	public static boolean isFamilySolaris() {
		return isFamily("sunos");
	}

	public static boolean isFamilyHpUx() {
		return isFamily("hp-ux");
	}

	public static boolean isFamilyZLinux() {
		return isOs("linux", null, "s390", null);
	}

	public static boolean isFamilyLinuxPpc() {
		return isOs("linux", null, "ppc", null);
	}

	public static boolean isName(String name) {
		return isOs(null, name, null, null);
	}

	public static boolean isArch(String arch) {
		return isOs(null, null, arch, null);
	}

	public static boolean isVersion(String version) {
		return isOs(null, null, null, version);
	}

	public static boolean isOs(String family, String name, String arch,
			String version) {
		boolean retValue = false;

		if ((family != null) || (name != null) || (arch != null)
				|| (version != null)) {
			boolean isFamily = true;
			boolean isName = true;
			boolean isArch = true;
			boolean isVersion = true;

			if (family != null) {
				if (family.equals("windows"))
					isFamily = OS_NAME.indexOf("windows") > -1;
				else if (family.equals("os/2"))
					isFamily = OS_NAME.indexOf("os/2") > -1;
				else if (family.equals("netware"))
					isFamily = OS_NAME.indexOf("netware") > -1;
				else if (family.equals("dos")) {
					isFamily = (PATH_SEP.equals(";")) && (!isFamily("netware"));
				} else if (family.equals("mac"))
					isFamily = OS_NAME.indexOf("mac") > -1;
				else if (family.equals("tandem"))
					isFamily = OS_NAME.indexOf("nonstop_kernel") > -1;
				else if (family.equals("unix")) {
					isFamily = (PATH_SEP.equals(":")) && (!isFamily("openvms"))
							&& ((!isFamily("mac")) || (OS_NAME.endsWith("x")));
				} else if (family.equals("win9x")) {
					isFamily = (isFamily("windows"))
							&& ((OS_NAME.indexOf("95") >= 0)
									|| (OS_NAME.indexOf("98") >= 0)
									|| (OS_NAME.indexOf("me") >= 0) || (OS_NAME
									.indexOf("ce") >= 0));
				} else if (family.equals("z/os")) {
					isFamily = (OS_NAME.indexOf("z/os") > -1)
							|| (OS_NAME.indexOf("os/390") > -1);
				} else if (family.equals("os/400"))
					isFamily = OS_NAME.indexOf("os/400") > -1;
				else if (family.equals("openvms"))
					isFamily = OS_NAME.indexOf("openvms") > -1;
				else if (family.equals("linux"))
					isFamily = OS_NAME.startsWith("linux");
				else if (family.equals("aix"))
					isFamily = OS_NAME.startsWith("aix");
				else if (family.equals("sunos"))
					isFamily = OS_NAME.startsWith("sunos");
				else if (family.equals("hp-ux"))
					isFamily = OS_NAME.startsWith("hp-ux");
				else {
					throw new IllegalArgumentException(
							"Don't know how to detect os family \"" + family
									+ "\"");
				}

			}

			if (name != null) {
				isName = name.equals(OS_NAME);
			}
			if (arch != null) {
				String beginOsArch;
				if ((arch.equals("s390")) && (OS_ARCH.length() > 4)) {
					beginOsArch = OS_ARCH.substring(0, 4);
				} else {
					if ((arch.equals("ppc")) && (OS_ARCH.length() > 3))
						beginOsArch = OS_ARCH.substring(0, 3);
					else
						beginOsArch = OS_ARCH;
				}
				isArch = arch.equals(beginOsArch);
			}
			if (version != null) {
				isVersion = version.equals(OS_VERSION);
			}
			retValue = (isFamily) && (isName) && (isArch) && (isVersion);
		}
		return retValue;
	}

	public static String describe() {
		return "OS(name:" + OS_NAME + ",arch:" + OS_ARCH + ",version:"
				+ OS_VERSION + ")";
	}
}