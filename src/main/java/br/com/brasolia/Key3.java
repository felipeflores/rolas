package br.com.brasolia;

import br.com.brasolia.controller.Controller;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Key3 extends Thread {

    @Override
    public void run() {
        boolean isCanRun = Controller.getInstance().isCanRun();

        if (isCanRun) {
            try {
                //Cria a instância do objeto
                Robot robot = new Robot();
                robot.delay(3000);
                KeyExecutor keyExecutor = new KeyExecutor(robot);

                int count = 0;
                while (true) {
                    System.out.println("count: " + count);
                    count++;
                    keyExecutor.execute(KeyEvent.VK_3, 300);
//                    robot.delay(1000);
//                    robot.keyPress(KeyEvent.VK_Y);
                    Thread.sleep((4 * 60) * 1000);
                    isCanRun = Controller.getInstance().isCanRun();

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
