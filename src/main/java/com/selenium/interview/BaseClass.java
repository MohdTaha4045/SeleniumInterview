package com.selenium.interview;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseClass 
{	
	public static WebDriver driver;
	
	@BeforeClass
	public static void setup()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
