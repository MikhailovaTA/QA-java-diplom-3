package config;

import static io.restassured.RestAssured.given;

public class RegistrationMethods {
    private static final String DELETE_USER_METHOD = "/api/auth/user";
    private static final String LOGIN_USER_METHOD = "/api/auth/login";

    public static String authorizationUser(DataUser dataUser) {
        ServerResponseAfterAuthorization responseServer = given()
            .header("Content-type", "application/json")
            .body(dataUser)
            .post(LOGIN_USER_METHOD)
            .body()
            .as(ServerResponseAfterAuthorization.class);
        return responseServer.getAccessToken();
    }

    public static void deleteUser(String accessToken, int expectedCode){
        given()
            .header("Content-type", "application/json")
            .auth().oauth2(accessToken.replace("Bearer ", ""))
            .delete(DELETE_USER_METHOD)
            .then()
            .assertThat()
            .statusCode(expectedCode);
    }
}
