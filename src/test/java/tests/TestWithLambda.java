package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TestWithLambda {
    private static final String BASE_URL = "https://github.com/";
    private static final String REPOSITORY = "anastasiyalobka/DZ5";
    private static final String RESULTS = "Issues";

    @Feature("Issues")
    @Owner("anastasiyalobka")

    @Test
    @Story("Проверка Issues")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Github", url = "https://github.com/")
    @DisplayName("Тест на проверку наличия Issues")

    public void issueSearchSuccess(){

        step("Открываем главную страницу " + BASE_URL, (s) -> {
            s.parameter("url", BASE_URL);
            open(BASE_URL);
        });

        step("Выполняем поиск репозитория " + REPOSITORY, (s) -> {
            s.parameter("repository", REPOSITORY);
            $(".header-search-input").setValue(REPOSITORY).pressEnter();
        });
        step("Переходим в репозиторий " + REPOSITORY, (s) -> {
            s.parameter("repository", REPOSITORY);
            $(By.linkText(REPOSITORY)).click();
        });
        step ("Проверяем наличие " + RESULTS, (s) -> {
            s.parameter("results", RESULTS);
            $(".UnderlineNav-body").$(byText("Issues")).should(Condition.visible);
        });

    }
}
