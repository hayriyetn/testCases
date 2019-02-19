import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testaadressbook {
    WebDriver driver;


    @BeforeMethod
   public void sharing() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        driver.get("http://a.testaddressbook.com/sign_in");
        WebElement username= ((ChromeDriver) driver).findElementByXPath("//input[@type='email']");
        username.sendKeys("kexesobepu@zsero.com");

        WebElement actualPassword=((ChromeDriver) driver).findElementByXPath("//input[@name='session[password]']");
        actualPassword.sendKeys("password");

        WebElement signInButton=((ChromeDriver) driver).findElementByXPath("//input[@name='commit']");
        signInButton.click();

        //Thread.sleep(2000);


    }

    @Test
    public void signIn(){

        WebElement actualUserName= driver.findElement(By.xpath("//span[@class='navbar-text']"));

        String expectedUserName= "kexesobepu@zsero.com";

        Assert.assertEquals(actualUserName.getText(),expectedUserName);

        Assert.assertTrue(actualUserName.getText().equals(expectedUserName));

        Assert.assertFalse(driver.getTitle().equals("Sign In"));



    }




}
