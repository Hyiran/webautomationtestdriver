/**
 * @Title: TCChangeUserInfo.java 
 * @Package com.pub.WTD.cases 
 * @author hekun
 * @date 2014年10月27 
 * @version V1.0   
 */
package cases.member;


import org.openqa.selenium.By;

import com.pub.WTD.common.BaseCase;
import com.pub.WTD.pages.HomePageWithOutLogIn;

public class TC_ChangeUserInfo extends BaseCase {

	public void execute() {

		setDescription("修改手机测试");
		// 修改个人信息test
		changeUserInfo();
		// 修改账户信息test
		// changeAccountInfo();

	}

	// 进入首页
	private void goToHome() {

		new HomePageWithOutLogIn(sessionData).goToPage();
		if (isCurrentURL(hostName + "/sh/") || isCurrentURL(hostName + "/")) {
			setPointResult("GoToHome", "回到首页", "pass", "NULL");
			screenCapture();
		} else {
			setPointResult("GoToHome", "回到首页", "fail",
					"can not go to home page");
			screenCapture();
		}
	}

	// 进入忘记密码页面
	private void goToUserInfoPage() {
		// 点击首页登录
		if (!findElVaule(By.id("topLogin")).equals("登录")) {
			clickById("topLogout");
		}
		sleep(2000);
		clickById("topLogin");
		sleep(2000);
	}

	private void changeUserInfo() {
		goToHome();
		goToUserInfoPage();

		sendKeys(By.name("sMobile"), "18100000001");
		sendKeys(By.name("sPassword"), "123456~");

		clickBy(By.className("login_btn"));
		sleep(3000);

		clickById("topLogin");

		switchNewWindow();
		if (webDriver.findElement(By.id("edit_personal_info")) != null) {
			// 编辑个人资料
			clickById("edit_personal_info");
			webDriver.findElement(By.id("nickname")).clear();
			sendKeysById("nickname", "sophie");
			webDriver.findElement(By.id("realname")).clear();
			sendKeysById("realname", "何坤");
			if (webDriver.findElement(By.id("select_gender")).isSelected()) {
				if (webDriver.findElement(
						By.xpath("(//input[@name='gender'])[1]")).isSelected()) {
					webDriver.findElement(
							By.xpath("(//input[@name='gender'])[2]")).click();
				} else {
					webDriver.findElement(
							By.xpath("(//input[@name='gender'])[1]")).click();
				}
			} else {
				webDriver.findElement(By.xpath("(//input[@name='gender'])[2]"))
						.click();
			}

			screenCapture();
			clickById("save_info");

			String text = alertAccept();

			if (text.contains("重复")) {
				webDriver.findElement(By.id("nickname")).clear();
				sendKeysById("nickname", getRandomPhoneNum());
				clickById("save_info");
				String text2 = alertAccept();
				if (text2.contains("更新成功")) {
					setPointResult("更改用户信息", "更改用户信息", "pass", "null");
				} else {
					setPointResult("更改用户信息", "更改用户信息", "fail", "更新用户信息失败");
				}
			} else if (text.contains("更新成功")) {

				setPointResult("更改用户信息", "更改用户信息", "pass", "null");
			} else {
				setPointResult("更改用户信息", "更改用户信息", "fail", "更新用户信息失败");
			}

		}

	}


}
