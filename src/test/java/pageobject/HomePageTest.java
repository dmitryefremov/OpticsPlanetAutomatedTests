package pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pageobject.pages.BaseFunc;
import pageobject.pages.HomePage;

public class HomePageTest {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private BaseFunc baseFunc = new BaseFunc();
    private HomePage homePage = new HomePage(baseFunc);

    private final By LOGO = By.id("header-logo");
    private final By TOP_BAR_HUNTING = By.id("header-department-3");
    private final By TOP_BAR_HUNTING_LINK = By.xpath("//*[@id='header-department-3']/a");
    private final By SITE_WIDE_BANNER = By.id("sw-banner-container");
    private final By SITE_WIDE_BANNER_LINK = By.xpath(".//a[@class='swt-main-banner_view-deals_link']");
    private final By HOME_PAGE_BANNER_LINK = By.xpath("//*[@id='banner-container-inner']/a[3]");
    private final By POPULAR_BRANDS_FIRST_BRAND = By.xpath("//*[@id='brand-container-scroll-inner']/a[1]");
    private final By POPULAR_CATEGORIES_FIRST_CATEGORY = By.xpath("//a[text()='Riflescopes']");

    @Test
    public void categoriesDropDownAtTheTop() {
        LOGGER.info("Test: Checking Top Bar Functionality");
        baseFunc.openPage("https://www.opticsplanet.com/");
        LOGGER.info("Saving 'Hunting' url from Top Bar");
        String HomePageUrl = baseFunc.getUrlFromLocator(TOP_BAR_HUNTING_LINK);

        LOGGER.info("Clicking on Hunting category");
        baseFunc.click(TOP_BAR_HUNTING_LINK);
        String LandingPageUrl = baseFunc.getCurrentUrl();
        baseFunc.compareTwoStrings(HomePageUrl, LandingPageUrl);
        LOGGER.info("Checking page is not 404");
        baseFunc.isVisible(LOGO);
        baseFunc.closeBrowser();

    }

    @Test
    public void siteWideBanner() {
        LOGGER.info("Test: Checking Site Wide Banner appearance and clickability");
        baseFunc.openPage("https://www.opticsplanet.com/");
        LOGGER.info("Saving url from site wide banner");
        String HomePageUrl = baseFunc.getUrlFromLocator(SITE_WIDE_BANNER_LINK);

        LOGGER.info("Clicking on Site Wide Banner");
        baseFunc.click(SITE_WIDE_BANNER_LINK);
        String LandingPageUrl = baseFunc.getCurrentUrl();
        baseFunc.compareTwoStrings(HomePageUrl, LandingPageUrl);
        LOGGER.info("Checking page is not 404");
        baseFunc.isVisible(LOGO);
        baseFunc.closeBrowser();
    }

    @Test
    public void homePageBanner() {
        LOGGER.info("Test: Checking Site Wide Banner appearance and clickability");
        baseFunc.openPage("https://www.opticsplanet.com/");
        LOGGER.info("Saving url from home page banner");
        String HomePageUrl = baseFunc.getUrlFromLocator(HOME_PAGE_BANNER_LINK);

        LOGGER.info("Clicking on Home Page Banner");
        baseFunc.click(HOME_PAGE_BANNER_LINK);
        String LandingPageUrl = baseFunc.getCurrentUrl();
        baseFunc.compareTwoStrings(HomePageUrl, LandingPageUrl);
        LOGGER.info("Checking page is not 404");
        baseFunc.isVisible(LOGO);
        baseFunc.closeBrowser();
    }

    @Test
    public void popularBrands() {
        LOGGER.info("Test: Checking Popular Brands appearance and clickability");
        baseFunc.openPage("https://www.opticsplanet.com/");
        LOGGER.info("Saving url from Popular Brands (first Brand)");
        String HomePageUrl = baseFunc.getUrlFromLocator(POPULAR_BRANDS_FIRST_BRAND);

        LOGGER.info("Clicking on First Popular Brand");
        baseFunc.click(POPULAR_BRANDS_FIRST_BRAND);
        String LandingPageUrl = baseFunc.getCurrentUrl();
        baseFunc.compareTwoStrings(HomePageUrl, LandingPageUrl);
        LOGGER.info("Checking page is not 404");
        baseFunc.isVisible(LOGO);
        baseFunc.closeBrowser();
    }

    @Test
    public void popularCategories() {
        LOGGER.info("Test: Checking Popular Categories appearance and clickability");
        baseFunc.openPage("https://www.opticsplanet.com/");
        LOGGER.info("Saving url from Popular Categories (Riflescopes)");
        String HomePageUrl = baseFunc.getUrlFromLocator(POPULAR_CATEGORIES_FIRST_CATEGORY);

        LOGGER.info("Clicking on Riflescopes category");
        baseFunc.click(POPULAR_CATEGORIES_FIRST_CATEGORY);
        String LandingPageUrl = baseFunc.getCurrentUrl();
        baseFunc.compareTwoStrings(HomePageUrl, LandingPageUrl);
        LOGGER.info("Checking page is not 404");
        baseFunc.isVisible(LOGO);
        baseFunc.closeBrowser();
    }

//    @Test
//    public void featuredDeals() {
//        LOGGER.info("Test: Checking Featured Deals appearance and clickability");
//        baseFunc.openPage("https://www.opticsplanet.com/");
//    }
//
//    @Test
//    public void dealsOnBestSellers() {
//        LOGGER.info("Test: Checking Deals on Best Sellers appearance and clickability");
//        baseFunc.openPage("https://www.opticsplanet.com/");
//    }
//
//    @Test
//    public void topRated() {
//        LOGGER.info("Test: Checking Top Rated appearance and clickability");
//        baseFunc.openPage("https://www.opticsplanet.com/");
//    }
//
//    @Test
//    public void onSale() {
//        LOGGER.info("Test: Checking On Sale appearance and clickability");
//        baseFunc.openPage("https://www.opticsplanet.com/");
//    }
//
//    @Test
//    public void newProducts() {
//        LOGGER.info("Test: Checking New Products appearance and clickability");
//        baseFunc.openPage("https://www.opticsplanet.com/");
//    }
//
//    @Test
//    public void exclusiveProducts() {
//        LOGGER.info("Test: Checking Exclusive Products appearance and clickability");
//        baseFunc.openPage("https://www.opticsplanet.com/");
//    }
}
