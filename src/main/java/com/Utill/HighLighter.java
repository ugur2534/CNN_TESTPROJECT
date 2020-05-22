package com.Utill;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighLighter {
		
		public static void getColor(WebDriver driver, WebElement element,String color) {
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].style.border='3px solid "+color+"'", element);
		}

		public static void getColor(WebDriver driver, WebElement data, int indexOf) {
			// TODO Auto-generated method stub
			
		}

	}