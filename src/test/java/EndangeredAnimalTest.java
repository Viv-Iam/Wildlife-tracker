import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.*;
import org.sql2o.*;

public class EndangeredAnimalTest {

  @Rule
  public DatabaseRule databaseRule = new DatabaseRule();

  @Test
  public void getId_returnsIdOfEndangeredAnimal_int() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Lion", EndangeredAnimal.HEALTHY, EndangeredAnimal.ADULT);
    testEndangeredAnimal.save();
    assertTrue(testEndangeredAnimal.getId() > 0);
  }

  @Test
    public void getName_returnsNameOfEndangeredAnimal_String() {
      EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Lion", EndangeredAnimal.HEALTHY, EndangeredAnimal.ADULT);
      testEndangeredAnimal.save();
      assertEquals("Lion", testEndangeredAnimal.getName());
    }

    @Test
 public void setName_changesNameOfEndangeredAnimal_void() {
   EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Lion", EndangeredAnimal.HEALTHY, EndangeredAnimal.ADULT);
   testEndangeredAnimal.save();
   testEndangeredAnimal.setName("Jaguar");
   assertEquals("Jaguar", testEndangeredAnimal.getName());
 }

}
