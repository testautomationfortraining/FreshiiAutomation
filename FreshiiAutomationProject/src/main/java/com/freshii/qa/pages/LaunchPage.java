package com.freshii.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.freshii.qa.base.TestBase;

public class LaunchPage extends TestBase {
	
	//Page Factory
	@FindBy(xpath="//input[@name='postalCode']")
	WebElement postalCodeTextBox;
	
	@FindBy(xpath="//button[text()='FIND STORE']")
	WebElement findStorebtn;
	
	@FindBy(xpath="//img[contains(@class,'CustomIcon_iconMiddle')][contains(@src,'login.svg')]")
	WebElement profileIcon;
	
	@FindBy(xpath="//button[@qaattr='signIn']")
	WebElement signUpBtn;
	
	@FindBy(xpath="//button[contains(@class,'SocialButton_googleBtn')]")
	WebElement loginWithGoogleBtn;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement emailTextBox;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement pwdTextBox;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement nextBtn;
	
	@FindBy(xpath="//input[@class='VfPpkd-muHVFf-bMcfAe']")
	WebElement showPassword;
	
	
	
	
	
	public LaunchPage() {
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public void enterFindStore(String postalCode) {
		postalCodeTextBox.sendKeys(postalCode);
		findStorebtn.click();
	}

	public void navigateToLoginPage() {
		profileIcon.click();
		signUpBtn.click();
		loginWithGoogleBtn.click();
	}
	
	public OrderNowPage signInWithGoogleAccount(String email, String pwd) throws InterruptedException {
		String mainWindow=driver.getWindowHandle();
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1=s1.iterator();
		
		while(i1.hasNext()) {
			String childWindow=i1.next();
			
			if(!mainWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				emailTextBox.sendKeys(email);
				nextBtn.click();
				Thread.sleep(3000);
				pwdTextBox.sendKeys(pwd);
				showPassword.click();
				nextBtn.click();
				Thread.sleep(2000);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		driver.navigate().refresh();
		Thread.sleep(2000);
		loginWithGoogleBtn.click();
		return new OrderNowPage();
	}
	}
