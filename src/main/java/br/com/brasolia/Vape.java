package br.com.brasolia;

import br.com.brasolia.controller.Controller;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Vape extends Thread {

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

                    System.out.println("count vape: " + count);
                    System.out.println("8: " + count % 8);
                    System.out.println("21: " + count % 21);
                    System.out.println("25: " + count % 25);
                    if (count > 0) {

                        if ((count % 8) == 0) {
                            System.out.println("VK_2" );
                            keyExecutor.execute(KeyEvent.VK_2, 300);
                        } else if  ((count % 21) == 0) {
                            System.out.println("VK_3" );
                            keyExecutor.execute(KeyEvent.VK_3, 300);
                        } else if  ((count % 25) yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy== 0) {
                            System.out.println("VK_4" );
                            keyExecutor.execute(KeyEvent.VK_4, 300);
                        }
                    }

                    Thread.sleep(1000 * 60);
                    count++;
//                    keyExecutor.execute(KeyEvent.VK_2, 300);
//                    robot.delay(1000);
//                    robot.keyPress(KeyEvent.VK_Y);
//                    Thread.sleep((10 * 60) * 1000);




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
