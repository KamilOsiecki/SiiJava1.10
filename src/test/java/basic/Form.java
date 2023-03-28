package basic;

import baseTest.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;

public class Form extends BaseTest {

    @Test()
    @DisplayName("Form test")
    @Tag("")
    public void shouldSendFormWithSuccess() {

        Random random = new Random();
        getChromeAddress();

        driver.findElement(By.cssSelector("#inputFirstName3")).sendKeys("Jan");
        driver.findElement(By.cssSelector("#inputLastName3")).sendKeys("Kowalski");
        driver.findElement(By.cssSelector("#inputEmail3")).sendKeys("jan_kowalski@gmail.com");

        List<WebElement> gridRadiosSex = driver.findElements(By.cssSelector("[name='gridRadiosSex']"));
        int sexIndex = random.nextInt(gridRadiosSex.size());
        gridRadiosSex.get(sexIndex).click();

        driver.findElement(By.cssSelector("#inputAge3")).sendKeys("33");

        List<WebElement> yearOfExperience = driver.findElements(By.cssSelector("[name='gridRadiosExperience']"));
        int experienceIndex = random.nextInt(yearOfExperience.size());
        yearOfExperience.get(experienceIndex).click();

        driver.findElement(By.cssSelector("[for='gridCheckAutomationTester']")).click();

        Select continent = new Select(driver.findElement(By.cssSelector("#selectContinents")));
        int continentIndex = random.nextInt(1, continent.getOptions().size());
        continent.getOptions().get(continentIndex).click();

        Select commands = new Select(driver.findElement(By.cssSelector("#selectSeleniumCommands")));
        commands.selectByValue("switch-commands");
        commands.selectByValue("wait-commands");

        File file = new File("src/main/resources/file.txt");
        driver.findElement(By.cssSelector("#chooseFile")).sendKeys(file.getAbsolutePath());

        driver.findElement(By.cssSelector(".btn-primary")).click();

        String resultMessageOfSendForm = driver.findElement(By.cssSelector("#validator-message")).getText();
        Assertions.assertThat(resultMessageOfSendForm).isEqualTo("Form send with success");
        Assertions.assertThat(IsDisplayed(By.cssSelector("#validator-message")));
    }

    private void getChromeAddress() {
        driver.get("http://www.seleniumui.moderntester.pl/form.php");
    }
}