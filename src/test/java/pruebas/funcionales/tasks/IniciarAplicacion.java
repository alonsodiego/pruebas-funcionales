package pruebas.funcionales.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import pruebas.funcionales.pages.RetencionesJudicialesPage;

public class IniciarAplicacion implements Task {

    RetencionesJudicialesPage retencionesJudicialesPage;

    @Step("Abrir aplicacion")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(retencionesJudicialesPage)
        );
    }
}
