package desktop.pageobject.components;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import desktop.pageobject.pages.BaseFunc;

public class SearchFunctionality {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private BaseFunc baseFunc = new BaseFunc();

    private final By SEARCH_INPUT = By.xpath(".//input[@class='e-site-search-block__input']");
    private final By SEARCH_SUGGESTION_FIRST_ELMNT = By.xpath("//*[@id='header-mid-bottom-container']/div[1]/div[1]/div[1]/div/ul/li[1]/a");
    private final By RECOMMENDED_PRODUCTS = By.xpath("//*[@id='header-mid-bottom-container']/div[1]/div[1]/div[2]/div/ul/li[1]");
    private final By TOOLTIP = By.xpath("//*[@id='header-mid-bottom-container']/div[1]/div[2]");
    private final By SEARCH_BUTTON = By.xpath(".//div[@class='e-site-search-button']");
    private final By FIRST_PRODUCT_IN_LIST = By.xpath("//*[@id='list-page-right']/div[1]/div[1]/div[4]/div[1]");

    @Test
    public void checkingSuggestionsDropDown() {
        baseFunc.openPage("https://www.opticsplanet.com/");
        LOGGER.info("Typing 'riflescope' to search input");
        baseFunc.type(SEARCH_INPUT, "riflescope");
        LOGGER.info("Checking for Related Suggestions in drop down");
        baseFunc.isVisible(SEARCH_SUGGESTION_FIRST_ELMNT);
        LOGGER.info("Checking for 'Recommended Products' in drop down");
        baseFunc.isVisible(RECOMMENDED_PRODUCTS);
        LOGGER.info("Suggestion Tooltip appear in drop down");
        baseFunc.isVisible(TOOLTIP);
        baseFunc.closeBrowser();
    }

    @Test
    public void searchSubmittedResultsDisplayed() {
        baseFunc.openPage("https://www.opticsplanet.com/");
        LOGGER.info("Typing 'riflescope' to search input");
        baseFunc.type(SEARCH_INPUT, "riflescope");
        LOGGER.info("Clicking on a SEARCH button");
        baseFunc.click(SEARCH_BUTTON);

        String searchResultText = baseFunc.getText(".//h1[@class='e-search-header__title']");
        String awaitingText = "Search Results for “riflescope”";

        LOGGER.info("Checking we're on the right Search Result Page");
        baseFunc.shouldContains(searchResultText, awaitingText);
        baseFunc.isVisible(FIRST_PRODUCT_IN_LIST);
        baseFunc.closeBrowser();
    }
}
