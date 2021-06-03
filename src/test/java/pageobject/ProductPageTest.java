package pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobject.pages.BaseFunc;
import pageobject.pages.ProductPage;

public class ProductPageTest {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private BaseFunc baseFunc = new BaseFunc();
    private ProductPage productPage = new ProductPage(baseFunc);

    WebDriver driver;

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

    @Test
    //Adding a product to the Cart from a single variant page
    public void addSingleVariantToCart() {
        baseFunc.openPage("https://www.opticsplanet.com/riflescopes.html?_iv_gridSize=240");
        LOGGER.info("Opening Product Page");
        productPage.findSingleVariantProduct().click();

        LOGGER.info("Saving Product Name on Product Page");
        String productNameOnProductPage = productPage.getProductNameAsString(PRODUCT_DESCRIPTION);

        LOGGER.info("Click on Add to Cart button");
        baseFunc.click(ADD_TO_CART_BTN);
        LOGGER.info("Inside Step Zero - Click on View Cart button");
        baseFunc.click(STEP_0_VIEW_CART);

        LOGGER.info("Saving Product Name on Cart");
        String productNameOnCart = productPage.getProductNameAsString(PRODUCT_DESCRIPTION_CART);
        LOGGER.info("Comparing Product Name from Product Page versus Cart");
        baseFunc.compareTwoStrings(productNameOnCart, productNameOnProductPage);
    }
}
