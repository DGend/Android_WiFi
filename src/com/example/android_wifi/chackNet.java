package com.example.android_wifi;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;

public class chackNet extends Activity{
	wifiIpAddress wifi;
	boolean nonet = false;
	
	public void chack(ConnectivityManager manager, WifiInfo wifiInfo){
		try{
		// WIFI 를 사용하는지 확인한다.
		if(manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting()){
			System.out.println("WIFI에 연결되어 있습니다.");
			wifi = new wifiIpAddress();
			wifi.wifiName(wifiInfo);
			wifi.wifiIp(wifiInfo);
		} else
			nonet = true;
		
		// 3G 를 사용하는지 확인힌다.
		if(manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting()){
			System.out.println("모바일 네트워크 연결되어 있습니다.");			
		} else
			nonet = true;
		
		// 네트워크 연결이 되어있지 않음
		if(nonet == false)
			System.out.println("네트워크 연결이 되어 있지 않습니다");			
		
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}	
}
