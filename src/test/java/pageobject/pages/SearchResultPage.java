package pageobject.pages;

import org.openqa.selenium.By;


public class SearchResultPage {
    private final By PRODUCT_TYPE = By.xpath(".//span[@class = 'single-title']");
    private BaseFunc baseFunc;

    public SearchResultPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void searchFor(String text) {
        baseFunc.searchFor(PRODUCT_TYPE, text);
    }
}
