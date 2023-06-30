package stepDev;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest extends env_target {
    @Given("User Open url website")
    public void userOpenUrlWebsite() {
        System.setProperty("webdriver.edge.driver","src\\main\\resources\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        //atur url
        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("login-button"))
        );
    }

    @When("User do Input valid username and password")
    public void userDoInputValidUsernameAndPassword() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User Click login button")
    public void userClickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User success Logged in")
    public void userSuccessLoggedIn() {
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("title"))
        );
        driver.quit();
    }

    @When("User Input (.*) and (.*)$")
    public void userInputUsernameAndPassword(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("User failed Loggin with (.*)$")
    public void userFailedLogginWithResult(String result) {
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        if (result == "passed"){
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header_container']/div[2]/span"))
            );
        }else if (result == "failed") {
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3/button"))
            );
        }
        driver.quit();
    }
}
