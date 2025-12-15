package org.example.pages.mushark;

import org.example.constants.FrameworkConstants;
import org.example.locators.mushark.MusharkSignupLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MusharkSignupPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public MusharkSignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.WAIT_TIMEOUT));
    }

    public void openPage() {
        driver.get(FrameworkConstants.URL_MUSHARK_REGISTER);
    }

    // Helper method to scroll
    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        try { Thread.sleep(200); } catch (InterruptedException e) {}
    }

    public void fillFullName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MusharkSignupLocators.FULL_NAME_FIELD));
        driver.findElement(MusharkSignupLocators.FULL_NAME_FIELD).sendKeys(name);
    }

    public void fillEmail(String email) {
        driver.findElement(MusharkSignupLocators.EMAIL_FIELD).sendKeys(email);
    }

    public void fillPhone(String phone) {
        driver.findElement(MusharkSignupLocators.PHONE_FIELD).sendKeys(phone);
    }

    public void selectCountrySaudi() {
        WebElement dropdown = driver.findElement(MusharkSignupLocators.COUNTRY_DROPDOWN);
        scrollToElement(dropdown);
        Select select = new Select(dropdown);
        select.selectByIndex(1);
    }

    public void fillID(String id) {
        driver.findElement(MusharkSignupLocators.ID_NUMBER_FIELD).sendKeys(id);
    }

    public void selectGender() {
        WebElement dropdown = driver.findElement(MusharkSignupLocators.GENDER_DROPDOWN);
        scrollToElement(dropdown);
        Select select = new Select(dropdown);
        select.selectByIndex(1);
    }

    public void fillPasswords(String pass, String confirmPass) {
        WebElement passField = driver.findElement(MusharkSignupLocators.PASSWORD_FIELD);
        scrollToElement(passField);
        passField.sendKeys(pass);
        driver.findElement(MusharkSignupLocators.CONFIRM_PASS_FIELD).sendKeys(confirmPass);
    }

    public void fillTeamInfo(String info) {
        WebElement element = driver.findElement(MusharkSignupLocators.TEAM_INFO_FIELD);
        scrollToElement(element);
        element.sendKeys(info);
    }
    public void selectTrack() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MusharkSignupLocators.TRACKS_LABEL));
        WebElement dropdownBox = driver.findElement(MusharkSignupLocators.TRACKS_DROPDOWN);
        scrollToElement(dropdownBox);

        try {
            dropdownBox.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdownBox);
        }
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(MusharkSignupLocators.TRACK_OPTION_DRAMA));
        option.click();
        driver.findElement(By.tagName("body")).click();
    }

    public void acceptTerms() {
        WebElement checkbox = driver.findElement(MusharkSignupLocators.TERMS_CHECKBOX);
        scrollToElement(checkbox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
    }


    public void clickSubmit() {
        try {
            WebElement button = driver.findElement(MusharkSignupLocators.SUBMIT_BUTTON);

            // Scroll to button
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);
            Thread.sleep(1000); // Wait for scroll

            // Debug
            System.out.println("🔘 Submit Button found:  " + button.isDisplayed());
            System.out.println("🔘 Submit Button enabled: " + button.isEnabled());
            System.out.println("🔘 Submit Button text: " + button.getText());

            // Click using JavaScript
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
            System.out.println("✅ Submit Button clicked via JavaScript!");

            // Wait for response
            Thread.sleep(3000); // Give server time to respond

        } catch (Exception e) {
            System.out.println("❌ Failed to click Submit:  " + e.getMessage());
            e.printStackTrace();
        }
    }


    public void fillFullForm(String name, String email, String phone, String id, String pass, String teamInfo) {
        fillFullName(name);
        fillEmail(email);
        fillPhone(phone);
        selectCountrySaudi();
        fillID(id);
        selectGender();
        fillPasswords(pass, pass);
        fillTeamInfo(teamInfo);
        selectTrack();
        acceptTerms();
    }
    public boolean isOtpScreenDisplayed() {
        try {
            // Wait for OTP modal
            wait.until(ExpectedConditions. visibilityOfElementLocated(MusharkSignupLocators. OTP_SCREEN));
            System.out.println("✅ OTP Screen FOUND!");
            return true;
        } catch (Exception e) {
            System.out.println("❌ OTP Screen NOT found.");

            // Debug: Check if there are any error messages on the page
            try {
                java.util.List<WebElement> errors = driver.findElements(MusharkSignupLocators.ERROR_ALERT);
                if (!errors.isEmpty()) {
                    System.out.println("🔴 Found " + errors.size() + " error alert(s):");
                    for (WebElement err : errors) {
                        System.out.println("   -> " + err.getText());
                    }
                } else {
                    System.out.println("⚠️ No error alerts found.  Form might not have submitted.");
                }
            } catch (Exception ex) {
                // Ignore
            }

            // Debug: Print current URL
            System.out.println("📍 Current URL: " + driver.getCurrentUrl());

            return false;
        }
    }

    public boolean isSubmitButtonEnabled() {
        try {
            WebElement button = driver.findElement(MusharkSignupLocators. SUBMIT_BUTTON);
            boolean isEnabled = button.isEnabled();
            System.out.println("🔘 Submit Button enabled: " + isEnabled);
            return isEnabled;
        } catch (Exception e) {
            System.out.println("❌ Submit Button not found");
            return false;
        }
    }

    public boolean isPasswordMismatchErrorDisplayed() {
        try {
            // Wait up to 5 seconds specifically for the mismatch text
            wait.until(ExpectedConditions.visibilityOfElementLocated(MusharkSignupLocators.PASS_MISMATCH_ERR));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isTrackErrorDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(MusharkSignupLocators.TRACK_REQUIRED_ERR));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Keep generic for others
    public boolean hasValidationErrors() {
        try {
            Thread.sleep(500); // Small stability wait
            return !driver.findElements(MusharkSignupLocators.GENERIC_ALERT).isEmpty();
        } catch (Exception e) { return false; }
    }


    public boolean hasAnyErrorAlert() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            shortWait.until(ExpectedConditions.visibilityOfElementLocated(MusharkSignupLocators.ERROR_ALERT));

            WebElement error = driver.findElement(MusharkSignupLocators.ERROR_ALERT);
            System.out.println("✅ Error Alert Found: " + error.getText());
            return true;
        } catch (Exception e) {
            System.out.println("❌ No Error Alert Found");
            return false;
        }
    }
}