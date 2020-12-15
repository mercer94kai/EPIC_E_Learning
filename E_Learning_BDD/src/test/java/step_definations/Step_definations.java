package step_definations;

import java.io.IOException;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.*;

public class Step_definations extends BasePage {
	Homepage Home_Page;
	Registration Reg_Page;
	
	@Given("user is on Homepage <Befor login> using {string}")
	public void user_is_on_Homepage_Befor_login_using(String string)  throws IOException {
		
			initDriver(string);
			launchApp();
			
			Home_Page= new Homepage(driver);
			Reg_Page= new Registration(driver);
	}

	@When("clicked on Sign_up option")
	public void clicked_on_Sign_up_option() {
		Home_Page.clickSignupBtn();		
	}

	@Then("redirected to user Registration page")
	public void redirected_to_user_Registration_page() {
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("My Organization - My education - Registration"));
	}

	@Then("user enters {string},{string},{string},{string},{string} & {string} details")
	public void user_enters_details(String string, String string2, String string3, String string4, String string5, String string6) {
		Reg_Page.enterFirstName(string);
		Reg_Page.enterLastName(string2);
		Reg_Page.enterEmail(string3);
		Reg_Page.enterUserName(string4);
		Reg_Page.enterPass(string5);
		Reg_Page.enterConPass(string6);
	}

	@Then("clicked on Registration button")
	public void clicked_on_Registration_button() {
		Reg_Page.clickRegistrationButton();
	}

	@Then("validate acknowlefgement message and clicked on the icon on top right corner & validate the dropdown with {string}")
	public void validate_acknowlefgement_message_and_clicked_on_the_icon_on_top_right_corner_validate_the_dropdown_with(String string) {
	   Reg_Page.VerifyConfMsg(string);
	}
	
	@Then("clicked on Homepage button and log out")
	public void clicked_on_Homepage_button_and_log_out() {
	    Reg_Page.clickHomepageBtn();
	    Assert.assertTrue(driver.getTitle().equalsIgnoreCase("My Organization - My education"));
	    driver.close();
	}


@Given("Verify user logi credentials on Homepage using {string},{string}& {string} using {string}")
public void verify_user_logi_credentials_on_Homepage_using_using(String string, String string2, String string3, String string4) throws IOException {
		initDriver(string4);
		launchApp();
		
		Home_Page= new Homepage(driver);
		Reg_Page= new Registration(driver);
		
		Home_Page.verifyLogin(string,string2,string3);
		
	}

	@When("clicked on Compose option")
	public void clicked_on_Compose_option() {
	   Home_Page.clickComposeBtn(); 
	}

	@When("user enters {string},{string} & {string} details")
	public void user_enters_details(String string, String string2, String string3) throws InterruptedException {
		Home_Page.writeMail(string, string2, string3);
	}

	@Then("clicked on Send Message button")
	public void clicked_on_Send_Message_button() {
	    Home_Page.clickOnSendMsgBtn();
	}

	@Then("user gets the confirmation message")
	public void user_gets_the_confirmation_message() {
	    Home_Page.verifySendMsgAck();
	}

	@Then("clicked on top right corner")
	public void clicked_on_top_right_corner() {
	    Home_Page.clickOndropdown();
	}

	@Then("clicked on Logout option")
	public void clicked_on_Logout_option() {
	   Home_Page.clickOnLogout();
	   driver.close();
	}

}
