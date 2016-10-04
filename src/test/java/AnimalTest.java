import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class AnimalTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void animal_instantiatesCorrectly_true() {
    Animal animal = new Animal("deer");
    assertEquals(true, animal instanceof Animal);
  }
  @Test
  public void animal_returnsName_True() {
    Animal animal = new Animal("deer");
    assertEquals("deer", animal.getName());
  }
  @Test
  public void equals_returnsTrueIfNameIsTheSame_true() {
    Animal animal = new Animal("deer");
    Animal animal1 = new Animal("deer");
    assertTrue(animal1.equals(animal));
  }
  @Test
  public void equals_FalseIfAttributesAreDifferent_false() {
    Animal animal = new Animal("deer");
    Animal animal1 = new Animal("elk");
    assertFalse(animal1.equals(animal));
  }
  @Test
  public void save_savesToDataBase_true() {
    Animal animal = new Animal("elk");
    animal.save();
    assertEquals("elk", Animal.all().get(0).getName());
  }
  @Test
  public void save_assignsIdToAnimal_true() {
    Animal animal = new Animal("deer");
    animal.save();
    assertEquals(true, animal.getId() > 0);
  }
  @Test
  public void all_returnsAllInstancesOfAnimal_true() {
    Animal animal = new Animal("snake");
    Animal animal1 = new Animal("fish");
    animal.save();
    animal1.save();
    assertEquals("snake", Animal.all().get(0).getName());
    assertEquals("fish", Animal.all().get(1).getName());
  }
  @Test
  public void find_returnsNullWhenNoAnimalIsFound_null() {
    assertTrue(Animal.find(999) == null);
  }
}
