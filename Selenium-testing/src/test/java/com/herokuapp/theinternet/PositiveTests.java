package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PositiveTests {

	@Test
	public void loginTest()
	{
		// 1. create driver
		System.out.println("==========Test started=========");
		WebDriver driver = new ChromeDriver();
		
		//2. open test page
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		sleep(1);
		driver.manage().window().maximize();
		sleep(1);
		System.out.println("Page is opened");
		
		//3.enter username
		WebElement username = driver.findElement(By.id("username"));
		
		//4. enter password
		WebElement password = driver.findElement(By.id("password"));
		
		//5.click login button
		WebElement loginButton = driver.findElement(By.tagName("button"));
		
		//6.successful login msg
		WebElement successMsg = driver.findElement(By.cssSelector("div#flash"));
		
		//6.logout
		WebElement logoutButton = driver.findElement(By.xpath("//a[@class='button secondary radius"));
		
		sleep(2);
		 driver.close();
		System.out.println("==============Test finished==========");

	}

	private void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
