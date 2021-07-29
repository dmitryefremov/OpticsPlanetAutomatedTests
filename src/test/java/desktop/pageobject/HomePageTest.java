package desktop.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import desktop.pageobject.pages.BaseFunc;

public class HomePageTest {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private BaseFunc baseFunc = new BaseFunc();

    private final By LOGO = By.id("header-logo");
    private final By TOP_BAR_HUNTING = By.id("header-department-3");
    private final By TOP_BAR_HUNTING_LINK = By.xpath("//*[@id='header-department-3']/a");
    private final By SITE_WIDE_BANNER = By.xpath("//*[@id=\"sw-banner-container\"]");
    private final By SITE_WIDE_BANNER_LINK = By.xpath(".//a[@class='swt-main-banner_view-deals_link']");
    private final By HOME_PAGE_BANNER_LINK = By.xpath("//*[@id=\"header-logo\"]");
    private final By POPULAR_BRANDS_FIRST_BRAND = By.xpath("//*[@id='brand-container-scroll-inner']/a[1]");
    private final By POPULAR_CATEGORIES_FIRST_CATEGORY = By.xpath("//a[text()='Riflescopes']");
    private final By FEATURED_DEALS_LINK = By.xpath("//*[@id=\"featured-deal-carousel-scrollable\"]/a[1]");
    private final By BEST_SELLERS_FIRST_PRODUCT = By.xpath("//*[@id='home-page-contents']/div[1]/div[2]/div[2]/div/div[1]/a");
    private final By BEST_SELLERS_VIEW_LINK = By.xpath("//*[@id='home-page-contents']/div[1]/div[1]/a");
    private final By TOP_RATED_FIRST_PRODUCT = By.xpath("//*[@id='home-page-contents']/div[2]/div[2]/div[2]/div/div[1]");
    private final By TOP_RATED_VIEW_LINK = By.xpath("//*[@id='home-page-contents']/div[2]/div[1]/a");
    private final By ON_SALE_FIRST_PRODUCT = By.xpath("//*[@id='home-page-contents']/div[3]/div[2]/div[2]/div/div[1]/a");
    private final By ON_SALE_VIEW_LINK = By.xpath("//*[@id='home-page-contents']/div[3]/div[1]/a");
    private final By NEW_PRODUCTS_FIRST_PRODUCT = By.xpath("//*[@id='home-page-contents']/div[4]/div[2]/div[2]/div/div[1]");
    private final By NEW_PRODUCTS_LINK = By.xpath("//*[@id='home-page-contents']/div[4]/div[1]/a");
    private final By EXCLUSIVE_PRODUCTS_FIRST_PRODUCT = By.xpath("//*[@id='home-page-contents']/div[5]/div[2]/div[2]/div/div[1]");
    private final By EXCLUSIVE_PRODUCTS_LINK = By.xpath("//*[@id='home-page-contents']/div[5]/div[1]/a");

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
        String SiteWideUrl = baseFunc.getUrlFromLocator(SITE_WIDE_BANNER_LINK);

        LOGGER.info("Clicking on Site Wide Banner");
        baseFunc.click(SITE_WIDE_BANNER);
        String LandingPageUrl = baseFunc.getCurrentUrl();
        baseFunc.compareTwoStrings(SiteWideUrl, LandingPageUrl);
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
        baseFunc.closeBrowser();
    }

    @Test
    public void featuredDeals() {
        LOGGER.info("Test: Checking Featured Deals appearance and clickability");
        baseFunc.openPage("https://www.opticsplanet.com/");
        LOGGER.info("Saving url from Featured Deal");
        String FeaturedDealUrl = baseFunc.getUrlFromLocator(FEATURED_DEALS_LINK);

        LOGGER.info("Clicking on Featured Deal");
        baseFunc.click(FEATURED_DEALS_LINK);
        String LandingPageUrl = baseFunc.getCurrentUrl();
        baseFunc.compareTwoStrings(FeaturedDealUrl, LandingPageUrl);
        baseFunc.closeBrowser();
    }

    @Test
    public void dealsOnBestSellers() {
        LOGGER.info("Test: Checking Deals on Best Sellers appearance and clickability");
        baseFunc.openPage("https://www.opticsplanet.com/");
        LOGGER.info("First product appear in carousel");
        baseFunc.isVisible(BEST_SELLERS_FIRST_PRODUCT);
        LOGGER.info("Saving url from View All Button");
        String HomePageUrl = baseFunc.getUrlFromLocator(BEST_SELLERS_VIEW_LINK);

        LOGGER.info("Clicking on View All Button");
        baseFunc.click(BEST_SELLERS_VIEW_LINK);
        String LandingPageUrl = baseFunc.getCurrentUrl();
        baseFunc.compareTwoStrings(HomePageUrl, LandingPageUrl);
        baseFunc.closeBrowser();
    }

    @Test
    public void topRated() {
        LOGGER.info("Test: Checking Top Rated appearance and clickability");
        baseFunc.openPage("https://www.opticsplanet.com/");
        LOGGER.info("First product appear in carousel");
        baseFunc.isVisible(TOP_RATED_FIRST_PRODUCT);
        LOGGER.info("Saving url from View All Button");
        String HomePageUrl = baseFunc.getUrlFromLocator(TOP_RATED_VIEW_LINK);

        LOGGER.info("Clicking on View All Button");
        baseFunc.click(TOP_RATED_VIEW_LINK);
        String LandingPageUrl = baseFunc.getCurrentUrl();
        baseFunc.compareTwoStrings(HomePageUrl, LandingPageUrl);
        baseFunc.closeBrowser();
    }

    @Test
    public void onSale() {
        LOGGER.info("Test: Checking On Sale appearance and clickability");
        baseFunc.openPage("https://www.opticsplanet.com/");
        LOGGER.info("First product appear in carousel");
        baseFunc.isVisible(ON_SALE_FIRST_PRODUCT);
        LOGGER.info("Saving url from View All Button");
        String HomePageUrl = baseFunc.getUrlFromLocator(ON_SALE_VIEW_LINK);

        LOGGER.info("Clicking on View All Button");
        baseFunc.click(ON_SALE_VIEW_LINK);
        String LandingPageUrl = baseFunc.getCurrentUrl();
        baseFunc.compareTwoStrings(HomePageUrl, LandingPageUrl);
        baseFunc.closeBrowser();
    }

    @Test
    public void newProducts() {
        LOGGER.info("Test: Checking New Products appearance and clickability");
        baseFunc.openPage("https://www.opticsplanet.com/");
        LOGGER.info("First product appear in carousel");
        baseFunc.isVisible(NEW_PRODUCTS_FIRST_PRODUCT);
        LOGGER.info("Saving url from View All Button");
        String HomePageUrl = baseFunc.getUrlFromLocator(NEW_PRODUCTS_LINK);

        LOGGER.info("Clicking on View All Button");
        baseFunc.click(NEW_PRODUCTS_LINK);
        String LandingPageUrl = baseFunc.getCurrentUrl();
        baseFunc.compareTwoStrings(HomePageUrl, LandingPageUrl);
        baseFunc.closeBrowser();
    }

    @Test
    public void exclusiveProducts() {
        LOGGER.info("Test: Checking Exclusive Products appearance and clickability");
        baseFunc.openPage("https://www.opticsplanet.com/");
        LOGGER.info("First product appear in carousel");
        baseFunc.isVisible(EXCLUSIVE_PRODUCTS_FIRST_PRODUCT);
        LOGGER.info("Saving url from View All Button");
        String HomePageUrl = baseFunc.getUrlFromLocator(EXCLUSIVE_PRODUCTS_LINK);

        LOGGER.info("Clicking on View All Button");
        baseFunc.click(EXCLUSIVE_PRODUCTS_LINK);
        String LandingPageUrl = baseFunc.getCurrentUrl();
        baseFunc.compareTwoStrings(HomePageUrl, LandingPageUrl);
        baseFunc.closeBrowser();
    }

    @Test
    public void productsYouViewed() {
        LOGGER.info("Test: Checking Products you've viewed are added to carousel and clickable");
        baseFunc.openPage("www.opticsplanet.com");
        LOGGER.info("Clicking on first product on page");
        String productName = baseFunc.getText(By.xpath("//*[@id=\"home-page-contents\"]/div[1]/div[2]/div[2]/div/div[1]"));
        baseFunc.click(By.xpath("//*[@id=\"home-page-contents\"]/div[1]/div[2]/div[2]/div/div[1]/a"));
        LOGGER.info("Going back to homepage to verify latest viewed product is added to special carousel");
        baseFunc.goBack();
        String latestViewedProductName = baseFunc.getText(By.xpath("//div[contains(@class, 'grid_recently-viewed')]"));
        baseFunc.shouldContains(productName,latestViewedProductName);
        baseFunc.closeBrowser();
    }
}
