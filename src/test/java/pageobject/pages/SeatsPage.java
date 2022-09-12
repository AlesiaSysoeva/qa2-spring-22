package pageobject.pages;

import io.netty.util.internal.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeatsPage {
    private final By SEAT = By.xpath(".//div[@class = 'seat']");
    private final By FINALLY_BOOK_BTN = By.id("book3");
    private final By SELECTED_SEAT_NUMBER = By.xpath(".//div[@class = 'line']");
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

    public FinalPage pressBookBtn() {
        baseFunc.click(FINALLY_BOOK_BTN);
        return new FinalPage(baseFunc);
    }

    public int getSelectedSeatNr() {
       String fullText = baseFunc.findElement(SELECTED_SEAT_NUMBER).getText();
//        fullText.substring(fullText.length() -2); можно так
        fullText = StringUtils.substringAfter(fullText, ": ");
        return Integer.parseInt(fullText);

    }
}
