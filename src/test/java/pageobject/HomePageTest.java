package pageobject;

import com.google.gson.annotations.Until;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.pages.BaseFunc;
import pageobject.pages.HomePage;
import pageobject.pages.ProductGridPage;
import pageobject.pages.ProductPage;

import java.util.List;

public class HomePageTest {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private BaseFunc baseFunc = new BaseFunc();
    private HomePage homePage = new HomePage(baseFunc);

    private final By TOP_BAR_HUNTING = By.id("header-department-3");
    private final By SITE_WIDE_BANNER = By.id("sw-banner-container");
    private final By SITE_WIDE_BANNER_LINK = By.xpath(".//a[@class=\"swt-main-banner_view-deals_link\"]");

    @Test
    public void categoriesDropDownAtTheTop() {
        LOGGER.info("Test: Checking Site Wide Banner appearance and clickability");
        baseFunc.openPage("https://www.opticsplanet.com/");
        System.out.println(baseFunc.getText(TOP_BAR_HUNTING));

    }

    @Test
    public void siteWideBanner() {
        LOGGER.info("Test: Checking Site Wide Banner appearance and clickability");
        baseFunc.openPage("https://www.opticsplanet.com/");
        LOGGER.info("Saving url from site wide banner");
        String HomePageUrl = baseFunc.getUrlFromLocator(SITE_WIDE_BANNER_LINK);
        baseFunc.click(SITE_WIDE_BANNER_LINK);
//        String LandingPageUrl = baseFunc.getCurrentUrl();




    }

    @Test
    public void homePageBanner() {
        LOGGER.info("Test: Checking Site Wide Banner appearance and clickability");
        baseFunc.openPage("https://www.opticsplanet.com/");
    }

    @Test
    public void popularBrands() {
        LOGGER.info("Test: Checking Popular Brands appearance and clickability");
        baseFunc.openPage("https://www.opticsplanet.com/");
    }

    @Test
    public void popularCategories() {
        LOGGER.info("Test: Checking Popular Categories appearance and clickability");
        baseFunc.openPage("https://www.opticsplanet.com/");
    }

    @Test
    public void featuredDeals() {
        LOGGER.info("Test: Checking Featured Deals appearance and clickability");
        baseFunc.openPage("https://www.opticsplanet.com/");
    }

    @Test
    public void dealsOnBestSellers() {
        LOGGER.info("Test: Checking Deals on Best Sellers appearance and clickability");
        baseFunc.openPage("https://www.opticsplanet.com/");
    }

    @Test
    public void topRated() {
        LOGGER.info("Test: Checking Top Rated appearance and clickability");
        baseFunc.openPage("https://www.opticsplanet.com/");
    }

    @Test
    public void onSale() {
        LOGGER.info("Test: Checking On Sale appearance and clickability");
        baseFunc.openPage("https://www.opticsplanet.com/");
    }

    @Test
    public void newProducts() {
        LOGGER.info("Test: Checking New Products appearance and clickability");
        baseFunc.openPage("https://www.opticsplanet.com/");
    }

    @Test
    public void exclusiveProducts() {
        LOGGER.info("Test: Checking Exclusive Products appearance and clickability");
        baseFunc.openPage("https://www.opticsplanet.com/");
    }
}
