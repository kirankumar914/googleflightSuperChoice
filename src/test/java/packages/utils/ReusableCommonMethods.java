package packages.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import packages.driver.Driver;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class ReusableCommonMethods extends Driver {
    public void selectAValueFromDropDown(WebElement webElement,String dropDownValue)
    {
        Select select=new Select(webElement);
        select.selectByValue(dropDownValue);
    }

    public void selectAValueByTextFromDropDown(WebElement webElement,String dropDownValue)
    {
        Select select=new Select(webElement);
        select.selectByVisibleText(dropDownValue);
    }

    public String getThePassword(int length)
    {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
        String pwd = RandomStringUtils.random( length, characters );
        System.out.println(pwd);
        return pwd;
    }

    public void implicitWait(int seconds)
    {
        driver.manage().timeouts().implicitlyWait(Duration.of(seconds, ChronoUnit.SECONDS));
    }

    public boolean isWebElementIsDisplayed(WebElement webElement) {
        boolean flag;
        {

            try {
                webElement.isDisplayed();
                flag = true;
            } catch (Exception e) {
                flag = false;
            }
        }
        return flag;
    }
}
