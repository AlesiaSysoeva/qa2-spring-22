package selenium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class HW1AlvTest {
    private final String HOME_PAGE_URL = "http://1a.lv";
    private final String MENU_ITEM_TO_OPEN = "Datortehnika, preces birojam";
    private final String SUB_MENU_ITEM_TO_OPEN = "Portatīvie datori un aksesuāri";
    private final String CATEGORY_MENU_ITEM_TO_OPEN = "Portatīvie datori";
    private final By MENU = By.xpath(".//div[@class = 'submenu-lvl1 submenu-lvl1--invisible submenu-lvl1--index']");
    private final By MENU_ITEM = By.xpath(".//li[contains(@class, 'submenu-lvl1__list-item--has-child')]");
    private final By ACCEPT_COOKIES_BTN = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    private final By SUB_MENU = By.xpath(".//ul[@class = 'menu product-categories-menu']");
    private final By SUB_MENU_ITEM = By.tagName("a");
    private final By CATEGORY_MENU = By.xpath(".//ul[@class = 'child-category']");
    private final By CATEGORY_MENU_ITEM = By.xpath(".//li[@class = 'parent-category list-filterable__item']");
    private final By CATALOG_ITEM = By.xpath(".//div[contains(@class, 'catalog-taxons-product--grid-view')]");
    private final By CATALOG_ITEM_NAME = By.xpath(".//a[@class = 'catalog-taxons-product__name']");
    private final By PRICE = By.xpath(".//span[@class = 'price']");
    private WebDriver browser;
    private WebDriverWait wait;

    @BeforeEach
    public void before() {
        System.setProperty("webdriver.chrome.driver", "d://webdrivers//chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get(HOME_PAGE_URL);
        wait = new WebDriverWait(browser, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));
        browser.findElement(ACCEPT_COOKIES_BTN).click();
    }

    @Test
    public void menu() {
        List<WebElement> menuItems = browser.findElement(MENU).findElements(MENU_ITEM);
        for (WebElement we : menuItems) {
            if (we.getText().equals(MENU_ITEM_TO_OPEN)) {
                we.click();
                break;
            }
        }

        List<WebElement> subMenuItems = browser.findElement(SUB_MENU).findElements(SUB_MENU_ITEM);
        for (WebElement we : subMenuItems) {
            if (we.getText().equals(SUB_MENU_ITEM_TO_OPEN)) {
                we.click();
                break;
            }
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(CATEGORY_MENU));
        List <WebElement> categoryMenuItems = browser.findElement(CATEGORY_MENU).findElements(CATEGORY_MENU_ITEM);
        for (WebElement we : categoryMenuItems) {
            if (we.getText().equals(CATEGORY_MENU_ITEM_TO_OPEN)) {
                we.click();
                break;
            }
        }
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(CATALOG_ITEM, 2));
        List<WebElement> catalogItems = browser.findElements(CATALOG_ITEM);
        wait.until(ExpectedConditions.presenceOfElementLocated(CATALOG_ITEM_NAME));
        try {
            catalogItems.get(10).click();
        }
        catch (ElementClickInterceptedException e) {
            catalogItems.get(10).click();
        }
        catalogItems.get(10).findElement(CATALOG_ITEM_NAME).click();

        String price = browser.findElement(PRICE).getText();
        System.out.println(price);
    }
}
