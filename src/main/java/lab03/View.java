package lab03;

import lab03.model.Date;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class View {
    int requestAction() {
        System.out.println("Select action: \n\t1 - Add date \n\t2 - delete date \n\t3 - list date \n\t4 - quit");
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }

    String requestProperty(String propertyName) {
        System.out.print(propertyName + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    int requestIndex() {
        System.out.print("Index: ");
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }

    void showMessage(String message) {
        System.out.println(message);
    }

    void showList(List<Date> dates) {
        for (Date computer : dates) {
            System.out.println(computer);
        }
    }
}
