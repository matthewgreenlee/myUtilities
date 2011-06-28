package com.goldenpond.jmx;

import java.io.IOException;

import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import com.goldenpond.utils.Print;

public class Client {

	private JMXConnector jmxc;

	public void connect(String host, int port) throws Exception {
		JMXServiceURL url = new JMXServiceURL("rmi", host, port, "/jndi/rmi://" + host + ":" + port + "/jmxrmi");
		jmxc = JMXConnectorFactory.connect(url);
		Print.ln("Get the MBeanServerConnection");
	}

	public void disconnect() throws Exception {
		Print.ln("Close the MBeanServerConnection");
		jmxc.close();
	}

	public JMXServiceURL extractJMXServiceURL(int pid) throws Exception {
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

	public static void main(String[] args) throws Exception {
		Client client = new Client();
		client.connect("p607023d", 9999);
		client.disconnect();
	}

}
