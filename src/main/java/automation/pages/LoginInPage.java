package automation.pages;

import automation.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginInPage {
    private WebDriver driver;
    public LoginInPage() {
        driver= DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="user-name")
    private WebElement signInUsername;

    @FindBy(id = "password")
    private WebElement signInPassword;

    @FindBy(id = "login-button")
    private WebElement logInButton;

    @FindBy(css = "#login_button_container > div > form > div.error-message-container.error > h3")
    private WebElement errorText;
    @FindBy(xpath="//*[@data-test = 'error']")
    private WebElement errorCredentialText;
    @FindBy(css ="#login_button_container > div > form > div.error-message-container.error > h3 ")
    private WebElement errorLocked;

    public void logIn (String username, String password) {
        signInUsername.sendKeys(username);
        this.signInPassword.sendKeys(password);
        logInButton.click();}

    public String getBlockedError() {return errorText.getText();}
    public String getCredentialError() {return errorCredentialText.getText();}
    public String getLockedError() {return errorLocked.getText();}

}
