package br.com.brasolia;

import br.com.brasolia.controller.Controller;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Coletar {

    public Coletar() {
        boolean isCanRun = Controller.getInstance().isCanRun();

        if (isCanRun) {
            try {
                //Cria a instância do objeto
                Robot robot = new Robot();
                robot.delay(3000);
                KeyExecutor keyExecutor = new KeyExecutor(robot);
                for (int x = 0; x < 25; x++) {
                    keyExecutor.execute(KeyEvent.VK_Y, 500);
                    Thread.sleep(2000);
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
