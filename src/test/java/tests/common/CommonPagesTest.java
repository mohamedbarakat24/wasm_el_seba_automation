package tests.common;

import base.BaseTest;
import listeners.ConsoleReportListener;
import org.example.constants.FrameworkConstants;
import org.example.pages.common. CommonPages;
import org.testng.Assert;
import org.testng. annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ConsoleReportListener.class)
public class CommonPagesTest extends BaseTest {

    // Test Tracks page opens
    @Test(priority = 1, description = "TC-001: Verify Tracks Page Opens")
    public void testTracksPageOpens() {
        CommonPages commonPages = new CommonPages(driver);
        commonPages.openTracksPage();
        Assert.assertTrue(commonPages.isPageLoaded(FrameworkConstants. URL_TRACKS), "Failed: Tracks page did not open!");
    }

    // Test Subjects page opens
    @Test(priority = 2, description = "TC-002: Verify Subjects Page Opens")
    public void testSubjectsPageOpens() {
        CommonPages commonPages = new CommonPages(driver);
        commonPages.openSubjectsPage();
        Assert.assertTrue(commonPages.isPageLoaded(FrameworkConstants.URL_SUBJECTS), "Failed: Subjects page did not open!");
    }

    // Test News page opens
    @Test(priority = 3, description = "TC-003: Verify News Page Opens")
    public void testNewsPageOpens() {
        CommonPages commonPages = new CommonPages(driver);
        commonPages. openNewsPage();
        Assert.assertTrue(commonPages.isPageLoaded(FrameworkConstants.URL_NEWS), "Failed: News page did not open!");
    }

    // Test Steps page opens
    @Test(priority = 4, description = "TC-004: Verify Steps Page Opens")
    public void testStepsPageOpens() {
        CommonPages commonPages = new CommonPages(driver);
        commonPages.openStepsPage();
        Assert.assertTrue(commonPages.isPageLoaded(FrameworkConstants.URL_STEPS), "Failed: Steps page did not open!");
    }

    // Test Terms page opens
    @Test(priority = 5, description = "TC-005: Verify Terms Page Opens")
    public void testTermsPageOpens() {
        CommonPages commonPages = new CommonPages(driver);
        commonPages. openTermsPage();
        Assert.assertTrue(commonPages.isPageLoaded(FrameworkConstants. URL_TERMS), "Failed: Terms page did not open!");
    }

    // Test About page opens
    @Test(priority = 6, description = "TC-006: Verify About Page Opens")
    public void testAboutPageOpens() {
        CommonPages commonPages = new CommonPages(driver);
        commonPages.openAboutPage();
        Assert.assertTrue(commonPages.isPageLoaded(FrameworkConstants.URL_ABOUT), "Failed: About page did not open!");
    }

    // Test Phone link is visible
    @Test(priority = 7, description = "TC-007: Verify Phone Link is Visible")
    public void testPhoneLinkVisible() {
        CommonPages commonPages = new CommonPages(driver);
        commonPages.openHomePage();
        commonPages.scrollToFooter();
        Assert.assertTrue(commonPages.isPhoneLinkVisible(), "Failed: Phone link not visible!");
    }

    // Test WhatsApp link is visible
    @Test(priority = 8, description = "TC-008: Verify WhatsApp Link is Visible")
    public void testWhatsAppLinkVisible() {
        CommonPages commonPages = new CommonPages(driver);
        commonPages.openHomePage();
        commonPages.scrollToFooter();
        Assert.assertTrue(commonPages. isWhatsAppLinkVisible(), "Failed: WhatsApp link not visible!");
    }

    // Test Facebook link opens
    @Test(priority = 9, description = "TC-009: Verify Facebook Link Opens")
    public void testFacebookLinkOpens() {
        CommonPages commonPages = new CommonPages(driver);
        commonPages.openHomePage();
        Assert.assertTrue(commonPages.clickSocialLinkAndVerify("facebook", "facebook.com"), "Failed: Facebook link not working!");
    }

    // Test LinkedIn link opens
    @Test(priority = 10, description = "TC-010: Verify LinkedIn Link Opens")
    public void testLinkedInLinkOpens() {
        CommonPages commonPages = new CommonPages(driver);
        commonPages.openHomePage();
        Assert.assertTrue(commonPages.clickSocialLinkAndVerify("linkedin", "linkedin.com"), "Failed: LinkedIn link not working!");
    }

    // Test TikTok link opens
    @Test(priority = 11, description = "TC-011: Verify TikTok Link Opens")
    public void testTikTokLinkOpens() {
        CommonPages commonPages = new CommonPages(driver);
        commonPages.openHomePage();
        Assert.assertTrue(commonPages.clickSocialLinkAndVerify("tiktok", "tiktok.com"), "Failed: TikTok link not working!");
    }

    // Test Snapchat link opens
    @Test(priority = 12, description = "TC-012: Verify Snapchat Link Opens")
    public void testSnapchatLinkOpens() {
        CommonPages commonPages = new CommonPages(driver);
        commonPages.openHomePage();
        Assert.assertTrue(commonPages.clickSocialLinkAndVerify("snapchat", "snapchat.com"), "Failed: Snapchat link not working!");
    }

    // Test Instagram link opens
    @Test(priority = 13, description = "TC-013: Verify Instagram Link Opens")
    public void testInstagramLinkOpens() {
        CommonPages commonPages = new CommonPages(driver);
        commonPages.openHomePage();
        Assert.assertTrue(commonPages.clickSocialLinkAndVerify("instagram", "instagram.com"), "Failed: Instagram link not working!");
    }

    // Test YouTube link opens
    @Test(priority = 14, description = "TC-014: Verify YouTube Link Opens")
    public void testYouTubeLinkOpens() {
        CommonPages commonPages = new CommonPages(driver);
        commonPages.openHomePage();
        Assert.assertTrue(commonPages.clickSocialLinkAndVerify("youtube", "youtube.com"), "Failed: YouTube link not working!");
    }

    // Test Twitter/X link opens
    @Test(priority = 15, description = "TC-015: Verify Twitter/X Link Opens")
    public void testTwitterLinkOpens() {
        CommonPages commonPages = new CommonPages(driver);
        commonPages.openHomePage();
        Assert.assertTrue(commonPages.clickSocialLinkAndVerify("twitter", "x.com"), "Failed: Twitter/X link not working!");
    }
}