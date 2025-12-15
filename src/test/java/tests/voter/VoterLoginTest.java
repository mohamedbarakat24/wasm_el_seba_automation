package tests.voter;

import base.BaseTest;
import listeners.ConsoleReportListener;
import org.example.constants.AccountData;
import org. example.pages.voter.VoterLoginPage;
import org. testng.Assert;
import org.testng. annotations. Listeners;
import org.testng.annotations.Test;

@Listeners(ConsoleReportListener.class)
public class VoterLoginTest extends BaseTest {

    @Test(priority = 1, description = "TC-001:  Successful Login with Valid Credentials")
    public void testSuccessfulLogin() {
        VoterLoginPage loginPage = new VoterLoginPage(driver);
        loginPage. openPage();

        loginPage.loginWithEgyptNumber(AccountData.VOTER_PHONE, AccountData.VOTER_PASSWORD);

        Assert.assertTrue(loginPage.isLoginSuccessful(), "Failed:  Login was not successful!");
    }

    @Test(priority = 2, description = "TC-002:  Fail - Login with Invalid Phone Number")
    public void testInvalidPhone() {
        VoterLoginPage loginPage = new VoterLoginPage(driver);
        loginPage.openPage();

        loginPage.loginWithEgyptNumber(AccountData. INVALID_PHONE, AccountData. VOTER_PASSWORD);

        Assert.assertFalse(loginPage.isLoginSuccessful(), "Bug: Login succeeded with invalid phone!");
    }

    @Test(priority = 3, description = "TC-003: Fail - Login with Invalid Password")
    public void testInvalidPassword() {
        VoterLoginPage loginPage = new VoterLoginPage(driver);
        loginPage.openPage();

        loginPage.loginWithEgyptNumber(AccountData. VOTER_PHONE, AccountData.INVALID_PASSWORD);

        Assert.assertFalse(loginPage.isLoginSuccessful(), "Bug: Login succeeded with invalid password!");
    }

    @Test(priority = 4, description = "TC-004: Fail - Login with Empty Phone")
    public void testEmptyPhone() {
        VoterLoginPage loginPage = new VoterLoginPage(driver);
        loginPage.openPage();

        loginPage.selectEgypt();
        loginPage.enterPhone("");
        loginPage.enterPassword(AccountData.VOTER_PASSWORD);

        Assert.assertFalse(loginPage.isLoginButtonEnabled(), "Bug: Login button enabled with empty phone!");
    }

    @Test(priority = 5, description = "TC-005: Fail - Login with Empty Password")
    public void testEmptyPassword() {
        VoterLoginPage loginPage = new VoterLoginPage(driver);
        loginPage.openPage();

        loginPage.selectEgypt();
        loginPage.enterPhone(AccountData.VOTER_PHONE);
        loginPage.enterPassword("");

        Assert.assertFalse(loginPage.isLoginButtonEnabled(), "Bug: Login button enabled with empty password!");
    }

    @Test(priority = 6, description = "TC-006: Fail - Login with Both Fields Empty")
    public void testBothFieldsEmpty() {
        VoterLoginPage loginPage = new VoterLoginPage(driver);
        loginPage.openPage();

        loginPage.enterPhone("");
        loginPage.enterPassword("");

        Assert.assertFalse(loginPage.isLoginButtonEnabled(), "Bug: Login button enabled with empty fields!");
    }

    @Test(priority = 7, description = "TC-007:  Verify Country Code Selection")
    public void testCountryCodeSelection() {
        VoterLoginPage loginPage = new VoterLoginPage(driver);
        loginPage.openPage();

        loginPage.selectEgypt();
        loginPage.enterPhone(AccountData. VOTER_PHONE);
        loginPage.enterPassword(AccountData. VOTER_PASSWORD);

        Assert.assertTrue(loginPage.isLoginButtonEnabled(), "Failed: Login button should be enabled!");
    }
}