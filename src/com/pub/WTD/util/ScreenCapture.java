/**
 * @Title: ScreenCapture.java 
 * @Package com.pub.WTD.util 
 * @Description: The tool class to capture the screen
 * @author hekun 158109016@qq.com
 * @date 2014��7��4�� ����2:30:00 
 * @version V1.0   
 */
package com.pub.WTD.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.pub.WTD.common.SessionData;

/**
 * @author zhoujing
 * 
 */
public class ScreenCapture {
	String path;

	/**
	 * capture the screen
	 * 
	 */
	public ScreenCapture(SessionData sessionData) {
		try {
		sessionData.getLogger().info(
				"~~~~~~~~~~~~ Start to Capture the Screen ~~~~~~~~~~~~");
				
		File srcFile = ((TakesScreenshot) sessionData.getWebDriver())
				.getScreenshotAs(OutputType.FILE);
		String sp = System.getProperty("file.separator");
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");

		path = sessionData.getLogFolder() + sp
				+ sf.format(date).replace(":", "_") + ".jpg";//the pic name
		
		
		sessionData.getLogger()
				.info("~~~~~~~~~~~~ The Screen Capture is :" + path
						+ " ~~~~~~~~~~~~");
		
			FileUtils.copyFile(srcFile, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			sessionData
					.getLogger()
					.info("######## [ Error ]: Screen Capture Failed !!!!!!!!!!!!!!!!!!!!!!###########");
			e.printStackTrace();
		}
		sessionData.getLogger().info(
				"~~~~~~~~~~~~Finish to Capture the Screen ~~~~~~~~~~~~");
	}

	public String getPicPath() {
		return path;
	}

}
