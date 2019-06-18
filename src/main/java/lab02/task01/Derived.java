package lab02.task01;

public class Derived extends Base {
    public Derived() {
        super(64);
    }

    public Derived(int value) {
        super(value);
    }

    @Override
    public String toString() {
        return "Derived(" + getValue() + ")";
    }
}
