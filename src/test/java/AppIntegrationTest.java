import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class AppIntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Use the form below");
  }
  @Test
  public void puzzleBuildTest() {
    goTo("http://localhost:4567/");
    fill("#puzzle-form").with("What is your favorite food?");
    submit(".btn");
    assertThat(pageSource()).contains("Wh-t -s y--r f-v-r-t- f--d?");
  }
  @Test
  public void rightAnswerTest() {
    goTo("http://localhost:4567/");
    fill("#puzzle-form").with("What is your name?");
    submit(".btn");
    fill("#solution-form").with("What is your name?");
    submit("#submit");
    assertThat(pageSource()).contains("you correctly solved the puzzle!");
  }
  @Test
  public void wrongAnswerTest() {
    goTo("http://localhost:4567/");
    fill("#puzzle-form").with("What is your name?");
    submit(".btn");
    fill("#solution-form").with("What is your favorite movie?");
    submit("#submit");
    assertThat(pageSource()).contains("You didn't get that one right");
  }
  @Test
  public void cheatingPuzzleTest() {
    goTo("http://localhost:4567/");
    fill("#puzzle-form").with("Wh-t is your name?");
    submit(".btn");
    assertThat(pageSource()).contains("Try again without cheating.");
  }
  @Test
  public void backButtonTest() {
    goTo("http://localhost:4567/");
    fill("#puzzle-form").with("Wh-t is your name?");
    submit(".btn");
    click(".back");
    assertThat(pageSource()).contains("Use the form below");
  }
}
