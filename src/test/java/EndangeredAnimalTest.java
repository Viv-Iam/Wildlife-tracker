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

 @Test
  public void getHealth_returnsHealthOfEndangeredAnimal_String() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Lion", EndangeredAnimal.HEALTHY, EndangeredAnimal.ADULT);
    testEndangeredAnimal.save();
    assertEquals(EndangeredAnimal.HEALTHY, testEndangeredAnimal.getHealth());
  }

  @Test
  public void getAge_returnsAgeOfEndangeredAnimal_String() {
    EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Lion", EndangeredAnimal.HEALTHY, EndangeredAnimal.ADULT);
    testEndangeredAnimal.save();
    assertEquals(EndangeredAnimal.ADULT, testEndangeredAnimal.getAge());
  }

  @Test
public void findById_returnsInstanceOfEndangeredAnimalById_EndangeredAnimal() {
  EndangeredAnimal testEndangeredAnimal1 = new EndangeredAnimal("Lion", EndangeredAnimal.HEALTHY, EndangeredAnimal.ADULT);
  testEndangeredAnimal1.save();
  EndangeredAnimal testEndangeredAnimal2 = new EndangeredAnimal("Jaguar", EndangeredAnimal.HEALTHY, EndangeredAnimal.ADULT);
  testEndangeredAnimal2.save();
  EndangeredAnimal object1FoundById = EndangeredAnimal.findById(testEndangeredAnimal1.getId());
  EndangeredAnimal object2FoundById = EndangeredAnimal.findById(testEndangeredAnimal2.getId());
  assertTrue(testEndangeredAnimal1.equals(object1FoundById));
  assertTrue(testEndangeredAnimal2.equals(object2FoundById));
}

}
