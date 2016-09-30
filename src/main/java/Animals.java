import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class Animals {
  private int id;
  private String name;

  public Animals (int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
