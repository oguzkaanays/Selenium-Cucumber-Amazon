package pages;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.elementHelper;

public class loginPage {

    elementHelper helper;
    public loginPage(WebDriver driver){
        this.helper = new elementHelper(driver);
    }

    By account = By.xpath("com.amazon.mShop.android.shopping:id/signin_to_yourAccount");
    By buttons = By.xpath("//android.widget.LinearLayout/android.widget.Button");


    public void checkAccount() {
        helper.checkElementPresence(account);
    }
    public void tapsToSkipSignInButton(String text) {
        helper.clickElementWithText(buttons,text);
    }

}
