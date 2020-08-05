package ru.google;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import ru.google.PageObjectGoogle;

import java.util.List;
import java.util.Map;

public class Steps {

    @Step("Шаг 1. Проверка что результатов поиска больше 3")
    public static void checkResultAmount(PageObjectGoogle firstPO, WebDriver driver) {
        if (firstPO.getSearchResult().size()>3) {
            Assertions.assertTrue(true);
        } else {
            CustomUtils.getScreen(driver);
            Assertions.fail("Результатов меньше трех");
        }
    }

    @Step("Шаг 2. Проверка что есть ссылка Гладиолус — Википедия")
    public static void checkWikiLink(PageObjectGoogle firstPO, WebDriver driver) {
        if (firstPO.getSearchResult().stream().anyMatch(x->x.getText().contains("Гладиолус — Википедия"))) {
            Assertions.assertTrue(true);
        } else {
            CustomUtils.getScreen(driver);
            Assertions.fail("Ссылки Гладиолус — Википедия нет");
        }
    }
}