import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class EndangeredAnimalTest {
  private EndangeredAnimal mEndangeredAnimal;
  @Before
  public void instantiate() {
    mEndangeredAnimal = new EndangeredAnimal("Spotted Hyena", "yes", "ill", "young");
  }

  EndangeredAnimal endangered1 = new EndangeredAnimal("Spotted Owl", "yes", "ill", "young");
  EndangeredAnimal endangered2 = new EndangeredAnimal("Black Rhino", "yes", "okay", "newborn");

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void endangeredAnimal_instantiatesCorrectly_true() {
    // EndangeredAnimal testEndangeredAnimal = endangered1;
    assertEquals(true, mEndangeredAnimal instanceof EndangeredAnimal);
  }

  @Test
  public void getName_animalInstantiatesWithName_Owl() {
    // EndangeredAnimal testEndangeredAnimal = endangered1;
    assertEquals("Spotted Hyena", mEndangeredAnimal.getName());
  }

  @Test
  public void getEndangered_animalInstantiatesWithEndangered_no() {
    // EndangeredAnimal testEndangeredAnimal = endangered1;
    assertEquals("yes", mEndangeredAnimal.getEndangered());
  }

  @Test
  public void getEndangered_animalInstantiatesWithAge_young() {
    // EndangeredAnimal testEndangeredAnimal = endangered1;
    assertEquals("young", mEndangeredAnimal.getAge());
  }

  @Test
  public void getEndangered_personInstantiatesWithHealth_ill() {
    // EndangeredAnimal testEndangeredAnimal = endangered1;
    assertEquals("ill", mEndangeredAnimal.getHealth());
  }

  @Test
  public void equals_returnsTrueIfNameAreSame_true() {
    EndangeredAnimal testEndangeredAnimal = mEndangeredAnimal;
    EndangeredAnimal anotherEndangeredAnimal = mEndangeredAnimal;
    assertTrue(testEndangeredAnimal.equals(anotherEndangeredAnimal));
  }

  @Test
  public void save_insertsObjectIntoDatabase_EndangeredAnimal() {
    // EndangeredAnimal testEndangeredAnimal = endangered1;
    mEndangeredAnimal.save();
    assertEquals(true, Animal.all().get(0).equals(mEndangeredAnimal));
  }

  @Test
  public void save_assignsIdToEndangeredAnimal() {
    // EndangeredAnimal testEndangeredAnimal = endangered1;
    mEndangeredAnimal.save();
    Animal savedEndangeredAnimal = Animal.all().get(0);
    assertEquals(savedEndangeredAnimal.getId(), mEndangeredAnimal.getId());
  }

  @Test
  public void all_returnsAllInstancesOfEndangeredAnimal_true() {
    EndangeredAnimal firstEndangeredAnimal = endangered1;
    firstEndangeredAnimal.save();
    EndangeredAnimal secondEndangeredAnimal = endangered2;
    secondEndangeredAnimal.save();
    assertEquals(true, Animal.all().get(0).equals(firstEndangeredAnimal));
    assertEquals(true, Animal.all().get(1).equals(secondEndangeredAnimal));
  }

  @Test
  public void find_returnsEndangeredAnimalWithSameId_secondEndangeredAnimal() {
    EndangeredAnimal firstEndangeredAnimal = endangered1;
    firstEndangeredAnimal.save();
    EndangeredAnimal secondEndangeredAnimal = endangered2;
    secondEndangeredAnimal.save();
    assertEquals(Animal.find(secondEndangeredAnimal.getId()), secondEndangeredAnimal);
  }

  @Test
  public void setEndangered_Animal_true() {
    EndangeredAnimal myEndangeredAnimal = new EndangeredAnimal("Spotted Owl", "no", "healthy", "young");
    myEndangeredAnimal.save();
    myEndangeredAnimal.setEndangered("yes", "ill", "newborn");
    assertEquals("yes", EndangeredAnimal.find(myEndangeredAnimal.getId()).getEndangered());
    assertEquals("ill", EndangeredAnimal.find(myEndangeredAnimal.getId()).getHealth());
    assertEquals("newborn", EndangeredAnimal.find(myEndangeredAnimal.getId()).getAge());
  }

  @Test(expected = IllegalArgumentException.class)
  public void setEndangered_throwsExceptionIfHealthIsNotAChoice(){
    EndangeredAnimal myEndangeredAnimal = new EndangeredAnimal("Spotted Owl", "no", "healthy", "young");
    myEndangeredAnimal.save();
    myEndangeredAnimal.setEndangered("yes", "blech", "newborn");
  }

  @Test(expected = IllegalArgumentException.class)
  public void setEndangered_throwsExceptionIfAgeIsNotAChoice(){
    EndangeredAnimal myEndangeredAnimal = new EndangeredAnimal("Spotted Owl", "no", "healthy", "young");
    myEndangeredAnimal.save();
    myEndangeredAnimal.setEndangered("yes", "ill", "blech");
  }
}
