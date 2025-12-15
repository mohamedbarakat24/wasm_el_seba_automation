package tests.mushark;

import base.BaseTest;
import listeners. ConsoleReportListener;
import org.example.pages.mushark.MusharkSignupPage;
import org.testng.Assert;
import org.testng. annotations.Listeners;
import org.testng.annotations.Test;
import java.util.Random;

@Listeners(ConsoleReportListener.class)
public class MusharkSignUpTest extends BaseTest {

    // Generate random phone number
    public String generateRandomPhone() {
        return "5" + (10000000 + new Random().nextInt(90000000));
    }

    // Generate random ID
    public String generateValidID() {
        return "1" + (100000000 + new Random().nextInt(900000000));
    }

    // Test successful sign-up with valid data
    @Test(priority = 1, description = "TC-001: Successful Sign-Up with Valid Data")
    public void testSuccessfulSignup() {
        MusharkSignupPage signupPage = new MusharkSignupPage(driver);
        signupPage.openPage();

        String phone = generateRandomPhone();
        String email = "auto" + phone + "@test.com";
        String validID = generateValidID();

        signupPage. fillFullForm("محمد أحمد محمود", email, phone, validID, "Pass@1234", "فريق النجاح");
        signupPage.clickSubmit();

        Assert.assertTrue(signupPage.isOtpScreenDisplayed(), "Failed: OTP Screen did not appear");
    }

    // Test name with English characters
    @Test(priority = 2, description = "TC-002: Fail - Name with English Characters")
    public void testNameWithEnglishChars() {
        MusharkSignupPage signupPage = new MusharkSignupPage(driver);
        signupPage.openPage();

        signupPage.fillFullName("Mohamed Ahmed");
        signupPage.fillEmail("valid@test. com");
        signupPage. fillPhone(generateRandomPhone());
        signupPage.fillID(generateValidID());
        signupPage.selectGender();
        signupPage.fillPasswords("Pass@1234", "Pass@1234");
        signupPage.fillTeamInfo("Test");
        signupPage.selectTrack();
        signupPage. acceptTerms();
        signupPage.clickSubmit();

        Assert.assertTrue(signupPage. hasValidationErrors(), "Bug: System accepted English name!");
    }

    // Test name with less than 3 words
    @Test(priority = 3, description = "TC-003: Fail - Name Less Than 3 Words")
    public void testNameLessThan3Words() {
        MusharkSignupPage signupPage = new MusharkSignupPage(driver);
        signupPage.openPage();

        signupPage.fillFullName("محمد أحمد");
        signupPage.fillEmail("valid@test.com");
        signupPage.fillPhone(generateRandomPhone());
        signupPage.fillID(generateValidID());
        signupPage. selectGender();
        signupPage.fillPasswords("Pass@1234", "Pass@1234");
        signupPage.fillTeamInfo("Test");
        signupPage.selectTrack();
        signupPage.acceptTerms();
        signupPage. clickSubmit();

        Assert.assertTrue(signupPage.hasValidationErrors(), "Bug: System accepted 2-word name!");
    }

    // Test password mismatch
    @Test(priority = 4, description = "TC-004: Fail - Password Mismatch")
    public void testPasswordMismatch() {
        MusharkSignupPage signupPage = new MusharkSignupPage(driver);
        signupPage.openPage();

        signupPage.fillFullName("محمد أحمد علي");
        signupPage.fillEmail("pass" + generateRandomPhone() + "@test.com");
        signupPage.fillPhone(generateRandomPhone());
        signupPage.fillID(generateValidID());
        signupPage.selectGender();
        signupPage.selectTrack();
        signupPage.fillTeamInfo("Team");
        signupPage. fillPasswords("Pass@123", "Pass@999");
        signupPage.acceptTerms();

        Assert.assertFalse(signupPage.isSubmitButtonEnabled(), "Bug: Submit enabled despite password mismatch!");
    }

    // Test invalid email format
    @Test(priority = 5, description = "TC-005: Fail - Invalid Email Format")
    public void testInvalidEmail() {
        MusharkSignupPage signupPage = new MusharkSignupPage(driver);
        signupPage.openPage();

        signupPage.fillFullName("محمد أحمد علي");
        signupPage.fillEmail("invalid-email-format");
        signupPage.fillPhone(generateRandomPhone());
        signupPage.fillID(generateValidID());
        signupPage.selectTrack();
        signupPage. selectGender();
        signupPage.fillPasswords("Pass@1234", "Pass@1234");
        signupPage.acceptTerms();
        signupPage.clickSubmit();

        Assert.assertTrue(signupPage.hasValidationErrors(), "Bug: System accepted invalid email!");
    }

    // Test no track selected
    @Test(priority = 6, description = "TC-006: Fail - No Track Selected")
    public void testNoTrackSelected() {
        MusharkSignupPage signupPage = new MusharkSignupPage(driver);
        signupPage.openPage();

        signupPage.fillFullName("محمد أحمد علي");
        signupPage.fillEmail("track" + generateRandomPhone() + "@test.com");
        signupPage. fillPhone(generateRandomPhone());
        signupPage.fillID(generateValidID());
        signupPage.selectGender();
        signupPage.fillPasswords("Pass@1234", "Pass@1234");
        signupPage.fillTeamInfo("Team");
        signupPage.acceptTerms();
        signupPage. clickSubmit();

        Assert.assertFalse(signupPage.isOtpScreenDisplayed(), "Bug: OTP appeared without selecting track!");
    }

    // Test terms not accepted
    @Test(priority = 7, description = "TC-007: Fail - Terms Not Accepted")
    public void testTermsNotChecked() {
        MusharkSignupPage signupPage = new MusharkSignupPage(driver);
        signupPage.openPage();

        signupPage. fillFullForm("محمد أحمد علي", "terms@test.com", generateRandomPhone(), generateValidID(), "Pass@1234", "Team");
        signupPage.acceptTerms();
        signupPage.clickSubmit();

        Assert.assertFalse(signupPage.isOtpScreenDisplayed(), "Bug: OTP appeared without accepting terms!");
    }
}