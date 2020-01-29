/**
исключение при разрыве мешка или коробки
 */

public class CaseExсeption extends Exception {

    public CaseExсeption() {
    }

    public CaseExсeption(String message) {
        super(message);
    }

    public CaseExсeption(String message, Throwable cause) {
        super(message, cause);
    }

    public CaseExсeption(Throwable cause) {
        super(cause);
    }



}
