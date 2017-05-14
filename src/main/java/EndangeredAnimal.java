import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;

public class EndangeredAnimal extends Animal {

  private String health;
  private String age;

  public static final String ANIMAL_TYPE = "endangered";
  public static final String HEALTHY = "distinctly healthy";
  public static final String AVERAGE = "average";
  public static final String ILL = "distinctly unhealthy";
  public static final String ADULT = "adult";
  public static final String YOUNG = "youthful";
  public static final String NEWBORN = "newborn";

  public EndangeredAnimal(String pName, String pHealth, String pAge) {
    super(pName);
    this.type = ANIMAL_TYPE;
    this.health = pHealth;
    this.age = pAge;
  }

  public String getHealth() {
     return this.health;
   }

   public String getAge() {
     return this.age;
   }

}
