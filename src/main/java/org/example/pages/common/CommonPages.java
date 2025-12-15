package org.example. pages.common;

import org. example.constants.FrameworkConstants;
import org.example.locators.common.CommonLocators;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa. selenium.WebElement;
import org.openqa.selenium.support. ui.ExpectedConditions;
import org. openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

public class CommonPages {
    private WebDriver driver;
    private WebDriverWait wait;

    public CommonPages(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openHomePage() {
        driver.get(FrameworkConstants.HOME_URL);
    }

    public void openTracksPage() {
        driver.get(FrameworkConstants.URL_TRACKS);
    }

    public void openSubjectsPage() {
        driver.get(FrameworkConstants.URL_SUBJECTS);
    }

    public void openNewsPage() {
        driver.get(FrameworkConstants.URL_NEWS);
    }

    public void openStepsPage() {
        driver.get(FrameworkConstants.URL_STEPS);
    }

    public void openTermsPage() {
        driver.get(FrameworkConstants.URL_TERMS);
    }

    public void openAboutPage() {
        driver.get(FrameworkConstants.URL_ABOUT);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isPageLoaded(String expectedUrl) {
        try {
            Thread.sleep(2000);
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Expected:  " + expectedUrl);
            System.out.println("Current: " + currentUrl);
            return currentUrl.equalsIgnoreCase(expectedUrl);
        } catch (Exception e) {
            return false;
        }
    }

    public void scrollToFooter() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document. body.scrollHeight);");
        try { Thread.sleep(1000); } catch (Exception e) {}
    }

    public boolean isPhoneLinkVisible() {
        try {
            WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(CommonLocators.PHONE_LINK));
            return link.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isWhatsAppLinkVisible() {
        try {
            WebElement link = wait.until(ExpectedConditions. visibilityOfElementLocated(CommonLocators.WHATSAPP_LINK));
            return link.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getPhoneLinkHref() {
        try {
            WebElement link = driver.findElement(CommonLocators. PHONE_LINK);
            return link.getAttribute("href");
        } catch (Exception e) {
            return "";
        }
    }

    public String getWhatsAppLinkHref() {
        try {
            WebElement link = driver.findElement(CommonLocators.WHATSAPP_LINK);
            return link.getAttribute("href");
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isSocialLinkVisible(String platform) {
        try {
            WebElement link = null;
            switch (platform.toLowerCase()) {
                case "facebook":  link = driver.findElement(CommonLocators.FACEBOOK_LINK); break;
                case "linkedin": link = driver.findElement(CommonLocators.LINKEDIN_LINK); break;
                case "tiktok": link = driver. findElement(CommonLocators. TIKTOK_LINK); break;
                case "snapchat": link = driver.findElement(CommonLocators.SNAPCHAT_LINK); break;
                case "instagram": link = driver. findElement(CommonLocators. INSTAGRAM_LINK); break;
                case "youtube": link = driver.findElement(CommonLocators. YOUTUBE_LINK); break;
                case "twitter": link = driver.findElement(CommonLocators.TWITTER_LINK); break;
            }
            return link != null && link.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Click social media link and verify new tab opens
    public boolean clickSocialLinkAndVerify(String platform, String expectedUrlPart) {
        try {
            scrollToFooter();
            Thread.sleep(1000);

            WebElement link = null;
            switch (platform. toLowerCase()) {
                case "facebook":  link = driver.findElement(CommonLocators.FACEBOOK_LINK); break;
                case "linkedin": link = driver.findElement(CommonLocators.LINKEDIN_LINK); break;
                case "tiktok": link = driver. findElement(CommonLocators. TIKTOK_LINK); break;
                case "snapchat": link = driver.findElement(CommonLocators.SNAPCHAT_LINK); break;
                case "instagram": link = driver. findElement(CommonLocators. INSTAGRAM_LINK); break;
                case "youtube": link = driver.findElement(CommonLocators. YOUTUBE_LINK); break;
                case "twitter": link = driver.findElement(CommonLocators.TWITTER_LINK); break;
            }

            if (link == null) {
                System.out.println("Link not found for:  " + platform);
                return false;
            }

            String originalWindow = driver.getWindowHandle();

            // Click using JavaScript
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
            Thread.sleep(3000);

            Set<String> allWindows = driver.getWindowHandles();
            for (String window : allWindows) {
                if (!window.equals(originalWindow)) {
                    driver.switchTo().window(window);
                    String newUrl = driver.getCurrentUrl();
                    System.out.println(platform + " URL: " + newUrl);

                    // Check if URL contains expected part
                    boolean result = newUrl.toLowerCase().contains(expectedUrlPart. toLowerCase());

                    driver.close();
                    driver. switchTo().window(originalWindow);
                    return result;
                }
            }

            System.out. println("No new window opened for: " + platform);
            return false;

        } catch (Exception e) {
            System.out.println("Error clicking " + platform + ": " + e.getMessage());
            return false;
        }
    }
}