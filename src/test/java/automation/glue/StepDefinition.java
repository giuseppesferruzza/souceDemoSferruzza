package automation.glue;

import automation.AutomationFrameworkConfiguration;
import automation.drivers.DriverSingleton;
import automation.pages.*;
import automation.utils.Constants;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import automation.utils.ConfigurationProperties;

import java.time.Duration;


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
    public void iAmOnTheLoginPage() {
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

    //ADDTOCART
    @And("I add a product to the cart")
    public void iAddAProductToTheCart() {
        homePage.addToCart();
    }
    @And("the cart badge shows {string}")
    public void theCartBadgeShowsString(String numero) {
        Assertions.assertEquals(numero, homePage.getNumbersOfProducts());
    }
    //REMOVETOCART
    @When("I remove a product from the cart")
    public void iRemoveAProductFromTheCart() {
        homePage.removeFromCart();
    }
    @Then("the cart shows no items")
    public void theCartShowsNoItems() {homePage.getNumbersOfProducts();

    }
    // ORDINAMENTO PRODOTTI ZA
    @When("I open the function that sorts the elements from Z to A")
    public void iOpenTheFunctionThatSortsTheElementsFromZToA() {homePage.clickmenuAZ();
    }

    @Then("The items update from Z to A")
    public void theItemsUpdateFromZToA() {
        homePage.clickAZ();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @After
    public void closeDriver(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        DriverSingleton.closeObjectInstance();
    }
    //ORDINAMENTO PRODOTTI LOW HIGH
    @When("I open the function that sorts the elements from pricelow to pricehigh")
    public void iOpenTheFunctionThatSortsTheElementsFromPricelowToPricehigh() {homePage.clickmenuAZ();
    }

    @Then("Items are ordered from lowest to highest price")
    public void itemsAreOrderedFromLowestToHighestPrice() {homePage.clickLowHigh();

    }
    //TEST FUNZIONE CARRELLO
    @When("I press the cart functionality")
    public void iPressTheCartFunctionality() {homePage.clickCart();
    }

    @Then("I view the cart")
    public void iViewTheCart() {cartPage.clickCheckOut();
    }

}



