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

//ensures animal name entered is retrieved
  @Test
    public void getName_animalInstantiatesWithName_Cheetah() {
      assertEquals("Cheetah", mAnimal.getName());
    }

//asserts animal object does not instantiate with endangered
  @Test
  public void getEndangered_animalInstantiatesWithEndangered_No() {
    assertEquals("No", mAnimal.getEndangered());
  }

//ensures object returns names if they are the same
  @Test
 public void equals_returnsTrueIfNameAreSame_true() {
   Animal testAnimal = mAnimal;
   Animal anotherAnimal = mAnimal;
   assertTrue(testAnimal.equals(anotherAnimal));
 }

//ensures object values are saved in database
 @Test
 public void save_insertsObjectIntoDatabase_Animal() {
   mAnimal.save();
   assertEquals(true, Animal.all().get(0).equals(mAnimal));
 }

//ensures animal object is assigned an id when saved
 @Test
  public void save_assignsIdToAnimal() {
    mAnimal.save();
    Animal savedAnimal = Animal.all().get(0);
    assertEquals(savedAnimal.getId(), mAnimal.getId());
  }

  @Test
    public void all_returnsAllInstancesOfAnimal_true() {
      Animal firstAnimal = animal1;
      firstAnimal.save();
      Animal secondAnimal = animal2;
      secondAnimal.save();
      assertEquals(true, Animal.all().get(0).equals(firstAnimal));
      assertEquals(true, Animal.all().get(1).equals(secondAnimal));
    }

}
