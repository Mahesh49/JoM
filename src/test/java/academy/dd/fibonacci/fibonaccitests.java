package academy.dd.fibonacci;
import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.*;

public class fibonaccitests {

    @BeforeClass
    public static void setup() {

        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(7003);
        }
        else{
            RestAssured.port = Integer.valueOf(port);
        }

        String basePath = System.getProperty("server.base");
        if(basePath==null){
            basePath = "/fib/";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;

    }

    @Test
    public void fibobacci_uri_returns_200() {
        given().when().get("/").then()
                .statusCode(200)
                .assertThat()
                .body(equalTo("[\"0\",\"1\",\"1\",\"2\",\"3\",\"5\",\"8\",\"13\",\"21\",\"34\"]"));
    }

    @Test
    public void fibobacci_index_returns_200() {
        given().when().get("/10").then()
                .statusCode(200)
                .assertThat()
                .body(equalTo("55"));
    }

    @Test
    public void fibobacci_index1_returns_200() {
        given().when().get("/1").then()
                .statusCode(200)
                .assertThat()
                .body(equalTo("1"));
    }

    @Test
    public void fibobacci_index2_returns_200() {
        given().when().get("/1").then()
                .statusCode(200)
                .assertThat()
                .body(equalTo("1"));

    }

    @Test
    public void fibobacci_index3_returns_200() {
        given().when().get("/3").then()
                .statusCode(200)
                .assertThat()
                .body(equalTo("2"));

    }

    @Test
    public void fibobacci_index30_returns_200() {
        given().when().get("/30").then()
                .statusCode(200)
                .assertThat()
                .body(equalTo("832040"));
    }

    @Test
    public void fibobacci_range_returns_200() {
        given().when().get("/range?startIndex=5&finishIndex=10").then()
                .statusCode(200)
                .assertThat()
                .body(equalTo("[\"5\",\"8\",\"13\",\"21\",\"34\"]"));
    }

    @Test
    public void fibobacci_range5to5_returns_200() {
//        List<String> range = new ArrayList<String>();
//        Collections.addAll(range,"\"5\",\"-3\",\"2\",\"-1\",\"1\",\"0\",\"1\",\"1\",\"2\",\"3\"");
        given().when().get("/range?startIndex=-5&finishIndex=5").then()
                .statusCode(200)
                .assertThat()
                .body(equalTo("[\"5\",\"-3\",\"2\",\"-1\",\"1\",\"0\",\"1\",\"1\",\"2\",\"3\"]"));
    }
}
