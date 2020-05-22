package com.MasterPageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MasterPageFactory {
	public MasterPageFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//*[@class='sc-htoDjs dpodOf'])[1]//li")
	private List<WebElement> allPageName;

	public List<WebElement> getAllPageName() {
		return allPageName;
	}
	@FindBy(xpath ="//*[@class='module-body wsod most-popular-stocks']//a")
	private List<WebElement> mostPopularStock;

	public List<WebElement> getMostPopularStock() {
		return mostPopularStock;
	}
	

}