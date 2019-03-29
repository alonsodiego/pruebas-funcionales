package pruebas.funcionales.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import pruebas.funcionales.pages.RetencionesJudicialesPage;

public class IniciarTablaRetJud implements Task {

    private final String nombreDemandado;

    RetencionesJudicialesPage retencionesJudicialesPage;

    public IniciarTablaRetJud(String nombreDemandado) {
        this.nombreDemandado = nombreDemandado;
    }

    @Override
    @Step("{0} starts with an empty todo list")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                    //Open.browserOn().the(retencionesJudicialesPage)
                BusquedaRetJud.iniciarAplicacion()
        );
        actor.attemptsTo(IngresarNombreDemandadoACajaDeBusquedaDeRetJud.called(nombreDemandado));
    }
}
