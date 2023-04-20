package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;

public class NewCustomerPage {
    WebDriver driver;
    public NewCustomerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
      }


      public void closeAdd(){
        //if(driver.getPageSource().contains("ad_position_box")) {
            try {
                WebElement frame1 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
                driver.switchTo().frame(frame1);
                WebElement frame2 = driver.findElement(By.id("ad_iframe"));
                driver.switchTo().frame(frame2);
                driver.findElement(By.id("dismiss-button")).click();
                driver.switchTo().defaultContent();
            } catch (Exception e) {
                System.out.println(e);
      //      }
        }
      }
    @FindBy(name = "name")
    WebElement customerNameFld;
    public void fillCustomerName(String customer){
        customerNameFld.sendKeys(customer);
    }

    @FindBy(name = "rad1")
    List<WebElement> genderRad;

    public static void selectRadioButtonByValue(List<WebElement> radioButtons, String value) {
        for (WebElement radioButton: radioButtons) {
            if (radioButton.getAttribute("value").toLowerCase().equals(value.toLowerCase())) {
                radioButton.click();
                break;
            }
        }
    }
    public void selectGender(String gender){
        selectRadioButtonByValue(genderRad, gender);
    }


    @FindBy(name = "dob")
    WebElement dateOfBirthFld;
    public void fillDateOfBirth(String date){
        dateOfBirthFld.sendKeys(date);
    }

    @FindBy(name = "addr")
    WebElement addressFld;
    public void fillAddress(String address){
        addressFld.sendKeys(address);
    }

    @FindBy(name = "city")
    WebElement cityFld;
    public void fillCity(String city){
        cityFld.sendKeys(city);
    }

    @FindBy(name = "state")
    WebElement stateFld;
    public void fillState(String state){
        stateFld.sendKeys(state);
    }


    @FindBy(name = "pinno")
    WebElement pinnoFld;
    public void fillPinNo(String pinno){
        pinnoFld.sendKeys(pinno);
    }

    @FindBy(name = "telephoneno")
    WebElement telephonenoFld;
    public void fillTelephoneNo(String telephoneno){
        telephonenoFld.sendKeys(telephoneno);
    }

    @FindBy(name = "emailid")
    WebElement emailFld;
    public void fillEmail(String email){
        emailFld.sendKeys(email);
    }

    @FindBy(name = "password")
    WebElement passwordFld;
    public void fillPassword(String password){
        passwordFld.sendKeys(password);
    }

    @FindBy(name = "sub")
    WebElement submitBtn;
    @FindBy(name = "res")
    WebElement resetBtn;
    public void clickSubmit(){
        submitBtn.click();
    }
    public void clickReset(){
        resetBtn.click();
    }


    public Boolean check_page() {
        return driver.getPageSource().contains("Customer Registered Successfully!!!");
    }



    @FindBy(xpath = "//*[@id='customer']/tbody/tr[4]/td[2]")
    WebElement customerId;
    public String newCustomerId(){
        return customerId.getText();
    }

    @FindBy(linkText = "New Account")
    WebElement newAccountBtn;

    public NewAccountPage clickNewAccountBtn() {
        newAccountBtn.click();
        return new NewAccountPage(driver);
    }

}
