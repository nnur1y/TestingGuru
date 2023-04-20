package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DepositPage {
    WebDriver driver;
    public DepositPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "accountno")
    WebElement accountNoFld;

    public void fillAccountNo(String account){
        accountNoFld.sendKeys(account);
    }

    @FindBy(name = "ammount")
    WebElement ammountFld;

    public void fillAmmount(String ammount){
        ammountFld.sendKeys(ammount);
    }

    @FindBy(name = "desc")
    WebElement descFld;

    public void fillDesc(String desc){
        descFld.sendKeys(desc);
    }


    @FindBy(name = "AccSubmit")
    WebElement submitBtn;
    public void clickSubmit(){
        submitBtn.click();
    }


}
