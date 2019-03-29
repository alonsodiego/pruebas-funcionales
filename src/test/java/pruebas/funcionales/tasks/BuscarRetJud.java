package pruebas.funcionales.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import pruebas.funcionales.pages.CajaDeBusqueda;

public class BuscarRetJud implements Task {

    private final String nombreDemandado;

    public BuscarRetJud(String nombreDemandado) {
        this.nombreDemandado = nombreDemandado;
    }

    @Override
    @Step("{0} starts with an empty todo list")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(nombreDemandado)
                        .into(CajaDeBusqueda.SEARCH_FIELD)
                        .thenHit(Keys.ENTER)
        );
    }
}
