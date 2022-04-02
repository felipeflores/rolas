package br.com.brasolia.controller;

public class Controller {

    private static Controller controller = null;

    private Boolean canRun;

    private Controller() {
        this.canRun = true;
    }

    public static Controller getInstance() {

        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    public void setCanRun(boolean canRun) {
        this.canRun = canRun;
    }

    public boolean isCanRun() {
        return this.canRun;
    }
}
