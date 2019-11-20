package playgroundApiTest.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.json.simple.JSONObject;
import playgroundApiTest.steps.PlaygroundApiSteps;

public class get {
    JSONObject productDetails;

    @Steps
    PlaygroundApiSteps playgroundApiSteps;

    @Given("the user provides existing product name")
    public void theUserProvidesExistingProductName() {
        playgroundApiSteps.buildUrl(false);
    }

    @When("the user make a GET request")
    public void theUserMakeAGETRequest() {
        playgroundApiSteps.getProductDetails();
    }

    @Then("the correct product appears")
    public void theProductAppears() {
        playgroundApiSteps.validateExistingProduct();
    }


}
