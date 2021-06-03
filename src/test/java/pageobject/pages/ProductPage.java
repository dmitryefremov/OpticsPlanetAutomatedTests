package pageobject.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    private BaseFunc baseFunc;
    public ProductPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    private final Logger LOGGER = LogManager.getLogger(ProductGridPage.class);
    WebDriverWait wait;

    public WebElement findSingleVariantProduct() {
        List<WebElement> allProducts = baseFunc.findElements(ALL_PRODUCTS_IN_GRID);
        LOGGER.info("Looking for a product which doesn't contain models");
        WebElement singleProduct = null;
        for (int i = 0; i < allProducts.size(); i++) {
            if (allProducts.get(i).getText().contains("models")) {
                singleProduct = allProducts.get(i + 1);
                continue;
            }
            else {
                break;
            }
        }
        return singleProduct;
    }

    public String getProductNameAsString(By locator) {
        LOGGER.info("Getting Product Name and crop it to first 15 characters for a future comparison");
        String text = baseFunc.getText(locator);
        return text = baseFunc.cutString(text);
    }

//    @Test //Adding a product to the Cart from a multi variant page
//    public void addMultiVariantToCart() {
//        LOGGER.info("Looking for a product which contain models");
//        List<WebElement> allProducts = driver.findElements(ALL_PRODUCTS_IN_GRID);
//        //Loop to find product which doesn't contain models
//        for (int i = 0; i < allProducts.size(); i++) {
//            if (!allProducts.get(i).getText().contains("models")) {
//                continue;
//            }
//            allProducts.get(i).click();
//            break;
//        }
//        LOGGER.info("Getting Product Name and crop it to first 15 characters for a future comparison");
//        wait.until(ExpectedConditions.elementToBeClickable(ADD_TO_CART_BTN)).click();
//        LOGGER.info("Inside Step Zero - Click on View Cart button");
//        wait.until(ExpectedConditions.elementToBeClickable(STEP_0_CLOSE));
//    }
}