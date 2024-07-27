package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage {

        WebDriver driver;
        WebDriverWait wait;
    //========================================Locators============================================================
        By recordCount = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/span[1]");
        By addButton = By.xpath("(//button[normalize-space()='Add'])[1]");
        By EmployeeName = By.xpath("//input[@placeholder='Type for hints...']");
        By selectEmployeeFromSearch = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[2]/span");
        By UserRoleField = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]");
        By selectAdminOption = By.xpath("//html");
        By statusField = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]");
        By selectEnableOption = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[2]/span");
        By usernameField = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[2]/input[1]");
        By passwordField = By.xpath("//div[@class=\"oxd-grid-item oxd-grid-item--gutters user-password-cell\"]//div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//div//input[@type=\"password\"]");
        By confirmPassword = By.xpath("//div[@class=\"oxd-grid-item oxd-grid-item--gutters\"]//div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//div//input[@type=\"password\"]");
        By saveButton = By.cssSelector("[type=\"submit\"]");
        By searchField = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]");
        By searchButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");
        By deleteButton = By.xpath("//div[@role=\"table\"]//div[1]//div[1]//div[6]//div[1]//button[1]");
        By confirmDelete = By.xpath("//button[normalize-space()=\"Yes, Delete\"]") ;
        By resetButton = By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[1]");
        //================================================Functions=======================================

        public AdminPage(WebDriver driver) {
            this.driver = driver;
        }

        public int getNumberOfRecords() {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(recordCount));
            String recordText = driver.findElement(recordCount).getText();
            recordText  = recordText.split(" ")[0];
            String recorededInt = recordText.replaceAll("[^0-9]", "");
//            System.out.println(recorededInt);
            return Integer.parseInt(recorededInt);

        }

        public void clickAddButton() {
            wait.until(ExpectedConditions.elementToBeClickable(addButton));
            driver.findElement(addButton).click();
        }

        public void fillUserData(String username, String password , String confirm_password) {
            wait.until(ExpectedConditions.elementToBeClickable(UserRoleField));
            driver.findElement(UserRoleField).click();
            driver.findElement(selectAdminOption).click();
            driver.findElement(EmployeeName).sendKeys("r");
            wait.until(ExpectedConditions.elementToBeClickable(selectEmployeeFromSearch));
            driver.findElement(selectEmployeeFromSearch).click();
            wait.until(ExpectedConditions.elementToBeClickable(statusField));
            driver.findElement(statusField).click();
            driver.findElement(selectEnableOption).click();
            driver.findElement(usernameField).sendKeys(username);
            driver.findElement(passwordField).sendKeys(password);
            driver.findElement(confirmPassword).sendKeys(confirm_password);
        }

        public void clickSaveButton() {
            driver.findElement(saveButton).click();
        }

        public void searchUser(String usename) {
            wait.until(ExpectedConditions.elementToBeClickable(searchField));
            driver.findElement(searchField).sendKeys(usename);
        }

        public void clickSearchButton() {
            driver.findElement(searchButton).click();

        }

        public void deleteUser() {
            wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
            driver.findElement(deleteButton).click();
            wait.until(ExpectedConditions.elementToBeClickable(confirmDelete));
            driver.findElement(confirmDelete).click();

        }
        public void resetList (){
            wait.until(ExpectedConditions.elementToBeClickable(resetButton));
            driver.findElement(resetButton).click();
        }

        public  void quit_Browser () {
            driver.quit();
        }

    }

