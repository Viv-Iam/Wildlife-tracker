import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class AnimalTest {

  @Rule
    public DatabaseRule database = new DatabaseRule();

  private Animal mAnimal;
  @Before
  public void instantiate() {
    mAnimal = new Animal("Cheetah", "No");
  }

//ensures new object of class Animal instantiates correctly
  @Test
    public void animal_instantiatesCorrectly_true() {
      assertEquals(true, mAnimal instanceof Animal);
    }

  @Test
    public void getName_animalInstantiatesWithName_Cheetah() {
      assertEquals("Cheetah", mAnimal.getName());
    }

  @Test
  public void getEndangered_animalInstantiatesWithEndangered_No() {
    assertEquals("No", mAnimal.getEndangered());
  }

  @Test
 public void equals_returnsTrueIfNameAreSame_true() {
   Animal testAnimal = mAnimal;
   Animal anotherAnimal = mAnimal;
   assertTrue(testAnimal.equals(anotherAnimal));
 }

 @Test
 public void save_insertsObjectIntoDatabase_Animal() {
   mAnimal.save();
   assertEquals(true, Animal.all().get(0).equals(mAnimal));
 }

}
