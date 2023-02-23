package Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountWebSuggestion 
{
	public static void main(String[] args) 
	{
		String word = "Fleek IT Solutions";
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.google.com");
        WebElement searchField = driver.findElement(By.xpath("//input[@type =\"text\"]"));
        searchField.sendKeys("Software Testing Company");
        searchField.sendKeys(Keys.ENTER);
        String result = driver.findElement(By.xpath("//div[@id=\"result-stats\"]")).getText();
        String[] splitResult = result.split("\\s+");
        
        String string_with_digits_only = splitResult[1].replaceAll("[^0-9]+", "");

        int integer_value = Integer.parseInt(string_with_digits_only);
        System.out.println(integer_value);
        if(integer_value>50000)
        {
        	System.out.println("Results are greater then 50,000");
        }
        else
        {
        	System.out.println("Results are less then 50,000");
        }
        

        WebElement body = driver.findElement(By.xpath("//div[@id=\"rcnt\"]"));
        String bodyText = body.getText();
        int count = 0;

        int index = bodyText.indexOf(word);

        while (index != -1) 
        {
           count++;
           bodyText = bodyText.substring(index + 1);
           index = bodyText.indexOf(word);
        }

        System.out.println("'Fleek It Solutions' repeated "+count+" times");
        driver.quit();
  }


}
