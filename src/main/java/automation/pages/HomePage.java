package automation.pages;

import automation.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import automation.utils.Constants;
import automation.utils.Utils;

import java.time.Duration;


public class HomePage {
    private WebDriver driver;

    public HomePage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#header_container > div.header_secondary_container > span")
    private WebElement product;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartButton;

    @FindBy(css = "#shopping_cart_container > a")
    private WebElement numbersOfProducts;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartButton;

    @FindBy(css = "#item_4_title_link > div")
    private WebElement productTitle;

    public String getTitle() {
        return product.getText();
    }

    public void addToCart() {
        addToCartButton.click();

        if (numbersOfProducts.getText().contains(Constants.CART_QUANTITY)) {
            System.out.println("il carrello è stato aggiornato");
        } else {
            System.out.println("il carrello non è stato aggiornato");
            Utils.takeScreenshot();
        }
    }

    public void proceedToCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.WAIT_TIME));
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));

        cartButton.click();


    }
    public void clickProductTitle() {productTitle.click();}
    public String getProductTitle() {return productTitle.getText();}
}