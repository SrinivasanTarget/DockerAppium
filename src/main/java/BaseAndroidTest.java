/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseAndroidTest {
    static AndroidDriver driver;

    /**
     * initialization.
     */
    @BeforeClass public static void beforeClass() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,".MainActivity");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.vodqareactnative");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 700000);
        capabilities.setCapability("clearSystemFiles",true);
        capabilities.setCapability(MobileCapabilityType.APP, "/opt/VodQA.apk");
        driver = new AndroidDriver(new URL("http://192.168.99.100:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * finishing.
     */
    @AfterClass public static void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}
