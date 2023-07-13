package com.freshii.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase() {
		
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("C:\\Users\\usrin\\git\\FreshiiAutomation\\FreshiiAutomationProject\\src\\main\\"
					+ "java\\com\\qa\\freshii\\config\\config.properties");
				prop.load(ip);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void initialization() throws InterruptedException {
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		} else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\firefox.exe");
			driver=new FirefoxDriver();
		} else {
			System.out.println("None of the browsers identified");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(6000);
	}
}
