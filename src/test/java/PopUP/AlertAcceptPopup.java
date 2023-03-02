package PopUP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertAcceptPopup 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.ksrtc.in/oprs-web/");
        WebElement searchField = driver.findElement(By.xpath("//button[@class=\"btn btn-primary btn-lg btn-block btn-booking\"]"));
        driver.findElement(By.id("corover-close-btn")).click();//inspectable popup

        searchField.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(5000);

        alert.accept();
        
        Thread.sleep(5000);
        driver.quit();
	}

}
