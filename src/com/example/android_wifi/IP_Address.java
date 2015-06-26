package com.example.android_wifi;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class IP_Address extends Activity {
	public final static int INET4ADDRESS = 1;
	public final static int INET6ADDRESS = 2;
	
	String str = null;
	
	public String getLocalIpAddress(int type) {
		try {
			for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
				NetworkInterface intf = ( NetworkInterface ) en.nextElement();
				for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
					InetAddress inetAddress = ( InetAddress ) enumIpAddr.nextElement();
					if (!inetAddress.isLoopbackAddress()) {
						switch (type) {
						case INET6ADDRESS:
							if (inetAddress instanceof Inet6Address) {
								return inetAddress.getHostAddress().toString();
							}
							break;
						case INET4ADDRESS:
							if (inetAddress instanceof Inet4Address) {
								return inetAddress.getHostAddress().toString();
							}
							break;
						}
					}
				}
		    }
		} catch (SocketException ex) {
		 	ex.printStackTrace();
		}
		return null;
	}	
	
	public void wifiInfo(){
		//To fetch the state of the Wi-Fi network in the device
		WifiManager wifiMgr = (WifiManager) getBaseContext().getSystemService(Context.WIFI_SERVICE); 
		WifiInfo wifiInfo = wifiMgr.getConnectionInfo();
		wifiName(wifiInfo);
		wifiIp(wifiInfo);
	}
	
	/**  wifi Network getting by name*/
	public String wifiName(WifiInfo wifi){
		//To fetch the name of the Wi-Fi network to which the device is connected
		String wifiName = wifi.getSSID();
		
		System.out.println(wifiName);
		return wifiName;
	}
	
	/** wifi Network getting by IP*/
	public String wifiIp(WifiInfo wifi){
		//To Wi-Fi newwork ip get
		int ipAddress = wifi.getIpAddress();
		if (ipAddress == 0)
			return null;
		
		System.out.println(Integer.toString(ipAddress));
		return Integer.toString(ipAddress);
	}
}
