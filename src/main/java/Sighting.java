import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class Sighting {
  private int animalId;
  private String location;
  private String rangerName;
  private int id;


  public Sighting(int animalId, String location, String rangerName) {
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
      String sql = "INSERT INTO sightings (location, rangername, animalid) VALUES (:location, :rangerName, :animalId)";
      con.createQuery(sql)
      .addParameter("location", this.location)
      .addParameter("rangerName", this.rangerName)
      .addParameter("animalId", this.animalId)
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
