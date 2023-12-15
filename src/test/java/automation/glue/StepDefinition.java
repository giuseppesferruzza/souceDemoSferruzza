package automation.glue;

import automation.AutomationFrameworkConfiguration;
import automation.drivers.DriverSingleton;
import automation.pages.*;
import automation.utils.Constants;
import io.cucumber.java.Before;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import automation.utils.ConfigurationProperties;


@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
public class StepDefinition {
    private WebDriver driver;
    private HomePage homePage;
    private SaucePage saucePage;
    private LoginInPage loginInPage;
    private CheckOutComplete checkOutComplete;
    private CheckOutYourInformation checkOutYourInformation;
    private CheckOutOverview checkOutOverview;
    private CartPage cartPage;

    @Autowired
    ConfigurationProperties configurationProperties;

    @Before
    public void initializeObjects() {
        DriverSingleton.getInstance(configurationProperties.getBrowser());
        homePage = new HomePage();
        loginInPage = new LoginInPage();
        checkOutComplete = new CheckOutComplete();
        checkOutYourInformation = new CheckOutYourInformation();
        checkOutOverview = new CheckOutOverview();
        cartPage = new CartPage();
        saucePage = new SaucePage();

    }

    @Given("I am on the login page")
    public void Iamontheloginpage() {
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
    }


    @And("I enter username as {string} and password as {string}")
    public void iEnterUsernameAsUsernameAndPasswordAsPassword(String username, String password) {
        loginInPage.logIn(username, password);
    }

    @Then("I land on the Product page")
    public void iLandOnTheProductPage() {
        Assertions.assertEquals(homePage.getTitle(),configurationProperties.getTitolohomepage());
    }

    //DETTAGLIO PRODOTTO

    @Given("I am logged in with username as {string} and password as {string}")
    public void iAmLoggedInWithUsernameAsStandardUserAndPasswordAsSecretSauce(String username, String password) {
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
        loginInPage.logIn(username, password);

    }

    @When ("I click on the title of the product")
    public void iClickOnTheTitleOfTheProduct() {
        homePage.clickProductTitle();
    }

    @Then("I land on the detail page of the product {string}")
    public void iLandOnTheDetailPageOfTheProductSauceLabsBackpack(String Sauce_Labs_Backpack) {
        Assertions.assertEquals(saucePage.getTitle(),Sauce_Labs_Backpack);
    }



}
