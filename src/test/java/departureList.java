import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class departureList {
    WebDriver driver;

    @BeforeMethod
    public void sharing(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://www.newtours.demoaut.com/");
    }

    @Test
    public void test(){

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tutorial");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("tutorial");
        driver.findElement(By.xpath("//input[@type='image']")).click();

        WebElement from=driver.findElement(By.xpath("//select[@name='fromPort']"));

      //   Select select=new Select(from);    nasil kullaniliyor????







    }


}
