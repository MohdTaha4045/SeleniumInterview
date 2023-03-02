package frameHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleiFrame 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
        
        //1st Frame
        driver.switchTo().frame("packageListFrame");
        driver.findElement(By.xpath("//a[@href='org/openqa/selenium/package-frame.html']")).click();
        driver.switchTo().defaultContent();
        
        //2nd Frame
        driver.switchTo().frame("packageFrame");
        driver.findElement(By.xpath("//span[text()='WebDriver']")).click();
        driver.switchTo().defaultContent();

        
      //3rd Frame
        driver.switchTo().frame("classFrame");
        driver.findElement(By.xpath("//a[text()='Help']")).click();

        Thread.sleep(3000);
        driver.quit();
	}

}
