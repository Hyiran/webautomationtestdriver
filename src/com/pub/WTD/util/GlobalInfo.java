/**
 * @Title: Configure.java 
 * @Package com.pub.WTD.util 
 * @Description: Global information
 * @author hekun 158109016@qq.com
 * @date 2014��7��3�� ����12:55:48 
 * @version V1.0   
 */
package com.pub.WTD.util;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.pub.WTD.ui.MainUIController;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

/**
 * @author zhoujing
 * 
 */
public class GlobalInfo {

	public static String rootPath = null;//the rootPath is the project path
	public static String pcIP;//the test server's ip
	public static String pcHostName;// the test server's hostname
	public static WebDriver currentWebDriver;
	public static HashMap<String, String> bid=new HashMap<String,String>();
	public static boolean isLaunchByUI=false;
	public static boolean isOnlineTest=true;
	public static String HostName="";
	public static HashMap<String, String> varibles=new HashMap<String,String>();
	public static MainUIController mainUIController=null;
	public static String os = System.getProperty("os.name").toLowerCase();  

}
