package PopUP;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowPopUp 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.actitime.com/login.do");
        
        String parentWindowId = driver.getWindowHandle();
        
        driver.findElement(By.xpath("//a[text()='actiTIME Inc.']")).click();
        Set<String> allWindowIds = driver.getWindowHandles();
        
        for(String windowId:allWindowIds)
        {
        	driver.switchTo().window(windowId);
        	if(!windowId.equals(parentWindowId))
        	{
        		driver.findElement(By.linkText("Try Free")).click();
        		break;
        	}
        }
        driver.switchTo().window(parentWindowId);
        driver.findElement(By.id("keep LoggedInCheckBox")).click();
        
        }

}
