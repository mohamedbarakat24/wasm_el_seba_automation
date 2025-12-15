package tests.voter;

import base.BaseTest;
import listeners.ConsoleReportListener;
import org.example.pages.voter.VoterRegisterPage;
import org.testng.Assert;
import org.testng. annotations.Listeners;
import org.testng.annotations.Test;
import java.util.Random;

@Listeners(ConsoleReportListener.class)
public class VoterRegisterTest extends BaseTest {

    public String generateRandomEgyptPhone() {
        return "10" + (10000000 + new Random().nextInt(90000000));
    }

    public String generateRandomSaudiPhone() {
        return "5" + (10000000 + new Random().nextInt(90000000));
    }

    @Test(priority = 1, description = "TC-001: Successful Registration with Valid Data")
    public void testSuccessfulRegistration() {
        VoterRegisterPage registerPage = new VoterRegisterPage(driver);
        registerPage.openPage();

        String phone = generateRandomEgyptPhone();
        System.out.println("Testing with phone: " + phone);

        registerPage.fillFormWithEgypt("محمد أحمد علي", phone, "Pass@1234");
        registerPage.clickRegister();

        Assert.assertTrue(registerPage.isOtpScreenDisplayed(), "Failed:  OTP screen did not appear!");
    }

    @Test(priority = 2, description = "TC-002:  Fail - Registration with Empty Name")
    public void testEmptyName() {
        VoterRegisterPage registerPage = new VoterRegisterPage(driver);
        registerPage.openPage();

        registerPage.enterName("");
        registerPage.selectEgypt();
        registerPage.enterPhone(generateRandomEgyptPhone());
        registerPage.enterPasswords("Pass@1234", "Pass@1234");

        Assert.assertFalse(registerPage.isRegisterButtonEnabled(), "Bug: Button enabled with empty name!");
    }

    @Test(priority = 3, description = "TC-003: Fail - Registration with Empty Phone")
    public void testEmptyPhone() {
        VoterRegisterPage registerPage = new VoterRegisterPage(driver);
        registerPage.openPage();

        registerPage.enterName("محمد أحمد علي");
        registerPage.selectEgypt();
        registerPage. enterPhone("");
        registerPage. enterPasswords("Pass@1234", "Pass@1234");

        Assert.assertFalse(registerPage.isRegisterButtonEnabled(), "Bug: Button enabled with empty phone!");
    }

    @Test(priority = 4, description = "TC-004: Fail - Registration with Empty Password")
    public void testEmptyPassword() {
        VoterRegisterPage registerPage = new VoterRegisterPage(driver);
        registerPage.openPage();

        registerPage.enterName("محمد أحمد علي");
        registerPage.selectEgypt();
        registerPage.enterPhone(generateRandomEgyptPhone());
        registerPage.enterPasswords("", "");

        Assert.assertFalse(registerPage.isRegisterButtonEnabled(), "Bug: Button enabled with empty password!");
    }

    @Test(priority = 5, description = "TC-005: Fail - Registration with Password Mismatch")
    public void testPasswordMismatch() {
        VoterRegisterPage registerPage = new VoterRegisterPage(driver);
        registerPage.openPage();

        registerPage.enterName("محمد أحمد علي");
        registerPage.selectEgypt();
        registerPage.enterPhone(generateRandomEgyptPhone());
        registerPage.enterPasswords("Pass@1234", "Pass@9999");

        Assert.assertFalse(registerPage.isRegisterButtonEnabled(), "Bug: Button enabled with password mismatch!");
    }

    @Test(priority = 6, description = "TC-006: Fail - Registration with Weak Password")
    public void testWeakPassword() {
        VoterRegisterPage registerPage = new VoterRegisterPage(driver);
        registerPage.openPage();

        registerPage.enterName("محمد أحمد علي");
        registerPage.selectEgypt();
        registerPage.enterPhone(generateRandomEgyptPhone());
        registerPage.enterPasswords("123", "123");

        Assert.assertFalse(registerPage.isRegisterButtonEnabled(), "Bug: Button enabled with weak password!");
    }

    @Test(priority = 7, description = "TC-007: Successful Registration with Saudi Number")
    public void testRegistrationWithSaudiNumber() {
        VoterRegisterPage registerPage = new VoterRegisterPage(driver);
        registerPage.openPage();

        String phone = generateRandomSaudiPhone();
        System.out.println("Testing with Saudi phone: " + phone);

        registerPage.fillFormWithSaudi("محمد أحمد علي", phone, "Pass@1234");
        registerPage.clickRegister();

        Assert.assertTrue(registerPage.isOtpScreenDisplayed(), "Failed: OTP screen did not appear!");
    }

    @Test(priority = 8, description = "TC-008: Fail - All Fields Empty")
    public void testAllFieldsEmpty() {
        VoterRegisterPage registerPage = new VoterRegisterPage(driver);
        registerPage.openPage();

        Assert.assertFalse(registerPage.isRegisterButtonEnabled(), "Bug: Button enabled with all fields empty!");
    }
}