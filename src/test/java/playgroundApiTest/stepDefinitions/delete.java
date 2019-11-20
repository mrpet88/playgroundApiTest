package playgroundApiTest.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.json.simple.JSONObject;
import playgroundApiTest.steps.PlaygroundApiSteps;

public class delete {
    JSONObject productDetails;
    int status;

    @Steps
    PlaygroundApiSteps playgroundApiSteps;

    @Given("the user provides id of the product")
    public void theUserProvidesIdOfTheProduct() {
        playgroundApiSteps.buildUrl(false);
    }

    @When("the user submits remove request")
    public void theUserSubmitsRemoveRequest() {
        playgroundApiSteps.deleteProduct();
    }

    @Then("product should be removed from successfully")
    public void productShouldBeRemovedFromSuccessfully() {
        playgroundApiSteps.validateResponseStatus(200);
    }
}
