package com.goldenpond.jmx;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import sun.management.ConnectorAddressLink;

import com.goldenpond.utils.Print;

public class Client {

	private JMXConnector jmxc;

	public void connect(int pid) {
		try {
			JMXServiceURL url = new JMXServiceURL(ConnectorAddressLink.importFrom(pid));
			jmxc = JMXConnectorFactory.connect(url);
			Print.ln("get the MBeanServerConnection");
		} catch (IOException e) {
			Print.ln("the JMX service was not found with the given pid");
			throw new RuntimeException(e.getMessage());
		}
	}

	public void connect(String host, int port) {
		try {
			JMXServiceURL url = new JMXServiceURL("rmi", host, port, "/jndi/rmi://" + host + ":" + port + "/jmxrmi");
			jmxc = JMXConnectorFactory.connect(url);
			Print.ln("get the MBeanServerConnection");
		} catch (MalformedURLException e) {
			Print.ln("the specified url was not well-formed");
			throw new RuntimeException(e.getMessage());
		} catch (IOException e) {
			Print.ln("the JMX service was not found with the given host:port");
			throw new RuntimeException(e.getMessage());
		}
	}

	public void disconnect() {
		try {
			jmxc.close();
			Print.ln("closed the MBeanServerConnection");
		} catch (IOException e) {
			Print.ln("cannot close MBeanServerConnection gracefully");
			throw new RuntimeException(e.getMessage());
		}
	}
}
