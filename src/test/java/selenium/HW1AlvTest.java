package selenium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HW1AlvTest {
    private final String HOME_PAGE_URL = "http://1a.lv";
//    private final String CATALOG_URL = "https://www.1a.lv/c/datortehnika-preces-birojam/2pd";
    private final String MENU_ITEM_TO_OPEN = "Datortehnika, preces birojam";
    private final String SUB_MENU_ITEM_TO_OPEN = "Portatīvie datori un aksesuāri";
    private final By MENU = By.xpath(".//div[@class = 'submenu-lvl1 submenu-lvl1--invisible submenu-lvl1--index']");
    private final By MENU_ITEM = By.xpath(".//li[contains(@class, 'submenu-lvl1__list-item--has-child')]");
    private final By ACCEPT_COOKIES_BTN = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
//    private final By SUB_MENU = By.xpath(".//div[@class = 'filter-block only-desktop']");
//    private final By SUB_MENU_ITEM = By.xpath(".//a[contains(@href, 'portativie-datori-un-aksesuari/2sv')]");
    private final By SUB_MENU = By.xpath(".//ul[@class = 'din-list new-cat-list']");
    private final By SUB_MENU_ITEM = By.xpath(".//span[@class = 'cat-title']");
    private WebDriver browser;

    @BeforeEach
    public void before() {
        System.setProperty("webdriver.chrome.driver", "d://webdrivers//chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get(HOME_PAGE_URL);

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(5));
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

    }

    @Test
    public void subMenu() {
        List<WebElement> subMenuItems = browser.findElement(SUB_MENU).findElements(SUB_MENU_ITEM);

        for (WebElement we : subMenuItems) {
            if (we.getText().equals(SUB_MENU_ITEM_TO_OPEN)) {
            we.click();
            break;
            }

        }

    }

}
