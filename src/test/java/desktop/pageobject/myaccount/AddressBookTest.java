package desktop.pageobject.myaccount;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import desktop.pageobject.pages.BaseFunc;
import desktop.pageobject.pages.ProductGridPage;

public class AddressBookTest {
    private final Logger LOGGER = LogManager.getLogger(ProductGridPage.class);
    private BaseFunc baseFunc = new BaseFunc();

    private final By SIGN_IN_BUTTON = By.id("sign-in-popup-button");
    private final By SIGN_IN_EMAIL_INPUT = By.id("signInEmailInput");
    private final By SIGN_IN_PASSWORD_INPUT = By.id("signInPasswordInput");
    private final By SIGN_IN_SUBMIT_BTN = By.xpath(".//*/button[@type='submit']");
    private final By CUSTOMER_AUTHORIZED_PROOF = By.id("authorized-customer-greeting");

    private final By NICKNAME_INPUT = By.id("customer_address_title");
    private final By FIRST_NAME_INPUT = By.id("customer_address_firstName");
    private final By LAST_NAME_INPUT = By.id("customer_address_lastName");
    private final By COMPANY_NAME_INPUT = By.id("customer_address_company");
    private final By ADDRESS_LINE_1_INPUT = By.id("customer_address_addressOne");
    private final By ADDRESS_LINE_2_INPUT = By.id("customer_address_addressTwo");
    private final By CITY_INPUT = By.id("customer_address_city");
    private final By STATE_DROPDOWN = By.id("customer_address_state");
    private final By ILLINOIS_STATE_IN_DROPDOWN = By.xpath("//*[text()='Illinois']");
    private final By ZIP_INPUT = By.id("customer_address_zip");
    private final By PHONE_INPUT = By.id("customer_address_phone");
    private final By PHONE_EXTENSION_INPUT = By.id("customer_address_phoneExtension");
    private final By ADD_NEW_ADDRESS_BTN = By.xpath(".//button[@class='op-btn_submit op-btn_submit_small-text']");
    private final By ADD_NEW_ADDRESS_WHEN_OTHER_EXISTS_BTN = By.xpath("//span[@data-event='add-address']");
    private final By POP_UP_SET_AS_DEFAULT_ADDRESS = By.id("customer_address_primary");

    private final By POST_CODE_VALIDATED = By.xpath(".//input[@id='customer_address_zip'][contains(@class, 'e-form__input_pass')]");
    private final By OP_OFFICE_ADDRESS = By.xpath("//tr[@class='green']/td/span[text()='OP Office']");
    private final By OP_OFFICE2_ADDRESS = By.xpath("//tr[@class='green']/td/span[text()='OP Office2']");
    private final By OP_OFFICE_EDITED_ADDRESS = By.xpath("//tr[@class='green']/td/span[text()='OP OfficeEdited']");
    private final By DELETE_ADDRESS_BTN = By.xpath("//span[@data-method='DELETE']");
    private final By EDIT_ADDRESS_BTN = By.xpath("//span[@data-event='edit-address']");
    private final By POP_UP_UPDATE_ADDRESS_BTN = By.xpath("//*[text()='Update address']");


    @BeforeEach
    public void BeforeEach() {
        baseFunc.openPage("https://www.opticsplanet.com/");
        LOGGER.info("Clicking Sign In Button");
        baseFunc.click(SIGN_IN_BUTTON);
        LOGGER.info("Providing customer e-mail and password");
        baseFunc.type(SIGN_IN_EMAIL_INPUT, "dfgdfgdfg");
        baseFunc.type(SIGN_IN_PASSWORD_INPUT, "dfgdfgdfg");

        LOGGER.info("Trying to Sign In");
        baseFunc.click(SIGN_IN_SUBMIT_BTN);
        LOGGER.info("Checking customer is really signed in");
        baseFunc.isVisible(CUSTOMER_AUTHORIZED_PROOF);
        LOGGER.info("Opening Address book Page");
        baseFunc.openPage("https://www.opticsplanet.com/my-account/address-book");
    }

    @Test
    public void addNewAddress() {
        LOGGER.info("Filling in inputs");
        baseFunc.type(NICKNAME_INPUT, "OP Office");
        baseFunc.type(FIRST_NAME_INPUT, "Test");
        baseFunc.type(LAST_NAME_INPUT, "Test");
        baseFunc.type(COMPANY_NAME_INPUT, "Optics Planet");
        baseFunc.type(ADDRESS_LINE_1_INPUT, "3150 Commercial Ave");
        baseFunc.type(ADDRESS_LINE_2_INPUT, "3150 Commercial Ave");
        baseFunc.type(CITY_INPUT, "Northbrook");
        baseFunc.click(STATE_DROPDOWN);
        baseFunc.click(ILLINOIS_STATE_IN_DROPDOWN);
        baseFunc.type(ZIP_INPUT, "60062");
        baseFunc.type(PHONE_INPUT, "5555555555");
        baseFunc.type(PHONE_EXTENSION_INPUT, "123");

        LOGGER.info("Waiting until post code passes validation");
        baseFunc.isVisible(POST_CODE_VALIDATED);

        LOGGER.info("Clicking on Add New Address Buton");
        baseFunc.click(ADD_NEW_ADDRESS_BTN);

        LOGGER.info("Checking OP Office Address appear on page");
        baseFunc.isVisible(OP_OFFICE_ADDRESS);

        LOGGER.info("Adding second address to Address Book");
        baseFunc.click(ADD_NEW_ADDRESS_WHEN_OTHER_EXISTS_BTN);

        LOGGER.info("Setting up as a Default Address");
        baseFunc.click(POP_UP_SET_AS_DEFAULT_ADDRESS);

        LOGGER.info("Filling in inputs");
        baseFunc.type(NICKNAME_INPUT, "OP Office2");
        baseFunc.type(FIRST_NAME_INPUT, "Test");
        baseFunc.type(LAST_NAME_INPUT, "Test");
        baseFunc.type(COMPANY_NAME_INPUT, "Optics Planet");
        baseFunc.type(ADDRESS_LINE_1_INPUT, "3150 Commercial Ave");
        baseFunc.type(ADDRESS_LINE_2_INPUT, "3150 Commercial Ave");
        baseFunc.type(CITY_INPUT, "Northbrook");
        baseFunc.click(STATE_DROPDOWN);
        baseFunc.click(ILLINOIS_STATE_IN_DROPDOWN);
        baseFunc.type(ZIP_INPUT, "60062");
        baseFunc.type(PHONE_INPUT, "4444444444");
        baseFunc.type(PHONE_EXTENSION_INPUT, "123");

        LOGGER.info("Waiting until post code passes validation");
        baseFunc.isVisible(POST_CODE_VALIDATED);

        LOGGER.info("Clicking on Add New Address Buton");
        baseFunc.click(ADD_NEW_ADDRESS_BTN);

        LOGGER.info("Checking OP Office Address appear on page and and set as Default");
        baseFunc.isVisible(OP_OFFICE2_ADDRESS);

        LOGGER.info("Deleting existing addresses");
        baseFunc.click(DELETE_ADDRESS_BTN);
        baseFunc.isVisible(OP_OFFICE_ADDRESS);
        baseFunc.click(DELETE_ADDRESS_BTN);
        baseFunc.isVisible(ADD_NEW_ADDRESS_BTN);
    }

    @Test
    public void editAddress() {
        LOGGER.info("Filling in inputs");
        baseFunc.type(NICKNAME_INPUT, "OP Office");
        baseFunc.type(FIRST_NAME_INPUT, "Test");
        baseFunc.type(LAST_NAME_INPUT, "Test");
        baseFunc.type(COMPANY_NAME_INPUT, "Optics Planet");
        baseFunc.type(ADDRESS_LINE_1_INPUT, "3150 Commercial Ave");
        baseFunc.type(ADDRESS_LINE_2_INPUT, "3150 Commercial Ave");
        baseFunc.type(CITY_INPUT, "Northbrook");
        baseFunc.click(STATE_DROPDOWN);
        baseFunc.click(ILLINOIS_STATE_IN_DROPDOWN);
        baseFunc.type(ZIP_INPUT, "60062");
        baseFunc.type(PHONE_INPUT, "5555555555");
        baseFunc.type(PHONE_EXTENSION_INPUT, "123");

        LOGGER.info("Waiting until post code passes validation");
        baseFunc.isVisible(POST_CODE_VALIDATED);

        LOGGER.info("Clicking on Add New Address Buton");
        baseFunc.click(ADD_NEW_ADDRESS_BTN);

        LOGGER.info("Checking OP Office Address appear on page");
        baseFunc.isVisible(OP_OFFICE_ADDRESS);

        LOGGER.info("Clicking on edit button");
        baseFunc.click(EDIT_ADDRESS_BTN);

        LOGGER.info("Editing inputs");
        baseFunc.type(NICKNAME_INPUT, "Edited");
        baseFunc.type(FIRST_NAME_INPUT, " 1");
        baseFunc.type(LAST_NAME_INPUT, " 1");
        baseFunc.type(COMPANY_NAME_INPUT, " 1");
        baseFunc.type(ADDRESS_LINE_1_INPUT, " 1");
        baseFunc.type(ADDRESS_LINE_2_INPUT, " 1");
        baseFunc.type(CITY_INPUT, "e");
        baseFunc.click(STATE_DROPDOWN);
        baseFunc.click(ILLINOIS_STATE_IN_DROPDOWN);
        baseFunc.click(NICKNAME_INPUT);

        LOGGER.info("clicking on Update Address button");
        baseFunc.click(POP_UP_UPDATE_ADDRESS_BTN);

        LOGGER.info("Checking edited address appear on page");
        baseFunc.isVisible(OP_OFFICE_EDITED_ADDRESS);

        LOGGER.info("Deleting existing addresses");
        baseFunc.click(DELETE_ADDRESS_BTN);
        baseFunc.isVisible(ADD_NEW_ADDRESS_BTN);
    }

    @AfterEach
    public void closeBrowser() {
        baseFunc.closeBrowser();
    }
}
