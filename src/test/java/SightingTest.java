import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;



private Animal mAnimal;
private Animal mAnimal1;
@Before
public void instantiate() {
  mAnimal = new Animal("Cheetah", "No");
  mAnimal1 = new Animal("Gazelle", "No");
}
