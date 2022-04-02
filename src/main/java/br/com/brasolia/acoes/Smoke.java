package br.com.brasolia.acoes;

import br.com.brasolia.Acao;
import br.com.brasolia.KeyExecutor;
import br.com.brasolia.controller.Controller;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Smoke implements Acao {
    @Override
    public void execute(KeyExecutor keyExecutor) throws Exception {
        boolean isCanRun = Controller.getInstance().isCanRun();
        if (isCanRun) {
            System.out.println("Fumando");
            keyExecutor.execute(KeyEvent.VK_F8, 500);
            keyExecutor.execute("e smoke");
            keyExecutor.execute(KeyEvent.VK_ENTER, 500);
            keyExecutor.execute(KeyEvent.VK_F8, 500);
        }
    }
}
