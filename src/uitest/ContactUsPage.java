import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Constructor;

public class ContactUsPage {

    private final WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = new ChromeDriver();
    }

    public void goToContactUsPage() {
        driver.get("https://automationexercise.com/contact_us");
    }

    public  void fillInTheForm() {
        WebElement name = driver
                .findElement(By.cssSelector("#contact-us-form > div:nth-child(2) > input"));
        name.sendKeys("Rut");

        WebElement email = driver
                .findElement(By.cssSelector("#contact-us-form > div:nth-child(3) > input"));
        email.sendKeys("test@gmail.com");

        WebElement subject = driver
                .findElement(By.cssSelector("#contact-us-form > div:nth-child(4) > input"));
        subject.sendKeys("Something");

        WebElement message = driver
                .findElement(By.cssSelector("#message"));
        message.sendKeys("xxx");
    }

    public void clickSubmitButton() {
        WebElement submit = driver.findElement(By.cssSelector("#contact-us-form > div:nth-child(7) > input"));
        submit.click();
    }

    public void waitForTheAlert() {
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void assertSuccessMessage() {
        WebElement successful = driver.findElement(By.cssSelector("#contact-page > div.row > div.col-sm-8 > div > div.status.alert.alert-success"));
        Assert.assertEquals("Success! Your details have been submitted successfully.", successful.getText());

    }
}
