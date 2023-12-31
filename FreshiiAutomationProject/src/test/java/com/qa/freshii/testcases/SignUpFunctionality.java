package com.qa.freshii.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.freshii.qa.base.TestBase;
import com.freshii.qa.pages.LaunchPage;

public class SignUpFunctionality extends TestBase {
	
	LaunchPage launchPage;
	public SignUpFunctionality() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		launchPage=new LaunchPage();
		launchPage.enterFindStore(prop.getProperty("postalCode"));
	}
	
	@Test(priority=0)
	public void signUpToFreshii() throws InterruptedException {
		Thread.sleep(5000);
		launchPage.navigateToLoginPage();
		Thread.sleep(3000);
		launchPage.signInWithGoogleAccount(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
