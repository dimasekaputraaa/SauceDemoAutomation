import config.env_target;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login extends env_target {
    @Test
    public void success(){
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
        //mulai
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("title"))
        );
        driver.quit();
    }

    @Test
    public void fail(){
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
        //mulai
        driver.findElement(By.id("user-name")).sendKeys("standart_us");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3/button"))
        );
        driver.quit();
    }
}
