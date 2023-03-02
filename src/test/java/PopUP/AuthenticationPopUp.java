package PopUP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPopUp 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        Thread.sleep(3000);
        //<syntax> "http://USERNAME:PASSWORD@the-internet.herokuapp.com/basic_auth"
        driver.quit();
	}
}
