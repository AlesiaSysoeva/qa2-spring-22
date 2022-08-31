package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.nl.Gegeven;

public class HelloWorldStepDefs {
    private int alexApplesCount;
    private int kateApplesCount;
    private int applesTotalCount;



    @Gegeven("Alex has {int} apples")
    public void set_apples_for_alex(int count) {
        alexApplesCount = count;
    }

    @Gegeven("Jekaterina has {int} apples")
    public void set_apples_for_kate(int count) {
        kateApplesCount = count;
    }

    @When("they are putting all apples together")
    public void puts_apples_together() {
        applesTotalCount = alexApplesCount + kateApplesCount;

    }

    @Then("they have {int} apples")
    public void check_apples_count(int count) {

    }
}
