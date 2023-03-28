package widgets;

import baseTest.BaseTest;
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
public class Progressbar extends BaseTest {

    @Test
    @DisplayName("Progressbar - label")
    @Tag("Progressbar")
    public void shouldHandleProgressbarByLabel() {
        getChromeAddress();
        driver.findElement(By.cssSelector("#progressbar"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[.='Complete!']")));
    }

    @Test
    @DisplayName("Progressbar - class")
    @Tag("Progressbar")
    public void shouldHandleProgressbarByClass() {
        getChromeAddress();
        driver.findElement(By.cssSelector("#progressbar"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ui-progressbar-complete")));
    }

    private void getChromeAddress() {
        driver.get("http://automation-practice.emilos.pl/progressbar.php");
    }
}