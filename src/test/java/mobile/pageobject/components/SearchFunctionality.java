package mobile.pageobject.components;

import desktop.pageobject.pages.BaseFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class SearchFunctionality {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void test() {
        baseFunc.openMobilePage("https://www.opticsplanet.com/");
    }
}
