import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductPage {
    //Product Page Locators
    private final By ALL_PRODUCTS_IN_GRID = By.xpath(".//*[@id='list-page-right']//div/div/a");
    private final By ADD_TO_CART_BTN = By.xpath(".//button[@data-externalid='add-to-cart']");
    private final By PRODUCT_DESCRIPTION = By.xpath(".//div[@id='page-header-text']/h1");

    //Step Zero Locators
    private final By STEP_0_CLOSE = By.xpath(".//span[@class='fancy-dropdown-close-button']/span");
    private final By STEP_0_KEEP_SHOPPING = By.xpath(".//span[@id='cart-items-popup-keep-shopping']");
    private final By STEP_0_POP_UP = By.xpath(".//div[contains(@id, 'cart-items-popup-container')]");
    private final By STEP_0_VIEW_CART = By.xpath(".//a[@id='cart-items-popup-edit']");

    //Cart Locators
    private final By PRODUCT_DESCRIPTION_CART = By.xpath(".//td[@class='cart-basket-name']/a");

    private WebDriverWait wait;
    private WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.opticsplanet.com/riflescopes.html");
        wait = new WebDriverWait(driver, 10);
    }

    public static String cutString(String result){ //Method to cut String after specified symbol
        int startIndex = 15;
        int stopIndex = result.length();
        StringBuilder croppedString = new StringBuilder(result);
        croppedString.delete(startIndex, stopIndex);
        return result = croppedString.toString();
    }

    @Test //Adding a product to the Cart from a single variant page
    public void addSingleVariantToCart() {
        List<WebElement> allProducts = driver.findElements(ALL_PRODUCTS_IN_GRID);
        //Loop to find product which contain models
        for (int i = 0; i < allProducts.size(); i++) {
            if (allProducts.get(i).getText().contains("models")) {
                continue;
            }
            allProducts.get(i).click();
            break;
        }
        //Getting Product Name and crop it to first 15 characters
        String productNameOnProductPage = driver.findElement(PRODUCT_DESCRIPTION).getText();
        productNameOnProductPage = cutString(productNameOnProductPage);

        wait.until(ExpectedConditions.elementToBeClickable(ADD_TO_CART_BTN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(STEP_0_VIEW_CART)).click();

        //Getting Product Name and crop it to first 15 characters
        String productNameOnCart = driver.findElement(PRODUCT_DESCRIPTION_CART).getText();
        productNameOnCart = cutString(productNameOnCart);

        //Getting sure its the same product
        if (productNameOnCart.equals(productNameOnProductPage)) { }
        else { wait.until(ExpectedConditions.elementToBeClickable(ADD_TO_CART_BTN)).click(); }
        driver.close();
    }

    @Test //Adding a product to the Cart from a multi variant page
    public void addMultiVariantToCart() {
        List<WebElement> allProducts = driver.findElements(ALL_PRODUCTS_IN_GRID);
        //Loop to find product which doesn't contain models
        for (int i = 0; i < allProducts.size(); i++) {
            if (!allProducts.get(i).getText().contains("models")) {
                continue;
            }
            allProducts.get(i).click();
            break;
        }
        wait.until(ExpectedConditions.elementToBeClickable(ADD_TO_CART_BTN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(STEP_0_CLOSE));


    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }
}