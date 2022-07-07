package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public abstract class BaseSetup {
    /******* ENV VARIABLES ***********/
    public static String workingHost = "https://reqres.in";

    protected RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

    public static class ApiPath {
        public static String REQRES_IN_REST_SERVICE_PATH = "/api/users";
    }

    public Response sendRequestAndGetResponseNew (Method method) {
        Response response = given().spec(requestSpecBuilder.build())
                .log().uri()
                .log().ifValidationFails()
                //.log().parameters()
                .log().body()
                .when().request(method);
        response.then()
                .log().status()
                .log().ifError()
             //   .log().ifValidationFails();
        .log().body();
        return response;
    }
}
