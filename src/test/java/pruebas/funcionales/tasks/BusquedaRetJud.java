package pruebas.funcionales.tasks;

import net.serenitybdd.core.steps.Instrumented;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BusquedaRetJud  {

    public static IniciarTablaRetJud iniciarTablaRetJud(String nombreDemandado) {
        return Instrumented.instanceOf(IniciarTablaRetJud.class)
                .withProperties(nombreDemandado);
    }

    public static IniciarAplicacion iniciarAplicacion() {
        return instrumented(IniciarAplicacion.class);
    }

    public static BuscarRetJud buscarRetJud(String nombreDemandado) {
        return Instrumented.instanceOf(BuscarRetJud.class)
                .withProperties(nombreDemandado);
    }

}

