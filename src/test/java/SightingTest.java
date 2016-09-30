import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class SightingTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void sighting_instantiatesCorrectly_true() {
  Sighting newSighting = new Sighting(1,"northern part of cut", "sarah");
    assertEquals(true, newSighting instanceof Sighting);
  }
  @Test
  public void sighting_returnsAnimalId_True() {
    Sighting newSighting = new Sighting(1,"northern part of cut", "sarah");
    assertEquals(1, newSighting.getAnimalId());
  }
  @Test
  public void sighting_returnsLocation_true() {
    Sighting sighting = new Sighting(1,"northern part of cut", "sarah");
    assertEquals("northern part of cut", sighting.getLocation());
  }
  @Test
  public void sighting_returnsRangerName_true() {
    Sighting sighting = new Sighting(1,"northern part of cut", "sarah");
    assertEquals("sarah", sighting.getRangerName());
  }

  @Test
  public void equals_returnsTrueIfAttributesAreTheSame_true() {
    Sighting mySighting = new Sighting(1,"northern part of cut", "sarah");
    Sighting mySightingTwo = new Sighting(1,"northern part of cut", "sarah");
    assertTrue(mySighting.equals(mySightingTwo));
  }
  @Test
  public void save_savesSightingToDataBase_true() {
    Sighting mySighting = new Sighting(1, "northern part of cut", "wqer");
    mySighting.save();
    assertTrue(Sighting.all().get(0).equals(mySighting));
  }
}

//
//   @Test
//   public void save_assignsIdToSighting_true() {
//     Sighting mySighting = new Sighting(1,"northern part of cut", "sarah");
//     mySighting.save();
//     assertTrue(mySighting.getId() > 0);
//   }
//   @Test
//   public void find_returnsSightingWithSameId_true() {
//     Sighting mySighting = new Sighting(1,"northern part of cut", "sarah");
//     mySighting.save();
//     Sighting mySightingTwo = new Sighting(1,"northern part of cut", "sarah");
//     mySightingTwo.save();
//     assertEquals(Sighting.find(mySightingTwo.getId()), mySightingTwo);
//   }
//   @Test
//   public void delete_deletesTheSighting_true() {
//   Sighting testSighting = new Sighting(1,"northern part of cut", "sarah");
//   testSighting.save();
//   int id = testSighting.getId();
//   testSighting.delete();
//   assertEquals(null, Sighting.find(id));
// }
// @Test
// public void update_updatesSighting_true() {
//   Sighting mySighting = new Sighting(1,"northern part of cut", "sarah");
//   mySighting.save();
//   mySighting.update("Jackson", 56, "crew", 1);
//   assertEquals("Jackson", Sighting.find(mySighting.getId()).getName());
//   @Test


//   public void all_returnsAllInstancesOfSighting_true() {
//     Sighting mySighting = new Sighting(1,"northern part of cut", "sarah");
//     Sighting mySightingTwo = new Sighting(1,"northern part of cut", "sarah");
//     mySighting.save();
//     mySightingTwo.save();
//     assertTrue(Sighting.all().get(0).equals(mySighting));
//     assertTrue(Sighting.all().get(1).equals(mySightingTwo));
//   }
// }
//
// }
