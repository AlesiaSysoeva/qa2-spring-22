package pageobject;

import org.junit.jupiter.api.Test;
import pageobject.pages.BaseFunc;
import pageobject.pages.HomePage;
import pageobject.pages.RegistrationPage;
import pageobject.pages.SeatSelectionPage;

public class FlightTests {
    private final String HOME_PAGE_URL = "http://qaguru.lv:8089/tickets/";
    private final String NAME = "Alesia";
    private final String SURNAME = "Sysoeva";
    private final String DISCOUNT = "321111";
    private final String ADULTS = "1";
    private final String CHILDREN = "1";
    private final String BUGS = "3";

    @Test
    public void fillInTheForm () {
        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openUrl(HOME_PAGE_URL);
        HomePage homePage = new HomePage(baseFunc);
        homePage.searchForA("RIX");
        homePage.searchForB("SFO");
        homePage.searchTickets();

        RegistrationPage registrationPage = new RegistrationPage(baseFunc);
        registrationPage.searchForName(NAME);
        registrationPage.searchForSurname(SURNAME);
        registrationPage.searchForDiscount(DISCOUNT);
        registrationPage.searchForAdults(ADULTS);
        registrationPage.searchForChildren(CHILDREN);
        registrationPage.searchForBugs(BUGS);
        registrationPage.searchForFlight("13");
        registrationPage.getPrice();
        registrationPage.book();

        SeatSelectionPage seatSelectionPage = new SeatSelectionPage(baseFunc);
        seatSelectionPage.seatSelection(15);
        seatSelectionPage.finallyBook();
    }
}
