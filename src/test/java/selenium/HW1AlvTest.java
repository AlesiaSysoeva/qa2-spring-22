package selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class HW1AlvTest {
    private final String HOME_PAGE = "http://1a.lv";
    private final By KATALOGS = By.xpath(".//div[@class = 'submenu-lvl1 submenu-lvl1--invisible']");


    @Test
    public void productSearch() {
        System.setProperty("webdriver.chrome.driver", "d://webdrivers//chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get(HOME_PAGE);
        WebElement searchField =  browser.findElement(KATALOGS);
        searchField.click();

//        List<WebElement> list = new ArrayList<>();
//        List<WebElement> linkList = browser.findElements(By.xpath(".//div[@class = 'submenu-lvl1 submenu-lvl1--invisible']"));
//        linkList.get(3);

    }
}
