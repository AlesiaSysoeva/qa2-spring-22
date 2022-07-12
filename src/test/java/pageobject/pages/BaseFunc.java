package pageobject.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseFunc {
    private WebDriver driver;
    private WebDriverWait wait;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "d://webdrivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void openUrl(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        driver.get(url);
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        WebElement we = driver.findElement(locator);
        try {
            we.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Can't click from first try");
            we.click();
        }
    }

    public void type(By locator, String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement we = driver.findElement(locator);
        we.clear();
        we.sendKeys(text);
    }

    public void select(By locator, String text) {
        WebElement we = driver.findElement(locator);
        Select select = new Select(we);
        select.selectByValue(text);
    }

    public void searchList(By locator, Integer number) {
        List<WebElement> seats = driver.findElements(locator);
        for (WebElement we : seats) {
            if (we.getText().equals(number.toString())) {
                we.click();
                break;
            }
        }
    }

    public void pressKey(By locator, Keys key) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement we = driver.findElement(locator);
        we.sendKeys(key);
    }

    public void searchFor(By locator, String text) {
        List<WebElement> subMenuItems = driver.findElements(locator);
        boolean flag = false;
        for (WebElement we : subMenuItems) {
            if (we.getText().equals(text)) {
                flag = true;
                wait.until(ExpectedConditions.elementToBeClickable(we));

                try {
                    we.click();
                } catch (ElementClickInterceptedException e) {
                    System.out.println("Can't click from the first time");
                    we.click();
                }

                break;
            }
        }
    }
}
