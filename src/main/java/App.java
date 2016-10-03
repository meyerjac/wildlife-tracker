import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import java.io.Console;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
    Console console = System.console();

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/animal-entry", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/animal-entry.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("animal-entry", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name= request.queryParams("name");
      String health= request.queryParams("health");
      String lifeStage=request.queryParams("lifestage");
      String type=request.queryParams("type");

      if (type.equals("endangered")) {
        Endangered endangered= new Endangered(name, health, lifeStage);
        endangered.save();
      } else {
        Animal animal= new Animal(name);
        animal.save();
      }
      model.put("template", "templates/sighting.vtl");
       response.redirect("/animal-entry/sighting-entry");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/animal-entry/sighting-entry", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/sighting-entry.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/animal-entry/sighting-entry", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String rangername= request.queryParams("rangername");
      String location= request.queryParams("location");
      int animalID = 1;
      Sighting sighting= new Sighting(rangername, location, animalID);
      sighting.save();
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

    get("/success", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
