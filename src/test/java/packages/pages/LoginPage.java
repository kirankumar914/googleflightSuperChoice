package packages.pages;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import packages.driver.Driver;
import packages.utils.ReusableCommonMethods;

public class LoginPage extends Driver {

    SoftAssertions softAssertions=new SoftAssertions();
    ReusableCommonMethods reusableCommonMethods=new ReusableCommonMethods();
    @FindBy(id="login-form")
    WebElement loginForm;
    @FindBy(id = "email")
    WebElement emailIdTextBox;
    @FindBy(id="password")
    WebElement passwordTextBox;
    @FindBy(xpath = "//*[@value='Log in']")
    WebElement loginButton;
    @FindBy(xpath = "//*[contains(text(),'Enter your Email address and password correct')]")
    WebElement loginErrorMessageText;
    @FindBy(xpath = "//*[@value='Log out']")
    WebElement logoutButton;
    public LoginPage()
    {
        PageFactory.initElements(driver,this);
    }

    public void isLoginFormDisplayed(){
        softAssertions.assertThat(reusableCommonMethods.isWebElementIsDisplayed(loginForm)).as("validate the presence of login form on the page")
                .isEqualTo(true);
        softAssertions.assertAll();
    }

    public void userLogin(String loginUserName,String loginUserPassword)
    {
        emailIdTextBox.sendKeys(loginUserName);
        passwordTextBox.sendKeys(loginUserPassword);
        loginButton.click();
    }

    public void validateTheLoginErrorMessage()
    {
        softAssertions.assertThat(reusableCommonMethods.isWebElementIsDisplayed(loginErrorMessageText)).as("validate the presence of invalid login error message")
                .isEqualTo(true);
        softAssertions.assertAll();
    }

    public void validateSuccessfulSignIn()
    {
        softAssertions.assertThat(reusableCommonMethods.isWebElementIsDisplayed(loginButton)).as("validate user successfully able to signIn")
                .isEqualTo(true);
        softAssertions.assertAll();
    }
}
