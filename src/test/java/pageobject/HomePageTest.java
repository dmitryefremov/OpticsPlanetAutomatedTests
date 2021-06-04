package pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import pageobject.pages.BaseFunc;
import pageobject.pages.HomePage;
import pageobject.pages.ProductGridPage;
import pageobject.pages.ProductPage;

public class HomePageTest {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private BaseFunc baseFunc = new BaseFunc();
    private HomePage homePage = new HomePage(baseFunc);

    @Test
    public void categoriesDropDownAtTheTop() {
        LOGGER.info("Test: Checking Site Wide Banner appearance and clickability");
    }

    @Test
    public void siteWideBanner() {
        LOGGER.info("Test: Checking Site Wide Banner appearance and clickability");
    }

    @Test
    public void homePageBanner() {
        LOGGER.info("Test: Checking Site Wide Banner appearance and clickability");
    }

    @Test
    public void popularBrands() {
        LOGGER.info("Test: Checking Popular Brands appearance and clickability");
    }

    @Test
    public void popularCategories() {
        LOGGER.info("Test: Checking Popular Categories appearance and clickability");
    }

    @Test
    public void featuredDeals() {
        LOGGER.info("Test: Checking Featured Deals appearance and clickability");
    }

    @Test
    public void dealsOnBestSellers() {
        LOGGER.info("Test: Checking Deals on Best Sellers appearance and clickability");
    }

    @Test
    public void topRated() {
        LOGGER.info("Test: Checking Top Rated appearance and clickability");
    }

    @Test
    public void onSale() {
        LOGGER.info("Test: Checking On Sale appearance and clickability");
    }

    @Test
    public void newProducts() {
        LOGGER.info("Test: Checking New Products appearance and clickability");
    }

    @Test
    public void exclusiveProducts() {
        LOGGER.info("Test: Checking Exclusive Products appearance and clickability");
    }
}
