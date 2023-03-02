package frameHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iframe2 

{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
        
        driver.switchTo().frame("iframeResult");
        System.out.println("Switched to the Parent Frame");
        
        //WebElement inneriFrame = driver.findElement(By.xpath("//iframe[@title=\"Iframe Example\"]']"));
        //driver.switchTo().frame(inneriFrame);
        driver.switchTo().frame(0);
        System.out.println("the written text inside Child frame is : "+driver.findElement(By.xpath("//h1")).getText());
        
        driver.switchTo().parentFrame();
        System.out.println("Control goes back to the Parent Frame"+driver.findElement(By.xpath("//p[text()='You can use the height and width attributes to specify the size of the iframe:']")));
 
        Thread.sleep(5000);
        driver.quit();
        
        
        
	}
}

