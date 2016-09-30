import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class Endangered {
  private int id;
  private String name;
  private String health;
  private int age;
  private String lifeStage;

  public Endangered (int id, String name, String health, int age, String lifeStage) {
    this.id = id;
    this.name = name;
    this.health = health;
    this.age = age;
    this.lifeStage = lifeStage;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getHealth() {
    return health;
  }

  public int getAge() {
    return age;
  }

  public String getLifeStage() {
    return lifeStage;
  }
}
