/**
 * @Title: BasePage.java 
 * @Package com.pub.WTD.common 
 * @Description: The basic page 
 * @author hekun 158109016@qq.com
 * @date 2014��7��3�� ����10:28:46 
 * @version V1.0   
 */
package com.pub.WTD.common;


/**
 * @author zhoujing
 * 
 */
public class BasePage extends BaseAction{
	/**
	 * sub-class must override this constractor and transport the SessionData
	 * objective to parent class
	 */
	public BasePage(SessionData sessionData) {
		super(sessionData);
	}
}
