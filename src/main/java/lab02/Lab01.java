package lab02;

import lab02.individual.Date;
import lab02.individual.Timestamp;
import lab02.task01.Base;
import lab02.task01.Derived;
import lab02.task02.Example;
import lab02.task02.Invoke;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Lab01 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        individual();
    }

    private static void task1() {
        System.out.println("== Task 1 ==");
        Base b = new Base(4);
        System.out.println("b = " + b);
        b = new Derived();
        System.out.println("b = " + b);
        System.out.println();
    }

    private static void task2() {
        System.out.println("== Task 2 ==");
        Example e = new Example();

        for (Method method : e.getClass().getDeclaredMethods()) {
            if (method.getAnnotation(Invoke.class) == null) {
                continue;
            }

            try {
                method.invoke(e);
            } catch (IllegalAccessException | InvocationTargetException err) {
                System.out.println(err);
            }
        }
        System.out.println();
    }

    private static void task3() {
        System.out.println("== Task 3 ==");
        Class cls = ArrayList.class;
        System.out.println("Class: " + cls.getSimpleName());
        System.out.println("Constructors:");
        for (Constructor<?> constr : cls.getConstructors()) {
            System.out.println("\t" + constr.toString());
        }
        System.out.println("Modifiers:" + cls.getModifiers());
        System.out.println();
    }

    private static void individual() {
        System.out.println("== Task (#16) ==");
        List<Date> dates = new ArrayList<Date>();
        dates.add(new Date(2019, 11, 285));
        dates.add(new Timestamp(2019, 11, 285, 12, 21));

        System.out.println("Dates:");
        for (Date date : dates) {
            System.out.println("\t" + date);
        }
        System.out.println();
    }
}
