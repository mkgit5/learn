package com.java.iq.network;

import java.net.Inet6Address;
import java.net.UnknownHostException;

/**
 * Output:
 * 
 * IP Address - 192.168.0.5 
 * Hostname - Manjus-MacBook.local
 *
 */
public class FindHostname {

	public static void main(String[] args) throws UnknownHostException {
		System.out.println("IP Address - " + Inet6Address.getLocalHost().getCanonicalHostName());
		System.out.println("Hostname - " + Inet6Address.getLocalHost().getHostName());
	}

}
