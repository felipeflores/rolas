package br.com.brasolia;

import java.awt.*;

public class KeyExecutor {
    private Robot robot;
    public KeyExecutor(Robot robot) {
        this.robot = robot;
    }

    public void execute(int key, int between, int initiate) {
        robot.delay(initiate);
        robot.keyPress(key);
        //Aguarda por um segundo
        robot.delay(between);
        robot.keyRelease(key);
    }
    public void execute(int key, int between) {
        execute(key, between, 1000);
    }

    public void execute(String phrase) {

        for (char charCode: phrase.toCharArray()) {
            int keyCode = java.awt.event.KeyEvent.getExtendedKeyCodeForChar(charCode);
            execute(keyCode, 500);
        }


    }
}
