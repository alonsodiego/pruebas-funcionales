package pruebas.funcionales.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import pruebas.funcionales.pages.TodoMvcApplicationHomePage;
import net.thucydides.core.annotations.Step;

public class StartWithAnEmptyList implements Task {

    TodoMvcApplicationHomePage todoMvcApplicationHomePage;

    @Override
    @Step("{0} starts with an empty todo list")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(todoMvcApplicationHomePage)
        );
    }
}
