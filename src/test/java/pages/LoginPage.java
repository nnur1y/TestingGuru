package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(name = "uid")
    WebElement userIdFld;

    @FindBy(name = "password")
    WebElement passwordFld;

    @FindBy(name = "btnLogin")
    WebElement loginBtn;


    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillUserID(String userId){
        userIdFld.sendKeys(userId);
    }

    public void fillPassword(String password){
        passwordFld.sendKeys(password);
    }

    public HomePage clickLoginBtn(){
        loginBtn.click();
        return new HomePage(driver);
    }
}