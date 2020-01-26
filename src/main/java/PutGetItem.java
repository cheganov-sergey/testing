public interface PutGetItem {

    // Данный интерфейс реализует возможность складировать предметы различными способоами и контролировать предельный вес системы хранения

    public void putItem(Item item); // добавить предмет
    public void getItem(Item item); // забрать предмет
    public void showItem(); // посмотреть что содержится внутри
    public double getCurrentweigth(); // общий вес / размер стопки

}
