package Parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {
	
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
    private AccountsPage accountspage;
    
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
		List<Map<String,String>> credentiallist = dataTable.asMaps();
		
		//Its gives us list of maps, each row is list and columns are maps , 
		//Column heading acts as keys (My own thinking)
		String usrname= credentiallist.get(0).get("username");
		String password = credentiallist.get(0).get("password");
		DriverFactory.getDriver().get("https://demo.opencart.com/index.php?route=account/login");
		accountspage = loginpage.doLogin(usrname, password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String title = accountspage.getAccountPageTitle();
		System.out.println("Account Page Title is " +title);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable dataTable) {
	    List<String> expectedAccountsSectionList = dataTable.asList();
	    System.out.println("Expected list is " +expectedAccountsSectionList);
	    List<String> actualAccountsSectionList = accountspage.getAccountSectionList();
	    System.out.println("Actual Account Section list is " +actualAccountsSectionList);
	    Assert.assertTrue(expectedAccountsSectionList.containsAll(actualAccountsSectionList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
		int count = accountspage.getAccountSectionListCount();
		Assert.assertEquals(count, (int)expectedSectionCount);
	}


	
}
