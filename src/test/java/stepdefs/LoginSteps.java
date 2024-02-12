package stepdefs;

import com.pages.HomePage;
import com.pages.OrderConfirmationPage;
import com.pages.OrderPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static io.restassured.RestAssured.given;

public class LoginSteps {

    WebDriver driver=DriverFactory.getDriver();
    HomePage homePage = new HomePage(driver);
    OrderPage orderPage = new OrderPage(driver);
    OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
    double price;
    double quantity;
    Response response;

    @Given("User Navigates to Application")
    public void user_navigates_to_application() {
        //driver=driverFactory.init_driver();
    }
    @Then("User Enters UserName {string} and Password {string}")
    public void user_enters_user_name_and_password(String string, String string2) {

    }
    @Then("User Clicks on Login Button")
    public void user_clicks_on_login_button() {
       homePage.clickSubmitButton();
    }
    @Then("Login Should be successful")
    public void login_should_be_successful() {
    }

    @And("User enters order details")
    public void userEntersOrderDetails() {
    }

    @Then("User Navigates to purchase Screen")
    public void userNavigatesToPurchaseScreen() {
        homePage.clickPurchase();
    }

    @Then("verify order purchase is successful")
    public void verifyOrderPurchaseIsSuccessful() {
    }

    @And("User Enters {string} , {string} , {string} , {string}")
    public void userEnters(String arg0, String arg1, String arg2, String arg3) {
        orderPage.fillOrderDetails(arg0,arg1,arg2,arg3);
        price=orderPage.getPrice();
        quantity= Double.parseDouble(arg1);
    }

    @And("verify Prise Displayed Accordingly")
    public void verifyPriseDisplayedAccordingly() throws InterruptedException {
        Assert.assertTrue(price*quantity==orderConfirmationPage.getPrice());
    }

    @Then("Continue Shopping for Customer")
    public void continueShoppingForCustomer() {
        orderConfirmationPage.setContinueShopping();
    }

    @Given("User triggers GetOrders API")
    public void userTriggersGetOrdersAPI() {
        response = given()
                .contentType(ContentType.JSON)
                .when().relaxedHTTPSValidation()
                .get("https://bar.bagconsult.eu/api/Order")
                .then()
                .extract().response();
    }

    @Then("Verify All Records are Present in Response")
    public void verifyAllRecordsArePresentInResponse() {
        System.out.println(response.body().prettyPrint());
        Assert.assertEquals(200,response.getStatusCode());
    }

    @Given("User Triggers CreateOrder API")
    public void userTriggersCreateOrderAPI() {
        String Body = "{\n" +
                "  \"IsAdult\": true,\n" +
                "  \"TypeId\": 3,\n" +
                "  \"Quantity\": 1,\n" +
                "  \"Name\": \"sample string 4\",\n" +
                "  \"Email\": \"sample string 5\",\n" +
                "  \"Price\": 6.0,\n" +
                "  \"Date\": \"2024-02-07T20:37:33.3713837+02:00\"\n" +
                "}";

        response = given()
                .contentType(ContentType.JSON).body(Body)
                .when().relaxedHTTPSValidation()
                .post("https://bar.bagconsult.eu/api/Order")
                .then()
                .extract().response();

    }

    @Then("Verify Record is inserted successfully")
    public void verifyRecordIsInsertedSuccessfully() {

        Assert.assertEquals(201,response.getStatusCode());
    }

    @Given("User Triggers GetOrders API with OrderID <{int}>")
    public void userTriggersGetOrdersAPIWithOrderID(int arg0) {
        response=given()
                .contentType(ContentType.JSON)
                .when().relaxedHTTPSValidation()
                .get("https://bar.bagconsult.eu/api/Order/"+arg0)
                .then()
                .extract().response();
        Assert.assertEquals(arg0,response.jsonPath().getInt("Id"));
    }

    @Then("Verify Order is retrieved Successfully")
    public void verifyOrderIsRetrievedSuccessfully() {
        Assert.assertEquals(200,response.getStatusCode());

    }

    @Given("User Triggers DeleteOrder with OrderID")
    public void userTriggersDeleteOrderWithOrderID() {
    }

    @Then("Verify Order is deleted from Orders Table")
    public void verifyOrderIsDeletedFromOrdersTable() {
    }
}
