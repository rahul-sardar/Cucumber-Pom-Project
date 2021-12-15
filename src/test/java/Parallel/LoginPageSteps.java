package Parallel;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
    
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private static String title;
	
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("https://demo.opencart.com/index.php?route=account/login");
		
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginpage.getPageTitle();
		System.out.println("Title of the Page is :" +title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedtitle) {
		Assert.assertTrue(title.contains(expectedtitle));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginpage.isForgetPasswordLinkExist());
	}
    
	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginpage.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginpage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginpage.clickOnLogin();
	}

}
