package com.goldenpond.jmx;

import java.io.IOException;

import javax.management.remote.JMXServiceURL;

import com.goldenpond.utils.Print;

public class Client {

	private static JMXServiceURL extractJMXServiceURL(int pid) throws Exception {
		String serviceURL = null;
		try {
			serviceURL = sun.management.ConnectorAddressLink.importFrom(pid);
		} catch (IOException e) {
			Print.ln("Cannot find process ${pid}");
		}

		if (serviceURL == null)
			return null;
		else
			return new JMXServiceURL(serviceURL);
	}
}
