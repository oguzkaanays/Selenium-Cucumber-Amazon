package stepDefinations;

import io.cucumber.java.en.Then;
import pages.loginPage;
import pages.productListPage;
import util.driverFactory;

public class productList {
    productListPage productListPage = new productListPage(driverFactory.getDriver());

    @Then("user should see the Product List page")
    public void userShouldSeeTheProductListPage() {
    }

}
