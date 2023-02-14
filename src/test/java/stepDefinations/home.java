package stepDefinations;

import io.cucumber.java.en.Then;
import pages.homePage;
import util.driverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class home {
   homePage homePage = new homePage(driverFactory.getDriver());
   

    @Then("user should see the Home page")
    public void userShouldSeeTheHomePage() {
     homePage.closeCookies();
     homePage.checkTheSearchButton();


    }

    @When("user searchs to {string} name on the Home page")
    public void userSearchsToNameOnTheHomePage(String product) {
    }

    @Given("user is on the Home page")
    public void userIsOnTheHomePage() {

    }
}
