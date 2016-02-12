import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("solution", request.session().attribute("solution"));
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/puzzle", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/puzzle.vtl");

      String userInput = request.queryParams("puzzle-form");
      request.session().attribute("solution", userInput);
      String wordPuzzle = puzzleBuild(userInput);

      model.put("userPuzzle", wordPuzzle);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/result", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/result.vtl");

      String userGuess = request.queryParams("solution-form");
      String solution = request.session().attribute("solution");
      Boolean isCorrect = puzzleEvaluate(solution, userGuess);

      model.put("solution", request.session().attribute("solution"));
      model.put("isCorrect", isCorrect);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static String puzzleBuild(String inputText) {
    return inputText.replaceAll("[aeiouAEIOU]", "-");
  }

  public static Boolean puzzleEvaluate(String puzzle, String userGuess) {
    if (puzzle.equals(userGuess)) {
      return true;
    } return false;
  }

}
