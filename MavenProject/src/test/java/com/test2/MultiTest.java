package com.test2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class MultiTest {

	WebDriver driver;
    ChromeOptions chromeOptions = new ChromeOptions();
   
	@BeforeClass
	public void Initalization() throws InterruptedException {
		
	//option = new ChromeOptions();
	
		chromeOptions.addArguments("--disable-search-engine-choice-screen");
		
		driver = new ChromeDriver(chromeOptions);

		driver.get("https://www.amazon.com");
		
		//option.addArguments("--disable-search-engine-choice-screen");

		Thread.sleep(5000);

		driver.manage().window().maximize();

		System.out.println(driver.getTitle());
	}

	@Test(priority = 1)
	public void SelectDropDown() throws InterruptedException {

		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));

		Select sel = new Select(dropdown);

		sel.selectByIndex(3);
		sel.selectByValue("search-alias=computers-intl-ship");

		sel.selectByVisibleText("Movies & TV");

	}

	@Test(priority = 2)
	public void AdvanceDropDown() throws InterruptedException {

		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));

		Select sel = new Select(dropdown);

		List<WebElement> li = sel.getOptions(); // getting only option tag

		System.out.println(li.size());

		for (int i = 0; i < li.size(); i++) {
			li.get(i).click();
			System.out.println(li.get(i).getText());
		}

	}

	@AfterClass
	public void CleanUp() {
		driver.quit();
	}

}
