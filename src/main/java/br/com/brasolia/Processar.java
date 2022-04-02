package br.com.brasolia;

import br.com.brasolia.controller.Controller;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Processar {

    public Processar() {
        boolean isCanRun = Controller.getInstance().isCanRun();
        System.out.println("Pode processar " + isCanRun);
        if (isCanRun) {
            try {

                //Cria a instância do objeto
                Robot robot = new Robot();
                robot.delay(5000);
                KeyExecutor keyExecutor = new KeyExecutor(robot);

                for (int i = 0; i < 23; i++) {
                    System.out.println(i + " Processando");
                    keyExecutor.execute(KeyEvent.VK_E, 500);
                    Thread.sleep(11000);
                    isCanRun = Controller.getInstance().isCanRun();
                    System.out.println("Cancelado " + isCanRun);
                    if (!isCanRun) {
                        break;
                    }
                }
                Controller.getInstance().setCanRun(true);
            } catch (AWTException ex) {
                ex.printStackTrace();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
    }
}
