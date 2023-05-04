package ru.learnUp.homework;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent{

    private final int number;

    public MyEvent(int number) {
        super(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
