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
      model.put("sightings", Sighting.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/initial_new_animal", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/animal-entry.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/animals", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int id = 0;
      String name= request.queryParams("name");
      String health= request.queryParams("health");
      String lifeStage=request.queryParams("lifestage");
      String type=request.queryParams("type");
      if (type.equals("endangered")) {
        if (health.equals("1")) {
          health = "very healthy";
        } if (health.equals("2")) {
          health = "okay";
        } if (health.equals("3")) {
          health = "ill";
        } if (lifeStage.equals("1")) {
          lifeStage = "newborn";
        } if (lifeStage.equals("2")) {
          lifeStage = "juvenile";
        } if (lifeStage.equals("3")) {
          lifeStage = "adult";
        }
        Endangered test = new Endangered(name, health, lifeStage);
        test.save();
        id = test.getId();
      } else {
        Animal newAnimal= new Animal(name);
        newAnimal.save();
        id = newAnimal.getId();
      }

      model.put("animalId", id);
      model.put("template", "templates/sighting-entry.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String rangername= request.queryParams("rangername");
      String location= request.queryParams("location");
      int animalId= Integer.parseInt(request.queryParams("id"));
      Sighting newSighting = new Sighting(location, rangername, animalId);
      newSighting.save();
      model.put("sightings", Sighting.all());
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // get("/initial_new_animal/initial_new_sighting/success", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   model.put("template", "templates/animal-entry.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

    get("/sighting/:id/animals", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Sighting sighting = Sighting.find(Integer.parseInt(request.params(":id")));
      model.put("animals", Animal.all());
      model.put("sighting", sighting);
      System.out.println(sighting.getAnimals());
      model.put("template", "templates/animal-list.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    //
    // get("/animal-entry-ranger", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   model.put("template", "templates/animal-established.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    //
    //

    // get("/animal-entry/sighting-entry", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   model.put("template", "templates/sighting-entry.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // post("/animal-entry/sighting-entry", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   String rangername= request.queryParams("rangername");
    //   String location= request.queryParams("location");
    //   int animalID = 1;
    //   Sighting sighting= new Sighting(location, rangername, animalID);
    //   sighting.save();
    //   model.put("template", "templates/success.vtl");
    //   return new ModelAndView(model, layout);
    //   }, new VelocityTemplateEngine());
    //
    // get("/success", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   model.put("template", "templates/success.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

  }
}
