package br.com.brasolia;

import br.com.brasolia.acoes.*;
import br.com.brasolia.controller.Controller;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Afk {

    private List<Acao> acoes = new ArrayList<Acao>();

    public Afk() {
        boolean isCanRun = Controller.getInstance().isCanRun();
        System.out.println("Pode processar " + isCanRun);
        if (isCanRun) {
            acoes.add(new Smoke());
            acoes.add(new Dancando());
            acoes.add(new AirGuitar());
            acoes.add(new Yoga());
            acoes.add(new Meditate());
            

            try {


                //Cria a instância do objeto
                Robot robot = new Robot();
                robot.delay(5000);
                KeyExecutor keyExecutor = new KeyExecutor(robot);

                Comendo comendo = new Comendo(keyExecutor);
                while (true) {
                    Random gerador = new Random();

                    int indexAcao = gerador.nextInt(acoes.size());
                    System.out.println("index " + indexAcao + " " + acoes.size());
                    Acao acao = acoes.get(indexAcao);
                    acao.execute(keyExecutor);
                    if (Controller.getInstance().isCanRun()) {
                        Thread.sleep(30 * 1000);
                        keyExecutor.execute(KeyEvent.VK_BACK_SPACE, 1000);

                        Passeando passeando = new Passeando();
                        passeando.execute(keyExecutor);

                        comendo.execute();
                    }
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
