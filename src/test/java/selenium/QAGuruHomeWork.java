package selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class QAGuruHomeWork {
    private final String HOME_PAGE_URL = "http://www.qaguru.lv:8089/tickets/step2.php?afrom=CPT&bfrom=BCN";
    private final By NAME = By.id("name");
    private final By SURNAME = By.id("surname");
    private final By DISCOUNT = By.id("discount");
    private final By ADULTS = By.id("adults");
    private final By CHILDREN = By.id("children");
    private final By BUGS = By.id("bugs");
    private final By FLIGHT = By.id("flight");
    private final By CLICK = By.xpath(".//span[@onclick = 'setLang();']");

    @Test
    public void fillInTheForm () {
        System.setProperty("webdriver.chrome.driver", "d://webdrivers//chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get(HOME_PAGE_URL);

        WebElement name =  browser.findElement(NAME);
        name.sendKeys("Alesia");
        WebElement surname =  browser.findElement(SURNAME);
        surname.sendKeys("Sysoeva");
        WebElement discount = browser.findElement(DISCOUNT);
        discount.sendKeys("321111-77745");
        WebElement adults = browser.findElement(ADULTS);
        adults.sendKeys("1");
        WebElement children = browser.findElement(CHILDREN);
        children.sendKeys("1");
        WebElement bugs = browser.findElement(BUGS);
        bugs.sendKeys("3");
        WebElement selectElement = browser.findElement(FLIGHT);
        Select selectObject = new Select(selectElement);
        selectObject.selectByIndex(4);
        WebElement clickBtn = browser.findElement(CLICK);
        clickBtn.click();

    }

}
