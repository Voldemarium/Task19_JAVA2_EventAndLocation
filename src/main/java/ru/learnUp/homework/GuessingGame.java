package ru.learnUp.homework;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame implements ApplicationContextAware {

    static int randomNumber = new Random().nextInt(1000);
    static Locale locale = Locale.getDefault();

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ru/learnUp/homework/configuration.xml");
        MyEventPublisher publisher = context.getBean(MyEventPublisher.class);
        MyEventListener listener = context.getBean((MyEventListener.class));
        Scanner scanner = new Scanner(System.in);

        System.out.println(context.getMessage("hello", null, locale));
        while (!listener.getMessage().equals("right")) {
            try {
                publisher.publishEvent(scanner.nextInt());
            } catch (InputMismatchException e) {
                System.out.println(context.getMessage("notAnInteger", null, locale));
                scanner.next();
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}