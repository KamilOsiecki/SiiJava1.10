package interactions;

import baseTest.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Selectable extends BaseTest {

    @Test
    @DisplayName("Selectable")
    @Tag("Selectable")
    public void shouldHandleSelectable() {
        gerChromeAddress();
        List<WebElement> items = driver.findElements(By.cssSelector("#selectable li"));
        Actions actions = new Actions(driver);

        actions.keyDown(Keys.LEFT_CONTROL)
                .click(items.get(0))
                .click(items.get(2))
                .click(items.get(3))
                .perform();
        String selectedResultFeedback = driver.findElement(By.cssSelector("#feedback")).getText();
        Assertions.assertThat(selectedResultFeedback).isEqualTo("You've selected: #1 #3 #4.");
        Assertions.assertThat(IsDisplayed(By.cssSelector("#feedback"))).isTrue();
    }

    private void gerChromeAddress() {
        driver.get("http://automation-practice.emilos.pl/selectable.php");
    }
}