package com.example.android_wifi;

import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.view.Menu;

public class MainActivity extends Activity {
	public final static int INET4ADDRESS = 1;
	public final static int INET6ADDRESS = 2;
	
	StringBuilder str = null;
	IP_Address ip;
	wifiIpAddress wifi;
	chackNet netInfo;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ConnectivityManager manager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
		//To fetch the state of the Wi-Fi network in the device
		WifiManager wifiMgr = (WifiManager) getBaseContext().getSystemService(Context.WIFI_SERVICE);
		WifiInfo wifiInfo = wifiMgr.getConnectionInfo();		
		
		ip = new IP_Address();
		netInfo = new chackNet();
		
		// 현제 네트워크 연결상태 표시 (모바일 or wifi or 네트워크 연결 안됨)
		netInfo.chack(manager, wifiInfo);
		
		str = new StringBuilder();
		str.append("IPv4 Address = " + ip.getLocalIpAddress(INET4ADDRESS) + "\n");
		str.append("IPv6 Address = " + ip.getLocalIpAddress(INET6ADDRESS) + "\n");
		str.append("MAC Address = " + getLocalMacAddress() + "\n");
		str.append("Device ID = " + getCurrentDeviceld());
		
		System.out.println(str);
		
		
	}
	
	/** MAC Address 가져오기*/
	public String getLocalMacAddress() {
        String mac = "";
        boolean blswifioff=false;
		try {
            WifiManager wifiManager = (WifiManager)getSystemService(Context.WIFI_SERVICE);
            if(!wifiManager.isWifiEnabled()){
            	wifiManager.setWifiEnabled(true);
            	blswifioff = true;
            }
            
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            mac = wifiInfo.getMacAddress();
            
            if(blswifioff){
            	wifiManager.setWifiEnabled(false);
            	blswifioff = false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return mac;
    }
	
	/** Device ID 가져오기*/
	public String getCurrentDeviceld(){
		String deviceld="";
		
		TelephonyManager tManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
		deviceld = tManager.getDeviceId();
		
		return deviceld;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
