import org.sql2o.*;
import java.util.List;

public class Animal {
//Animal class attributes
public String name;

//Animal constructor
public Animal(String name) {
  this.name = name;
}
//implement getName()
public String getName() {
  return name;
}
}
