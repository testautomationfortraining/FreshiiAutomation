package com.freshii.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freshii.qa.base.TestBase;

public class OrderNowPage extends TestBase {
	
	//Order Now Page
		@FindBy(xpath="//button[text()='ORDER NOW']")
		WebElement OrderNowButton;
		
		@FindBy(xpath="//button[text()='CONFIRM']")
		WebElement confirmBtn;
		
		@FindBy(xpath="//a[text()='Salads']")
		WebElement saladsBtn;
		
		@FindBy(xpath="//h5[text()='Cobb Salad']")
		WebElement cobbSaladsBtn;
		
		@FindBy(xpath="//button[text()='ADD TO CART']")
		WebElement addToCartBtn;
		
		@FindBy(xpath="//button[text()='NO THANKS']")
		WebElement noThanksBtn;
		
		@FindBy(xpath="//button[@qaattr='addTocart']")
		WebElement addToCartFinalBtn;
		
		@FindBy(xpath="//button[@qaattr='checkout']")
		WebElement checkoutBtn;
		
		@FindBy(xpath="//button[text()='SCHEDULE ORDER']")
		WebElement scheduleOrderBtn;
		
		@FindBy(xpath="//input[@id='rc_select_4']")
		WebElement timeDropDown;
		
		@FindBy(xpath="//div[@title='01:00 PM']")
		WebElement scheduledTime;
		
		@FindBy(xpath="//div[@class='ant-col ant-col-xs-24']/button")
		WebElement scheduleBtn;
		
		@FindBy(xpath="//button[@qaattr='removeAll']")
		WebElement removeAllBtn;
		
		public OrderNowPage() {
			PageFactory.initElements(driver, this);
		}
		
		public void orderNowFunctionality() throws InterruptedException {
			OrderNowButton.click();
			Thread.sleep(2000);
			confirmBtn.click();
			Thread.sleep(2000);
			saladsBtn.click();
			Thread.sleep(2000);
			cobbSaladsBtn.click();
			Thread.sleep(2000);
			addToCartBtn.click();
			Thread.sleep(2000);
			noThanksBtn.click();
			Thread.sleep(2000);
			addToCartFinalBtn.click();
			Thread.sleep(2000);
			checkoutBtn.click();
			Thread.sleep(2000);
			noThanksBtn.click();
			Thread.sleep(5000);
//			if(scheduleOrderBtn.isDisplayed()) {
//				scheduleOrderBtn.click();
//				Thread.sleep(2000);
//				timeDropDown.click();
//				scheduledTime.click();
//				Thread.sleep(2000);
//				scheduleBtn.click();
//				Thread.sleep(2000);
//				scheduleBtn.click();
//			}
			
			removeAllBtn.click();
			Thread.sleep(2000);
		}
}
