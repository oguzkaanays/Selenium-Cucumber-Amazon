package util;

import io.cucumber.core.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class elementHelper {

    WebDriver driver;
    Actions actions;
    WebDriverWait wait;
    propertiesFactory propertiesFactory = new propertiesFactory();


    public elementHelper(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(propertiesFactory.getWait()));
    }

    public void click(By by) {
        scrollElement(by).click();
    }

    public void sendKey(By by, String text) {
        scrollElement(by).sendKeys(text);
    }

    public String getText(By by) {
        String text = scrollElement(by).getText();
        return text;
    }


    public void checkElementPresence(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


    public WebElement scrollElement(By by) {
        checkElementPresence(by);
        WebElement element = driver.findElement(by);
        //actions.moveToElement(element).build().perform();
        return element;
    }

    public void clickElementWithText(By by, String text) {
        List<WebElement> buttons = driver.findElements(by);
        for (WebElement element : buttons) {
            if(element.getText().equals(text)){
                element.click();
            }

        }
    }




}
