package packages.pages;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import packages.driver.Driver;
import packages.utils.ReusableCommonMethods;

import java.util.Arrays;
import java.util.List;

public class SearchResultObjectRepository extends Driver {

    SoftAssertions softAssertions = new SoftAssertions();
    ReusableCommonMethods reusableCommonMethods = new ReusableCommonMethods();

    @FindBy(xpath = "(//*[contains(text(),'Best flights')])[1]")
    WebElement bestFlightsText;

    @FindBy(xpath = "(//*[contains(text(),'Best departing flights')])[1]")
    WebElement bestDepartingFlightsText;

    @FindBy(xpath = "(//*[contains(text(),'Other flights')])[1]")
    WebElement otherFlightsText;
    @FindBy(xpath = "(//*[@jsaction='bSWuu:O1htCb;EOHNLe:O1htCb'])[1]")
    WebElement firstFlight;
    private static By flightInformation = By.xpath("//*[@jsaction='click:O1htCb']");

    public SearchResultObjectRepository() {
        PageFactory.initElements(driver, this);
    }

    public void isBestFlightsTextIsPresent() {
        reusableCommonMethods.waitUntilElementIsVisible(bestFlightsText);
        softAssertions.assertThat(bestFlightsText.isDisplayed()).as("validate the best flights text is present")
                .isEqualTo(true);
        softAssertions.assertAll();
    }

    public void isOtherFlightsTextIsPresent() {
        softAssertions.assertThat(otherFlightsText.isDisplayed()).as("validate the other flights text is present")
                .isEqualTo(true);
        softAssertions.assertAll();
    }

    public void getTextOfMultipleFlights(String origin, String destination, String dateOfJourney, String typeOfJourney) {
        List<String> day = Arrays.stream(dateOfJourney.split(",")).toList();
        List<String> date = Arrays.stream(day.get(1).split(" ")).toList();
        List<WebElement> webelemnts = driver.findElements(flightInformation);
        for (int i = 0; i <= 2; i++) {
            softAssertions.assertThat(webelemnts.get(i).getAttribute("aria-label")).as("validate the origin details of the each flight")
                    .containsSubsequence("Leaves " + origin + " Airport");
            softAssertions.assertThat(webelemnts.get(i).getAttribute("aria-label")).as("validate the destination details of the each flight")
                    .containsSubsequence("arrives at " + destination + " Airport");
            softAssertions.assertThat(webelemnts.get(i).getAttribute("aria-label")).as("validate the date details of the each flight")
                    .containsAnyOf(day.get(0))
                    .containsAnyOf(date.get(0))
                    .containsAnyOf(date.get(1));
            softAssertions.assertAll();
        }
        if (typeOfJourney.equalsIgnoreCase("Round trip")) {
            firstFlight.click();
            reusableCommonMethods.implicitWait();
        }
    }

    public void isBestDepartingFlightsTextIsPresent() {
        reusableCommonMethods.waitUntilElementIsVisible(bestDepartingFlightsText);
        softAssertions.assertThat(bestDepartingFlightsText.isDisplayed()).as("validate the best departing flights text is present")
                .isEqualTo(true);
        softAssertions.assertAll();
    }
}
