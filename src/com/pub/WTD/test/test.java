/**
* @Title: test.java 
* @Package com.pub.WTD.test 
* @Description: To do something
* @author hekun 158109016@qq.com
* @date 2014��7��2�� ����5:42:27 
* @version V1.0   
 */
package com.pub.WTD.test;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.dom4j.Branch;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;



/**
 * @author hekun
 *
 */
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		InetAddress a;
//		try {
//			a = InetAddress.getLocalHost();
//			System.out.println(a.getHostName());
//		} catch (Exception e) {
//			e.printStackTrace();
//			
//		}
//		String logFolder="D:\\project\\com.WTD\\logs\\2014-07-09 10_15_29_FirefoxDriver";
//		String img="D:\\11.gif";
//		
//		try {
//			BufferedImage dd =removeBackgroud(img);
//			
//			  FileOutputStream   fos   =   new   FileOutputStream("img.jpg");    
//			   
//			//  JPEGImageEncoder   encoder   =   JPEGCodec.createJPEGEncoder(fos);    
//			   
//			//  encoder.encode(img);    
//			   
//			//.close();
//			Graphics g=dd.getGraphics();
//			 g.drawImage(dd, 0, 0, null);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	//	mergeAllResult(logFolder);
//		for(int i=0;i<5;i++){
//			int randomValue=(int)(Math.random()*99);
//			System.out.println(randomValue);
//		}
		
		
		test ss=new test();

ss.webtest();
	}
	
    public static void webtest() {  
    	
 
    	
    	String browserLocation="D:\\download\\Mozilla Firefox\\firefox.exe";
    	String sp = System.getProperty("file.separator");
    	System.setProperty("webdriver.firefox.bin",browserLocation);
		//FirefoxDriver webDriver = new FirefoxDriver(capabilities);
   	FirefoxDriver webDriver = new FirefoxDriver();
   
   	System.out.println(webDriver.toString());
		System.setProperty("webdriver.ie.driver", "D:\\project\\qa-wtd\\tools\\IEDriverServer.exe");
	//InternetExplorerDriver	webDriver = new InternetExplorerDriver();

webDriver.get("http://member.hekun.qa.ipo.com/user/register/?return_url=http://www.hekun.qa.ipo.com/sh/");
//webDriver.get("http://member.hekun.qa.ipo.com/");
webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);    
	
	webDriver.manage().window().maximize();
	//System.out.println(webDriver.getPageSource());
	webDriver.findElementById("mobile").sendKeys("18000000099");
	try {
		Thread.sleep(3000);
	} catch (Exception e) {
		// TODO: handle exception
	}
	webDriver.findElementById("sendIdentifyCode").click();
	try {
		Thread.sleep(3000);
	} catch (Exception e) {
		// TODO: handle exception
	}
	String re=webDriver.findElementById("regcodeImg").getAttribute("src");
	//webDriver.findElementById("regcodeImg").click();
	//System.out.println(re);
	Set<Cookie> allCookies = webDriver.manage().getCookies();
	SessionId dfdf = webDriver.getSessionId();
	Cookie cookie = new Cookie("guid", "guid=7dec7f32d0123d55d90a4191f758ffc6; Hm_lvt_aeea9ec5dfbb4a51631862676f9f7362=1409708581,1409708789,1409709517; Hm_lpvt_aeea9ec5dfbb4a51631862676f9f7362=1409709517; hfdagent=N2pRENQ%2B8wHKEdmjsdLG5e2qQkYmiP3eUQ7dUMVqp8GY%2Fdk66d8djDmpGmLQ0eraljS0L4oegl2dufaFQWFb5NZ9n7Ktz1VWe91H6oD2q2ZxCDIphq7c%2B4Uhi2wx3mKvqHpOPrZNsDCMGZlC1KZ4NeRd4Hd7c2LJ8cnfo4newwq8%2B%2FQZ9Pk3qzis64jIhkj2; cityid=1; per_e7a1612fe9afd4519571661035d2352a=25");
	webDriver.manage().addCookie(cookie);
//	System.out.println(dfdf.toString()+"dfdfddfd");
	String myCookie="";
	for (Cookie loadedCookie : allCookies) {
		myCookie+=loadedCookie.getName()+"=" +loadedCookie.getValue()+";";


	}
	myCookie=myCookie.substring(0, myCookie.length()-1);
	  System.out.println(myCookie);
	//webDriver.getPageSource();
    URL url;
	try {
		url = new URL(re);
		URLConnection conn = url.openConnection();
		
		//   String myCookie = "guid=7dec7f32d0123d55d90a4191f758ffc6; Hm_lvt_aeea9ec5dfbb4a51631862676f9f7362=1409708581,1409708789,1409709517; Hm_lpvt_aeea9ec5dfbb4a51631862676f9f7362=1409709517; hfdagent=N2pRENQ%2B8wHKEdmjsdLG5e2qQkYmiP3eUQ7dUMVqp8GY%2Fdk66d8djDmpGmLQ0eraljS0L4oegl2dufaFQWFb5NZ9n7Ktz1VWe91H6oD2q2ZxCDIphq7c%2B4Uhi2wx3mKvqHpOPrZNsDCMGZlC1KZ4NeRd4Hd7c2LJ8cnfo4newwq8%2B%2FQZ9Pk3qzis64jIhkj2; cityid=1; per_e7a1612fe9afd4519571661035d2352a=25"; 
		    conn.setRequestProperty("Cookie", myCookie); 
	  
	    Map headers = conn.getHeaderFields();
	    Set<String> keys = headers.keySet();
	    for( String key : keys ){
	    	
	    	if (null!=key&&key.equalsIgnoreCase("sCaptcha")) {		
	        String val = conn.getHeaderField(key);
	        //System.out.println(key+"   "+val);
	    	webDriver.findElementById("regcode").sendKeys(val);
	    	webDriver.findElementByClassName("regbtn1").click();
	    	}
	    }
	        
	  //  System.out.println( conn.getLastModified() );
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
    }  	
	
    public static int isWhite(int colorInt) {  
        Color color = new Color(colorInt);  
        if (color.getRed() + color.getGreen() + color.getBlue() > 100) {  
            return 1;  
        }  
        return 0;  
    }  
  
    public static BufferedImage removeBackgroud(String picFile)  
            throws Exception {  
        BufferedImage img = ImageIO.read(new File(picFile));  
        int width = img.getWidth();  
        int height = img.getHeight();  
        for (int x = 0; x < width; ++x) {  
            for (int y = 0; y < height; ++y) {  
                if (isWhite(img.getRGB(x, y)) == 1) {  
                    img.setRGB(x, y, Color.WHITE.getRGB());  
                } else {  
                    img.setRGB(x, y, Color.BLACK.getRGB());  
                }  
            }  
        }  
        return img;  
    }  
	public void initFactory(){
		System.setProperty("webdriver.firefox.bin","D:\\download\\Mozilla Firefox\\firefox.exe"); 
		 File pathToFirefoxBinary = new File("D:\\download\\Mozilla Firefox\\firefox.exe");  
		FirefoxBinary firefoxbin = new FirefoxBinary(pathToFirefoxBinary); 
		 WebDriver webDriver= new FirefoxDriver(firefoxbin,null);
//		PageFactory.initElements(webDriver, this);
//		PageFactory.i
//		
	}
	private void openBrowser(){
		String sp = System.getProperty("file.separator");
//		System.setProperty("webdriver.ie.driver","D:\\project\\qa-wtd" + sp + "tools" + sp
//				+ "IEDriverServer.exe");
		WebDriver	webDriver;
	//webDriver = new InternetExplorerDriver();
		     ChromeDriverService   service = new ChromeDriverService.Builder()
        .usingDriverExecutable(new File("D:\\project\\qa-wtd" + sp + "tools" + sp
    			+ "chromedriver.exe"))
        .usingAnyFreePort()
        .build();
    try {
		service.start();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    webDriver = new RemoteWebDriver(service.getUrl(),
            DesiredCapabilities.chrome());
    webDriver.get("http://www.google.com");
	System.setProperty("webdriver.chrome.driver","D:\\project\\qa-wtd" + sp + "tools" + sp
			+ "chromedriver.exe");
      System.setProperty("webdriver.chrome.bin", 
    		 "C:\\Users\\PA\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe"); 
      
      
      
//      
//      System.setProperty(
//    		  	                "webdriver.chrome.driver",
//    		 	                "C:\\Users\\PA\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
//    		  	        // 创建一个 ChromeDriver 的接口，用于连接 Chrome
//    		 	        @SuppressWarnings("deprecation")
//    		 	        ChromeDriverService service = new ChromeDriverService.Builder()
//    		  	                .usingDriverExecutable(
//    		 	                        new File(
//    		 	                        		"D:\\project\\qa-wtd" + sp + "tools" + sp
//    		 	                   			+ "chromedriver.exe"))
//    		 	                .usingAnyFreePort().build();
//    		  	        try {
//							service.start();
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//    		 	        // 创建一个 Chrome 的浏览器实例
//    		  	      webDriver = new RemoteWebDriver(service.getUrl(),
//    		 	                DesiredCapabilities.chrome());
//    		  
//	 
//    		 	      //  driver.quit();
//    
//    		 	     //   service.stop();
      
      
      
      
          
webDriver=new ChromeDriver();
webDriver.get("http://www.hekun.qa.ipo.com");
//webDriver.close();
webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);    
	webDriver.get("http://www.hekun.qa.ipo.com");
	
	webDriver.manage().window().maximize();
	webDriver.get("http://www.hekun.qa.ipo.com");
	

		WebElement el = webDriver.findElement(By.id("topLogin"));
		el.click();
		WebElement el2 = webDriver.findElement(By.id("mobile"));
		el2.sendKeys("123456789");
		WebElement el3 = webDriver.findElement(By.id("login"));
		el3.click();
		//el.click();
	//	System.out.print("*******"+el.getText());
		//el.click();
	
	webDriver.manage().window().maximize();
	webDriver.manage().window().maximize();
	}
	private static List<File> search(String folder,List<File> listFiles){
		 File[] files=new File(folder).listFiles();
	
		 for(File file :files){
			 if(file.isDirectory()){
				 search(file.toString(),listFiles);
			 }else{
				 if(file.getName().toLowerCase().equalsIgnoreCase("result.xml")){
					 listFiles.add(file);
				 }
			 }
			
		 }
		 return listFiles;
	}
	
	private static void mergeAllResult(String logFolder){
		String fileName=logFolder+System.getProperty("file.separator")+"allResult.xml";
		if(new File(fileName).exists());
		
		try{
			 Document document = DocumentHelper.createDocument();  
			 
			 Element root = document.addElement("TestResult");  
			 List<File> listFiles=new ArrayList<File>();
			 List<File> lists=search(logFolder,listFiles);
			 for(File f:lists){
				 SAXReader reader = new SAXReader(); 
					Document tmpDoc = reader.read(f); 
					 List<Element> elements=tmpDoc.selectNodes("//TestResult");
					 for(Element e:elements){
					 root.appendContent((Branch) e.clone());
					 }
			
			 }
		     OutputFormat outFmt = new OutputFormat("\t",true,"gbk");  
		   
		     XMLWriter xmlWriter = new XMLWriter(new FileWriter(fileName), outFmt);  
		     xmlWriter.write(document);  
		     xmlWriter.close();  
			}catch(Exception e){
			e.printStackTrace();
			}
	}
}
