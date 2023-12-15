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

public class CheckOutYourInformation {
    private WebDriver driver;
    public CheckOutYourInformation() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);}

    @FindBy(css = "#first-name")
    private WebElement firstname;
    @FindBy(css = "#last-name")
    private WebElement surname;
    @FindBy(css = "#postal-code")
    private WebElement postalcode;
    @FindBy(id = "continue")
    private WebElement continua;

    public void proceed(String nome, String cognome, String cap){
        firstname.sendKeys(nome);
        surname.sendKeys(cognome);
        postalcode.sendKeys(cap);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.WAIT_TIME));
        wait.until(ExpectedConditions.elementToBeClickable(continua));

        continua.click();
    }

}

