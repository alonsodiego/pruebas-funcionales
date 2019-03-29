package pruebas.funcionales.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TablaRetJud {
    public static Target CAJA_DE_BUSQUEDA =
            Target.the("'Caja de busqueda'")
                    .located(By.name("q"));
    public static Target PRIMER_ELEMENTO =
            Target.the("primer elemento de la lista de retenciones judiciales")
                    .locatedBy(".g .LC20lb:first-of-type");
}
