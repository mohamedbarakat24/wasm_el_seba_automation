// src/test/java/listeners/ScreenshotListener.java
package listeners;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import base.BaseTest;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScreenshotListener extends BaseTest implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            Path dest = Path.of("target/screenshots", result.getName() + ".png");
            Files.createDirectories(dest.getParent());
            Files.copy(src.toPath(), dest);
            // page source
            Files.writeString(Path.of("target/pagesource", result.getName() + ".html"), driver.getPageSource());
            System.out.println("Saved screenshot and page source for " + result.getName());
        } catch (Exception e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}