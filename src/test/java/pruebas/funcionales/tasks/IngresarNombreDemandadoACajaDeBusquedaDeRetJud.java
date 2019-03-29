package pruebas.funcionales.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import pruebas.funcionales.pages.TablaRetJud;

public class IngresarNombreDemandadoACajaDeBusquedaDeRetJud implements Task{

    private final String nombreDemandado;

    public IngresarNombreDemandadoACajaDeBusquedaDeRetJud(String nombreDemandado) {
        this.nombreDemandado = nombreDemandado;
    }

    @Step("{0} ingresar nombre del demandado '#nombreDemandado'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(nombreDemandado).into(TablaRetJud.CAJA_DE_BUSQUEDA)
                        .thenHit(Keys.RETURN)
        );
    }

    public static Task called(String nombreDemandado) {
        return Instrumented
                .instanceOf(IngresarNombreDemandadoACajaDeBusquedaDeRetJud.class)
                .withProperties(nombreDemandado);
    }
}
