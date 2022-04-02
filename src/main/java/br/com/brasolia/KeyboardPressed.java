package br.com.brasolia;

import br.com.brasolia.controller.Controller;
import br.com.brasolia.listeners.GlobalKeyListenerExample;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class KeyboardPressed implements NativeKeyListener {

    public void nativeKeyPressed(NativeKeyEvent e) {
//        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

        if (e.getKeyCode() == NativeKeyEvent.VC_HOME) {
            System.out.println("Pressed Home");
            Controller.getInstance().setCanRun(false);
        }
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
//        System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
//        System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
    }

    public void start() {
        System.out.println("Deu start no bagulho");
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new KeyboardPressed());
    }

    public void stop() {
        try {
            GlobalScreen.unregisterNativeHook();
        } catch (NativeHookException nativeHookException) {
            nativeHookException.printStackTrace();
        }
    }
}
