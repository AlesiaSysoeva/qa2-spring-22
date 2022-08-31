package stepdefs;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.weather.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

import java.util.Map;

public class WeatherStepDefs {
    private long cityId;
    private WeatherResponse response;


    @Given("city id: {long}")
    public void set_city_id(long cityId) {
        this.cityId = cityId;

    }

    @When("we are requesting weather data")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(cityId);

    }

    @Then("coords are:")
    public void check_coords(Map<String, Double> params) {
        Assertions.assertEquals(params.get("lon"), response.getCoord().getLon(), "Wrong Lon!");
        Assertions.assertEquals(params.get("lat"), response.getCoord().getLat(), "Wrong Lat!");
    }

    @Then("weather is:")
    public void check_weather(Map<String, String> params) {
        long id = Long.parseLong(params.get("id"));
        Assertions.assertEquals(id, response.getWeathers().get(0).getId(), "Wrong Weather Id!");
        Assertions.assertEquals(params.get("main"), response.getWeathers().get(0).getMain(), "Wrong Main!");
        Assertions.assertEquals(params.get("description"), response.getWeathers().get(0).getDescription(), "Wrong Description!");
        Assertions.assertEquals(params.get("icon"), response.getWeathers().get(0).getIcon(), "Wrong Icon!");
    }

    @Then("base is {string}")
    public void check_base(String base) {
        Assertions.assertEquals(base, response.getBase(), "Wrong Base!");
    }

    @Then("main is:")
    public void check_main(Map<String, String> params) {
        Double temp = Double.parseDouble(params.get("temp"));
        Integer pressure = Integer.parseInt(params.get("pressure"));
        Integer humidity = Integer.parseInt(params.get("humidity"));
        Double temp_min = Double.parseDouble(params.get("temp_min"));
        Double temp_max = Double.parseDouble(params.get("temp_max"));
        Assertions.assertEquals(temp, response.getMain().getTemp(), "Wrong Temp!");
        Assertions.assertEquals(pressure, response.getMain().getPressure(), "Wrong Pressure!");
        Assertions.assertEquals(humidity, response.getMain().getHumidity(), "Wrong Humidity!");
        Assertions.assertEquals(temp_min, response.getMain().getTemp_min(), "Wrong Temp_min!");
        Assertions.assertEquals(temp_max, response.getMain().getTemp_max(), "Wrong Temp_max!");
    }

    @Then("visibility is {int}")
    public void check_visibility(Integer visibility) {
        Assertions.assertEquals(visibility, response.getVisibility(), "Wrong Visibility!");
    }

    @Then("wind is:")
    public void check_wind(Map<String, String> params) {
        Double speed = Double.parseDouble(params.get("speed"));
        Integer deg = Integer.parseInt(params.get("deg"));
        Assertions.assertEquals(speed, response.getWind().getSpeed(), "Wrong Speed!");
        Assertions.assertEquals(deg, response.getWind().getDeg(), "Wrong Deg!");
    }

    @Then("clouds is:")
    public void check_clouds(Map<String, Integer> params) {
        Assertions.assertEquals(params.get("all"), response.getClouds().getAll(), "Wrong All!");
    }

    @Then("dt is {int}")
    public void check_dt(Integer dt) {
        Assertions.assertEquals(dt, response.getDt(), "Wrong Dt!");
    }

    @Then("sys is:")
    public void check_sys(Map<String, String> params) {
        Integer type = Integer.parseInt(params.get("type"));
        Long id = Long.parseLong(params.get("id"));
        Double message = Double.parseDouble(params.get("message"));
        Long sunrise = Long.parseLong(params.get("sunrise"));
        Long sunset = Long.parseLong(params.get("sunset"));
        Assertions.assertEquals(type, response.getSys().getType(), "Wrong Type!");
        Assertions.assertEquals(id, response.getSys().getId(), "Wrong  Sys Id!");
        Assertions.assertEquals(message, response.getSys().getMessage(), "Wrong Message!");
        Assertions.assertEquals(params.get("country"), response.getSys().getCountry(), "Wrong Country!");
        Assertions.assertEquals(sunrise, response.getSys().getSunrise(), "Wrong Sunrise!");
        Assertions.assertEquals(sunset, response.getSys().getSunset(), "Wrong Sunset!");
    }

    @Then("id is {long}")
    public void check_id(Long id) {
        Assertions.assertEquals(id, response.getId(), "Wrong Id!");

    }

    @Then("name is {string}")
    public void check_name(String name) {
        Assertions.assertEquals(name, response.getName(), "Wrong Name!");
    }

    @Then("cod is {int}")
    public void check_cod(Integer cod) {
        Assertions.assertEquals(cod, response.getCod(), "Wrong Cod!");
    }
}
