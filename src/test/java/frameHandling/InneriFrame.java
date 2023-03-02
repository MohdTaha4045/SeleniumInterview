package frameHandling;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InneriFrame 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.automationtesting.in/Frames.html");
        driver.findElement(By.xpath("//a[@href='#Multiple']")).click();
        
        WebElement outeriFrame = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
        driver.switchTo().frame(outeriFrame);
        System.out.println("Switched to the Outer Frame");
        
        WebElement inneriFrame = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
        driver.switchTo().frame(inneriFrame);
        System.out.println("Switched to the Inner Frame");

        
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Sample text");
        System.out.println("Text is sent to the TextField");
	
        Thread.sleep(5000);
        driver.quit();
	}
	

}
