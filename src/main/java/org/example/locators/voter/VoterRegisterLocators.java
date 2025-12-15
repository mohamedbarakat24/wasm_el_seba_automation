package org.example.locators.voter;

import org.openqa. selenium.By;

public class VoterRegisterLocators {

    // Name Input
    public static final By NAME_INPUT = By.cssSelector("input[formcontrolname='profileName']");

    // Phone Input
    public static final By PHONE_INPUT = By.cssSelector("input[formcontrolname='mobile']");

    // Country Code Dropdown - FIXED:  removed space
    public static final By COUNTRY_DROPDOWN_BTN = By.cssSelector("button.dropdown-toggle");
    public static final By COUNTRY_EGYPT = By.xpath("//span[@class='country-dial' and text()='+20']/parent::a");
    public static final By COUNTRY_SAUDI = By.xpath("//span[@class='country-dial' and text()='+966']/parent::a");

    // Password Inputs
    public static final By PASSWORD_INPUT = By. cssSelector("input[formcontrolname='password']");
    public static final By CONFIRM_PASSWORD_INPUT = By. cssSelector("input[formcontrolname='comfirmPassword']");

    // Submit Button
    public static final By REGISTER_BUTTON = By.xpath("//button[@type='submit' and contains(text(),'تسجيل')]");

    // Error Messages - FIXED: removed space
    public static final By ERROR_ALERT = By.cssSelector("div.alert.alert-danger");

    // OTP Screen - FIXED: removed space
    public static final By OTP_MODAL = By.cssSelector("div.otp-modal");
    public static final By OTP_TITLE = By.cssSelector("h5.otp-title");
    public static final By OTP_INPUT = By.cssSelector("input.otp-input");
    public static final By OTP_CONFIRM_BTN = By.xpath("//button[contains(@class,'btn-primary') and contains(text(),'تأكيد')]");
    public static final By OTP_CANCEL_BTN = By.xpath("//button[contains(@class,'btn-secondary') and contains(text(),'إلغاء')]");
}