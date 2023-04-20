package pages;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(linkText = "New Customer")
    WebElement newCustomerBtn;

    public NewCustomerPage clickNewCustomerBtn() {
        newCustomerBtn.click();
        return new NewCustomerPage(driver);
    }


    public Boolean check_page() {
        return driver.getPageSource().contains("Manger Id");
    }


}