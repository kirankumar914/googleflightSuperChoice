package packages.pages;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import packages.driver.Driver;
import packages.utils.ReusableCommonMethods;

import java.util.Arrays;

public class RequestQuotePage extends Driver {
    public static String identificationNumberValue=null;
    ReusableCommonMethods reusableCommonMethods=new ReusableCommonMethods();
    SoftAssertions softAssertions=new SoftAssertions();
    @FindBy(id="quotation_incidents")
    WebElement incidentsTextBox;
    @FindBy(id = "quotation_vehicle_attributes_registration")
    WebElement registrationTextBox;
    @FindBy(id="quotation_vehicle_attributes_mileage")
    WebElement annualMileageTextBox;
    @FindBy(id="quotation_vehicle_attributes_value")
    WebElement estimatedValueTextBox;
    @FindBy(id="quotation_vehicle_attributes_parkinglocation")
    WebElement parkingLocationTextBox;
    @FindBy(name="year")
    WebElement yearDropdown;
    @FindBy(name="month")
    WebElement monthDropdown;
    @FindBy(name="date")
    WebElement dateDropdown;
    @FindBy(xpath = "//*[@value='Calculate Premium']")
    WebElement calculatePremium;
    @FindBy(xpath = "//a[contains(text(),'Request Quotation')]")
    WebElement requestQuotationLink;
    @FindBy(id = "calculatedpremium")
    WebElement calculatedPremium;
    @FindBy(xpath = "//*[@value='Save Quotation']")
    WebElement saveQuoteButton;
    @FindBy(xpath = "//*[contains(text(),'You have saved this quotation!')]")
    WebElement savedTheQuoteTextMessage;
    @FindBy(xpath = "//*[contains(text(),'Your identification number is :')]")
    WebElement identificationNumber;
    @FindBy(xpath = "//*[@value='Log out']")
    WebElement logoutButton;

    public RequestQuotePage(){
        PageFactory.initElements(driver,this);
    }

    public void fillTheQuotationForm(String incidents,String registration,String annualMileage,String estimatedValue,String parkingLocation,String policyDate)
    {
        incidentsTextBox.sendKeys(incidents);
        registrationTextBox.sendKeys(registration);
        annualMileageTextBox.sendKeys(annualMileage);
        estimatedValueTextBox.sendKeys(estimatedValue);
        parkingLocationTextBox.sendKeys(parkingLocation);
        String[] strings=policyDate.split(",");
        String year= Arrays.stream(strings).toList().get(0);
        String month=Arrays.stream(strings).toList().get(1);
        String date=Arrays.stream(strings).toList().get(2);
        reusableCommonMethods.selectAValueFromDropDown(yearDropdown,year);
        reusableCommonMethods.selectAValueFromDropDown(monthDropdown,month);
        reusableCommonMethods.selectAValueFromDropDown(dateDropdown,date);
        calculatePremium.click();
    }

    public void clickOnRequestQuotationLink()
    {
        requestQuotationLink.click();
        reusableCommonMethods.implicitWait(3);
    }

    public void validateApplicationGeneratedPremium()
    {
        softAssertions.assertThat(reusableCommonMethods.isWebElementIsDisplayed(calculatedPremium)).as("validate that the premium is calculated")
                .isEqualTo(true);
        softAssertions.assertAll();
    }

    public void clickOnSaveQuoteButton()
    {
        saveQuoteButton.click();
        reusableCommonMethods.implicitWait(3);
        reusableCommonMethods.isWebElementIsDisplayed(savedTheQuoteTextMessage);
    }

    public void validateTheIdentificationNumberIsGenerated()
    {
        reusableCommonMethods.isWebElementIsDisplayed(identificationNumber);
        identificationNumberValue=identificationNumber.getText();
        System.out.println(identificationNumberValue);
    }

    public void userLogout()
    {
        logoutButton.click();
    }
}
