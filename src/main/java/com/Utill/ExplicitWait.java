package com.Utill;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
//	public static void getwait(WebDriver driver, WebElement element) {
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.elementToBeClickable(element));
//		

	public static void getMyWait(WebDriver driver,WebElement element) {

		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(element));
	}
		
	}
	