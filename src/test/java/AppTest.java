import org.junit.*;
import static org.junit.Assert.*;

public class AppTest {

  @Test
  public void puzzleBuild_enterAWordAndReceiveItBackWithVowelsAsDashes() {
    App testPuzzle = new App();
    assertEquals("h-ll-", testPuzzle.puzzleBuild("hello"));
  }
  @Test
  public void puzzleBuild_enterASentenceAndReceiveItBackWithVowelsAsDashes() {
    App testPuzzle = new App();
    assertEquals("h-ll- h-w -r- y-- my n-m- -s -nn-", testPuzzle.puzzleBuild("hello how are you my name is anna"));
  }
  @Test
  public void puzzleBuild_preservePunctuation() {
    App testPuzzle = new App();
    assertEquals("h-ll-, h-w -r- y--? my n-m- -s -nn-.", testPuzzle.puzzleBuild("hello, how are you? my name is anna."));
  }
  @Test
  public void puzzleBuild_preserveCapitalization() {
    App testPuzzle = new App();
    assertEquals("H-ll- h-w -r- y-- my n-m- -s -nn-", testPuzzle.puzzleBuild("Hello how are you my name is Anna"));
  }
}
