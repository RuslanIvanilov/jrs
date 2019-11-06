package ru.s7;

import ru.s7.stuff.AppProperty;
import ru.s7.main_frame.MainFrame;

public class App {
    public static void main(String[] args){
        System.out.println("App Jasper - Studio prepare for start....1");
        new MainFrame(AppProperty.getInstance()).setVisible(true);
    }

}
