package starter.Mentutor.AllStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Mentutor.MentutorAPI;

import java.io.File;

public class PostLoginStepDefs {
    @Steps
    MentutorAPI mentutorAPI;

    // Scenario 1
    @Given("Post login with all valid value as admin")
    public void postLoginWithAllValidValueAsAdmin(){
        File json = new File(MentutorAPI.JSON_REQ_BODY+"/PostLoginAdmin.json");
        mentutorAPI.postLoginUser(json);
    }

    @When("Send request post login")
    public void sendRequestPostLogin() {
        SerenityRest.when().post(MentutorAPI.LOGIN);
    }

    @Then("Should return {int} OK")
    public void shouldReturnOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Validate post login valid value json schema")
    public void validatePostLoginValidValueJsonSchema() {
        File json = new File(MentutorAPI.JSON_SCHEMA+"/PostLoginJsonSchema.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Scenario 2
    @Given("Post login with all valid value as mentor")
    public void postLoginWithAllValidValueAsMentor(){
        File json = new File(MentutorAPI.JSON_REQ_BODY+"/PostLoginMentor.json");
        mentutorAPI.postLoginUser(json);
    }

    @Given("Post login with all valid value as mentee")
    public void postLoginWithAllValidValueAsMentee() {
        File json = new File(MentutorAPI.JSON_REQ_BODY+"/PostLoginMentee.json");
        mentutorAPI.postLoginUser(json);
    }

    @Given("Post login as admin with invalid email")
    public void postLoginAsAdminWithInvalidEmail() {
        File json = new File(MentutorAPI.JSON_REQ_BODY+"/PostLoginAdminInvalidEmail.json");
        mentutorAPI.postLoginUser(json);
    }

    @Then("Should return respons body code {int} not found")
    public void shouldReturnResponsBodyCodeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    @And("Validate post login user not found json schema")
    public void validatePostLoginNotFoundJsonSchema() {
        File json = new File(MentutorAPI.JSON_SCHEMA+"/PostLoginNotFoundJsonSchema.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Post login as admin with invalid password")
    public void postLoginAsAdminWithInvalidPassword() {
        File json = new File(MentutorAPI.JSON_REQ_BODY+"/PostLoginAdminInvalidPassword.json");
        mentutorAPI.postLoginUser(json);
    }

    @And("Validate post login invalid input from client json schema")
    public void validatePostLoginInvalidInputFromClientJsonSchema() {
        File json = new File(MentutorAPI.JSON_SCHEMA+"/PostLoginInvalidInputFromClient.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Then("Should return respons body code {int} bad request")
    public void shouldReturnResponsBodyCodeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    @Given("Post login as admin with invalid all data")
    public void postLoginAsAdminWithInvalidAllData() {
        File json = new File(MentutorAPI.JSON_REQ_BODY+"/PostLoginInvalidAllData.json");
        mentutorAPI.postLoginUser(json);
    }

    @Given("Post login as admin with empty email")
    public void postLoginAsAdminWithEmptyEmail() {
        File json = new File(MentutorAPI.JSON_REQ_BODY+"/PostLoginEmptyEmail.json");
        mentutorAPI.postLoginUser(json);
    }

    @Given("Post login as admin with empty password")
    public void postLoginAsAdminWithEmptyPassword() {
        File json = new File(MentutorAPI.JSON_REQ_BODY+"/PostLoginEmptyPassword.json");
        mentutorAPI.postLoginUser(json);
    }

    @Given("Post login as admin with empty data")
    public void postLoginAsAdminWithEmptyData() {
        File json = new File(MentutorAPI.JSON_REQ_BODY+"/PostLoginEmptyData.json");
        mentutorAPI.postLoginUser(json);
    }
}
