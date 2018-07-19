package com.java.iq.network;

import java.net.Inet6Address;
import java.net.UnknownHostException;

public class FindHostname {

	public static void main(String[] args) throws UnknownHostException {
		System.out.println("IP Address - " + Inet6Address.getLocalHost().getCanonicalHostName());
	}

}
