package automation.pages;

import automation.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import automation.utils.Constants;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    public CartPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);}

    @FindBy(id ="checkout")
    private WebElement CheckOutButton;
    @FindBy(css ="#header_container > div.header_secondary_container > span")
    private WebElement YourCart;

    public void proceedToCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.WAIT_TIME));
        wait.until(ExpectedConditions.elementToBeClickable(CheckOutButton));

        CheckOutButton.click();
    }
}
