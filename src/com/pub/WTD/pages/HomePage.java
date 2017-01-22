/**
* @Title: HomePage.java 
* @Package com.pub.WTD.pages 
* @Description: home page
* @author hekun 158109016@qq.com
* @date 2014��7��3�� ����10:27:41 
* @version V1.0   
 */
package com.pub.WTD.pages;


import com.pub.WTD.common.BasePage;
import com.pub.WTD.common.SessionData;

/**
 * @author hekun
 *
 */
public class HomePage extends BasePage{
	/**
	 * @param sessionData
	 */
	public HomePage(SessionData sessionData){
		super(sessionData);
	}
	//go to home page
	public boolean goToPage(){
		
		webDriver.get(hostName);
		
		return true;
	}
}
