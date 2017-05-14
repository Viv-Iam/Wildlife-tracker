import org.sql2o.*;
import java.util.List;

public class Animal {
//Animal class attributes
public String name;
public String endangered;
public int id;

//Animal constructor
public Animal(String name, String endangered) {
  this.name = name;
  this.endangered = endangered;
}
//implement getName()
public String getName() {
  return name;
}
//implement getEndangered()
public String getEndangered() {
    return endangered;
  }
//implement getId()
public int getId() {
    return id;
  }

  public void save() {
      if (name.equals("")) {
        throw new IllegalArgumentException("Please enter a name.");
      }
      try(Connection con = DB.sql2o.open()) {
        String sql = "INSERT INTO animals (name, endangered) VALUES (:name, :endangered)";
        this.id = (int) con.createQuery(sql, true)
          .addParameter("name", this.name)
          .addParameter("endangered", this.endangered)
          .throwOnMappingFailure(false)
          .executeUpdate()
          .getKey();
      }
    }



}
