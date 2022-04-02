package br.com.brasolia;

import br.com.brasolia.controller.Controller;

import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Comendo {

    private Calendar lastSanduiche;
    private Calendar lastRedbull;
    private KeyExecutor keyExecutor;
    public Comendo(KeyExecutor keyExecutor) {
        this.keyExecutor = keyExecutor;
    }

    public void execute() {
        boolean isCanRun = Controller.getInstance().isCanRun();
        if (isCanRun) {
            eatSanduiche();
            drinkRedbull();
        }
    }

    private void eatSanduiche() {
        int time = 6;
        long diff = 0;
        if (lastSanduiche != null) {
            diff = new Date().getTime() - lastSanduiche.getTimeInMillis();//as givend
        }
        if (lastSanduiche == null || TimeUnit.MILLISECONDS.toMinutes(diff) > time) {
            System.out.println("Comendo");
            lastSanduiche = Calendar.getInstance();
            keyExecutor.execute(KeyEvent.VK_F2, 500);
            keyExecutor.execute(KeyEvent.VK_DOWN, 100);
            keyExecutor.execute(KeyEvent.VK_DOWN, 100);
            keyExecutor.execute(KeyEvent.VK_DOWN, 100);
            keyExecutor.execute(KeyEvent.VK_DOWN, 100);
            keyExecutor.execute(KeyEvent.VK_ENTER, 100);
            keyExecutor.execute(KeyEvent.VK_ENTER, 100);
            keyExecutor.execute(KeyEvent.VK_BACK_SPACE, 100);
            keyExecutor.execute(KeyEvent.VK_BACK_SPACE, 100);
        }

    }

    private void drinkRedbull() {
        int time = 8;
        long diff = 0;
        if (lastRedbull != null) {
            diff = new Date().getTime() - lastRedbull.getTimeInMillis();//as givend
        }
        if (lastRedbull == null || TimeUnit.MILLISECONDS.toMinutes(diff) > time) {
            System.out.println("Bebendoi");
            lastRedbull = Calendar.getInstance();
            keyExecutor.execute(KeyEvent.VK_F2, 500);
            keyExecutor.execute(KeyEvent.VK_DOWN, 100);
            keyExecutor.execute(KeyEvent.VK_DOWN, 100);
            keyExecutor.execute(KeyEvent.VK_DOWN, 100);
            keyExecutor.execute(KeyEvent.VK_ENTER, 100);
            keyExecutor.execute(KeyEvent.VK_ENTER, 100);
            keyExecutor.execute(KeyEvent.VK_BACK_SPACE, 100);
            keyExecutor.execute(KeyEvent.VK_BACK_SPACE, 100);
        }
    }
}
