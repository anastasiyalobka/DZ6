package tests;

import org.junit.jupiter.api.Test;

public class TestWithAnnotationStep {

    private WebSteps steps = new WebSteps();

    @Test
    public void issueSearchSuccess(){
        steps.openPage();
        steps.searchRepository("anastasiyalobka/DZ5");
        steps.goToRepository("anastasiyalobka/DZ5");
        steps.checkResults();
    }
}
