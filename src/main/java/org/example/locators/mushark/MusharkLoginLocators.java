package org.example.locators.mushark;

import org.openqa.selenium.By;

public class MusharkLoginLocators {

    // Inputs
    public static final By EMAIL_FIELD = By.xpath("//*[@id='login']/div/div/form/div[2]/div/div/input");
    public static final By PASSWORD_FIELD = By.xpath("//*[@id='login']/div/div/form/div[3]/div/div/input");

    // Buttons
    public static final By LOGIN_BUTTON = By.xpath("//*[@id='login']/div/div/form/div[5]/button");
    public static final By EYE_ICON = By.xpath("//*[@id='login']/div/div/form/div[3]/div/div/button");

    // ERROR MESSAGES
    public static final By EMAIL_ERROR_TEXT = By.xpath("//*[@id='login']/div/div/form/div[2]/div/div[2]/div");
    public static final By ERROR_PASS_TEXT = By.xpath("//*[@id='login']/div/div/form/div[3]/div/div[2]/div");
    public static final By TOAST_ERROR_MESSAGE = By.xpath("//*[@id='toast-container']/div/div[2]");

    public static final By FORGOT_PASSWORD_LINK = By.xpath("//*[@id=\"login\"]/div/div/form/div[4]/a");

}