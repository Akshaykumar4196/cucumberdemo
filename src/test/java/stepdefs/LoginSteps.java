package stepdefs;

import com.pages.HomePage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginSteps {

    HomePage homePage = new HomePage(DriverFactory.getDriver());

    @Given("User Navigates to Application")
    public void user_navigates_to_application() {
        //driverFactory.init_driver().get("https://www.facebook.com/login/");
    }
    @Then("User Enters UserName {string} and Password {string}")
    public void user_enters_user_name_and_password(String string, String string2) {
        homePage.enterUserCredentials(string,string2);
    }
    @Then("User Clicks on Login Button")
    public void user_clicks_on_login_button() {
       homePage.clickSubmitButton();
    }
    @Then("Login Should be successful")
    public void login_should_be_successful() {

    }

}
