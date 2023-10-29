package packages.pages;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import packages.configs.factroy.ConfigFactory;
import packages.driver.Driver;
import packages.utils.ReusableCommonMethods;

import javax.xml.xpath.XPath;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.SECONDS;

public class HomePage extends Driver {

    SoftAssertions softAssertions=new SoftAssertions();
    ReusableCommonMethods reusableCommonMethods=new ReusableCommonMethods();
    @FindBy(xpath="//a[contains(text(),'Register')]")
    WebElement registerButton;
    public HomePage()
    {
        PageFactory.initElements(driver,this);
    }
    public void moveToRegistrationPage(){
        registerButton.click();
    }

}
