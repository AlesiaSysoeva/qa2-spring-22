package pageobject.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeatsPage {
    private final By SEAT = By.xpath(".//div[@class = 'seat']");
    private final By FINALLY_BOOK = By.id("book3");
    private BaseFunc baseFunc;

    public SeatsPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void seatSelection(Integer seatNr) {
        baseFunc.waitForElementCountAtLeast(SEAT, 5);

        WebElement seatToChose = null;

        for (WebElement we : baseFunc.findElements(SEAT)) {
            if (Integer.parseInt(we.getText()) == seatNr) {
                seatToChose = we;
                break;
            }
        }

        Assertions.assertNotNull(seatToChose, "Can't find seat!");

        baseFunc.click(seatToChose);
    }

    public void finallyBook() {
        baseFunc.click(FINALLY_BOOK);
    }
}
