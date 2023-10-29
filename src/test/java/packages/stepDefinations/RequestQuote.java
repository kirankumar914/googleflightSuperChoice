package packages.stepDefinations;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import packages.driver.Driver;
import packages.pages.RequestQuotePage;

import java.util.List;
import java.util.Map;

public class RequestQuote extends Driver {

    RequestQuotePage requestQuotePage=new RequestQuotePage();
    @When("user provides the required details to calculate the premium")
    public void userProvidesTheRequiredDetailsToCalculateThePremium(DataTable quoteDetails)
    {
        List<Map<String,String>> data =quoteDetails.asMaps(String.class,String.class);
        String incidents=data.get(0).get("incidents");
        String registrationNumber=data.get(0).get("Registration");
        String annualMileage=data.get(0).get("Annual mileage");
        String estimatedValue=data.get(0).get("Estimated value");
        String parkingLocation=data.get(0).get("Parking Location");
        String startOfPolicy=data.get(0).get("Start of policy");
        requestQuotePage.fillTheQuotationForm(incidents,registrationNumber,annualMileage,estimatedValue,parkingLocation,startOfPolicy);
    }

    @Then("validate the application generated a premium")
    public void validateTheApplicationGeneratedAPremium() {
        requestQuotePage.validateApplicationGeneratedPremium();
    }

    @Given("user is on the request quotation page")
    public void userIsOnTheRequestQuotationPage() {
        requestQuotePage.clickOnRequestQuotationLink();
    }

    @When("user save quotation")
    public void userSaveQuotation() {
        requestQuotePage.clickOnSaveQuoteButton();
    }

    @Then("validate identification number is generated")
    public void validateIdentificationNumberIsGenerated() {
        requestQuotePage.validateTheIdentificationNumberIsGenerated();
    }

    @Then("logs out from the session")
    public void logsOutFromTheSession() {
        requestQuotePage.userLogout();
    }
}
