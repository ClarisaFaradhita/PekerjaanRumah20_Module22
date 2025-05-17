package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import static org.junit.Assert.*;


public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("user is on the login page")
    public void user_on_login_page() {
        driver = new ChromeDriver();
        driver.get("https://example.com/login");
        loginPage = new LoginPage(driver);
    }

    @When("user enters valid username and password")
    public void user_enters_valid_credentials() {
        loginPage.enterUsername("validUser");
        loginPage.enterPassword("validPass");
    }

    @When("user enters invalid username and password")
    public void user_enters_invalid_credentials() {
        loginPage.enterUsername("invalidUser");
        loginPage.enterPassword("wrongPass");
    }

    @When("user enters empty username and password")
    public void user_enters_empty_credentials() {
        loginPage.enterUsername("");
        loginPage.enterPassword("");
    }

    @When("clicks the login button")
    public void user_clicks_login() {
        loginPage.clickLogin();
    }

    @Then("user should be redirected to the homepage")
    public void redirected_to_homepage() {
        assertTrue(driver.getCurrentUrl().contains("home"));
        driver.quit();
    }

    @Then("error message should be displayed")
    public void error_message_displayed() {
        assertTrue(loginPage.getErrorMessage().contains("Invalid credentials"));
        driver.quit();
    }
}
