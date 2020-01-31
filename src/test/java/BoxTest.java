import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

/**
 * тесьируем Box
 * ESP - точность проверки double
 **/
public class BoxTest {
    private final double ESP = 1e-9;
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
    @Test
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
    @Test
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
    @Test (expected = CaseExсeption.class)
        public void moreThatAllowWeighthShouldThrowsException () throws CaseExсeption {
        brick1 = new Brick(35);
        box1.putItem(brick1);
    }

    /**
     * нельзя добавить не плоский предмет в коробку
     * @throws CaseExсeption
     */
    @Test
    public void tryAddNotFlatItemToBox() throws CaseExсeption {
        Bag bag = new Bag(); // создаем не плоский предмет
        box1.putItem(bag);
        Assert.assertEquals(box1.getInsideItems().size(), 0);
    }

    /**
     * можно добавить плоский в коробку
     * @throws CaseExсeption
     */
    @Test
    public void tryAddFlatItemToBox() throws  CaseExсeption {
        brick2 = new Brick(1); // создаем плоский предмет
        box1.putItem(brick2);
        Assert.assertEquals(box1.getInsideItems().size(), 1);
    }

}
