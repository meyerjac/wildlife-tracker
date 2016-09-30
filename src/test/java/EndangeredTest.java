// import org.sql2o.*;
// import org.junit.*;
// import static org.junit.Assert.*;
// import java.util.*;
//
// public class EndangeredTest {
//
//   @Rule
//   public DatabaseRule database = new DatabaseRule();
//
//   @Test
//   public void endangered_instantiatesCorrectly_true() {
//     Endangered endangered = new Endangered("deer", "healthy", 13, "adult");
//     assertEquals(true, endangered instanceof Endangered);
//   }
//   @Test
//   public void endangered_returnsName_True() {
//     Endangered endangered = new Endangered("deer", "healthy", 13, "adult");
//     assertEquals("deer", endangered.getName());
//   }
//   @Test
//   public void equals_returnsTrueIfNameIsTheSame_true() {
//     Endangered endangered = new Endangered("deer", "healthy", 13, "adult");
//     Endangered endangered1 = new Endangered("deer", "healthy", 13, "adult");
//     assertTrue(endangered1.equals(endangered));
//   }
//   @Test
//   public void equals_FalseIfAttributesAreDifferent_false() {
//     Endangered endangered = new Endangered("deer", "healthy", 13, "adult");
//     Endangered endangered1 = new Endangered("deer", "healthy", 13, "adult");
//     assertTrue(endangered1.equals(endangered));
//   }
//   @Test
//   public void all_returnsAllInstancesOfEndangered_true() {
//     Endangered endangered = new Endangered("deer", "healthy", 13, "adult");
//     Endangered endangered1 = new Endangered("deer", "healthy", 13, "adult");
//     endangered.save();
//     endangered.save();
//     assertEquals(true, Endangered.all().get(0).equals(endangered));
//     assertEquals(true, Endangered.all().get(1).equals(endangered1));
//   }
//   @Test
//   public void save_savesToDataBase_true() {
//     Endangered endangered = new Endangered("deer", "healthy", 13, "adult");
//     endangered.save();
//     assertEquals(true, Endangered.all().get(0).equals(endangered));
//   }
//
//   @Test
//   public void save_assignsIdToEndangered_true() {
//     Endangered endangered = new Endangered("deer", "healthy", 13, "adult");
//     endangered.save();
//     assertEquals(true, endangered.getId() > 0);
//   }
// }
