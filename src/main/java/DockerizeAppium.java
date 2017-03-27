import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DockerizeAppium extends BaseAndroidTest {

    @Test
    public void horizontalSwipingTest() throws Exception {
        login();
        driver.findElementByAccessibilityId("slider1").click();
        MobileElement slider = (MobileElement) driver.findElementByAccessibilityId("slider");
        Dimension size = slider.getSize();

        TouchAction swipe = new TouchAction(driver).press(slider, 0, size.height / 2).waitAction(2000)
            .moveTo(slider, size.width / 2, size.height / 2).release();
        swipe.perform();
    }

    private void login() {
        new WebDriverWait(driver,30).until(ExpectedConditions.
            elementToBeClickable(MobileBy.AccessibilityId("login"))).click();
    }
}
