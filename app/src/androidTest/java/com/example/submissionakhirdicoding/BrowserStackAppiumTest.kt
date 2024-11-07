package com.example.submissionakhirdicoding
import io.appium.java_client.android.AndroidDriver
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL

class BrowserStackAppiumTest {

    private lateinit var driver: AndroidDriver
    @Before
    fun setUp() {
        val caps = DesiredCapabilities()
        caps.setCapability("platformName", "Android")
        caps.setCapability("deviceName", "Samsung Galaxy S23")
        caps.setCapability("automationName", "UiAutomator2")
        caps.setCapability("app", "bs://aff8f518e13c120a4aa3b75d99a4abc6b3ded25f")

        // Credential dari environment variable
        caps.setCapability("browserstack.user", System.getenv("BROWSERSTACK_USERNAME"))
        caps.setCapability("browserstack.key", System.getenv("BROWSERSTACK_ACCESS_KEY"))

         driver = AndroidDriver(URL("https://hub-cloud.browserstack.com/wd/hub"), caps)
    }

    @Test
    fun testShareButton() {
        val shareButton = driver.findElement(By.id("com.example.submissionakhirdicoding:id/action_share"))
        assert(shareButton.isEnabled) { "Share button is not clickable!" }
    }

    @After
    fun tearDown() {
        driver.quit()
    }
}
