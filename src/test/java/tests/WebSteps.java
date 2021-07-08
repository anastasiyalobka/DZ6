package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step ("Открываем главную страницу")
    public void openPage() {
        open("https://github.com/");
    }

    @Step("Выполняем поиск репозитория {repository}")
    public void searchRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").setValue("anastasiyalobka/DZ5").pressEnter();
    }

    @Step("Переходим в репозиторий {repository}")
    public void goToRepository(String repository) {
        $(By.linkText("anastasiyalobka/DZ5")).click();
    }

    @Step("Проверяем наличие Issues")
    public void CheckResults() {
        $(byText("Issues")).should(Condition.exist);
    }
}
