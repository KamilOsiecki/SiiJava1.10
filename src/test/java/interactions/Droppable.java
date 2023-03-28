package interactions;

import baseTest.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Droppable extends BaseTest {

    @Test
    @DisplayName("Droppable")
    @Tag("Droppable")
    public void shouldHandleDroppable() {
        getChromeAddress();
        Actions actions = new Actions(driver);
        WebElement drag = driver.findElement(By.cssSelector("#draggable"));
        WebElement drop = driver.findElement(By.cssSelector("#droppable"));
        actions.dragAndDrop(drag, drop)
                .build()
                .perform();
        Assertions.assertThat(IsDisplayed(By.cssSelector("#droppable p"))).isTrue();
    }

    private void getChromeAddress() {
        driver.get("http://automation-practice.emilos.pl/droppable.php");
    }
}