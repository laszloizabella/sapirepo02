package ro.sapientia.mesteri2015.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TaskUpdateStepDefinition {

	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^I edit the scrum list's first task$")
	public void I_edit_the_scrum_list_s_first_task() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/");
	}

	@When("^I enter \"([^\"]*)\" in  the title textbox and I push the update button$")
	public void I_enter_in_the_title_textbox_and_I_push_the_update_button(String updateTitle) throws Throwable {
	    // Express the Regexp above with the code you wish you had
		WebElement addButton = driver.findElement(By.id("task-1"));
		addButton.click();
		//driver.wait(1000);
		WebElement updateButton = driver.findElement(By.id("action-update-button"));
		updateButton.click();
		//driver.wait(1000);
		WebElement titleField = driver.findElement(By.id("task-title"));
		titleField.sendKeys(Keys.CONTROL + "a");
		titleField.sendKeys(Keys.DELETE);
		titleField.sendKeys(updateTitle);
		
		WebElement updateStoryButton = driver.findElement(By.id("update-task-button"));
		updateStoryButton.click();
	
	}
	
	@Then("^I should get result \"([^\"]*)\" in new tasks list$")
	public void I_should_get_result_in_new_tasks_list(String expectedResult) throws Throwable {
	    // Express the Regexp above with the code you wish you had
		WebElement titleText = driver.findElement(By.id("task-title"));
		String result = titleText.getText();

		Assert.assertEquals(result, expectedResult);
		//Assert.assertNotSame(result, expectedResult);
		driver.close();
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}

}
