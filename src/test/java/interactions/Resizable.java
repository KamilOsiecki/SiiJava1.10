package interactions;

import baseTest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Resizable extends BaseTest {

    @Test
    @DisplayName("Resizable")
    @Tag("Resizable")
    public void shouldHandleResizable() {
        getChromeAddress();
        Actions actions = new Actions(driver);
        WebElement window = driver.findElement(By.cssSelector(".ui-resizable-se"));
        System.out.println("Initial location: " + window.getLocation());
        int offSet = 10;

        actions.clickAndHold(window)
                .moveByOffset(offSet, 0)
                .moveByOffset(0, offSet)
                .moveByOffset(offSet, offSet)
                .release()
                .perform();

        System.out.println("Final location: " + window.getLocation());
    }

    private void getChromeAddress() {
        driver.get("http://automation-practice.emilos.pl/resizable.php");
    }
}