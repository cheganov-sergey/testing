/**
 * Данный интерфейс реализует возможность складировать предметы различными способоами и контролировать предельный вес системы хранения
 */
public interface PutGetItem {

   void putItem(Item item) throws CaseExсeption; // добавить предмет
   void getItem(Item item); // забрать предмет
   void showItem(); // посмотреть что содержится внутри
   double getCurrentweigth(); // общий вес / размер стопки

}
