package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.elementHelper;
import util.propertiesFactory;

public class homePage {

    elementHelper helper;

    public homePage(WebDriver driver){
        this.helper = new elementHelper(driver);
    }

    By cookies = By.id("a-autoid-0");
    By search = By.id("com.amazon.mShop.android.shopping:id/chrome_search_hint_view");





    public void closeCookies() {
        helper.click(cookies);
    }
    public void checkTheSearchButton(){
        helper.click(search);
    }



}
