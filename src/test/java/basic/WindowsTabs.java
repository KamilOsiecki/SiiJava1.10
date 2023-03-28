package basic;

import baseTest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WindowsTabs extends BaseTest {
    Tables operation = new Tables();

    @Test
    @DisplayName("Windows tab")
    @Tag("Windows_tab")
    public void shouldHandleWindowsTab() {
        getChromeAddress();
        String initHandle = driver.getWindowHandle();
        assert driver.getWindowHandles().size() == 1;

        driver.findElement(By.cssSelector("#newBrowserWindow")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        switchToOtherWindow();
        wait.until(ExpectedConditions.titleIs("Automation Pratice"));
        operation.operationsOnTable(driver);
        driver.close();
        assert driver.getWindowHandles().size() == 1;
        driver.switchTo().window(initHandle);

        driver.findElement(By.cssSelector("#newMessageWindow")).click();
        switchToOtherWindow();
        System.out.println(driver.findElement(By.cssSelector("body")).getText());
        driver.close();
        assert driver.getWindowHandles().size() == 1;
        driver.switchTo().window(initHandle);

        driver.findElement(By.cssSelector("#newBrowserTab")).click();
        switchToOtherWindow();
        wait.until(ExpectedConditions.titleIs("Automation Pratice"));
        operation.operationsOnTable(driver);
        driver.close();
    }

    private void switchToOtherWindow() {
        String initHandle = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!initHandle.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    private void getChromeAddress() {
        driver.get("http://www.seleniumui.moderntester.pl/windows-tabs.php");
    }
}







