import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * абстрактный класс Item - родитель всего ))
 */
public abstract class Item {

   String name;  // имя
   private double weight;  // вес
   private boolean flat;  // можно ли упаковывать стопкой
   private boolean bigSize;   // негабаритная вещь
   private Set<String> otherCharacters;  // дополнительные параметры
   private boolean packed;   // защита от повторной упаковки

   public Item(){
      this.name = "name";
      this.weight = 0.0;
      this.flat = true;
      this.bigSize = false;
      this.otherCharacters = new HashSet<String>();
      boolean packed = false;
   }
   /**
    * @param name нозвание предмета
    * @param weight  вес предметка в кг.
    * @param flat можно ли складировать стопкой
    * @param bigSize можно ли положить в коробку (если false
    * @param packed предмет уже где то хранится (при помещении в контейнер true)
    */
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

   public String getName() {
      return name;
   }

   public double getWeight() {
      return weight;
   }

   public boolean isFlat() {
      return flat;
   }

   public boolean isBigSize() {
      return bigSize;
   }

   public Set<String> getOtherCharacters() {
      return otherCharacters;
   }

   public boolean isPacked() {
      return packed;
   }


   public void setOtherCharacters(Set<String> otherCharacters) {
      this.otherCharacters = otherCharacters;
   }

   public void setPacked(boolean packed) {
      this.packed = packed;
   }
}
