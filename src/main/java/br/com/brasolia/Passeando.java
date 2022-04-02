package br.com.brasolia;

import br.com.brasolia.controller.Controller;

import java.awt.event.KeyEvent;

public class Passeando {


    public void execute(KeyExecutor keyExecutor) {
        boolean isCanRun = Controller.getInstance().isCanRun();
        if (isCanRun) {
            System.out.println("Rodando");
            keyExecutor.execute(KeyEvent.VK_W, 1000);
            keyExecutor.execute(KeyEvent.VK_D, 1000);
            keyExecutor.execute(KeyEvent.VK_S, 1000);
            keyExecutor.execute(KeyEvent.VK_A, 1000);
            keyExecutor.execute(KeyEvent.VK_W, 1000);
        }
    }

}
