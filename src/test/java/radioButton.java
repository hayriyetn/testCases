import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class radioButton {
    WebDriver driver;

    @BeforeMethod
    public void share(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://www.newtours.demoaut.com/");
    }

    @Test
    public void test() throws InterruptedException {

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tutorial");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("tutorial");
        driver.findElement(By.xpath("//input[@type='image']")).click();

        WebElement roundTrip=driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        Assert.assertTrue(roundTrip.isSelected());

        WebElement oneWay=driver.findElement(By.xpath("(//input[@type='radio'])[2]"));

        Assert.assertFalse(oneWay.isSelected());

        oneWay.click();

        Thread.sleep(3000);

        Assert.assertFalse(roundTrip.isSelected());
        Assert.assertTrue(oneWay.isSelected());

    }
}
