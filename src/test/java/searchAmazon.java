import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class searchAmazon {
    WebDriver driver;

   @BeforeMethod
   public void mutual(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://amazon.com");

       WebElement search=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
       search.sendKeys("baby oil");

    }
    @Test
    public void test(){

        Assert.assertTrue(driver.getTitle().contains("baby oil"));
    }

}
