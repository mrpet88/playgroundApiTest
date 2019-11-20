package playgroundApiTest.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.json.simple.JSONObject;
import playgroundApiTest.steps.PlaygroundApiSteps;

public class update {
    JSONObject productDetails;
    int status;

    @Steps
    PlaygroundApiSteps playgroundApiSteps;

    @Given("the user provides details")
    public void theUserProvidesDetails() {
        playgroundApiSteps.buildUrl(false);
    }

    @When("the user submits update request")
    public void theUserSubmitsUpdateRequest() {
        playgroundApiSteps.setPatchBody();
    }


    @Then("product details updated successfully")
    public void productDetailsUpdatedSuccessfully() {
        playgroundApiSteps.validateResponseStatus(200);
    }
}
