package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class DashboardPage {
    WebDriver driver;

    By adminTab = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardDisplayed() {
        return driver.findElement(adminTab).isDisplayed();
    }

    public void clickAdminTab() {
        driver.findElement(adminTab).click();
    }
}
