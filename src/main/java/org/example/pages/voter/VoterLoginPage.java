package org.example.pages. voter;

import org.example. constants.FrameworkConstants;
import org.example.locators. voter.VoterLoginLocators;
import org.openqa. selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa. selenium.WebElement;
import org.openqa.selenium.support. ui.ExpectedConditions;
import org. openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class VoterLoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public VoterLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openPage() {
        driver.get(FrameworkConstants. VOTER_LOGIN_URL);
        try { Thread.sleep(2000); } catch (Exception e) {}
    }

    public void clickCountryDropdown() {
        try {
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(VoterLoginLocators.COUNTRY_DROPDOWN_BTN));
            dropdown.click();
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("Error clicking dropdown: " + e.getMessage());
        }
    }

    public void selectEgypt() {
        try {
            clickCountryDropdown();
            WebElement egypt = wait.until(ExpectedConditions.elementToBeClickable(VoterLoginLocators.COUNTRY_EGYPT));
            egypt.click();
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("Error selecting Egypt: " + e.getMessage());
        }
    }

    public void selectSaudiArabia() {
        try {
            clickCountryDropdown();
            WebElement saudi = wait.until(ExpectedConditions.elementToBeClickable(VoterLoginLocators.COUNTRY_SAUDI));
            saudi.click();
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("Error selecting Saudi:  " + e.getMessage());
        }
    }

    public void enterPhone(String phone) {
        try {
            WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(VoterLoginLocators.PHONE_INPUT));
            phoneInput. clear();
            phoneInput.sendKeys(phone);
        } catch (Exception e) {
            System.out.println("Error entering phone:  " + e.getMessage());
        }
    }

    public void enterPassword(String password) {
        try {
            WebElement passInput = wait.until(ExpectedConditions.visibilityOfElementLocated(VoterLoginLocators.PASSWORD_INPUT));
            passInput.clear();
            passInput.sendKeys(password);
        } catch (Exception e) {
            System.out.println("Error entering password: " + e. getMessage());
        }
    }

    public void clickLogin() {
        try {
            WebElement button = driver.findElement(VoterLoginLocators.LOGIN_BUTTON);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);
            Thread.sleep(500);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error clicking login: " + e.getMessage());
        }
    }

    public boolean isLoginButtonEnabled() {
        try {
            WebElement button = driver.findElement(VoterLoginLocators. LOGIN_BUTTON);
            return button.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoginSuccessful() {
        try {
            Thread.sleep(2000);
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL after login: " + currentUrl);
            boolean urlChanged = ! currentUrl.contains("voterLogin");
            try {
                WebElement logout = driver.findElement(VoterLoginLocators.LOGOUT_BUTTON);
                return logout. isDisplayed();
            } catch (Exception e) {
                return urlChanged;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasErrorMessage() {
        try {
            Thread.sleep(1000);
            WebElement error = driver.findElement(VoterLoginLocators.ERROR_ALERT);
            return error.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void loginWithEgyptNumber(String phone, String password) {
        selectEgypt();
        enterPhone(phone);
        enterPassword(password);
        clickLogin();
    }

    public void loginWithSaudiNumber(String phone, String password) {
        selectSaudiArabia();
        enterPhone(phone);
        enterPassword(password);
        clickLogin();
    }
}