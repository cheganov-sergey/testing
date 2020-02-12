public class Run {

    public static void main(String[] args) {

        Box box1 = new Box();
        Brick brick1 = new Brick();
        Brick brick2 = new Brick(10);
        Blok blok = new Blok();

        try {
            box1.putItem(brick1);
            box1.putItem(brick2);
            box1.putItem(brick1);
            box1.putItem(blok);
        }
        catch (CaseExсeption e){
            System.out.println("Коробка порвалась! " + e);
        }
        box1.showItem();
        System.out.println(box1);
        System.out.println();

        Box box2 = new Box();
        Brick brick = new Brick();
        Blok blok1 = new Blok();
        Blok blok2 = new Blok();
        Brick brick3 = new Brick();

        try {
            box2.putItem(brick);
            box2.putItem(blok2);
            box2.putItem(brick3);
            box2.putItem(brick1);
            box1.putItem(box1);
            box2.putItem(blok1);
        }
        catch (CaseExсeption e){
            System.out.println("Коробка порвалась! " + e);
        }
        box2.showItem();
        System.out.println(box2);
        box2.getItem(blok2);
        box2.getItem((blok2));
        System.out.println(box2);
        box1.getRandom();
        System.out.println();

        Bag bag = new Bag();
        Whell whell1 = new Whell();
        Whell whell2 = new Whell();
        Whell whell3 = new Whell();
        try {
            bag.putItem(whell1);
            bag.putItem(whell2);
            bag.putItem(whell3);
        }
        catch (CaseExсeption e) {
            System.out.println("Мешок порвался! " + e);
        }
        Brick  brick5 = new Brick();

        System.out.println(bag);
        bag.getItem(whell1);
        bag.getItem(blok);
        try {
            bag.putItem(brick5);
            bag.putItem(blok);
            bag.putItem(bag);
        }
        catch (CaseExсeption e) {
            System.out.println("Мешок порвался! " + e);
        }
        bag.showItem();
        System.out.println(bag);

        bag.getByName("Колесо");
        bag.showItem();
        bag.getRandom();
        System.out.println();

        Stacked stack = new Stacked();
        stack.putItem(box1);
        stack.putItem(box2);
        stack.putItem(whell1);
        stack.putItem(bag);
        stack.putItem(brick1);
        stack.putItem(whell2);
        stack.putItem(whell2);
        stack.putItem(whell3);

        System.out.println(stack);
        stack.getItem();
        //stack.getItem();
        stack.showItem();
        stack.putItem(stack);
        System.out.println(stack);

        System.out.println("Стопка 2:");
        Stacked stac2 = new Stacked();
        stac2.putItem(brick5);
        stac2.putItem(stack);
        System.out.println(stac2);
        System.out.println(stack);
    }
}
