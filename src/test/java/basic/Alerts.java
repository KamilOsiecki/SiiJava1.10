package basic;

import baseTest.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Execution(ExecutionMode.CONCURRENT)
public class Alerts extends BaseTest {

    @Test
    @DisplayName("Simple Alert Pop up")
    @Tag("Alerts")
    public void shouldHandleSimpleAlertPopup() {
        getChromeAddress();
        driver.findElement(By.cssSelector("#simple-alert")).click();
        driver.switchTo().alert().accept();
    }

    @Test
    @DisplayName("Prompt Alert box")
    @Tag("Alerts")
    public void shouldHandlePromptAlertBox() {
        getChromeAddress();
        driver.findElement(By.cssSelector("#prompt-alert")).click();
        driver.switchTo().alert().sendKeys("Lord Vader");
        driver.switchTo().alert().accept();
        var helloMessage = driver.findElement(By.cssSelector("#prompt-label")).getText();
        Assertions.assertThat(helloMessage).isEqualTo("Hello Lord Vader! How are you today?");
    }

    @Test
    @DisplayName("Confirm Alert box")
    @Tag("Alerts")
    public void shouldHandleConfirmAlertBox() {
        getChromeAddress();
        driver.findElement(By.cssSelector("#confirm-alert")).click();
        driver.switchTo().alert().accept();
        var pressedOkMessage = driver.findElement(By.cssSelector("#confirm-label")).getText();
        Assertions.assertThat(pressedOkMessage).isEqualTo("You pressed OK!");
        driver.findElement(By.cssSelector("#confirm-alert")).click();
        driver.switchTo().alert().dismiss();
        var pressedCancelMessage = driver.findElement(By.cssSelector("#confirm-label")).getText();
        Assertions.assertThat(pressedCancelMessage).isEqualTo("You pressed Cancel!");
    }

    @Test
    @DisplayName("Delayed alert")
    @Tag("Alerts")
    public void shouldHandleDelayedAlert() {
        getChromeAddress();
        driver.findElement(By.cssSelector("#delayed-alert")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        var delayedAlertPressed = driver.findElement(By.cssSelector("#delayed-alert-label")).getText();
        Assertions.assertThat(delayedAlertPressed).isEqualTo("OK button pressed");
    }

    private void getChromeAddress() {
        driver.get("http://www.seleniumui.moderntester.pl/alerts.php");
    }
}