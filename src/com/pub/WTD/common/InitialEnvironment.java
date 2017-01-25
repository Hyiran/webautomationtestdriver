/**
 * @Title: InitialEnvironment.java 
 * @Package com.pub.WTD.common 
 * @Description: initial the Env by set all necessary variables
 * @author hekun 158109016@qq.com
 * @date 2014��7��3�� ����1:06:34 
 * @version V1.0   
 */
package com.pub.WTD.common;

import java.io.File;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.pub.WTD.util.GlobalInfo;

/**
 * @author zhoujing
 * 
 */
public class InitialEnvironment {
	SessionData sessionData = new SessionData();
	Document doc = null;
	List<String> emails = new ArrayList<String>();// email array
	HashMap<String, String> webDriverhash = new HashMap<String, String>();// webDrvier
																			// hash
																			// map

	public InitialEnvironment() {
		String path = new File("").getAbsolutePath();// get the local project
														// path

		GlobalInfo.rootPath = path;// the the static rootPath to the logcal
									// project path

		setBid();
		
		SAXReader saxReader = new SAXReader();// read the config file


		try {
			String sp = System.getProperty("file.separator");
			doc = saxReader.read(new File(GlobalInfo.rootPath + sp + "conf"
					+ sp + "WTD.cfg.xml"));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		setPcHost();
		setShareFolder();
		setHostNameToSession(doc);

		setWebDrivers(doc);

		setMailReceptors(doc);
		
		setOnlineVarible();
	}

	/**
	 * get Email Address
	 */
	public List<String> getMailReceptors() {

		return emails;
	}

	/**
	 * get Email Address
	 */
	public void setMailReceptors(Document doc) {

		List<Element> emailElements = (List<Element>) doc
				.selectNodes("//MailReceptor/user");
		for (int i = 0; i < emailElements.size(); i++) {
			emails.add(emailElements.get(i).attributeValue("email"));
		}

	}

	/**
	 * get WebDrivers
	 */
	public HashMap<String, String> getWebDrivers() {

		return webDriverhash;
	}

	/**
	 * set WebDrivers
	 */
	public void setWebDrivers(Document doc) {
		List<Element> webDriveEles = doc.selectNodes("//Browser/*");
		for (Element e : webDriveEles) {
			String location = e.attributeValue("location");
			String browserName = e.getName();
			webDriverhash.put(browserName, location);
		}

	}

	/**
	 * get sessionData obj
	 */
	public SessionData getSessionData() {
		return sessionData;
	}

	/**
	 * set the hostName
	 */
	public void setHostName(String hostName) {
		sessionData.setHostName(hostName);
	}

	/**
	 * set the hostName to Session Data
	 */
	public void setHostNameToSession(Document doc) {

		Element urlElement = (Element) doc
				.selectSingleNode("//host-url/url");
		String hostName = urlElement.attributeValue("name");
		sessionData.setHostName(hostName);
	}
	
	/**
	 * set the internet PC host
	 */
	public void setPcHost() {

		InetAddress a;
		try {
			a = InetAddress.getLocalHost();
			GlobalInfo.pcHostName=a.getHostName();
			GlobalInfo.pcIP=a.getHostAddress().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * set the share log folder on this PC
	 */
	public void setShareFolder() {
		try{
			String sp = System.getProperty("file.separator");
			Runtime.getRuntime().exec("net share "+GlobalInfo.pcHostName+"="+GlobalInfo.rootPath+sp+"logs");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * get the internet PC host
	 */
	public String getPcHost() {

		return GlobalInfo.pcHostName;
	}
	
	/**
	 * get the internet PC Ip address
	 */
	public String getPcIp() {

		return GlobalInfo.pcIP;
	}
	
	/**
	 * set the business Bid to static
	 */
	private void setBid(){
		 /**
	     * 业务ID-测试
	     * @var int
	     */
	    int BID_TEST = 0;

	    /**
	     * 业务ID-用户注册 app
	     * @var int
	     */
	    int BID_REGISTER_APP = 1;

	    /**
	     * 业务ID-修改密码 app
	     * @var int
	     */
	    int BID_CHANGE_APP = 2;

	    /**
	     * 业务ID-重置密码 app
	     * @var int
	     */
	    int BID_RESET_APP = 3;

	    /**
	     * 业务ID-用户注册 web
	     * @var int
	     */
	    int BID_REGISTER_WEB = 4;

	    /**
	     * 业务ID-修改密码 web
	     * @var int
	     */
	    int BID_CHANGE_WEB = 5;

	    /**
	     * 业务ID-重置密码 web
	     * @var int
	     */
	    int BID_RESET_WEB = 6;

		/**
		 * 业务ID-多次登录错误 web
		 * @var int
		 */
		int BID_LOGIN_WEB = 7;
		
		GlobalInfo.bid.put("BID_TEST", BID_TEST+"");
		GlobalInfo.bid.put("BID_REGISTER_APP", BID_REGISTER_APP+"");
		GlobalInfo.bid.put("BID_CHANGE_APP", BID_CHANGE_APP+"");
		GlobalInfo.bid.put("BID_RESET_APP", BID_RESET_APP+"");
		GlobalInfo.bid.put("BID_REGISTER_WEB", BID_REGISTER_WEB+"");
		GlobalInfo.bid.put("BID_CHANGE_WEB", BID_CHANGE_WEB+"");
		GlobalInfo.bid.put("BID_RESET_WEB", BID_RESET_WEB+"");
		GlobalInfo.bid.put("BID_LOGIN_WEB", BID_LOGIN_WEB+"");
		
	}
	
	/**
	 * set the isNoline varible
	 */
	private void setOnlineVarible() {
		if(sessionData.getHostName().contains("onlinehost.com")){
		GlobalInfo.isOnlineTest=true;	
		}else{
		GlobalInfo.isOnlineTest=false;
		}
	}
	
}
