package requesters;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import model.weather.WeatherResponse;
import org.springframework.web.client.RestTemplate;

public class WeatherRequester {
    private final String PREFIX = "https://samples.openweathermap.org/data/2.5/weather?id=";
    private final String POSTFIX = "&appid=b1b15e88fa797225412429c1c50c122a1";

    public WeatherResponse requestWeather(long cityId) throws JsonProcessingException {
        String url = PREFIX + cityId + POSTFIX;

        RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForEntity(url, String.class).getBody();

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, WeatherResponse.class);
    }
}
