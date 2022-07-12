package pageobject;

import org.junit.jupiter.api.Test;
import pageobject.pages.BaseFunc;
import pageobject.pages.HomePage1ALV;
import pageobject.pages.SearchResultPage;

public class CatalogTests {
    private final String HOME_PAGE_URL = "http://1a.lv";
    private final String PRODUCT_TO_FIND = "Apple";

    @Test
    public void productDetailsCheck() {
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openUrl(HOME_PAGE_URL);

        HomePage1ALV homePage1ALV = new HomePage1ALV(baseFunc);
        homePage1ALV.acceptCookies();
        homePage1ALV.searchFor(PRODUCT_TO_FIND);

        SearchResultPage resultPage = new SearchResultPage(baseFunc);
        resultPage.searchFor("Apple AirPods");
    }
}
