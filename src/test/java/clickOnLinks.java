import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class clickOnLinks {
    WebDriver driver;

    @BeforeMethod
    public void share(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[@href='/download']")).click();

    }

    @Test
    public void test() throws InterruptedException {

        Assert.assertTrue(driver.getTitle().contains("download"));
    }

    @Test
    public void test2() {

        driver.navigate().back();

        driver.findElement(By.xpath("//a[@href='/upload']")).click();

        Assert.assertTrue(driver.getTitle().contains("upload"));

    }
}

//iki test de failed cunku title da download ve upload yok!