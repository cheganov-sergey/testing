import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

/**
 * тестируем Box
 * ESP - точность проверки double
 **/
@DisplayName("Корбка")
public class BoxTest {
    private static final double ESP = 1e-9;
    private static Box box1, box2;
    private  static Brick brick1, brick2;

    /**
     * создм новые коробки перед каждым тестом
     */
    @Before
    public void  createBoxTest() {
        box1 = new Box();
        box2 = new Box("коробка конструктор 1", 1.0, true, false, 30.0);
    }

    /**
     * проверка конструктора по умолчанию
     */
    @Description (value = "проверка конструктора по умолчанию")
    @Test
    @DisplayName("Создаем коробку по умолчанию")
    public void crateBoxTestDeffaultConstructor() {
        Assert.assertEquals(box1.name, "Стандартная коробка");
        Assert.assertEquals(box1.getWeight(), 1, ESP);
        Assert.assertTrue(box1.isFlat());
        Assert.assertTrue(box1.isBigSize());
        Assert.assertEquals(box1.getAllowadlWeight(), 30, ESP);
    }

    /**
     * тестирование метода подсчета общего веса коробки
     * вес предметов в коробке + вес самой коробки
     * @throws CaseExсeption - случай превышения допустимого веса
     */
    @Description (value = "Тестирование метода подсчета общего веса коробки." )
    @Test
    @DisplayName("Вычисляем вес коробки")
    public void getCurrentWeighTest() throws CaseExсeption {
        brick1 = new Brick(5);
        brick2 = new Brick(10);
        box2.putItem(brick1);
        box2.putItem(brick2);
        Assert.assertEquals(box2.getCurrentweigth(), 16, ESP);
    }

    /**
     * проверка на выброс исключения методом putItem при привышении допустимого веса
     * @throws CaseExсeption - первышение допустимого веса
     */
    @Description (value = "проверка на выброс исключения методом putItem при привышении допустимого веса")
    @Test (expected = CaseExсeption.class)
    @DisplayName("Проверка на перегруз коробки")
        public void moreThatAllowWeighthShouldThrowsException () throws CaseExсeption {
        brick1 = new Brick(35);
        box1.putItem(brick1);
    }

    /**
     * нельзя добавить не габаритный предмет в коробку
     * @throws CaseExсeption
     */
    @Description (value = "нельзя добавить не габаритный предмет в коробку")
    @Test
    @DisplayName("Проверяем на добавление не габаритного предмета")
    public void tryAddNotFlatItemToBox() throws CaseExсeption {
        Whell well = new Whell(); // создаем не габаритный предмет
        box1.putItem(well);
        Assert.assertEquals(0,box1.getInsideItems().size());
    }

    /**
     * добавляем габаритный предмет в коробку
     * @throws CaseExсeption
     */
    @Description (value = "добавляем габаритный предмет в коробку")
    @Test
    @DisplayName("Кладем плоский предмет в короку")
    public void tryAddFlatItemToBox() throws  CaseExсeption {
        brick2 = new Brick(1); // создаем плоский предмет
        box1.putItem(brick2);
        Assert.assertEquals(1, box1.getInsideItems().size());
    }

    /**
     * проверяем достается ли предмет
     * @throws CaseExсeption
     */
    @Test
    @DisplayName("Достаем предмет из коробки")
    public void GetItemFromBox() throws CaseExсeption {
        Brick brick = new Brick();
        box1.putItem(brick);
        box1.getItem(brick);
        Assert.assertEquals(0, box1.insideItems.size());
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
        box1.putItem(brick);
        box1.putItem(blok);
        Assert.assertEquals(blok.name ,box1.getByName("Блок"));
    }
    @Test
    @DisplayName("Пытамеся упаковать предмет сам в себя")
    public void AddBoxToThisBox() throws CaseExсeption {
        box1.putItem(box1);
        Assert.assertEquals(0, box1.insideItems.size());
    }

}
