import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class Item {

   String name;
   double weight;
   boolean flat;
   boolean bigSize;
   Set<String> otherCharacters;

   // Конструктор объекта по умолчанию
   public Item(){
      this.name = "name";
      this.weight = 0.0;
      this.flat = true;
      this.bigSize = false;
      this.otherCharacters = new HashSet<String>();
   }


   // Конструктор без доп.параметров
   public Item(String name, double weight, boolean flat, boolean bigSize) {
      this.name = name;
      this.weight = weight;
      this.flat = flat;
      this.bigSize = bigSize;
      this.otherCharacters = new HashSet<String>();
   }

   // конструктор с доп. параметрами
   public Item(String name, double weight, boolean flat, boolean bigSize, Set<String> otherCharacters) {
      this.name = name;
      this.weight = weight;
      this.flat = flat;
      this.bigSize = bigSize;
      this.otherCharacters = new HashSet<String>(otherCharacters);
   }

   @Override
   public String toString() {
      return "Item{" +
              "name='" + name + '\'' +
              '}';
   }
}
