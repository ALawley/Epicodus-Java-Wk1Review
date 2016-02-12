import org.junit.*;
import static org.junit.Assert.*;

public class AppTest {

  @Test
  public void puzzleBuild_enterAStringAndReceiveItBackWithVowelsAsDashes() {
    App testPuzzle = new App();
    assertEquals("h-ll-", testPuzzle.puzzleBuild("hello"));
  }
}
