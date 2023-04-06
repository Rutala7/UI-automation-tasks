import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectorTest extends AbstractTest {

    @Test
    public void testSignInText() {

        WebElement linkElement = driver.findElement(By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a"));
       // WebElement linkElement = driver.findElement(By.xpath("//a[@href='/login']"));

        Assert.assertEquals("The text is wrong.", "Signup / Login", linkElement.getText());
    }

    @Test
    public void testTshirtPrice() {

        List<WebElement> listOfItems = driver.findElements(By.cssSelector(".productinfo text-center"));

        for (WebElement element : listOfItems) {
            if ("GRAPHIC DESIGN MEN T SHIRT - BLUE".equals(element.findElement(By.tagName("p")).getText())) {
                Assert.assertTrue(element.findElement(By.tagName("h2")).getText().contains("1389"));
                break;
            }
        }
    }

    @Test
    public void testEmailText() {

        driver.get("https://automationexercise.com/contact_us");
        WebElement emailElement = driver.findElement(By.cssSelector("#contact-page > div.row > div.col-sm-4 > div > address > p:nth-child(3) > a > u"));

        Assert.assertEquals( "feedback@automationexercise.com", emailElement.getText());
        // Assert.assertTrue("feedback@automationexercise.com".equals(emailElement.getText()));
    }
}
