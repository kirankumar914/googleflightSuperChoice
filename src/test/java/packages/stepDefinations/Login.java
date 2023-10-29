package packages.stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import packages.pages.LoginPage;

public class Login {

    LoginPage loginPage=new LoginPage();

    @Given("user is on the login page")
    public void userIsOnTheLoginPage()
    {
            loginPage.isLoginFormDisplayed();
    }


    @Then("validate the error message on the screen")
    public void validateTheErrorMessageOnTheScreen() {
        loginPage.validateTheLoginErrorMessage();
    }

    @When("user provides invalid {string} and {string}")
    public void userProvidesInvalidAnd(String loginID, String loginPassword) {
        loginPage.userLogin(loginID,loginPassword);
    }

    @When("user provides valid {string} and {string}")
    public void userProvidesValidAnd(String loginID, String loginPassword) {
        loginPage.userLogin(loginID,loginPassword);
    }

    @Then("validate user is successfully able to signIn")
    public void validateUserIsSuccessfullyAbleToSignin() {
    }

    @When("user provides valid login details")
    public void userProvidesValidLoginDetails() {
        loginPage.userLogin("","");
    }
}
