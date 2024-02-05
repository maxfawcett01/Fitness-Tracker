package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HealthStatisticsStepDefinitions {
    @Given("the Health Statistics API is available")
    public void theHealthStatisticsAPIIsAvailable() {
    }

    @When("I make a GET request to the endpoint {string}")
    public void iMakeAGETRequestToTheEndpoint(String arg0) {
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int arg0) {
    }
}
