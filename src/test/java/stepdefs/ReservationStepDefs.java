package stepdefs;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.reservation.Reservation;
import org.openqa.selenium.WebElement;
import pageobject.pages.*;
import requesters.ReservationsRequester;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class ReservationStepDefs {
    private Reservation reservation;
    private BaseFunc baseFunc = new BaseFunc();
    private TicketsHomePage homePage;
    private UserInfoPage infoPage;
    private SeatsPage seatsPage;
    private List<Reservation> response;
    private Reservation reservationFromApi;
    private FinalPage finalPage;

    private final String HOME_PAGE_URL = "http://qaguru.lv:8089/tickets";

    @Given("random client with:")
    public void create_client(Map<String, String> params) {
        reservation = new Reservation("random", "random", params.get("discount"), params.get("flight_date"),
                params.get("airport_from"), params.get("airport_to"), Integer.parseInt(params.get("seat_number")),
                2, 3, 2);
    }

    @Given("home page is opened")
    public void open_home_page() {
        baseFunc.openUrl(HOME_PAGE_URL);
        homePage = new TicketsHomePage(baseFunc);
    }

    @When("we are selecting airports")
    public void select_airports() {
        homePage.selectAirports(reservation);
        infoPage = homePage.pressGoBtn();
    }

    @Then("selected airports appears on client info page")
    public void check_airports() {
        List<WebElement> airports = infoPage.getSelectedAirports();
        assertEquals(reservation.getDepartureAirport(), airports.get(0).getText(), "Incorrect dep airport");
        assertEquals(reservation.getArrivalAirport(), airports.get(1).getText(), "Incorrect dep airport");
    }

    @When("we are filling in passenger info form")
    public void fill_passenger_info_form() {
        infoPage.fillInInfoForm(reservation);
    }

    @When("we are clicking on Get Price ling")
    public void click_on_get_price() {
        infoPage.clickOnGetPrice();
    }

    @Then("passenger name appears")
    public void check_passenger_name() {
       assertTrue(infoPage.ifPassengerNamePresents(reservation.getFirstName()), "Incorrect name");
    }

    @Then("price is {int} EUR")
    public void check_price(int price) {
        assertEquals(price, infoPage.getPrice(), "Wrong price!");
    }

    @When("we are pressing Book button")
    public void click_on_book_btn() {
        seatsPage = infoPage.click_On_Book_Btn();
    }

    @When("selecting seat number")
    public void select_seat_number() {
        seatsPage.seatSelection(reservation.getSeatNumber());
    }

    @Then("selected seat number appears")
    public void check_seat_number() {
        assertEquals(reservation.getSeatNumber(), seatsPage.getSelectedSeatNr(), "Wrong seat seleced number!" );
    }

    @When("we are placing the order")
    public void place_the_order() {
        finalPage = seatsPage.pressBookBtn();
    }

    @Then("successful booking page appears")
    public void check_if_success() {
        assertTrue(finalPage.isReservationSuccessful(), "Reservation isn't successful!");
    }

    @When("we requesting all reservations via API")
    public void request_reservations() throws JsonProcessingException {
        ReservationsRequester requester = new ReservationsRequester();
        response = requester.requestReservations();
    }

    @When("we found created reservation")
    public void  find_reservation() {
        for (Reservation r : response) {
            if (r.getFirstName().equals(reservation.getFirstName())) {
                reservationFromApi = r;
                break;
            }
        }

        assertNotNull(reservationFromApi, "Can't find created reservation!");
    }

    @Then("all data stored correctly")
    public void check_reservation_date() {
        assertEquals(reservation.getLastName(), reservationFromApi.getLastName(), "Wrong Last Name!");
        assertEquals(reservation.getDiscount(), reservationFromApi.getDiscount(), "Wrong Discount!");
        assertEquals(reservation.getFlightDate().split("-")[0], reservationFromApi.getFlightDate(), "Wrong Flight Date!");
        assertEquals(reservation.getAdultsCount(), reservationFromApi.getAdultsCount(), "Wrong Adult Count!");
        assertEquals(reservation.getChildCount(), reservationFromApi.getChildCount(), "Wrong Child Count!");
        assertEquals(reservation.getBagsCount(), reservationFromApi.getBagsCount(), "Wrong Bags Count!");
        assertEquals(reservation.getSeatNumber(), reservationFromApi.getSeatNumber(), "Wrong Seat Number!");
        assertEquals(reservation.getDepartureAirport(), reservationFromApi.getDepartureAirport(), "Wrong Departure Airport!");
        assertEquals(reservation.getArrivalAirport(), reservationFromApi.getArrivalAirport(), "Arrival Airport!");
    }
}
