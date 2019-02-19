import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class retrievePassword {
    WebDriver driver;

    @BeforeMethod
    public void first() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/forgot_password");
        Thread.sleep(2000);


    }

    @Test
    public void test(){
        WebElement email=driver.findElement(By.id("email"));
        email.sendKeys("hayriye@gmail.com");
        driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']")).click();
        String url="https://the-internet.herokuapp.com/email_sent";
        Assert.assertTrue(url.contains("email_sent"));


    }
}
