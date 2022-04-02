package br.com.brasolia.acoes;

import br.com.brasolia.Acao;
import br.com.brasolia.KeyExecutor;
import br.com.brasolia.controller.Controller;

import java.awt.event.KeyEvent;

public class Meditate implements Acao {
    @Override
    public void execute(KeyExecutor keyExecutor) throws Exception {
        boolean isCanRun = Controller.getInstance().isCanRun();
        if (isCanRun) {
            System.out.println("yoga");
            keyExecutor.execute(KeyEvent.VK_F8, 500);
            keyExecutor.execute("e meditate");
            keyExecutor.execute(KeyEvent.VK_ENTER, 500);
            keyExecutor.execute(KeyEvent.VK_F8, 500);
        }
    }
}
