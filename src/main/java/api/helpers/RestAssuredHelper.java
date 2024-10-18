package api.helpers;

import api.endpoints.MegogoEndpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static org.apache.http.HttpStatus.SC_OK;

public class RestAssuredHelper {

    public static <RESPONSE> RESPONSE initGetRequest(MegogoEndpoints url, Class<RESPONSE> responseClass) {
        return getRequestSpecification()
                .get(url.getValue())
                .then()
                .statusCode(SC_OK)
                .extract()
                .as(responseClass);
    }

    public static <RESPONSE> RESPONSE initGetRequestWithQueryParams(MegogoEndpoints url, Class<RESPONSE> responseClass, String queryParam, Object... paramsArgs) {
        return getRequestSpecification()
                .queryParam(queryParam, paramsArgs)
                .get(url.getValue())
                .then()
                .statusCode(SC_OK)
                .extract()
                .as(responseClass);
    }

    private static RequestSpecification getRequestSpecification() {
        return RestAssured.given()
                .urlEncodingEnabled(false)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log()
                .ifValidationFails();
    }
}
