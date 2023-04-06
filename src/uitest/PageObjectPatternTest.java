import org.junit.Test;

public class PageObjectPatternTest extends AbstractTest {

    @Test
    public void testContactUsForm() {
        ContactUsPage contactUs = new ContactUsPage(driver);
        contactUs.goToContactUsPage();
        contactUs.fillInTheForm();
        contactUs.clickSubmitButton();
        contactUs.waitForTheAlert();
        contactUs.acceptAlert();
        contactUs.assertSuccessMessage();
    }
}
