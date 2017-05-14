import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  @Override
  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wild_tracker_test", "viv-iam", "password");
  }
//empties Sightings and Animals tables after each spec
  @Override
    protected void after() {
      try(Connection con = DB.sql2o.open()) {
        String deleteSightingssQuery = "DELETE FROM persons *;";
        String deleteAnimalsQuery = "DELETE FROM monsters *;";
        con.createQuery(deleteSightingssQuery).executeUpdate();
        con.createQuery(deleteAnimalsQuery).executeUpdate();
      }
    }

}
