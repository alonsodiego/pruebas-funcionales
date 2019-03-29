package pruebas.funcionales.features.BusquedaRJ;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pruebas.funcionales.tasks.BusquedaRetJud;
import pruebas.funcionales.tasks.IniciarAplicacion;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class BusquedaRetJudPorNombreDemandado {

    Actor coraline = Actor.named("Coraline");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    IniciarAplicacion openTheApplication;

    @Before
    public void coralineCanBrowseTheWeb() {
        coraline.can(BrowseTheWeb.with(herBrowser));
    }

    /*
        Feature : Busqueda de Retenciones Judiciales (RT)
            COMO consultor
            QUIERO poder buscar retenciones judiciales de personas demandadas
            PARA verificar que su informacion haya sido cargada y consolidada en el RRJ.

        Scenario: Busqueda de una RJ registrada en el sistema RRJ
            Given la interfaz de consultas de RJ del sistema RRJ
            When escribo el nombre,o parte de el, de un demandado <A> en la caja de busqueda
            Then deberia poder ver una lista de retenciones judiciales que tengan como demandado aquellas personas
                que su nombre contenga la palabra ingresada en la caja de busqueda

        Scenario: Búsqueda de una RJ no registrado en el sistema RRJ
            Given la interfaz de consultas de RJ del sistema RRJ
            When escribo el nombre,o parte de el, de un demandado <A> en la caja de busqueda
            Then deberia ver la lista de retenciones judiciales vacia
     */
    @Test
    public void busquedaDeRetencionJudicialRegistrada() {

        givenThat(coraline).wasAbleTo(openTheApplication);

        when(coraline).attemptsTo(BusquedaRetJud.buscarRetJud("Canvia"));

        then(coraline).should(eventually(seeThat(TheWebPage.title(), containsString("Canvia"))));

    }

    @Test
    public void busquedaDeRetencionJudicialNoRegistrada() {

        givenThat(coraline).wasAbleTo(openTheApplication);

        when(coraline).attemptsTo(BusquedaRetJud.buscarRetJud("Canvia"));

        then(coraline).should(eventually(seeThat(TheWebPage.title(), containsString("Canvia"))));

    }
    /*
        Ejemplos ScreenPlay
        https://www.programcreek.com/java-api-examples/?api=net.serenitybdd.screenplay.actions.Click

     */
}
