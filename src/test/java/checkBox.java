import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class checkBox {

    WebDriver driver;

    @BeforeMethod

    public void sharing(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");


    }

    @Test

    public void test() throws InterruptedException {


        WebElement checkBox=driver.findElement(By.xpath("//input[@type='checkbox']"));

        Assert.assertFalse(checkBox.isSelected());

        WebElement checkBox2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        Assert.assertTrue(checkBox2.isSelected());

        checkBox.click();

        Thread.sleep(3000);

       // Assert.assertEquals(checkBox.getAttribute("checked"),"1");
        Assert.assertTrue(checkBox.isSelected());

        checkBox2.click();

        Thread.sleep(3000);

        Assert.assertFalse(checkBox2.isSelected());
       }


}

//bir tane @Test olunca passed oluyor ama birden fazla @Test i yapamadim

