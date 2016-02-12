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
  public void puzzleBuild_preserveConsonantCapitalization() {
    App testPuzzle = new App();
    assertEquals("H-ll- h-w -r- y-- my n-m- -s -nn-", testPuzzle.puzzleBuild("Hello how are you my name is anna"));
  }
  @Test
  public void puzzleBuild_replaceCapitalizedVowels() {
    App testPuzzle = new App();
    assertEquals("h-ll- h-w -r- y-- my n-m- -s -nn-", testPuzzle.puzzleBuild("hello how are you my name is Anna"));
  }
  @Test
  public void hintPuzzleBuild_hideNonAVowels() {
    App testPuzzle = new App();
    assertEquals("h-ll- h-w ar- y-- my nam- -s Anna", testPuzzle.hintPuzzleBuild("hello how are you my name is Anna"));
  }
  @Test
  public void puzzleEvaluate_evaluateIfSolutionMatchesPuzzle_true() {
    App testPuzzle = new App();
    String userInput = "Hello how are you my name is Anna";
    String solution = "Hello how are you my name is Anna";
    assertEquals(true, testPuzzle.puzzleEvaluate(solution, userInput));
  }
  @Test
  public void puzzleEvaluate_ignoreCapitalization_true() {
    App testPuzzle = new App();
    String userInput = "Hello how are you my name is Anna";
    String solution = "hello how are you my name is anna";
    assertEquals(true, testPuzzle.puzzleEvaluate(solution, userInput));
  }
  @Test
  public void puzzleEvaluate_ignorePunctuation_true() {
    App testPuzzle = new App();
    String userInput = "Hello, how are you? my name is Anna.";
    String solution = "Hello how are you my name is Anna";
    assertEquals(true, testPuzzle.puzzleEvaluate(solution, userInput));
  }
  @Test
  public void isCheater_checksIfInputContainsDashes_true() {
    App testPuzzle = new App();
    String userInput = "Hello, how a-e you?";
    assertEquals(true, testPuzzle.isCheater(userInput));
  }
}
