package br.com.brasolia;

import br.com.brasolia.controller.Controller;

import java.awt.*;
import java.awt.event.KeyEvent;

public class AuroraMalhar {

    public AuroraMalhar() {
        boolean isCanRun = Controller.getInstance().isCanRun();

        if (isCanRun) {
            try {
                //Cria a instância do objeto
                Robot robot = new Robot();
                robot.delay(3000);
                KeyExecutor keyExecutor = new KeyExecutor(robot);
                for (int x = 0; x < 5; x++) {
                    keyExecutor.execute(KeyEvent.VK_E, 500);
                    for (int i = 0; i < 11 ; i++) {
                        System.out.println(i + " Malhando");

                        keyExecutor.execute(KeyEvent.VK_SPACE, 500);
                        Thread.sleep(3000);

                        isCanRun = Controller.getInstance().isCanRun();
                        System.out.println("Cancelado " + isCanRun);
                        if (!isCanRun) {
                            break;
                        }
                    }
                    Thread.sleep(3000);
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
