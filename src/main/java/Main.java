import automation.drivers.DriverSingleton;
import automation.pages.*;
import org.openqa.selenium.WebDriver;
import automation.pages.*;
import automation.utils.FrameworkProperties;

public class Main {
    public static void main(String[] args) {
        FrameworkProperties frameworkProperties = new FrameworkProperties();
        DriverSingleton driverSingleton = DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        WebDriver driver = DriverSingleton.getDriver();
        driver.get("https://saucedemo.com/");

        //istanze delle pagine
        LoginInPage loginInPage = new LoginInPage();
        HomePage homePage = new HomePage();
        CartPage cartPage = new CartPage();
        CheckOutYourInformation checkOutYourInformation = new CheckOutYourInformation();
        CheckOutOverview checkOutOverview = new CheckOutOverview();
        CheckOutComplete checkOutComplete = new CheckOutComplete();



        loginInPage.logIn("standard_user", "secret_sauce");

        if(homePage.getTitle().equals("Products")){
            System.out.println("Test passed");
        }
        else
            System.out.println("Test not passed");

        homePage.addToCart();

        homePage.proceedToCheckout();

        cartPage.proceedToCheckout();

        checkOutYourInformation.proceed("bartolo","palle","12345");
        checkOutOverview.premibottonefinale();
        checkOutComplete.premibottonebackhome();
        DriverSingleton.closeObjectInstance();

    }
}
