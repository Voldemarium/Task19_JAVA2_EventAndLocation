package ru.learnUp.homework;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;

import static ru.learnUp.homework.GuessingGame.locale;
import static ru.learnUp.homework.GuessingGame.randomNumber;


public class MyEventListener implements ApplicationListener<MyEvent>, ApplicationContextAware {
    private ApplicationContext context;
    private String message = " ";

    public String getMessage() {
        return message;
    }

    @Override
    public void onApplicationEvent(MyEvent event) {
        if (event.getNumber() != randomNumber) {
            if (event.getNumber() < 0 || event.getNumber() > 1000) {
                message = "outOfRange";
            } else if (event.getNumber() < randomNumber) {
                message = "more";
            } else if (event.getNumber() > randomNumber) {
                message = "less";
            }
            System.out.println(context.getMessage(message, null, locale));
        } else {
            message = "right";
            System.out.println(context.getMessage(message, null, locale) + " " + randomNumber + "!");
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
