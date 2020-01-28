import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class Item {

   String name;  // имя
   double weight;  // вес
   boolean flat;  // можно ли упаковывать стопкой
   boolean bigSize;   // негабаритная вещь
   Set<String> otherCharacters;  // дополнительные параметры
   boolean packed;   // защита от повторной упаковки

   // Конструктор объекта по умолчанию
   public Item(){
      this.name = "name";
      this.weight = 0.0;
      this.flat = true;
      this.bigSize = false;
      this.otherCharacters = new HashSet<String>();
      boolean packed = false;
   }


   public Item(String name, double weight, boolean flat, boolean bigSize, boolean packed) {
      this.name = name;
      this.weight = weight;
      this.flat = flat;
      this.bigSize = bigSize;
      this.otherCharacters = new HashSet<String>();
      this.packed = packed;
   }

   // Конструктор без доп.параметров
   public Item(String name, double weight, boolean flat, boolean bigSize) {
      this.name = name;
      this.weight = weight;
      this.flat = flat;
      this.bigSize = bigSize;
      this.otherCharacters = new HashSet<String>();
      boolean packed = false;
   }

   // конструктор с доп. параметрами
   public Item(String name, double weight, boolean flat, boolean bigSize, Set<String> otherCharacters) {
      this.name = name;
      this.weight = weight;
      this.flat = flat;
      this.bigSize = bigSize;
      this.otherCharacters = new HashSet<String>(otherCharacters);
      boolean packed = false;
   }

   @Override
   public String toString() {
      return "Item{" +
              "name='" + name + '\'' +
              '}';
   }
}
