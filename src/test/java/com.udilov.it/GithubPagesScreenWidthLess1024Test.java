package com.udilov.it;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class GithubPagesScreenWidthLess1024Test {

    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize = "1023x768";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successfulEnterprisePageOpen() {

        open("");
        $(".d-flex").$(".Button-label").click();
        $$(".HeaderMenu-link").filterBy(text("Solutions")).first().click();
        $("a[href='/enterprise']").click();

        $("#hero-section-brand-heading").shouldBe(visible).shouldHave(text("The AI-powered"));
    }
}
