package packages.pages;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import packages.driver.Driver;
import packages.utils.ReusableCommonMethods;

import java.util.Arrays;
import java.util.List;

public class RegisterPage extends Driver {

    SoftAssertions softAssertions=new SoftAssertions();
    @FindBy(id = "user_title")
    WebElement title;
    @FindBy(id="user_firstname")
    WebElement firstNameTextBox;
    @FindBy(id="user_surname")
    WebElement surNameTextBox;
    @FindBy(id="user_phone")
    WebElement userPhoneTextBox;
    @FindBy(name="year")
    WebElement dateOfBirthYearDropdown;
    @FindBy(name="month")
    WebElement dateOfBirthMonthDropdown;
    @FindBy(name="date")
    WebElement dateOfBirthDateDropdown;
    @FindBy(id = "user_licenceperiod")
    WebElement licencePeriodDropdown;
    @FindBy(name = "occupation")
    WebElement occupationNameDropdown;
    @FindBy(id="user_address_attributes_street")
    WebElement streetTextBox;
    @FindBy(id="user_address_attributes_city")
    WebElement cityTextBox;
    @FindBy(id="user_address_attributes_county")
    WebElement countryTextBox;
    @FindBy(id="user_address_attributes_postcode")
    WebElement postCodeTextBox;
    @FindBy(id = "user_user_detail_attributes_email")
    WebElement emailAddressTextBox;
    @FindBy(id = "user_user_detail_attributes_password")
    WebElement passwordTextBox;
    @FindBy(id = "user_user_detail_attributes_password_confirmation")
    WebElement passwordConfirmationTextBox;
    @FindBy(name = "submit")
    WebElement submitButton;

    public RegisterPage()
    {
        PageFactory.initElements(driver,this);
    }
    ReusableCommonMethods reusableCommonMethods=new ReusableCommonMethods();
    public void selectATitle(String titleToBeSelected)
    {
        reusableCommonMethods.selectAValueFromDropDown(title,titleToBeSelected);
    }
    public void provideFirstName(String firstName)
    {
        firstNameTextBox.sendKeys(firstName);
    }
    public void provideSurName(String surName){
        surNameTextBox.sendKeys(surName);
    }

    public void providePhoneNumber(String phoneNumber)
    {
        userPhoneTextBox.sendKeys(phoneNumber);
    }

    public void provideTheDateOfBirth(String DateOfBirth)
    {
        String[] strings=DateOfBirth.split(",");
        String year=Arrays.stream(strings).toList().get(0);
        String month=Arrays.stream(strings).toList().get(1);
        String date=Arrays.stream(strings).toList().get(2);
        reusableCommonMethods.selectAValueFromDropDown(dateOfBirthYearDropdown,year);
        reusableCommonMethods.selectAValueFromDropDown(dateOfBirthMonthDropdown,month);
        reusableCommonMethods.selectAValueFromDropDown(dateOfBirthDateDropdown,date);

    }

    public void provideLicencePeriod(String licencePeriod)
    {
        reusableCommonMethods.selectAValueFromDropDown(licencePeriodDropdown,licencePeriod);
    }

    public void provideOccupationDetails(String occupationName)
    {
        reusableCommonMethods.selectAValueByTextFromDropDown(occupationNameDropdown,occupationName);
    }

    public void provideUserAddressDetails(String address,String emailAddress)
    {
        List<String> strings= Arrays.stream(address.split(",")).toList();
        String streetName=strings.get(0);
        String cityName=strings.get(1);
        String countryName=strings.get(2);
        String postCode=strings.get(3);

        streetTextBox.sendKeys(streetName);
        cityTextBox.sendKeys(cityName);
        countryTextBox.sendKeys(countryName);
        postCodeTextBox.sendKeys(postCode);
        emailAddressTextBox.sendKeys(emailAddress);
    }

    public void provideTitleNamePhoneNumber(String titleToBeSelected,String firstName,String lastName,String phoneNumber,String dateOfBirth,String licencePeriod,String occupationName){
        title.click();
        selectATitle(titleToBeSelected);
        provideFirstName(firstName);
        provideSurName(lastName);
        providePhoneNumber(phoneNumber);
        provideTheDateOfBirth(dateOfBirth);
        provideLicencePeriod(licencePeriod);
        provideOccupationDetails(occupationName);
    }

    public void providePassword()
    {
        String password=reusableCommonMethods.getThePassword(8);
        passwordTextBox.sendKeys(password);
        passwordConfirmationTextBox.sendKeys(password);

    }

    public void clickOnCreateButton()
    {
        submitButton.click();
    }

    public void validateUserLandedOnLoginPage()
    {
        softAssertions.assertThat(driver.getCurrentUrl())
                .as("validate user landed on login page after registration process")
                .isEqualTo("https://demo.guru99.com/insurance/v1/index.php");
    }

}
