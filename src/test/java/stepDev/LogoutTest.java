package stepDev;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutTest extends env_target {
    @Given("User must be login before")
    public void userMustBeLoginBefore() {
        System.setProperty("webdriver.edge.driver","src\\main\\resources\\msedgedriver.exe");
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        //atur url
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))
        );
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("User click humberger button")
    public void userClickHumbergerButton() {

        driver.findElement(By.xpath("//*[@id='sreact-burger-menu-btn']")).click();


    }

    @And("User click logout text")
    public void userClickLogoutText() {
        driver.findElement(By.id("logout_sidebar_link")).click();
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))
        );
        driver.quit();
    }
}
