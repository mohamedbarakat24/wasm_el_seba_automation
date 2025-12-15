package org.example.pages.voter;

import org.example.constants.FrameworkConstants;
import org.example.locators.voter.VoterRegisterLocators;
import org.openqa. selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa. selenium.WebElement;
import org.openqa.selenium.support. ui.ExpectedConditions;
import org. openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class VoterRegisterPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public VoterRegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openPage() {
        driver.get(FrameworkConstants.VOTER_REGISTER_URL);
        try { Thread.sleep(2000); } catch (Exception e) {}
    }

    public void enterName(String name) {
        try {
            WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(VoterRegisterLocators.NAME_INPUT));
            nameInput.clear();
            nameInput.sendKeys(name);
        } catch (Exception e) {
            System.out.println("Error entering name: " + e.getMessage());
        }
    }

    public void clickCountryDropdown() {
        try {
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(VoterRegisterLocators. COUNTRY_DROPDOWN_BTN));
            dropdown.click();
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("Error clicking dropdown: " + e.getMessage());
        }
    }

    public void selectEgypt() {
        try {
            clickCountryDropdown();
            WebElement egypt = wait.until(ExpectedConditions.elementToBeClickable(VoterRegisterLocators.COUNTRY_EGYPT));
            egypt.click();
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("Error selecting Egypt: " + e.getMessage());
        }
    }

    public void selectSaudiArabia() {
        try {
            clickCountryDropdown();
            WebElement saudi = wait. until(ExpectedConditions.elementToBeClickable(VoterRegisterLocators.COUNTRY_SAUDI));
            saudi.click();
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("Error selecting Saudi:  " + e.getMessage());
        }
    }

    public void enterPhone(String phone) {
        try {
            WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(VoterRegisterLocators.PHONE_INPUT));
            phoneInput.clear();
            phoneInput.sendKeys(phone);
        } catch (Exception e) {
            System.out. println("Error entering phone: " + e.getMessage());
        }
    }

    public void enterPassword(String password) {
        try {
            WebElement passInput = wait.until(ExpectedConditions.visibilityOfElementLocated(VoterRegisterLocators.PASSWORD_INPUT));
            passInput.clear();
            passInput.sendKeys(password);
        } catch (Exception e) {
            System.out.println("Error entering password: " + e.getMessage());
        }
    }

    public void enterConfirmPassword(String password) {
        try {
            WebElement confirmInput = wait.until(ExpectedConditions. visibilityOfElementLocated(VoterRegisterLocators. CONFIRM_PASSWORD_INPUT));
            confirmInput.clear();
            confirmInput.sendKeys(password);
        } catch (Exception e) {
            System.out.println("Error entering confirm password: " + e.getMessage());
        }
    }

    public void enterPasswords(String password, String confirmPassword) {
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
    }

    public void clickRegister() {
        try {
            WebElement button = driver.findElement(VoterRegisterLocators.REGISTER_BUTTON);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);
            Thread.sleep(500);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
            Thread. sleep(3000);
        } catch (Exception e) {
            System.out.println("Error clicking register: " + e.getMessage());
        }
    }

    public boolean isRegisterButtonEnabled() {
        try {
            WebElement button = driver.findElement(VoterRegisterLocators. REGISTER_BUTTON);
            return button.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isOtpScreenDisplayed() {
        try {
            Thread.sleep(3000);
            WebElement otpModal = driver.findElement(VoterRegisterLocators.OTP_MODAL);
            return otpModal.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasErrorMessage() {
        try {
            Thread.sleep(1000);
            WebElement error = driver.findElement(VoterRegisterLocators.ERROR_ALERT);
            return error.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void fillFormWithEgypt(String name, String phone, String password) {
        enterName(name);
        selectEgypt();
        enterPhone(phone);
        enterPasswords(password, password);
    }

    public void fillFormWithSaudi(String name, String phone, String password) {
        enterName(name);
        selectSaudiArabia();
        enterPhone(phone);
        enterPasswords(password, password);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}