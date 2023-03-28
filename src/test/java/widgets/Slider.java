package widgets;

import baseTest.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Slider extends BaseTest {

    @Test
    @DisplayName("Slider")
    @Tag("Slider")
    public void shouldHandleSlider() {
        getChromeAddress();
        moveSlider(50);
        moveSlider(80);
        moveSlider(80);
        moveSlider(20);
        moveSlider(0);
    }

    private void moveSlider(int sliderFinalValue) {

        WebElement slider = driver.findElement(By.cssSelector("#custom-handle"));
        int actualSliderValue = Integer.parseInt(slider.getText());

        if (actualSliderValue < sliderFinalValue) {
            for (int i = actualSliderValue; i < sliderFinalValue; i++) {
                slider.sendKeys(Keys.ARROW_RIGHT);
            }
        } else if (actualSliderValue > sliderFinalValue) {
            for (int i = actualSliderValue; i > sliderFinalValue; i--) {
                slider.sendKeys(Keys.ARROW_LEFT);
            }
        }
        int endValue = Integer.parseInt(slider.getText());
        Assertions.assertThat(sliderFinalValue).isEqualTo(endValue);
    }

    private void getChromeAddress() {
        driver.get("http://automation-practice.emilos.pl/slider.php");
    }
}