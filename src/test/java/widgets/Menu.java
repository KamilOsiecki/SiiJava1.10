package widgets;

import baseTest.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Menu extends BaseTest {

    @ParameterizedTest
    @MethodSource("widgets.UtilTest#newUserDataProvider")
    @DisplayName("Menu")
    @Tag("Widgets")
    public void shouldHandleWidgetMenu(String uname, String umail, String psw) {
        getChromeAddress();
        driver.findElement(By.cssSelector("#ui-id-9")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#ui-id-13"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#ui-id-16"))).click();

        driver.findElement(By.cssSelector("li:nth-child(3)")).click();
        driver.findElement(By.cssSelector("#modal-dialog-item")).click();
        driver.findElement(By.cssSelector("#create-user")).click();
        driver.findElement(By.cssSelector("#name")).clear();
        driver.findElement(By.cssSelector("#name")).sendKeys(uname);
        driver.findElement(By.cssSelector("#email")).clear();
        driver.findElement(By.cssSelector("#email")).sendKeys(umail);
        driver.findElement(By.cssSelector("#password")).clear();
        driver.findElement(By.cssSelector("#password")).sendKeys(psw);
        driver.findElement(By.cssSelector("button:nth-child(1)")).click();

        String fullName = driver.findElement(By.xpath("//tr[2]/td[1]")).getText();
        Assertions.assertThat(fullName).isEqualTo("Jan Kowalski");
        String emailAddress = driver.findElement(By.xpath("//tr[2]/td[2]")).getText();
        Assertions.assertThat(emailAddress).isEqualTo("JanKowalski@gmail.com");
        String password = driver.findElement(By.xpath("//tr[2]/td[3]")).getText();
        Assertions.assertThat(password).isEqualTo("12345");
    }

    private void getChromeAddress() {
        driver.get("http://www.seleniumui.moderntester.pl/menu-item.php");
    }
}