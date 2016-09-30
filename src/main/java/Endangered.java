// import org.sql2o.*;
// import java.util.ArrayList;
// import java.util.List;
//
// public class Endangered {
//   private int id;
//   private String name;
//   private String health;
//   private int age;
//   private String lifeStage;
//
//   public Endangered (String name, String health, int age, String lifeStage) {
//
//     this.name = name;
//     this.health = health;
//     this.age = age;
//     this.lifeStage = lifeStage;
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
//   public String getHealth() {
//     return health;
//   }
//
//   public int getAge() {
//     return age;
//   }
//
//   public String getLifeStage() {
//     return lifeStage;
//   }
//
//
//   @Override
//   public boolean equals(Object otherEndangered) {
//     if (!(otherEndangered instanceof Endangered)) {
//       return false;
//     } else {
//       Endangered newEndangered = (Endangered) otherEndangered;
//       return this.getLifeStage().equals(newEndangered.getLifeStage()) &&
//              this.getAge() ==(newEndangered.getAge()) &&
//              this.getHealth().equals(newEndangered.getHealth()) &&
//              this.getName().equals(newEndangered.getName()) &&
//              this.getId() == (newEndangered.getId());
//
//     }
//   }
//
//   public void save() {
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "INSERT INTO animals (name, health, age, life_stage) VALUES (:name, :health, :age, :lifeStage)";
//       this.id = (int) con.createQuery(sql, true)
//         .addParameter("name", this.name)
//         .addParameter("health", this.health)
//         .addParameter("age", this.age)
//         .addParameter("lifeStage", this.lifeStage)
//         .executeUpdate()
//         .getKey();
//     }
//   }
//
//   public static List<Endangered> all() {
//     String sql = "SELECT * FROM animals";
//     try(Connection con = DB.sql2o.open()) {
//       return con.createQuery(sql).executeAndFetch(Endangered.class);
//     }
//   }
//
//   public static Endangered find(int id) {
//     String sql = "SELECT * FROM animals where id=:id";
//     try(Connection con = DB.sql2o.open()) {
//       Endangered endangered= con.createQuery(sql)
//         .addParameter("id", id)
//         .executeAndFetchFirst(Endangered.class);
//       return endangered;
//     }
// }
// }
