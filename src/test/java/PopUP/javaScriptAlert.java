package PopUP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class javaScriptAlert 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        
       driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Alert alert = driver.switchTo().alert();
        
        Thread.sleep(2000);

        alert.accept();
        
        Thread.sleep(2000);
                
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        
        Thread.sleep(2000);

        alert.dismiss();
        
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Thread.sleep(2000);

        alert.sendKeys("hi I am Mohd Taha");
        
        Thread.sleep(5000);
        
        alert.accept();
        
        Thread.sleep(2000);

        driver.quit();
        
        
	}

}
