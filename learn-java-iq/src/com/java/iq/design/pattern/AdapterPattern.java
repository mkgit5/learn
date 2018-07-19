package com.java.iq.design.pattern;

/*
 * 
 * Adapter Pattern - Structural Design Pattern
 * 	- Usage: Manage two unrelated interfaces to work together. 
 * 	- The object that joins these unrelated interface is called an Adapter.
 * 	- Interfaces - Electric outlet (Volts) and Mobile
 * 	- Adapter	 - SocketAdapter (To charge the mobile from an electric outlet)
 * 
 * 					SocketAdapter
 * 						+ get240Volts() -> returns volt from an electric outlet (240v)
 * 						+ get120Volts() -> returns step down volt of 120 from an electric outlet (240v) 
 * 						|
 * 					SocketAdapterImpl
 * 
 *
 */
public class AdapterPattern {

	public static void main(String[] args) {
		SocketAdapter adapter = new SocketAdapterImpl();
		Volt volt = adapter.get240Volt();
		System.out.println("Volts - " + volt.getVolts());

		Volt volt2 = adapter.get120Volt();
		System.out.println("Volts - " + volt2.getVolts());
	}

}

class Volt {
	private int volts;

	public Volt(int volts) {
		this.volts = volts;
	}

	public int getVolts() {
		return volts;
	}

	public void setVolts(int volts) {
		this.volts = volts;
	}

}

interface SocketAdapter {
	Volt get120Volt();

	Volt get240Volt();
}

class SocketAdapterImpl implements SocketAdapter {

	@Override
	public Volt get240Volt() {
		return getVolt();
	}

	@Override
	public Volt get120Volt() {
		Volt volt = getVolt();
		return converVolt(volt, 2);
	}

	/**
	 * Converts or step-down 240 volt to 120 volt
	 * 
	 * @param volt
	 * @param i
	 * @return returns volt
	 */
	private Volt converVolt(Volt volt, int i) {
		return new Volt(volt.getVolts() / i);
	}

	/**
	 * @return Returns Volt from an electric outlet AS-IS
	 */
	private Volt getVolt() {
		return new Volt(240);
	}

}
