import WordProcessor;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeyListener implements NativeKeyListener {
    boolean m_HasInitialized = false;

    public void nativeKeyPressed(NativeKeyEvent e) {
        if ( ! m_HasInitialized ){
            m_HasInitialized = true;
        }
        WordProcessor.Process( e );
        if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void nativeKeyReleased(NativeKeyEvent e) {}

    public void nativeKeyTyped(NativeKeyEvent e) {
    }

    public static void SuppressKeyListenerErrorLogs(){
        Logger logger = Logger.getLogger( GlobalScreen.class.getPackage().getName() );
        logger.setLevel(Level.OFF);

        Handler[] handlers = Logger.getLogger("").getHandlers();
        for (int i = 0; i < handlers.length; i++) {
            handlers[i].setLevel(Level.OFF);
        }
    }
}