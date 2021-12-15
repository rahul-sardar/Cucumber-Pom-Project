package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.qa.util.ElementUtils;


public class LoginPage {
	private WebDriver driver;
	private ElementUtils utility;
	
	//By Locators
	private By emailID = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@value='Login']");
	private By forwardPasswordLink = By.linkText("Forgotten Password11");

	//Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		utility = new ElementUtils(this.driver);
	}

	//Page Action
	public String getPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgetPasswordLinkExist() {
		utility.waitForElementToBeLocated(forwardPasswordLink, 5);
		return driver.findElement(forwardPasswordLink).isDisplayed();
	}

	public void enterUserName(String usrname) {
		utility.waitForElementToBeLocated(emailID, 20);
		driver.findElement(emailID).sendKeys(usrname);
	}

	public void enterPassword(String pwd) {
		utility.waitForElementToBeLocated(password, 20);
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnLogin() {
		utility.waitForElementToBeLocated(loginButton, 20);
		driver.findElement(loginButton).click();
	}

	public AccountsPage doLogin(String username, String pwd) {
		driver.findElement(emailID).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
		return new AccountsPage(driver);
		
	}

}
