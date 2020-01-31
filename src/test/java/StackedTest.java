import net.sf.saxon.om.Item;
import org.junit.Assert;
import org.junit.Test;

/**
 * тестируем класс Stacked "Стопка"
 */

public class StackedTest {
    private final double ESP = 1e-5;
    private static Stacked stacked;
    private  static Brick brick1, brick2;

    /**
     * проверяем корректность конструктора по умолчанию
     */
    @Test
    public void createStackTest() {
        stacked = new Stacked();
        Assert.assertEquals(stacked.getName(),"Стопка (S)");
        Assert.assertEquals(stacked.getWeight(), 0, ESP);
        Assert.assertFalse(stacked.isFlat());
        Assert.assertTrue(stacked.isBigSize());
    }

    /**
     * можно ли добавить новый предмет
     */
    @Test
    public void putItemToStackTest() {
        stacked = new Stacked();
        brick1 = new Brick();
        stacked.putItem(brick1);
        Assert.assertEquals(stacked.getInsideItems().size(), 1);
    }

}
