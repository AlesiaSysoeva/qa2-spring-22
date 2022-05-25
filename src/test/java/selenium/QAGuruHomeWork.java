package selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class QAGuruHomeWork {
    private final String HOME_PAGE_URL = "http://www.qaguru.lv:8089/tickets/step2.php?afrom=CPT&bfrom=BCN";
    private final By NAME = By.id("name");
    private final By SURNAME = By.id("surname");
    private final By DISCOUNT = By.id("discount");
    private final By ADULTS = By.id("adults");
    private final By CHILDREN = By.id("children");
    private final By BUGS = By.id("bugs");
    private final By FLIGHT = By.xpath(".//option[@value = '14']");
    private final By CLICK = By.xpath(".//span[@onclick =  'setLang();']");

    @Test
    public void fillInTheForm () {
        System.setProperty("webdriver.chrome.driver", "d://webdrivers//chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get(HOME_PAGE_URL);

        WebElement searchField1 =  browser.findElement(NAME);
        searchField1.sendKeys("Alesia");
        WebElement searchField2 =  browser.findElement(SURNAME);
        searchField2.sendKeys("SYSOEVA");
        WebElement searchField3 = browser.findElement(DISCOUNT);
        searchField3.sendKeys("321111-77745");
        WebElement searchField4 = browser.findElement(ADULTS);
        searchField4.sendKeys("1");
        WebElement searchField5 = browser.findElement(CHILDREN);
        searchField5.sendKeys("1");
        WebElement searchField6 = browser.findElement(BUGS);
        searchField6.sendKeys("3");
        WebElement searchField7 = browser.findElement(FLIGHT);
        searchField7.click();
        WebElement searchField8 = browser.findElement(CLICK);
        searchField8.click();

    }






}
