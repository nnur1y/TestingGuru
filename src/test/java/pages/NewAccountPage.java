package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAccountPage {
    WebDriver driver;
    public NewAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "cusid")
    WebElement customerIdFld;
    public void fillCustomerId(String customer){
        customerIdFld.sendKeys(customer);
    }

    @FindBy(name = "inideposit")
    WebElement initdepoFld;
    public void fillInitDepo(String depo){
        initdepoFld.sendKeys(depo);
    }
    @FindBy(name = "button2")
    WebElement submitBtn;

    public void clickSubmit(){
        submitBtn.click();
    }


    public Boolean check_page() {
        return driver.getPageSource().contains("Account Generated Successfully!!!");
    }

    @FindBy(xpath = "//*[@id=\"account\"]/tbody/tr[4]/td[2]")
    WebElement accId;
    public String newAccountId(){
        return accId.getText();
    }

    @FindBy(linkText = "Deposit")
    WebElement depositBtn;

    public DepositPage clickDepositBtn() {
        depositBtn.click();
        return new DepositPage(driver);
    }

}
