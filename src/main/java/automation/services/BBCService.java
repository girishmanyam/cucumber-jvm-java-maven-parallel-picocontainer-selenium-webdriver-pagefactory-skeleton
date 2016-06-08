package automation.services;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.given;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BBCService {
    private final Logger log = LoggerFactory.getLogger(BBCService.class);
    private final String url;

    public BBCService(String baseUrl) {
        this.url = baseUrl + "/programmes/b008ncn6.json";
    }

    public String getTitle() {
        return getProgramme().get("title").getAsString();
    }

    public String getShortSynopsis() {
        return getProgramme().get("short_synopsis").getAsString();
    }

    private JsonObject getProgramme()  {
        return jsonRequest().get("programme").getAsJsonObject();
    }

    private JsonObject jsonRequest() {
        log.info("Request url is:" + url);
        Response response = given().header("Accept", "application/json").when().get(url);
        log.info("Response code is:" + Integer.toString(response.statusCode()));
        JsonParser parser = new JsonParser();
        return parser.parse(response.getBody().asString()).getAsJsonObject();
    }
}
