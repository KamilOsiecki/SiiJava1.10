package basic;

import baseTest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Iframes extends BaseTest {

    @Test
    @DisplayName("Iframes test")
    @Tag("Iframes")
    public void shouldHandleIframe() {
        getChromeAddress();
        driver.switchTo().frame("iframe1");
        driver.switchTo().defaultContent();
        driver.switchTo().frame("iframe2");
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector(".dropdown-toggle")).click();
    }

    private void getChromeAddress() {
        driver.get("http://www.seleniumui.moderntester.pl/iframes.php");
    }
}