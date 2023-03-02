package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.selenium.interview.BaseClass;

public class ProperTestNG extends BaseClass
{
	@Test
	public void handleIframe()
	{
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

	}
	@Test
	public void iframe2()
	{
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
        
        driver.switchTo().frame("iframeResult");
        System.out.println("Switched to the Parent Frame");

        driver.switchTo().frame(0);
        System.out.println("Text present Child frame : "+driver.findElement(By.xpath("//h1")).getText());
        
        driver.switchTo().parentFrame();
        String text = driver.findElement(By.xpath("//p[text()='You can use the height and width attributes to specify the size of the iframe:']")).getText();
        
        System.out.println("Text present in Parent Frame : "+text);
	}
	@Test
	public void inneriframe()
	{
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
	
	}
}
