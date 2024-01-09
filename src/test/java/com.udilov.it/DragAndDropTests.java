package com.udilov.it;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests {

    SelenideElement firstRectangle = $("#column-a");
    SelenideElement secondRectangle = $("#column-b");

    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize = "640x480";
        Configuration.baseUrl = "https://the-internet.herokuapp.com/drag_and_drop";
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeEach
    void beforeEach() {
        open("");
        firstRectangle.shouldHave(text("A"));
        secondRectangle.shouldHave(text("B"));
    }

    @AfterEach
    void afterEach() {
        firstRectangle.shouldHave(text("B"));
        secondRectangle.shouldHave(text("A"));
    }

    @Test
    void dragAndDropWithElementCommandTest() {
        firstRectangle.dragAndDrop(DragAndDropOptions.to(secondRectangle));
    }

    @Test
    void dragAndDropWithSelenideActionsTest() {
        actions().dragAndDrop(firstRectangle, secondRectangle).perform();
    }
}