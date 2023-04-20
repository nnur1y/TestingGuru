import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
//mngr481323
//UqUhYjy

public class FirstTestClass{
    WebDriver driver;

    @BeforeSuite
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/alerts");
    }


    @Test
    public void simpleAlert(){
        WebElement click_me = driver.findElement(By.id("alertButton"));
        click_me.click();

    }




//    @Test(dataProvider = "loginData")
//    public void loginTest(String userId, String password, String expectedUrl){
//        WebElement userIdFld = driver.findElement(By.name("uid"));
//        WebElement passwordFld = driver.findElement(By.name("password"));
//        WebElement loginBtn = driver.findElement(By.name("btnLogin"));
//
//        userIdFld.sendKeys(userId);
//        passwordFld.sendKeys(password);
//        loginBtn.click();
//
//        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
//    }
//
//    @AfterSuite
//    public void tearDown(){
//        driver.close();
//    }
//    @DataProvider(name = "loginData")
//    public Object[][] loginData(){
//        return new Object[][]{
//                {"mngr481323","UqUhYjy", "https://demo.guu99.com/v4/manager/Managerhomepage.php"}
//        };
//    }


}