import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class Sighting {
  private int animalId;
  private String location;
  private String rangerName;
  private int id;


  public Sighting(String location, String rangerName, int animalId) {
    this.animalId= animalId;
    this.location = location;
    this.rangerName = rangerName;
  }
  public int getAnimalId() {
    return animalId;
  }
  public String getLocation() {
    return location;
  }
  public String getRangerName() {
    return rangerName;
  }
  public int getId() {
    return id;
  }
  @Override
  public boolean equals(Object otherSighting) {
   if (!(otherSighting instanceof Sighting)) {
     return false;
   } else {
     Sighting newSighting = (Sighting) otherSighting;
     return this.getAnimalId()==(newSighting.getAnimalId()) &&
            this.getLocation().equals(newSighting.getLocation()) &&
            this.getRangerName().equals(newSighting.getRangerName()) &&
            this.getId() == (newSighting.getId());
   }
 }
 public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO sightings (location, rangername, animalid) VALUES (:location, :rangername, :animalid)";
      con.createQuery(sql)
      .addParameter("location", this.location)
      .addParameter("rangername", this.rangerName)
      .addParameter("animalid", this.animalId)
      .executeUpdate();

    }
  }
  public static List<Sighting> all() {
   String sql = "SELECT * FROM sightings";
   try(Connection con = DB.sql2o.open()) {
     return con.createQuery(sql).executeAndFetch(Sighting.class);
    }
  }
}
