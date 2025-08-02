package com.test2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Ebay {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.ebay.com/");
		
		driver.manage().window().maximize();
		Thread.sleep(2000);

		WebElement Electronics = driver.findElement(By.xpath("(//a[text()='Electronics'])[2]"));
		
		Thread.sleep(1000);
		
		Actions a = new Actions(driver);
		
		a.moveToElement(Electronics).perform();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//a[text()='TV, Video & Home Audio Electronics'])")).click();
		
	}

}
