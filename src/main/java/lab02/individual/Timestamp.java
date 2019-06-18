package lab02.individual;

import java.util.Objects;

public class Timestamp extends Date implements IDate {
    private int hours;

    @Override
    public String toString() {
        return "Timestamp{" +
                "year=" + getYear() +
                ", month=" + getMonth() +
                ", day=" + getDay() +
                "hours=" + getHours() +
                ", minutes=" + getMinutes() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Timestamp)) return false;
        if (!super.equals(o)) return false;
        Timestamp timestamp = (Timestamp) o;
        return getHours() == timestamp.getHours() &&
                getMinutes() == timestamp.getMinutes();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getHours(), getMinutes());
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public Timestamp(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public Timestamp(int year, int month, int day, int hours, int minutes) {
        super(year, month, day);
        this.hours = hours;
        this.minutes = minutes;
    }

    private int minutes;
}
