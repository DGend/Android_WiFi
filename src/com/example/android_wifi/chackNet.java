package com.example.android_wifi;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;

public class chackNet extends Activity{
	wifiIpAddress wifi;
	boolean nonet = false;
	
	public void chack(ConnectivityManager manager, WifiInfo wifiInfo){
		try{
		// WIFI �� ����ϴ��� Ȯ���Ѵ�.
		if(manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting()){
			System.out.println("WIFI�� ����Ǿ� �ֽ��ϴ�.");
			wifi = new wifiIpAddress();
			wifi.wifiName(wifiInfo);
			wifi.wifiIp(wifiInfo);
		} else
			nonet = true;
		
		// 3G �� ����ϴ��� Ȯ������.
		if(manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting()){
			System.out.println("����� ��Ʈ��ũ ����Ǿ� �ֽ��ϴ�.");			
		} else
			nonet = true;
		
		// ��Ʈ��ũ ������ �Ǿ����� ����
		if(nonet == false)
			System.out.println("��Ʈ��ũ ������ �Ǿ� ���� �ʽ��ϴ�");			
		
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}	
}
