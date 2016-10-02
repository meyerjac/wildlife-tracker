import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.sql.Timestamp;

public class SightingTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void sighting_instantiatesCorrectly_true() {
  Sighting newSighting = new Sighting("northern part of cut", "sarah", 1);
    assertEquals(true, newSighting instanceof Sighting);
  }
  @Test
  public void sighting_returnsAnimalId_True() {
    Sighting newSighting = new Sighting("northern part of cut", "sarah", 1);
    assertEquals(1, newSighting.getAnimalId());
  }
  @Test
  public void sighting_returnsLocation_true() {
    Sighting sighting = new Sighting("northern part of cut", "sarah", 1);
    assertEquals("northern part of cut", sighting.getLocation());
  }
  @Test
  public void sighting_returnsRangerName_true() {
    Sighting sighting = new Sighting("northern part of cut", "sarah", 1);
    assertEquals("sarah", sighting.getRangerName());
  }
  @Test
  public void equals_returnsTrueIfAttributesAreTheSame_true() {
    Sighting mySighting = new Sighting("northern part of cut", "sarah", 1);
    Sighting mySightingTwo = new Sighting("northern part of cut", "sarah", 1);
    assertTrue(mySighting.equals(mySightingTwo));
  }
  @Test
  public void save_savesSightingToDataBase_true() {
    Sighting mySighting = new Sighting("souther quarter", "mother", 1);
    mySighting.save();
    assertEquals("mother", Sighting.all().get(0).getRangerName());
  }
  @Test
  public void find_returnsSightingWithSameAnimalId_true() {
    Sighting newsighting = new Sighting("northern part of cut", "sarah", 6);
    newsighting.save();
    Sighting sighting1= new Sighting("northern part of cut", "sarah", 6 );
    sighting1.save();
    assertEquals(Sighting.find(newsighting.getAnimalId()), Sighting.find(sighting1.getAnimalId()));
  }

  @Test
  public void all_returnsAllInstancesOfSighting_true() {
  Sighting newsighting = new Sighting("juneau", "juneau", 6);
  newsighting.save();
    Sighting newsighting1 = new Sighting("juneau", "juneau", 7);
    newsighting1.save();
    assertEquals("juneau", Sighting.all().get(0).getRangerName());
    assertEquals("juneau", Sighting.all().get(1).getRangerName());
  }

}
