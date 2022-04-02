package br.com.brasolia.acoes;

import br.com.brasolia.Acao;
import br.com.brasolia.KeyExecutor;
import br.com.brasolia.controller.Controller;

import java.awt.event.KeyEvent;

public class AirGuitar implements Acao {
    @Override
    public void execute(KeyExecutor keyExecutor) throws Exception {
        boolean isCanRun = Controller.getInstance().isCanRun();
        if (isCanRun) {
            System.out.println("AirGuitar");
            keyExecutor.execute(KeyEvent.VK_F8, 500);
            keyExecutor.execute("e airGuitar");
            keyExecutor.execute(KeyEvent.VK_ENTER, 500);
            Thread.sleep(5000);
            keyExecutor.execute("e airGuitar");
            keyExecutor.execute(KeyEvent.VK_ENTER, 500);
            keyExecutor.execute(KeyEvent.VK_F8, 500);
        }
    }
}
