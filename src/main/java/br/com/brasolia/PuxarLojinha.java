package br.com.brasolia;

import br.com.brasolia.controller.Controller;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PuxarLojinha {

    public PuxarLojinha() {
        boolean isCanRun = Controller.getInstance().isCanRun();
        System.out.println("Pode puxar lojinha " + isCanRun);
        if (isCanRun) {
            try {
                //Cria a instância do objeto
                Robot robot = new Robot();
                robot.delay(3000);
                KeyExecutor keyExecutor = new KeyExecutor(robot);


                while (true) {
                    System.out.println("Puxar Lojinha");
                    keyExecutor.execute(KeyEvent.VK_E, 100, 0);
                    keyExecutor.execute(KeyEvent.VK_DOWN, 100, 0);
                    keyExecutor.execute(KeyEvent.VK_ENTER, 100, 0);
                    isCanRun = Controller.getInstance().isCanRun();
                    System.out.println("Cancelado " + isCanRun);
                    if (!isCanRun) {
                        break;
                    }
                }

                Controller.getInstance().setCanRun(true);

            } catch (AWTException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }


    }

}
