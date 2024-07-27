package Steps;
import Pages.AdminPage;
import Pages.DashboardPage;
import Pages.LoginPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class OrangeHRMSteps {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AdminPage adminPage;
    int initialRecordCount;
    int finalRecordCount;

    @Given("I am on the OrangeHRM login page")
    public void i_am_on_the_orangehrm_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        adminPage = new AdminPage(driver);
    }

    @When("I log in with username and password")
    public void i_log_in_with_username_and_password() {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in")
    public void i_should_be_logged_in() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]")));
        Assert.assertTrue(dashboardPage.isDashboardDisplayed());
    }

    @When("I navigate to the Admin tab")
    public void i_navigate_to_the_admin_tab() {
        dashboardPage.clickAdminTab();
    }

    @Then("I get the number of records")
    public void i_get_the_number_of_records() {
        initialRecordCount = adminPage.getNumberOfRecords();
    }

    @When("I log in with username Admin and password admin123")
    public void i_add_a_new_user_with_username_and_password() {
        adminPage.clickAddButton();
        adminPage.fillUserData("Mina.tessssssssst", "Mina_Sasa22" , "Mina_Sasa22");
        adminPage.clickSaveButton();
        finalRecordCount = adminPage.getNumberOfRecords();
        Assert.assertEquals(initialRecordCount + 1, finalRecordCount);
    }

    @Then("I search for the username")
    public void i_search_for_the_user() {
        adminPage.searchUser("Mina.tessssssssst");
        adminPage.clickSearchButton();
    }

    @When("I delete the user and reset the list")
    public void i_delete_the_user() {
        adminPage.deleteUser();
        adminPage.resetList();
    }

        @And("The number of records should decrease by 1")
    public void the_number_of_records_should_decrease_by_1() {
        finalRecordCount = adminPage.getNumberOfRecords();
        Assert.assertEquals(initialRecordCount , finalRecordCount);
    }

    @Then("Quit the browser")
    public void quit_Browser () {
        adminPage.quit_Browser();
    }

}
