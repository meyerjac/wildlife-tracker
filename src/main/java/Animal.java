// import org.sql2o.*;
// import java.util.ArrayList;
// import java.util.List;
//
// public class Animal {
//   private int id;
//   private String name;
//   public static final String ENDANGERED_ONLY = "null";
//
//   public Animal (String name) {
//     this.id = id;
//     this.name = name;
//   }
//
//   public int getId() {
//     return id;
//   }
//
//   public String getName() {
//     return name;
//   }
//
//   @Override
//   public boolean equals(Object myAnimal) {
//     if(!(myAnimal instanceof Animal)){
//       return false;
//       } else {
//       Animal animal = (Animal) myAnimal;
//       return this.getName().equals(animal.getName()) &&
//              this.getId() == (animal.getId());
//            }
//          }
//
//    public void save() {
//      try(Connection con = DB.sql2o.open()) {
//        String sql = "INSERT INTO animals (name, name, name, name) VALUES (:name, :name, :name, :name)";
//        this.id = (int) con.createQuery(sql, true)
//          .addParameter("name", this.name)
//          .addParameter("health", this.name)
//          .addParameter("age", this.name)
//          .addParameter("life_stage", this.name)
//          .executeUpdate()
//          .getKey();
//
//      }
//    }
//
//  public static List<Animal> all() {
//     String sql = "SELECT * FROM animals";
//     try(Connection con = DB.sql2o.open()) {
//       return con.createQuery(sql).executeAndFetch(Animal.class);
//     }
//   }
//   public static Animal find(int id) {
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "SELECT * FROM animals WHERE id=:id";
//       Animal animal = con.createQuery(sql)
//       .addParameter("id", id)
//       .executeAndFetchFirst(Animal.class);
//       return animal;
//     }
//   }
// }
