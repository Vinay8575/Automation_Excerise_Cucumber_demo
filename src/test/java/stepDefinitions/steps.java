package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.DeleteAccount;
import pageObjects.HomePage;
import pageObjects.Signup_Login;
import utilities.PropertiesReader;


public class steps
{
	WebDriver driver;
	HomePage hp= new HomePage(BaseClass.getDriver());
	Signup_Login sl=new Signup_Login(BaseClass.getDriver());
	DeleteAccount da=new DeleteAccount(BaseClass.getDriver());
	
	String path= System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
	PropertiesReader testdata = new PropertiesReader(path);
	
	@Given("The user clicks on signup or login link from the Homepage")
	public void the_user_clicks_on_signup_or_login_link_from_the_homepage() 
	{
		hp.clickonsignuporlogin();
	}

	@When("the user enter the valid credentials")
	public void the_user_enter_the_valid_credentials() 
	{
		sl.txtloginemail(testdata.getProperty("email"));
		sl.txtloginpwd(testdata.getProperty("password"));
	}
	
	@When("the user enter the valid credentials {string},{string}")
	public void the_user_enter_the_valid_credentials(String email, String password) 
	{
		sl.txtloginemail(email);
		sl.txtloginpwd(password);
	}

	@When("the user clicks on Login button")
	public void the_user_clicks_on_login_button() 
	{
		sl.clicklogin();
	}

	@Then("the user validates the Delete Account option is getting displayed")
	public void the_user_validates_the_delete_account_option_is_getting_displayed() 
	{
        boolean value=da.verifytext();
		Assert.assertTrue(value);
	}


}
