package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.ElementUtils;

public class AccountsPage {
    
	private WebDriver driver;
	private ElementUtils utility;
	
	//By Locator
	private By accountsSectionheadersOnPage = By.xpath("//div[@id='content']/h2");
	
	//Constructor
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		utility = new ElementUtils(this.driver);	
	}
	
	
	
	public String getAccountPageTitle() {
		return driver.getTitle();
	}

	
	public int getAccountSectionListCount() {	
		List<WebElement> elements = utility.getElements(accountsSectionheadersOnPage);
		return elements.size();
	}
	
	public List<String> getAccountSectionList() {
		List<String> arrayList = new ArrayList<String>();
		List<WebElement> elements = utility.getElements(accountsSectionheadersOnPage);
		for(WebElement e : elements) {
			arrayList.add(e.getText());
		}
		return arrayList;
	}
}
