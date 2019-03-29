package pruebas.funcionales.features.BusquedaRJ;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pruebas.funcionales.tasks.BusquedaRetJud;
import pruebas.funcionales.tasks.ClickResultadoDeBusquedaRetJud;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class EdicionRetJud {

    Actor coraline = Actor.named("Coraline");

    @Managed
    public WebDriver herBrowser;

    //@Steps
    //IniciarAplicacion openTheApplication;

    @Before
    public void coralineCanBrowseTheWeb() {
        coraline.can(BrowseTheWeb.with(herBrowser));
    }

    /*
        Feature : Edicion de los medios de pago y datos del cobrante de una Retencion Judicial (RT)
            COMO Administrador
            QUIERO poder editar los medios de pago y datos del cobrante de una RJ perteneciente a una persona demandada
            PARA mantener actualizada la informacion de las RJ en el RRJ.

        Scenario: Edicion de los datos de los medios de pago y datos del cobrante de una RJ
            Given
            When
            Then

        Buscar en las RJ
        Hacer click en el boton editar de uno de los registros resultado
        Hacer click en modificar en el PopUp que aparece
        Ingresar o cambiar los datos de los medios de pago y Hacer click en guardar
        Ingresar o cambiar los datos de los cobrantes y Hacer click en guardar
        Hacer click en el boton Finalizar del PopUp Informacion guardada con Exito

        (Dejar sin efecto es otro caso)
    */
    @Test
    public void busquedaDeRetencionJudicialRegistrada() {

        givenThat(coraline).wasAbleTo(BusquedaRetJud.iniciarTablaRetJud("otra"));

        when(coraline).attemptsTo(ClickResultadoDeBusquedaRetJud.called("otra"));

        then(coraline).should(eventually(seeThat(TheWebPage.title(), containsString("otra"))));

    }
}
