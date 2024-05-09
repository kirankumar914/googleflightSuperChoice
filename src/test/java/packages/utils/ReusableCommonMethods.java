package packages.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import packages.configs.factroy.ConfigFactory;
import packages.driver.Driver;

import java.time.Duration;
import java.util.List;

public class ReusableCommonMethods extends Driver {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigFactory.getConfig().webDriverWait()));

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

    public void selectAValueFromDropDown(By by, String value) {
        List<WebElement> webElementList = driver.findElements(by);
        for (WebElement elem : webElementList) {
            if (elem.getText().equalsIgnoreCase(value)) {
                waitUntilElementIsVisible(elem);
                clickOnMidOfElement(elem);
            }
        }
    }

    public void waitUntilElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigFactory.getConfig().webDriverWait()));
    }

    public void clickOnMidOfElement(WebElement webElement) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click()", webElement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pressEscape() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).build().perform();
    }

    public void pressTab() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).build().perform();
    }

}
