package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class GuruTest {
    WebDriver driver;
    String customer;

    String account;
    @BeforeSuite
    public void setUp(){


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 0)
    public void loginTest() {
        driver.get("https://demo.guru99.com/v4/");
        LoginPage loginPage = new LoginPage(driver);
        //past
        loginPage.fillUserID("mngr494854");
        //fail
        //loginPage.fillUserID("mngr49485");
        loginPage.fillPassword("zerybEb");
        loginPage.clickLoginBtn();
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.check_page());
        //homePage.clickNewCustomerBtn();

    }
/*
    @Test(priority = 1)
    public void newCustomerTest() throws InterruptedException {
        NewCustomerPage customerPage = new NewCustomerPage(driver);
        Thread.sleep(1000);
        customerPage.closeAdd();
        customerPage.fillCustomerName("Nurly");
        customerPage.selectGender("f");
        customerPage.fillDateOfBirth("25.12.2003");
        customerPage.fillAddress("Zhasulan 91");
        customerPage.fillCity("Almaty");
        customerPage.fillState("Koksay");
        customerPage.fillPinNo("123456");
        customerPage.fillTelephoneNo("+77762467770");
        customerPage.fillEmail("n8@mail.ru");
        customerPage.fillPassword("12345678");
        customerPage.clickSubmit();
        Thread.sleep(5000);
        Assert.assertTrue(customerPage.check_page());
        customer = customerPage.newCustomerId();
        customerPage.clickNewAccountBtn();
    }

    @Test(priority = 2)
    public void newAccountPage(){
        NewAccountPage accountPage = new NewAccountPage(driver);
        accountPage.fillCustomerId(customer);
        accountPage.fillInitDepo("12345");
        accountPage.clickSubmit();
        Assert.assertTrue(accountPage.check_page());
        account = accountPage.newAccountId();
        accountPage.clickDepositBtn();

    }

    @Test(priority = 3)
    public void depositPage(){
        DepositPage depositPage = new DepositPage(driver);
        depositPage.fillAccountNo(account);
        depositPage.fillAmmount("12345");
        depositPage.fillDesc("qwerty");
        depositPage.clickSubmit();


    }
    */

    @AfterSuite
    public void close(){
        driver.quit();
    }
}
