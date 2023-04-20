package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    @BeforeSuite
    public void setUp(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void loginTest() {
        driver.get("https://demo.guru99.com/v4/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserID("mngr488814");
        loginPage.fillPassword("bYtErAv");
        loginPage.clickLoginBtn();
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.check_page());
        homePage.clickNewCustomerBtn();

    }
}