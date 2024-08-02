
package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {

	@Test
	public void loginTest() {
		// 1. create driver
		System.out.println("==========Test started=========");
		WebDriver driver = new ChromeDriver();

		// 2. open test page
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		// sleep(1);
		driver.manage().window().maximize();
		// sleep(1);
		System.out.println("Page is opened");

		// 3.enter username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmithm");

		// 4. enter password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("SuperSecretPassword!");
		// sleep(2);

		// 5.click login button
		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();

		// 6..check if username is correct or incorrect
		WebElement errorMsg = driver.findElement(By.cssSelector("div#flash"));
		String expectedErrorMsg = "Your username is invalid!";
		String actualErrorMsg = errorMsg.getText();
		Assert.assertTrue(actualErrorMsg.contains(expectedErrorMsg),
				"Actual error message is not the same as expected error message");

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
