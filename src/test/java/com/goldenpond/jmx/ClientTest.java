package com.goldenpond.jmx;

import org.junit.Before;
import org.junit.Test;

public class ClientTest {

	private Client client;

	@Before
	public void setUp() {
		client = new Client();
	}

	@Test
	public void testConnectDisconnect() {
		client.connect("localhost", 9999);
		client.disconnect();
	}
}
