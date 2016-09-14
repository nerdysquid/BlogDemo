package cucumberselenuim.cucumberseleniumexample.CustomerRegistrationForm;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CustomerDataVerification {

	public static WebDriver driver;
	public static List<WebElement> tdOfTable;

	@Given("^user is on register customer page$")
	public void user_is_on_register_cust_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// chmod this to make this executable -> chmod +x file
		driver = CustomerRegistrationForm.driver;
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("faces/default.xhtml"));
	}

	@When("^A row with new customer is added$")
	public void row_addition_with_new_data() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		
		//			.findElements(By.tagName("tr")).size();
		List<WebElement> tr = driver.findElements(By.className("order-table")).get(0).findElements(By.tagName("tr"));
		System.out.println("tr size "+ tr.size()+ " total Data "+ CustomerRegistrationForm.totalData );
		WebElement lastTr = tr.get(tr.size() - 1);
		tdOfTable = lastTr.findElements(By.tagName("td"));
		System.out.println("td size "+tdOfTable.size());
		Assert.assertTrue(tr.size() == (CustomerRegistrationForm.totalData + 1));
	}

	@When("^value in the name column is cust_name$")
	public void verify_cust_name() throws Throwable {
		String nameOfUser = tdOfTable.get(1).getText();
		System.out.println("Name of user: " + nameOfUser);
		Assert.assertTrue(nameOfUser.equals("John"));
	}

	@When("^value in Address column is cust_addr$")
	public void verify_cust_addr() throws Throwable {
		String addrOfUser = tdOfTable.get(2).getText();
		System.out.println("Address: " + addrOfUser);
		Assert.assertTrue(addrOfUser.equals("Wall Street"));
	}
	
	@When("^user is navigated to login page$")
	public void verify_user_page() throws Throwable {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("faces/userLogin.xhtml"));
	}
}