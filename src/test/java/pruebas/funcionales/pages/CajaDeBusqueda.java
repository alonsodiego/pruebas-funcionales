package pruebas.funcionales.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CajaDeBusqueda {
    public static Target SEARCH_FIELD = Target.the("Caja de busqueda").located(By.name("q"));
}
