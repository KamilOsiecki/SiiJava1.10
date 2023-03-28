package other;

import baseTest.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoQa extends BaseTest {
    @Test
    @DisplayName("DemoQA")
    @Tag("DemoQA")
    public void shouldHandleDemoQA() {
        getChromeAddress();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,250)", "");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("#subjectsInput")).sendKeys("m");
        String mathElement = wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("#react-select-2-option-0")))).getText();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#react-select-2-option-0"))).click();
        driver.findElement(By.cssSelector("#subjectsInput")).sendKeys("a");
        String artElement = wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("#react-select-2-option-2")))).getText();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#react-select-2-option-2"))).click();
        Assertions.assertThat(mathElement + "\n" + artElement).isEqualTo("Maths\nArts");
    }

    private void getChromeAddress() {
        driver.get("https://demoqa.com/automation-practice-form");
    }
}