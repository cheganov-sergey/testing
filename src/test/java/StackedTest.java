import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * тестируем класс Stacked "Стопка"
 */

@DisplayName("Стопка")
public class StackedTest {
    private final double ESP = 1e-5;
    private static Stacked stack;

    @Before
    public  void CreateStack() {
        stack = new Stacked();
    }

    /**
     * проверяем корректность конструктора по умолчанию
     */
    @Description(value = "проверяем корректность конструктора по умолчанию")
    @Test
    @DisplayName("Создаем стопку по умолчанию")
    public void createStackTest() {
        Assert.assertEquals(stack.getName(),"Стопка (S)");
        Assert.assertEquals(stack.getWeight(), 0, ESP);
        Assert.assertTrue(stack.isFlat());
        Assert.assertTrue(stack.isBigSize());
    }

    /**
     * можно ли добавить новый предмет
     */
    @Description(value = "можно ли добавить новый предмет")
    @Test
    @DisplayName("Добаляем новый предмет")
    public void putItemToStackTest() {
        Brick brick1 = new Brick();
        stack.putItem(brick1);
        Assert.assertEquals(stack.getInsideItems().size(), 1);
    }

    /**
     *проверяем добавляется ли стопка в стопку
     */
    @Test
    @DisplayName("Добавление стопки в стопку")
    public void AddStackToStackTest() {
        Stacked stack2 = new Stacked();
        Brick brick = new Brick();
        Brick brick2 = new Brick();
        stack2.putItem(brick2);
        stack.putItem(brick);
        stack.putItem(stack2);
        int i = 0;
        while (!stack.getInsideItems().empty()) {
            stack.getItem();
            i++;
            }
        Assert.assertEquals(2, i);
        Assert.assertTrue(stack2.getInsideItems().empty());
    }

    /**
     * проверяем достается ли верхний предмет из стопки
     */
    @Test
    @DisplayName("Достаем верхний предмет из стопки")
    public void GetItemFromStack() {
        Brick brick = new Brick();
        stack.putItem(brick);
        stack.getItem();
        Assert.assertTrue(stack.getInsideItems().empty());
    }

}
