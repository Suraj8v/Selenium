package com.herokuapp.theinternet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {

	@Test
	public void loginTest() {
		// 1. create driver
		System.out.println("==========Test started=========");
		WebDriver driver = new ChromeDriver();

		// 2. open test page
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);	
		driver.manage().window().maximize();
		System.out.println("Page is opened");

		// 3.enter username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");
		
		//explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		
		//implicit wait
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Specifies the amount of time the driver should wait when searching for an element if it is not immediately present. 

		// 4. enter password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("SuperSecretPassword!");
		
		// 5.click login button
		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();

		String expectedUrl = "https://the-internet.herokuapp.com/secure";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

		// 6.successful login msg
		WebElement successMsg = driver.findElement(By.cssSelector("div#flash"));
		String expectedMsg = "You logged into a secure area!";
		String actualMsg = successMsg.getText();
		Assert.assertTrue(actualMsg.contains(expectedMsg), "Actual message is not the same as expected message");

		// 6.logout
		WebElement logoutButton = driver.findElement(By.xpath("//div[@id='content']//a[@href='/logout']"));
		Assert.assertTrue(logoutButton.isDisplayed(), "Logout button is not visible");

		// 7.close browser
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
