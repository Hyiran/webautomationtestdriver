/**
 * @Title: TcGotoHome.java 
 * @Package com.pub.WTD.cases 
 * @Description: Test Case to go to home
 * @author hekun 158109016@qq.com
 * @date 2014��7��3�� ����2:58:40 
 * @version V1.0   
 */
package cases.member;

import java.io.File;


import com.pub.WTD.common.BaseCase;
import com.pub.WTD.pages.HomePage;

/**
 * @author hekun
 * 
 */
public class TC_GoHome extends BaseCase {
	/**
	 * must override this constructor from BaseCase.class this is the main
	 * entrance to run case,you can write all kinds of methods to run case
	 */
	public void execute() {
		new HomePage(sessionData).goToPage();// new a homePage class and run
												// goToPage() function to go to
												// home page

		setDescription("To go home page");// set the Test Case's Description,if
											// not set,the description is "" by
											// default

		
		
		if (isCurrentURL(hostName+"/sh/")|| isCurrentURL(hostName + "/")) {// if the
																// curentUrl is
																// *** ,we can
																// assert that
																// the last step
																// is pass

			setPointResult("GoToHome", "回到首页", "pass", "NULL");// call this
																// function to
																// set one
																// testpoint to
																// resul.xml and
																// log file
		} else {
			setPointResult("GoToHome", "回到首页", "fail",
					"can not go to home page");
		}
		String path = screenCapture();// capture one screen pic
		File f = new File(path);
		if (f.exists()) {
			setPointResult("ScreenCapture", "SreenCapture", "pass", "NULL");
		} else {
			setPointResult("ScreenCapture", "SreenCapture", "fail",
					"Screen Capture failed");

		}

	}

}
