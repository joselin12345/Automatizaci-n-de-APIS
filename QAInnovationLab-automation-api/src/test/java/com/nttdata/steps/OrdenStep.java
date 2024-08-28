package com.nttdata.steps;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class OrdenStep {

    private static final String BASE_URL = "https://petstore.swagger.io/v2/store/order";
    private Response response;

    @Step("Crear una orden con petId {0}, quantity {1}, status {2}")
    public void crearOrden(int petId, int quantity, String status) {
        response = SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": " + petId + ",\n" +
                        "  \"petId\": " + petId + ",\n" +
                        "  \"quantity\": " + quantity + ",\n" +
                        "  \"shipDate\": \"" + "2024-08-28T18:06:59.265Z" + "\",\n" +
                        "  \"status\": \"" + status + "\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .log().all()
                .post(BASE_URL)
                .then()
                .log().all()
                .extract()
                .response();
    }

    @Step("Validar el código de respuesta es {0}")
    public void validarCodigoRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    @Step("Validar el status de la orden es {0}")
    public void validarStatusOrden(String status) {
        restAssuredThat(response -> response.body("status", equalTo(status)));
    }

    @Step("Consultar orden con orderId {0}")
    public void consultarOrden(int orderId) {
        response = SerenityRest.given()
                .relaxedHTTPSValidation()
                .get(BASE_URL + "/" + orderId)
                .then()
                .log().all()
                .extract()
                .response();
    }

    @Step("Validar el petId es {0}")
    public void validarPetId(int petId) {
        restAssuredThat(response -> response.body("petId", equalTo(petId)));
    }

    @Step("Validar la cantidad es {0}")
    public void validarQuantity(int quantity) {
        restAssuredThat(response -> response.body("quantity", equalTo(quantity)));
    }

    @Step("Validar el status es {0}")
    public void validarStatus(String status) {
        restAssuredThat(response -> response.body("status", equalTo(status)));
    }
}
