package pageobject.pages;

import org.openqa.selenium.By;

public class SeatSelectionPage {
    private final By SEAT = By.xpath(".//div[@class = 'seat']");
    private final By FINALLY_BOOK = By.id("book3");
    private BaseFunc baseFunc;

    public SeatSelectionPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }
    public void seatSelection(Integer number) {
        baseFunc.searchList(SEAT, number);
    }

    public void finallyBook() {
        baseFunc.click(FINALLY_BOOK);
    }
}
