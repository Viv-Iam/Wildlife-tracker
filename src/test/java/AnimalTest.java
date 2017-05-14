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
    mAnimal = new Animal("Cheetah");
  }

}
