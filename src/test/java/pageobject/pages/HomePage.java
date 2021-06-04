package pageobject.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class HomePage {
    private BaseFunc baseFunc;
    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    private final Logger LOGGER = LogManager.getLogger(ProductGridPage.class);



}
