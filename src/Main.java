import command.*;

import java.util.*;

/**
 * @author Alexandr Scherbakov P3114 (335101)
 * project entry point
 */
public class Main {
    static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Client client = new Client(scan);
        try {
            client.run();
        } catch (Exception e){
            client.stop();
//            System.err.println("Возникла ошибка. Работа программы прекращена");
            System.err.println(e.getMessage());
        }
    }
}
