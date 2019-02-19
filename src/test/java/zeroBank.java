import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class zeroBank {
    WebDriver driver;

    @BeforeMethod
    public void share(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");

        WebElement userName=driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("username");

        WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("password");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

    }

    @Test
    public void display(){

        WebElement actualUserName=driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[2]"));
        String expectedUserName="username";

       // Assert.assertEquals(actualUserName.getText(),expectedUserName);

        Assert.assertTrue(driver.getTitle().equals("Zero - Account Summary"));
    }
}
