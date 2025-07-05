package com.test2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Multitest2 {

	WebDriver driver;
	ChromeOptions chromeOptions = new ChromeOptions();

	@BeforeClass
	public void firstthing() {
		chromeOptions.addArguments("--disable-search-engine-choice-screen");

		driver = new ChromeDriver(chromeOptions);

		driver.get("https://demo.guru99.com/test/newtours/register.php");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}

	@Test(priority = 1)
	public void SelectIndia() throws InterruptedException {

		WebElement dropdown = driver.findElement(By.name("country"));
		Select sel = new Select(dropdown);
		List<WebElement> li = sel.getOptions();
		String value = "INDIA";

		for (int i = 0; i < li.size(); i++) {

			System.out.println(li.get(i).getText());

			li.get(i).click();

			if (li.get(i).getText().equalsIgnoreCase(value)) {

				break;
			}
		}

	}

	@Test(priority = 2)
	public void FillForm() throws InterruptedException {

		driver.findElement(By.name("firstName")).sendKeys("Janet");
		driver.findElement(By.name("lastName")).sendKeys("Jane");
		driver.findElement(By.name("phone")).sendKeys("01828911818");
		driver.findElement(By.name("userName")).sendKeys("jj@yahoo.com");
		driver.findElement(By.name("address1")).sendKeys("Street 1234");
		driver.findElement(By.name("city")).sendKeys("New York");
		driver.findElement(By.name("state")).sendKeys("The State");
		driver.findElement(By.name("postalCode")).sendKeys("3910TYJ");
		WebElement dropdown = driver.findElement(By.name("country"));
		Select sel = new Select(dropdown);
		sel.selectByValue("UNITED STATES");
		driver.findElement(By.name("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.name("password")).sendKeys("IOOSO^(%%");
		driver.findElement(By.name("confirmPassword")).sendKeys("IOOSO^(%%");
		driver.findElement(By.name("submit")).click();

	}

	@AfterClass
	public void CleanUp() {
		driver.quit();
	}
}
