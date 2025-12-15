package org.example.locators.mushark;

import org.openqa.selenium.By;

public class MusharkSignupLocators {

    // Inputs
    public static final By FULL_NAME_FIELD = By.xpath("//*[@id=\"next\"]/div/div/div[1]/form/div[3]/div/input");
    public static final By EMAIL_FIELD = By.xpath("//*[@id=\"next\"]/div/div/div[1]/form/div[4]/div/input");
    public static final By PHONE_FIELD = By.xpath("//*[@id=\"next\"]/div/div/div[1]/form/div[5]/div/div/input");
    public static final By ID_NUMBER_FIELD = By.xpath("//*[@id=\"next\"]/div/div/div[1]/form/div[6]/div/input");

    public static final By COUNTRY_DROPDOWN = By.xpath("//*[@id=\"countrySelect\"]");
    public static final By COUNTRY_OPTION_SAUDI = By.xpath("//*[@id=\"countrySelect\"]/option[2]");

    public static final By GENDER_DROPDOWN = By.xpath("//*[@id=\"next\"]/div/div/div[1]/form/div[8]/div/select");
    public static final By GENDER_OPTION_MALE = By.xpath("//*[@id=\"next\"]/div/div/div[1]/form/div[8]/div/select/option[1]");



    public static final By TRACKS_LABEL = By.xpath("//label[contains(text(),'اختر المسارات')]");
    public static final By TRACKS_DROPDOWN = By.xpath("//div[@class='multi-select-dropdown']");
    public static final By TRACK_OPTION_DRAMA = By.xpath("//*[@id=\"next\"]/div/div/div[1]/form/div[13]/div/div[2]/div[2]/div[1]/div[1]/div/input");




    public static final By PASSWORD_FIELD = By.xpath("//*[@id=\"next\"]/div/div/div[1]/form/div[9]/div/div/input");
    public static final By CONFIRM_PASS_FIELD = By.xpath("//*[@id=\"next\"]/div/div/div[1]/form/div[10]/div/div/input");

   // public static final By TEAM_INFO_FIELD = By.xpath("//*[@id=\"next\"]/div/div/div[1]/form/div[12]/div/textarea");
    public static final By TEAM_INFO_FIELD = By.xpath("//label[contains(text(),'معلومات الفريق')]/following::textarea[1]");

    public static final By TERMS_CHECKBOX = By.xpath("//*[@id=\"termsCheckbox\"]");

    public static final By SUBMIT_BUTTON = By.xpath("//button[contains(text(),'تسجيل')]");

    public static final By OTP_SCREEN = By.cssSelector(".otp-modal");

    public static final By OTP_HEADER = By.xpath("//*[contains(text(),'التحقق من الرمز')]");

    public static final By VALIDATION_ERROR_MSG = By.cssSelector(".alert.alert-danger");
    public static final By PASSWORD_ERROR_MSG = By.xpath("//div[contains(@class,'alert-danger') and contains(text(),'8 أحرف')]");

    public static final By GENERIC_ALERT = By.cssSelector(".alert.alert-danger");
    public static final By PASS_MISMATCH_ERR = By.xpath("//div[contains(@class,'alert-danger') and contains(text(),'غير متطابقين')]");
    public static final By TRACK_REQUIRED_ERR = By.xpath("//div[contains(@class,'alert-danger') and contains(text(),'مسار واحد')]");
    public static final By ERROR_ALERT = By.cssSelector("div.alert.alert-danger");

}