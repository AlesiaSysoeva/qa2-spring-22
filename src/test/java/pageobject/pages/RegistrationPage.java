package pageobject.pages;

import org.openqa.selenium.By;

public class RegistrationPage {
    private final By NAME = By.id("name");
    private final By SURNAME = By.id("surname");
    private final By DISCOUNT = By.id("discount");
    private final By ADULTS = By.id("adults");
    private final By CHILDREN = By.id("children");
    private final By BUGS = By.id("bugs");
    private final By FLIGHT = By.id("flight");
    private final By CLICK = By.xpath(".//span[@onclick = 'setLang();']");
    private final By BOOK = By.id("book2");
    private BaseFunc baseFunc;

    public RegistrationPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void searchForName(String textToFind) {
        baseFunc.type(NAME, textToFind);
    }

    public void searchForSurname(String textToFind) {
        baseFunc.type(SURNAME, textToFind);
    }

    public void searchForDiscount(String textToFind) {
        baseFunc.type(DISCOUNT, textToFind);
    }

    public void searchForAdults(String textToFind) {
        baseFunc.type(ADULTS, textToFind);
    }

    public void searchForChildren(String textToFind) {
        baseFunc.type(CHILDREN, textToFind);
    }

    public void searchForBugs(String textToFind) {
        baseFunc.type(BUGS, textToFind);
    }

    public void searchForFlight(String text) {
        baseFunc.select(FLIGHT, text);
    }

    public void getPrice() {
        baseFunc.click(CLICK);
    }

    public void book() {
        baseFunc.click(BOOK);
    }

}
