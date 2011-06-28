package com.goldenpond.jmx;

import java.io.IOException;

import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import sun.management.ConnectorAddressLink;

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

	public void connect(int pid) throws Exception {
		try {
			String serviceURL = ConnectorAddressLink.importFrom(pid);
			jmxc = JMXConnectorFactory.connect(new JMXServiceURL(serviceURL));
		} catch (IOException e) {
			Print.ln("Cannot find process pid: " + pid);
			throw new RuntimeException(e.getMessage());
		}
	}

	public static void main(String[] args) throws Exception {
		Client client = new Client();
		client.connect("p607023d", 9999);
		client.disconnect();
	}

}
