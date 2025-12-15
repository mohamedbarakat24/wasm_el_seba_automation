package org.example.pages.mushark;

import org.example.constants.FrameworkConstants;
import org.example.locators.mushark.MusharkLoginLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MusharkLoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MusharkLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.WAIT_TIMEOUT));
    }

    public void openPage() {
        driver.get(FrameworkConstants.URL_MUSHARK_LOGIN);
    }

    public void login(String email, String password) {
        driver.findElement(MusharkLoginLocators.EMAIL_FIELD).clear();
        driver.findElement(MusharkLoginLocators.EMAIL_FIELD).sendKeys(email);

        driver.findElement(MusharkLoginLocators.PASSWORD_FIELD).clear();
        driver.findElement(MusharkLoginLocators.PASSWORD_FIELD).sendKeys(password);

        driver.findElement(MusharkLoginLocators.LOGIN_BUTTON).click();
    }

    public void fillCredentials(String email, String password) {
        driver.findElement(MusharkLoginLocators.EMAIL_FIELD).clear();
        driver.findElement(MusharkLoginLocators.EMAIL_FIELD).sendKeys(email);

        driver.findElement(MusharkLoginLocators.PASSWORD_FIELD).clear();
        driver.findElement(MusharkLoginLocators.PASSWORD_FIELD).sendKeys(password);
    }

    public void toggleShowPassword() {
        driver.findElement(MusharkLoginLocators.EYE_ICON).click();
    }

    public String getEmailFieldValidation() {
        return driver.findElement(MusharkLoginLocators.EMAIL_ERROR_TEXT).getText();
    }

    public String getToastMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MusharkLoginLocators.TOAST_ERROR_MESSAGE));
        return driver.findElement(MusharkLoginLocators.TOAST_ERROR_MESSAGE).getText();
    }

    public boolean isLoginButtonEnabled() {
        try {
            return driver.findElement(MusharkLoginLocators.LOGIN_BUTTON).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickEyeIcon() {
        driver.findElement(MusharkLoginLocators.EYE_ICON).click();
    }

    public String getPasswordFieldType() {
        return driver.findElement(MusharkLoginLocators.PASSWORD_FIELD).getAttribute("type");
    }

    public String getPasswordValidationText() {
        return driver.findElement(MusharkLoginLocators.ERROR_PASS_TEXT).getText();
    }

    public void clickForgotPassword() {
        driver.findElement(MusharkLoginLocators.FORGOT_PASSWORD_LINK).click();
    }
}