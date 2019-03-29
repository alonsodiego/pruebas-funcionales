package pruebas.funcionales.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import pruebas.funcionales.pages.TablaRetJud;

public class ClickResultadoDeBusquedaRetJud implements Task {

    private final String nombreDemandado;

    public ClickResultadoDeBusquedaRetJud(String nombreDemandado) {
        this.nombreDemandado = nombreDemandado;
    }

    @Step("{0} hacemos click en el primer elemento de la lista de resultados '#nombreDemandado'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(TablaRetJud.PRIMER_ELEMENTO)
        );
    }

    public static Task called(String nombreDemandado) {
        return Instrumented.instanceOf(ClickResultadoDeBusquedaRetJud.class)
                .withProperties(nombreDemandado);    }
}
