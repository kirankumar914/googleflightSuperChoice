package packages.pages;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import packages.driver.Driver;
import packages.utils.ReusableCommonMethods;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class HomePageObjectsRepository extends Driver {

    SoftAssertions softAssertions = new SoftAssertions();
    ReusableCommonMethods reusableCommonMethods = new ReusableCommonMethods();
    @FindBy(xpath = "//div[@class='Eo39gc']")
    WebElement flightsText;
    @FindBy(xpath = "//div[contains(@class,'TQYpgc gInvKb')]")
    WebElement typeOfTrip;

    @FindBy(xpath = "//input[@aria-label='Where from?']")
    WebElement originTextBox;

    @FindBy(xpath = "//input[@placeholder='Where to?']")
    WebElement destinationTextBox;

    @FindBy(xpath = "//input[@value='Sydney']")
    WebElement staticOriginText;

    @FindBy(xpath = "(//input[@placeholder='Departure'])[1]")
    WebElement departureField;
    @FindBy(xpath = "(//input[@placeholder='Return'])[1]")
    WebElement returnField;
    @FindBy(xpath = "//*[contains(text(),'Search')]//ancestor::button")
    WebElement searchButton;

    @FindBy(xpath = "//*[contains(@class,'FcFFRb')]")
    WebElement paxButton;

    @FindBy(xpath = "//*[contains(text(),'Add adult')]//preceding-sibling::button")
    WebElement adultAddButton;
    @FindBy(xpath = "//*[contains(text(),'Add child')]//preceding-sibling::button")
    WebElement childButton;
    @FindBy(xpath = "//*[contains(text(),'Add infant in seat')]//preceding-sibling::button")
    WebElement infantOnSeat;
    private static By typeOfTravelList = By.xpath(" //ul[@aria-label=\"Select your ticket type.\"]/li/span[4]");

    public HomePageObjectsRepository() {
        PageFactory.initElements(driver, this);
    }

    public void validateThePresenceOfFlightsTextOnTheHomePage() {
        softAssertions.assertThat("Flights").as("flights text is displayed on the screen")
                .isEqualTo(flightsText.getText());
        softAssertions.assertAll();
    }

    public void selectTypeOfTrip(String typeOfTripValue) {
        typeOfTrip.click();
        reusableCommonMethods.selectAValueFromDropDown(typeOfTravelList, typeOfTripValue);
    }

    public void provideTheOriginDestination(String origin, String destination) throws InterruptedException {
        staticOriginText.clear();
        reusableCommonMethods.waitUntilElementIsVisible(originTextBox);
        originTextBox.sendKeys(origin);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul/li[@role='option']//*[contains(text(),'" + origin + "')]")).click();
        reusableCommonMethods.pressEscape();
        reusableCommonMethods.waitUntilElementIsVisible(destinationTextBox);
        destinationTextBox.sendKeys(destination);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul/li[@role='option']//*[contains(text(),'" + destination + "')]")).click();
        reusableCommonMethods.pressEscape();
    }

    public void provideDepartureDate(String departureDate) throws InterruptedException {
        Thread.sleep(2000);
        departureField.sendKeys(departureDate);
        reusableCommonMethods.pressTab();
    }

    public void provideReturnDate(String returnDate) throws InterruptedException {
        if (!returnDate.isEmpty()) {
            Thread.sleep(2000);
            returnField.sendKeys(returnDate);
            reusableCommonMethods.pressTab();
        }
    }

    public void numberOfPax(String paxDetails) throws InterruptedException {
        List<String> typeOfPax = Arrays.stream(paxDetails.split(",")).toList();
        String adultsCount = typeOfPax.get(0);
        int childrenCount = Integer.parseInt(typeOfPax.get(1));
        int infantOnSeatCount = Integer.parseInt(typeOfPax.get(2));
        reusableCommonMethods.waitUntilElementIsVisible(paxButton);
        paxButton.click();
        reusableCommonMethods.waitUntilElementIsVisible(adultAddButton);
        for (int i = 1; i <= Integer.parseInt(adultsCount); i++) {
            adultAddButton.click();
        }

        for (int i = 1; i <= childrenCount; i++) {
            childButton.click();
        }

        for (int i = 1; i <= infantOnSeatCount; i++) {
            infantOnSeat.click();
        }
        reusableCommonMethods.pressEscape();
    }

    public void clickOnSearchButton() throws InterruptedException {
        Thread.sleep(1000);
        reusableCommonMethods.clickOnMidOfElement(searchButton);
    }

}
