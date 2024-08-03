
package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeTests {

	@Parameters({"username","password","expectedErrorMsg"})
	@Test(priority = 1)
	public void incorrectUsernameTest(String username, String password, String expectedErrorMsg) {
		// 1. create driver
		System.out.println("==========incorrectUsernameTest started=========");
		WebDriver driver = new ChromeDriver();

		// 2. open test page
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		// sleep(1);
		driver.manage().window().maximize();
		// sleep(1);
		System.out.println("Page is opened");

		// 3.enter username
		WebElement usernameElement = driver.findElement(By.id("username"));
		usernameElement.sendKeys(username);

		// 4. enter password
		WebElement passwordElement = driver.findElement(By.id("password"));
		passwordElement.sendKeys(password);
		// sleep(2);

		// 5.click login button
		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();

		// 6..check if username is correct or incorrect
		WebElement errorMsg = driver.findElement(By.cssSelector("div#flash"));
//		String expectedErrorMsg = "Your username is invalid!";
		String actualErrorMsg = errorMsg.getText();
		Assert.assertTrue(actualErrorMsg.contains(expectedErrorMsg),
				"Actual error message is not the same as expected error message");

		// 7.close browser
		driver.close();
		System.out.println("==============Test finished==========");

	}

	@Test(priority = 2, enabled = false)
	public void incorrectPasswordTest() {
		// 1. create driver
		System.out.println("==========incorrectPasswordTest started=========");
		WebDriver driver = new ChromeDriver();

		// 2. open test page
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		driver.manage().window().maximize();
		System.out.println("Page is opened");

		// 3.enter username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");

		// 4. enter password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("SuperSecretPassword");

		// 5.click login button
		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();

		// 6..check if password is correct or incorrect
		WebElement errorMsg = driver.findElement(By.cssSelector("div#flash"));
		String expectedErrorMsg = "Your password is invalid!";
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
