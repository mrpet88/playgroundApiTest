package playgroundApiTest.stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import playgroundApiTest.steps.PlaygroundApiSteps;

public class post {

    @Steps
    PlaygroundApiSteps playgroundApiSteps;

    @When("the user POST the product to the response body")
    public void userPostProductToResponseBody() {
        playgroundApiSteps.buildUrl(true);
        playgroundApiSteps.postProductDetails();
    }

    @Then("valid response with status {int} appears")
    public void validResponseWithStatusAppears(int givenStatus) {
        playgroundApiSteps.validateResponseStatus(givenStatus);
    }
}
