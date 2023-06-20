package stepDef;

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

public class Login extends env_target {
    @Given("User Login")
    public void userLogin() {
        //atur driver edge
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

    @When("User Input username and password")
    public void userInputUsernameAndPassword() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User Click login button")
    public void userClickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User Logged in")
    public void userLoggedIn() {
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("title"))
        );
        driver.quit();
    }

    @When("User Input username and wrong password")
    public void userInputUsernameAndWrongPassword() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_saauce");
    }

    @Then("User Get Error Msg")
    public void userGetErrorMsg() {
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3/button"))
        );
        driver.quit();
    }
}
