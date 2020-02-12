import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.hasItem;


public class YoutilityTest {

    private String endPoint = "https://restcountries.eu/rest/v2/capital/london";

    @Test
    public void _01_verifyCapitalResponse() {

        Response r = RestAssured.get(endPoint);
        r.then().body("capital", hasItem("London"));
        r.then().statusCode(200);

        String capital = r.jsonPath().get("capital[0]").toString();
        System.out.println("CapitalCity : " + capital);
    }

    @Test
    public void _02_verifyBritishPoundResponse() {

        Response r = RestAssured.get(endPoint);
        String currency = r.jsonPath().get("currencies[0].name[0]").toString();

        if (currency.equals("British pound")) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}