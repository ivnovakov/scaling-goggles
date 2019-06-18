package lab02.task02;

public class Example {
    @Invoke
    public void method1() {
        System.out.println("method1");
    }

    public void method2() {
        System.out.println("method2");
    }

    @Invoke
    public void method3() {
        System.out.println("method3");
    }

}
