package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TestWithSelenide {

    @Test

    public void issueSearchSuccess(){
        open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").setValue("anastasiyalobka/DZ5").pressEnter();
        $(By.linkText("anastasiyalobka/DZ5")).click();
       // $(byText("Issues")).click();
        $(byText("Issues")).should(Condition.exist);

    }

}
