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

public class CheckOutComplete {
    private WebDriver driver;
    public CheckOutComplete() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);}

    @FindBy(id = "back-to-products")
    private WebElement premibottonebackhome;

    public void premibottonebackhome() {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.WAIT_TIME));
        wait.until(ExpectedConditions.elementToBeClickable(premibottonebackhome));

        premibottonebackhome.click();
    }
}
