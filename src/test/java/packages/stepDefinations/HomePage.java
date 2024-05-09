package packages.stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import packages.pages.HomePageObjectsRepository;

@Slf4j
@Log
public class HomePage {

    HomePageObjectsRepository homepage = new HomePageObjectsRepository();

    @Given("user is on the home page")
    public void userIsOnTheHomePage() {
        homepage.validateThePresenceOfFlightsTextOnTheHomePage();
    }

    @When("the user provides {string} {string} {string} {string} {string} {string} {string}")
    public void theUserProvides(String typeOfTrip, String numberOfPassengers, String classOfJourney, String origin, String destination, String dateOfJourney, String dateOfReturn) throws InterruptedException {
        homepage.selectTypeOfTrip(typeOfTrip);
        homepage.numberOfPax(numberOfPassengers);
        homepage.provideTheOriginDestination(origin, destination);
        homepage.provideDepartureDate(dateOfJourney);
        homepage.provideReturnDate(dateOfReturn);
    }

    @And("clicks on explore button")
    public void clicksOnExploreButton() throws InterruptedException {
        homepage.clickOnSearchButton();
    }
}
