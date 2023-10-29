package packages.stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import packages.driver.Driver;
import packages.pages.HomePage;
import packages.pages.RegisterPage;

public class Register extends Driver {

    HomePage homePage=new HomePage();
    RegisterPage registerPage=new RegisterPage();

    @Given("user is new and wants to register")
    public void UserIsNewAndWantsToRegister()
    {
        homePage.moveToRegistrationPage();
    }

    @When("user provides {string} {string} {string} {string} {string} {string} {string}")
    public void userProvides(String title, String firstName, String surName, String phoneNumber, String DateOfBirth, String licensePeriod, String Occupation) {
        registerPage.provideTitleNamePhoneNumber(title,firstName,surName,phoneNumber,DateOfBirth,licensePeriod,Occupation);
    }

    @And("provides {string} and {string} for communication")
    public void providesAndForCommunication(String userAddress, String userEmailAddress) {
        registerPage.provideUserAddressDetails(userAddress,userEmailAddress);
    }

    @And("user set the password")
    public void userSetThePassword() {
        registerPage.providePassword();
    }

    @And("submits the registration form")
    public void submitsTheRegistrationForm() {
        registerPage.clickOnCreateButton();
    }

    @Then("validate upon successful registration user lands on login page")
    public void validateUponSuccessfulRegistrationUserLandsOnLoginPage() {
    }
}
