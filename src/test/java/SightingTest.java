import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;

public class SightingTest {

private Sighting mSighting;
private Sighting mSighting1;
@Before
public void instantiate() {
  mSighting = new Sighting("Jane", "Zone A", 1);
  mSighting1 = new Sighting("Jwaqs", "Zone B", 2);
}
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
 public void sighting_instantiatesCorrectly_true() {
   assertEquals(true, mSighting instanceof Sighting);
 }
 @Test
   public void getRangerName_personInstantiatesWithRangerName_Henry() {
     assertEquals("Jane", mSighting.getRangerName());
   }


}
