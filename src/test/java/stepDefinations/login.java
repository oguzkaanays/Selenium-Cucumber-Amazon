package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.homePage;
import pages.loginPage;
import util.driverFactory;

public class login {

    loginPage loginPage = new loginPage(driverFactory.getDriver());


    @Given("user should see the Login page")
    public void userShouldSeeTheLoginPage() {
        loginPage.checkAccount();
    }

    @When("user taps to {string} button on the Login page")
    public void userTapsToButtonOnTheLoginPage(String button) {
        loginPage.tapsToSkipSignInButton(button);

    }


}
