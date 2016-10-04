import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

public class Sighting {
  private int animalId;
  private Timestamp seenat;
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
  public Timestamp getTime() {
    return seenat;
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
      String sql = "INSERT INTO sightings (location, rangername, animalid, seenat) VALUES (:location, :rangername, :animalid, now())";
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
  public static Sighting find(int id) {
    String sql = "SELECT * FROM sightings where id=:id";
    try(Connection con = DB.sql2o.open()) {
      Sighting newSighting = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Sighting.class);
      return newSighting;
    }
  }
  public List<Animal> getAnimals() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM Sightings WHERE animalid=:id";
      return con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetch(Animal.class);
    }
  }
}
