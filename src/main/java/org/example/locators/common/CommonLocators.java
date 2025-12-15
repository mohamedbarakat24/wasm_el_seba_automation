package org.example.locators.common;

import org.openqa. selenium.By;

public class CommonLocators {

    // Contact Links
    public static final By PHONE_LINK = By.cssSelector("a[href='tel:+966599052180']");
    public static final By WHATSAPP_LINK = By. cssSelector("a[href='https://wa.me/966599052180']");

    // Social Media Links
    public static final By FACEBOOK_LINK = By.xpath("//div[@class='social-links']//a[contains(@href,'facebook.com')]");
    public static final By LINKEDIN_LINK = By.xpath("//div[@class='social-links']//a[contains(@href,'linkedin.com')]");
    public static final By TIKTOK_LINK = By. xpath("//div[@class='social-links']//a[contains(@href,'tiktok.com')]");
    public static final By SNAPCHAT_LINK = By. xpath("//div[@class='social-links']//a[contains(@href,'snapchat.com')]");
    public static final By INSTAGRAM_LINK = By.xpath("//div[@class='social-links']//a[contains(@href,'instagram.com')]");
    public static final By YOUTUBE_LINK = By.xpath("//div[@class='social-links']//a[contains(@href,'youtube.com')]");
    public static final By TWITTER_LINK = By.xpath("//div[@class='social-links']//a[contains(@href,'x.com')]");
}