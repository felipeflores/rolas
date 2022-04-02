package br.com.brasolia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomSystemTray {


    public CustomSystemTray() {
        final KeyboardPressed keyboardPressed = new KeyboardPressed();
        keyboardPressed.start();


        final TrayIcon trayIcon; // declarando uma constante do tipo TrayIcon
        // Aqui vamos testar se o recurso é suportado
        if (SystemTray.isSupported()) {
            //declarando uma variavel  do tipo SystemTray
            SystemTray tray = SystemTray.getSystemTray();
            //declarando uma variavel  do tipo Image que contera a imagem tray.gif
            Image image = Toolkit.getDefaultToolkit().getImage("tray.gif");
            //Criamos um listener para escutar os eventos de mouse
            MouseListener mouseListener = new MouseListener() {
                public void mouseClicked(MouseEvent e) {
                }
                public void mouseEntered(MouseEvent e) {
                }
                public void mouseExited(MouseEvent e) {
                }
                public void mousePressed(MouseEvent e) {
                    //Toda vez que for clicado imprime uma mensagem na tela
                    System.out.println("Tray Icon - O Mouse foi pressionado!");
                }
                public void mouseReleased(MouseEvent e) {
                }
            };
            // Criamos um ActionListener para a ação de encerramento do programa.
            ActionListener exitListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //Imprime uma mensagem de despedida na tela

                    keyboardPressed.stop();

                    System.out.println("Saindo...");
                    JOptionPane.showMessageDialog(null,"Saindo...");
                    System.exit(0);
                }
            };
            //Criando um objeto PopupMenu
            PopupMenu popup = new PopupMenu("Menu de Opções");
            // Criamos um ActionListener para a exibir uma mensagem na tela ao clicarmos
            //em um item do menu.
            ActionListener afkListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new Afk();
                }
            };
            //criando itens do menu
            MenuItem afk = new MenuItem("AFK");
            afk.addActionListener(afkListener);
            //Adicionando itens ao PopupMenu
            popup.add(afk);

            ActionListener afkProcessar = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new Processar();
                }
            };
            MenuItem processar = new MenuItem("Processar");
            processar.addActionListener(afkProcessar);
            popup.add(processar);

            ActionListener afkPuxaLojinha = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new PuxarLojinha();
                }
            };
            MenuItem puxaLojinha = new MenuItem("Puxar Lojinha");
            puxaLojinha.addActionListener(afkPuxaLojinha);
            popup.add(puxaLojinha);

            ActionListener auroraMalhar = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new AuroraMalhar();
                }
            };
            MenuItem menuAuroraMalhar = new MenuItem("AuroraMalhar");
            menuAuroraMalhar.addActionListener(auroraMalhar);
            popup.add(menuAuroraMalhar);

            ActionListener coletar = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new Coletar();
                }
            };
            MenuItem coletarMenu = new MenuItem("Coletar");
            coletarMenu.addActionListener(coletar);
            popup.add(coletarMenu);

            ActionListener yInfinito = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new YInfinito();
                }
            };
            MenuItem menuyInfinito = new MenuItem("Y Infinito");
            menuyInfinito.addActionListener(yInfinito);
            popup.add(menuyInfinito);

            MenuItem defaultItem = new MenuItem("Sair");
            //na linha a seguir associamos os objetos aos eventos
            defaultItem.addActionListener(exitListener);
            //Criando objetos do tipo Checkbox
            popup.addSeparator();
            popup.add(defaultItem);
            //criando um objeto do tipo TrayIcon
            trayIcon = new TrayIcon(image, "TrayIcon Demonstração", popup);
            ActionListener actionListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    trayIcon.displayMessage("Action Event", "Um Evento foi disparado", TrayIcon.MessageType.INFO);
                }
            };
            //Na linha a seguir a imagem a ser utilizada como icone sera redimensionada
            trayIcon.setImageAutoSize(true);
            //Seguida adicionamos os actions listeners
            trayIcon.addActionListener(actionListener);
            trayIcon.addMouseListener(mouseListener);

            new Vape().start();
//            new Key3().start();
//            new Key4().start();

            //Tratamento de erros
            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                System.err.println("Erro, TrayIcon não sera adicionado.");
            }
        } else {
            //Caso o item  System Tray não for suportado
            JOptionPane.showMessageDialog(null,"recurso ainda não esta disponível pra o seu sistema");
        }
    }
}
