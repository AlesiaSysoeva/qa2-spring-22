package selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebShopTest {
    private final String HOME_PAGE_URL = "http://1a.lv";
    private final By SEARCH_INPUT_FIELD = By.id("q");
    private final By PRODUCT_TYPE = By.xpath("*//span[@class = 'single-title']");
    private final By MAIN_LOGO = By.className("main-logo");
    private final By SITE_TOP_MENU_LEFT_LINK = By.className("site-top__menu-left-link");
    private final By LANGUAGE_LV = By.xpath("*//a[@class= 'site-top__menu-right-link']");
    private final By LANGUAGE_RU = By.xpath("*//a[@class= 'site-top__menu-right-link']");

    @Test
    public void searchFieldsCheck() {
        System.setProperty("webdriver.chrome.driver", "d://webdrivers//chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get(HOME_PAGE_URL);

        WebElement searchField =  browser.findElement(SEARCH_INPUT_FIELD);
        searchField.sendKeys("Apple");

    }

    }


