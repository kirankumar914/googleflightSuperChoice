package packages.stepDefinations;

import io.cucumber.java.en.Then;
import packages.pages.SearchResultObjectRepository;

public class SearchResultPage {
    SearchResultObjectRepository searchResultPage = new SearchResultObjectRepository();

    @Then("validate the user is landed on search result page")
    public void validateTheUserIsLandedOnSeacrhResultPage() {
        searchResultPage.isBestFlightsTextIsPresent();
        searchResultPage.isOtherFlightsTextIsPresent();
    }

    @Then("validate search result has shown up flights related to the entered destination and origin {string} {string} {string} {string}")
    @Then("validate search result has shown up flights related to the entered origin and destination {string} {string} {string} {string}")
    public void validateSearchResultHasShownUpFlightsRelatedToTheEnteredOriginAndDestination(String origin, String destination, String dateOfJourney, String typeOfJourney) {
        searchResultPage.getTextOfMultipleFlights(origin, destination, dateOfJourney, typeOfJourney);
    }

    @Then("validate the user is landed on departure search result page")
    public void validateTheUserIsLandedOnDepartureSearchResultPage() {
        searchResultPage.isBestDepartingFlightsTextIsPresent();
    }

}
