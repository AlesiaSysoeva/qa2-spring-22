package pageobject.pages;

import org.openqa.selenium.By;

public class HomePage {
    private final By AFROM = By.id("afrom");
    private final By BFROM = By.id("bfrom");
    private final By GO_BTN = By.className("gogogo");
    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void searchForA(String text) {
        baseFunc.select(AFROM, text);
    }

    public void searchForB(String text) {
        baseFunc.select(BFROM, text);
    }

    public void searchTickets() {
        baseFunc.click(GO_BTN);
    }
}

