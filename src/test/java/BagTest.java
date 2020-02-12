import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@DisplayName("Мешок")
public class BagTest {

    private static Bag bag;
    private static final double ESP = 1e-9;
    private  static Brick brick1, brick2;

    @Before
    public void CreateBag() {
        bag = new Bag();
    }

    @Description(value = "проверка конструктора по умолчанию")
    @Test
    @DisplayName("Создаем мешок по умолчанию")
    public void crateBoxTestDeffaultConstructor() {
        Assert.assertEquals(bag.name, "Мешок");
        Assert.assertEquals(bag.getWeight(), 1, ESP);
        Assert.assertFalse(bag.isFlat());
        Assert.assertTrue(bag.isBigSize());
        Assert.assertEquals(bag.getAllowadlWeight(), 50.0, ESP);
    }

    /**
     * тестирование метода подсчета общего веса мешка
     * вес предметов в коробке + вес самой мешка
     * @throws CaseExсeption - случай превышения допустимого веса
     */
    @Description (value = "Тестирование метода подсчета общего веса мешка." )
    @Test
    @DisplayName("Вычисляем вес мешка")
    public void getCurrentWeighTest() throws CaseExсeption {
        brick1 = new Brick(5);
        brick2 = new Brick(10);
        Bag bag2 = new Bag();
        bag2.putItem(brick1);
        bag2.putItem(brick2);
        Assert.assertEquals(bag2.getCurrentweigth(), 16, ESP);
    }

    /**
     * проверка на выброс исключения методом putItem при привышении допустимого веса
     * @throws CaseExсeption - первышение допустимого веса
     */
    @Description (value = "проверка на выброс исключения методом putItem при привышении допустимого веса")
    @Test (expected = CaseExсeption.class)
    @DisplayName("Проверка на перегруз мешка")
    public void moreThatAllowWeighthShouldThrowsException () throws CaseExсeption {
        brick1 = new Brick(55);
        bag.putItem(brick1);
    }

    /**
     * нельзя добавить не габаритный предмет в мешок
     * @throws CaseExсeption
     */
    @Description (value = "нельзя добавить не габаритный предмет в мешок")
    @Test
    @DisplayName("Проверяем на добавление не габаритного предмета")
    public void tryAddNotFlatItemToBox() throws CaseExсeption {
        Whell well = new Whell(); // создаем не габаритный предмет
        bag.putItem(well);
        Assert.assertEquals(1,bag.getInsideItems().size());
    }

    /**
     * добавляем габаритный предмет в мешок
     * @throws CaseExсeption
     */
    @Description (value = "добавляем габаритный предмет в мешок")
    @Test
    @DisplayName("Кладем габаритный предмет в мешок")
    public void tryAddFlatItemToBox() throws  CaseExсeption {
        brick2 = new Brick(1); // создаем плоский предмет
        bag.putItem(brick2);
        Assert.assertEquals(1, bag.getInsideItems().size());
    }

    /**
     * проверяем достается ли предмет
     * @throws CaseExсeption
     */
    @Test
    @DisplayName("Достаем предмет из мешка")
    public void GetItemFromBox() throws CaseExсeption {
        Brick brick = new Brick();
        bag.putItem(brick);
        bag.getItem(brick);
        Assert.assertEquals(0, bag.insideItems.size());
    }

    /**
     * достаем предмет по имени
     * @throws CaseExсeption
     */
    @Test
    @DisplayName("Достаем предмет по имени")
    public void GetItemByName() throws CaseExсeption {
        Brick brick = new Brick();
        Blok blok = new Blok();
        bag.putItem(brick);
        bag.putItem(blok);
        Assert.assertEquals(blok.name ,bag.getByName("Блок"));
    }
    @Test
    @DisplayName("Пытамеся упаковать предмет сам в себя")
    public void AddBoxToThisBox() throws CaseExсeption {
        bag.putItem(bag);
        Assert.assertEquals(0, bag.insideItems.size());
    }

}
