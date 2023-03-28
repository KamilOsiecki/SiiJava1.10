package widgets;

import baseTest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Tooltip extends BaseTest {

    @Test
    @DisplayName("Tooltip")
    @Tag("Tooltip")
    public void shouldHandleTooltip(){
        getChromeAddress();
        driver.findElement(By.cssSelector("#age")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ui-tooltip-content")));
        System.out.println(driver.findElement(By.cssSelector(".ui-tooltip-content")).getText());
    }

    private void getChromeAddress(){
        driver.get("http://automation-practice.emilos.pl/tooltip.php");
    }
}