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
}
