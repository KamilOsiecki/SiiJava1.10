package other;

import baseTest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

@Execution(ExecutionMode.CONCURRENT)
public class HighSite extends BaseTest {

    @Test
    @DisplayName("HighSite")
    @Tag("HighSite")
    public void shouldScrollToElementJSEMethod() {
        getChromeAddress();
        scrollUntilVisibleJSMethod();
    }

    @Test
    @DisplayName("HighSite")
    @Tag("HighSite")
    public void shouldScrollToElementActionsMethod() {
        getChromeAddress();
        scrollUntilVisibleActionsMethod();
    }

    private void scrollUntilVisibleJSMethod() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        do {
            executor.executeScript("window.scrollBy(0,100)", "");
        } while (!IsDisplayed(By.cssSelector("#scroll-button")));
    }

    private void scrollUntilVisibleActionsMethod() {
        Actions actions = new Actions(driver);
        do {
            actions.scrollByAmount(0, 100).perform();
        } while (!IsDisplayed(By.cssSelector("#scroll-button")));
    }

    private void getChromeAddress() {
        driver.get("http://automation-practice.emilos.pl/high-site.php");
    }
}