package com.nttdata.glue;
import com.nttdata.steps.OrdenStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
public class OrderStepDef {

    @Steps
    OrdenStep OrderStep;

    @Given("la url del API de Store")
    public void laUrlDelAPIDeStore() {
        
    }

    @When("creo una orden con petId {int}, quantity {int}, status {string}")
    public void crearOrden(int petId, int quantity, String status) {
        OrderStep.crearOrden(petId, quantity, status);
    }

    @Then("el código de respuesta es {int}")
    public void validarCodigoRespuesta(int statusCode) {
        OrderStep.validarCodigoRespuesta(statusCode);
    }

    @And("el status de la orden es {string}")
    public void validarStatusOrden(String status) {
        OrderStep.validarStatusOrden(status);
    }

    @When("consulto la orden con orderId {int}")
    public void consultarOrden(int orderId) {
        OrderStep.consultarOrden(orderId);
    }

    @And("el petId es {int}")
    public void validarPetId(int petId) {
        OrderStep.validarPetId(petId);
    }

    @And("la cantidad es {int}")
    public void validarQuantity(int quantity) {
        OrderStep.validarQuantity(quantity);
    }

    @And("el status es {string}")
    public void validarStatus(String status) {
        OrderStep.validarStatus(status);
    }
}
