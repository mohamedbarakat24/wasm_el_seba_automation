package org.example.locators.voter;

import org. openqa.selenium.By;

public class VoterLoginLocators {

    public static final By COUNTRY_DROPDOWN_BTN = By.cssSelector("button.dropdown-toggle");
    public static final By COUNTRY_EGYPT = By.xpath("//span[@class='country-dial' and text()='+20']/parent::a");
    public static final By COUNTRY_SAUDI = By.xpath("//span[@class='country-dial' and text()='+966']/parent::a");

    public static final By PHONE_INPUT = By.cssSelector("input[formcontrolname='username']");

    public static final By PASSWORD_INPUT = By. cssSelector("input[formcontrolname='password']");

    public static final By LOGIN_BUTTON = By.xpath("//button[@type='submit' and contains(text(),'تسجيل الدخول')]");

    public static final By ERROR_ALERT = By.cssSelector("div. alert.alert-danger");

    public static final By LOGOUT_BUTTON = By.xpath("//button[contains(text(),'تسجيل الخروج')] | //a[contains(text(),'تسجيل الخروج')]");
}