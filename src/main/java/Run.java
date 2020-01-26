public class Run {

    public static void main(String[] args) {

        Box box1 = new Box();
        Brick brick1 = new Brick();
        Brick brick2 = new Brick();
        Blok blok = new Blok();

        box1.putItem(brick1);
        box1.putItem(brick2);
        box1.putItem(brick1);
        box1.putItem(blok);
        box1.showItem();
        System.out.println(box1);
        System.out.println();

        Box box2 = new Box();
        Blok blok1 = new Blok();
        Blok blok2 = new Blok();
        Brick brick3 = new Brick();

        box2.putItem(blok1);
        box2.putItem(blok2);
        box2.putItem(brick3);
        box2.showItem();
        System.out.println(box2);
        box2.getItem(blok2);
        box2.getItem((blok2));
        box2.putItem(brick1);
        System.out.println(box2);
        System.out.println();

        Bag bag = new Bag();
        Whell whell1 = new Whell();
        Whell whell2 = new Whell();
        Whell whell3 = new Whell();
        bag.putItem(whell1);
        bag.putItem(whell2);
        bag.putItem(whell3);
        System.out.println(bag);
        bag.getItem(whell1);
        bag.getItem(blok);
        bag.putItem(blok);
        bag.putItem(brick1);
        bag.showItem();
        System.out.println(bag);
        System.out.println();

        StackedLinkList stackLL = new StackedLinkList();
        stackLL.putItem(whell1);
        stackLL.putItem(whell1); // проверка на дубликат объекта
        stackLL.putItem(whell2);
        stackLL.putItem(whell3);
        stackLL.putItem(box1);
        stackLL.putItem(box2);
        stackLL.putItem(brick1);
        stackLL.showItem();
        System.out.println(stackLL);
        StackedLinkList sll =new StackedLinkList();
        sll.showItem();
        System.out.println();



//        Stacked stack = new Stacked();
//        stack.putItem(box1);
//        stack.putItem(box2);
//        stack.putItem(whell1);
//        stack.putItem(bag);
//        stack.putItem(brick1);
//        stack.putItem(whell2);
//        stack.putItem(whell2);
//        stack.putItem(whell3);
//
//        System.out.println(stack);
//        stack.getItem(brick1);
//       // stack.getItem(brick2);
//       // stack.showItem();
//        System.out.println(stack);








    }
}
