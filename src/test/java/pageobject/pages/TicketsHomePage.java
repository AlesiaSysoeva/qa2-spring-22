package pageobject.pages;

import model.reservation.Reservation;
import org.openqa.selenium.By;

public class TicketsHomePage {
    private final By FROM = By.id("afrom");
    private final By TO = By.id("bfrom");
    private final By GO_BTN = By.xpath(".//span[@class = 'gogogo']");

    private BaseFunc baseFunc;


    public TicketsHomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void selectAirports(Reservation reservation) {
        baseFunc.selectDima(FROM, reservation.getDepartureAirport());
        baseFunc.selectDima(TO, reservation.getArrivalAirport());
    }

    public UserInfoPage pressGoBtn() {
        baseFunc.click(GO_BTN);
        return new UserInfoPage(baseFunc);
    }
}
