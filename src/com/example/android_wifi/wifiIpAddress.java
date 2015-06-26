package com.example.android_wifi;

import android.app.Activity;
import android.net.wifi.WifiInfo;

public class wifiIpAddress extends Activity{
	
	public String wifiName(WifiInfo wifiInfo){
		String wifiName = null;
		try{			
		//To fetch the name of the Wi-Fi network to which the device is connected
		wifiName = wifiInfo.getSSID();
		System.out.println(wifiName);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return wifiName;
		
	}
	
	/** wifi Network getting by IP*/
	public String wifiIp(WifiInfo wifiInfo){
		int ipAddress= 0;
		try{
		//To Wi-Fi newwork ip get
		ipAddress = wifiInfo.getIpAddress();
		if (ipAddress == 0)
			return null;
		System.out.println(Integer.toString(ipAddress));
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return Integer.toString(ipAddress);
	}
}
