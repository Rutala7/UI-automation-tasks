import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FormTest extends AbstractTest {

    @Test
    public void testContactUsForm() {

        WebElement linkElement = driver.findElement(By.cssSelector("#username-error"));
        Assert.assertEquals("Strings are not the same", "Sorry, we don't recognize this email.", linkElement.getText());
    }

    @Test
    public void testCustomerServiceMessage() throws InterruptedException {

        driver.get("https://automationexercise.com/contact_us");

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

        WebElement submit = driver.findElement(By.cssSelector("#contact-us-form > div:nth-child(7) > input"));
        submit.click();

        Thread.sleep(5000);
        driver.switchTo().alert().accept();

        WebElement successful = driver.findElement(By.cssSelector("#contact-page > div.row > div.col-sm-8 > div > div.status.alert.alert-success"));
        Assert.assertEquals("Success! Your details have been submitted successfully.", successful.getText());

    }
}
