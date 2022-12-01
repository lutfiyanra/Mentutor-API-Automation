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
        File json = new File(MentutorAPI.JSON_REQ_BODY+"/PostLoginMentee.json.json");
        mentutorAPI.postLoginUser(json);
    }
}
