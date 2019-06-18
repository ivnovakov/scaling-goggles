package lab03;

import lab03.model.DateStorage;

public class Lab03 {
    public static void main(String[] args) {
        DateStorage computerStorage = new DateStorage();
        View view = new View();
        Controller controller = new Controller(view, computerStorage);

        controller.run();
    }
}
