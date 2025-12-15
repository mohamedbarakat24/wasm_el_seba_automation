package tests.mushark;

import base.BaseTest;
import listeners.ConsoleReportListener;
import org.example.constants.AccountData;
import org.example.pages.mushark.MusharkLoginPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ConsoleReportListener.class)
public class MusharkLoginTest extends BaseTest {

    /// TC-001: Successful Login
    @Test(description = "TC-001 Successful Login with Valid Credentials")
    public void validLoginTest() {
        MusharkLoginPage loginPage = new MusharkLoginPage(driver);
        loginPage.openPage();

        loginPage.login(AccountData.VALID_EMAIL, AccountData.VALID_PASSWORD);

        Assert.assertFalse(driver.getCurrentUrl().contains("Login"), "User should be redirected to dashboard");
    }

    /// TC-002: Incorrect Password
    @Test(description = "TC-002 Login with Incorrect Password")
    public void invalidPasswordTest() {
        MusharkLoginPage loginPage = new MusharkLoginPage(driver);
        loginPage.openPage();

        /// Correct Email, WRONG Password
        loginPage.login(AccountData.VALID_EMAIL, AccountData.WRONG_PASSWORD);

        String error = loginPage.getToastMessage();
        Assert.assertTrue(error.contains("خطأ في أسم المستخدم أو كلمة السر") || error.contains("خطأ"),
                "Toast message did not match. Got: " + error);
    }

    /// TC-003: Empty Fields
    @Test(description = "TC-003 Login with Empty Fields")
    public void emptyFieldsTest() {
        MusharkLoginPage loginPage = new MusharkLoginPage(driver);
        loginPage.openPage();

        boolean isEnabled = loginPage.isLoginButtonEnabled();

        Assert.assertFalse(isEnabled, "Login Button should be DISABLED (not clickable) when fields are empty");

    }

    /// TC-004: Unregistered Phone/Email
    @Test(description = "TC-004 Login with Unregistered Account")
    public void unregisteredUserTest() {
        MusharkLoginPage loginPage = new MusharkLoginPage(driver);
        loginPage.openPage();
        loginPage.login("notexist@test.com", "Some@Pass123");

        String error = loginPage.getToastMessage();
        Assert.assertTrue(error.contains("خطأ في أسم المستخدم أو كلمة السر") || error.contains("خطأ"),
                "Expected 'Not Registered' message but got: " + error);
    }



    /// TC-005: Empty Password Only
    @Test(description = "TC-005 Empty Password Only - Button should be disabled")
    public void emptyPasswordTest() {
        MusharkLoginPage loginPage = new MusharkLoginPage(driver);
        loginPage.openPage();

        loginPage.fillCredentials(AccountData.VALID_EMAIL, "");
        Assert.assertFalse(loginPage.isLoginButtonEnabled(), "Login button should be DISABLED when password is empty");
    }

    /// TC-006: Empty Email Only
    @Test(description = "TC-006 Empty Email Only - Button should be disabled")
    public void emptyPhoneTest() {
        MusharkLoginPage loginPage = new MusharkLoginPage(driver);
        loginPage.openPage();

        loginPage.fillCredentials("", AccountData.VALID_PASSWORD);
        Assert.assertFalse(loginPage.isLoginButtonEnabled(), "Login button should be DISABLED when email is empty");
    }

    /// TC-007: Show / Hide Password Functionality
    @Test(description = "TC-007 Show/Hide Password Functionality")
    public void showHidePasswordTest() {
        MusharkLoginPage loginPage = new MusharkLoginPage(driver);
        loginPage.openPage();

        loginPage.fillCredentials(AccountData.VALID_EMAIL, "MySecretPass");
        Assert.assertEquals(loginPage.getPasswordFieldType(), "password", "Initially password should be masked");

        loginPage.clickEyeIcon();
        Assert.assertEquals(loginPage.getPasswordFieldType(), "text", "Password should be visible after click");
    }

    /// TC-008: Password Masking Check
    @Test(description = "TC-008 Password Masking")
    public void passwordMaskingTest() {
        MusharkLoginPage loginPage = new MusharkLoginPage(driver);
        loginPage.openPage();
        Assert.assertEquals(loginPage.getPasswordFieldType(), "password", "Password field must be of type 'password' for masking");
    }

    /// TC-009: HTTPS Check
    @Test(description = "TC-009 Verify Application is over HTTPS")
    public void httpsSecurityTest() {
        MusharkLoginPage loginPage = new MusharkLoginPage(driver);
        loginPage.openPage();

        Assert.assertTrue(driver.getCurrentUrl().startsWith("https"), "URL must start with https:// for security");
    }

    /// TC-010: Trim Leading/Trailing Spaces
    @Test(description = "TC-010 Login with spaces in email should work")
    public void trimSpacesTest() {
        MusharkLoginPage loginPage = new MusharkLoginPage(driver);
        loginPage.openPage();

        String emailWithSpaces = " " + AccountData.VALID_EMAIL + " ";

        loginPage.login(emailWithSpaces, AccountData.VALID_PASSWORD);
        Assert.assertFalse(driver.getCurrentUrl().contains("Login"), "System should auto-trim spaces and login successfully");
    }


    /// TC-011: Forgot Password Redirection
    @Test(description = "TC-011 Click Forgot Password redirects correctly")
    public void forgotPasswordTest() {
        MusharkLoginPage loginPage = new MusharkLoginPage(driver);
        loginPage.openPage();

        loginPage.clickForgotPassword();

        new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(5))
                .until(org.openqa.selenium.support.ui.ExpectedConditions.urlContains("ForgetPassword"));

        Assert.assertTrue(driver.getCurrentUrl().contains("ForgetPassword") || driver.getCurrentUrl().contains("Recovery"),
                "User should be redirected to Password Recovery page");
    }


    /// TC-012: Browser Back Button Behavior
    @Test(description = "TC-012 Back button after login should not logout user")
    public void backButtonBehaviorTest() {
        MusharkLoginPage loginPage = new MusharkLoginPage(driver);
        loginPage.openPage();

        loginPage.login(AccountData.VALID_EMAIL, AccountData.VALID_PASSWORD);

        driver.navigate().back();
        Assert.assertFalse(loginPage.isLoginButtonEnabled(), "Should not see active login form after pressing back when logged in");
    }
}