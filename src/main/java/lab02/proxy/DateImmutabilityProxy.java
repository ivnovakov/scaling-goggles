package lab02.proxy;

import lab02.individual.Date;
import lab02.individual.IDate;

public class DateImmutabilityProxy implements IDate {
    private Date instance;

    public DateImmutabilityProxy(Date instance) {
        this.instance = instance;
    }

    @Override
    public int getYear() {return instance.getYear();}
    @Override
    public void setYear(int year) {throw new RuntimeException("setting property on immutable object");}
    @Override
    public int getMonth() {return instance.getMonth();}
    @Override
    public void setMonth(int month) {throw new RuntimeException("setting property on immutable object");}
    @Override
    public int getDay() {return instance.getDay();}
    @Override
    public void setDay(int day) {throw new RuntimeException("setting property on immutable object");}
}
