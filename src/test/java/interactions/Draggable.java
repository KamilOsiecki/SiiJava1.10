package interactions;

import baseTest.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Draggable extends BaseTest {

    @Test
    @DisplayName("Draggable")
    @Tag("Draggable")
    public void shouldHandleDraggable() {
        getChromeAddress();
        Actions actions = new Actions(driver);
        WebElement square = driver.findElement(By.cssSelector("#draggable"));
        int squareHeight = square.getSize().getHeight();
        int squareWidth = square.getSize().getWidth();
        int draggableX = square.getLocation().getX();
        int draggableY = square.getLocation().getY();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int pageHeight = ((Number) js.executeScript("return window.innerHeight")).intValue();
        int pageWidth = ((Number) js.executeScript("return window.innerWidth")).intValue();
        System.out.println("PAge height:  " + pageHeight + "\nwidth: " + pageWidth);
        actions.clickAndHold(square)
                .moveByOffset(pageWidth - draggableX - squareWidth, -draggableY)
                .moveByOffset(0, pageHeight - squareHeight)
                .moveByOffset(-(pageWidth / 2) + (squareWidth / 2), -(pageHeight / 2) + (squareHeight / 2))
                .moveByOffset(-(pageWidth / 2) + (squareWidth / 2), (pageHeight / 2) - (squareHeight / 2))
                .release()
                .perform();
    }

    private void getChromeAddress() {
        driver.get("http://automation-practice.emilos.pl/draggable.php");
    }
}