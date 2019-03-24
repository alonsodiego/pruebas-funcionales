package pruebas.funcionales.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import pruebas.funcionales.tasks.OpenTheApplication;
import pruebas.funcionales.tasks.Search;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class SearchByKeywordStory {

    Actor coraline = Actor.named("Coraline");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void coralineCanBrowseTheWeb() {
        coraline.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void seach_results_should_show_the_search_term_in_the_title() {

        givenThat(coraline).wasAbleTo(openTheApplication);

        when(coraline).attemptsTo(Search.forTheTerm("Canvia"));

        then(coraline).should(eventually(seeThat(TheWebPage.title(), containsString("Canvia"))));

    }
}