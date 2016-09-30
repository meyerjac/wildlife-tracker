import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class Sightings {
  private int animalsId;
  private String location;
  private String rangerName;


  public Sightings(int animalsId, String location, String rangerName) {
    this.animalsId= animalsId;
    this.location = location;
    this.rangerName = rangerName;
  }

  public int getAnimalsId() {
    return animalsId;
  }

  public String getlocation() {
    return location;
  }

  public String getRangerName() {
    return rangerName;
  }




}
