package com.company;

import org.jnativehook.keyboard.NativeKeyEvent;
import java.util.ArrayList;

public class WordProcessor {
    private static String  m_CurrentWord = "";
    static boolean         m_HasPressedSpace = false;
    static float           m_CurrentTime;
    static int             m_MeasureWindow = 10;
    static int             m_CharacterCount = 0;
    static float           m_InitializedTime = 0;
    static float           m_LastCalculatedWPM = 0;
    static ArrayList<String> m_WordHistory  = new ArrayList< String >();

    public static void Process( NativeKeyEvent CurrentKeyEvent ){
        String m_CurrentKey = GetKeyName( CurrentKeyEvent );

        if ( m_CurrentKey.length() == 1 && !m_CurrentKey.equals("Space") && !m_CurrentKey.equals("Backspace") ){
            m_CurrentWord += m_CurrentKey;
            m_CharacterCount++;
        }else if( m_CurrentKey.equals("Space")){
            if( !m_HasPressedSpace ){
                m_HasPressedSpace = true;
                m_CurrentTime = m_InitializedTime = pUtil.CurTime();
            }else{
                float m_Current = pUtil.CurTime();;

                m_LastCalculatedWPM = Math.round( ( float ) ( m_CharacterCount / 5 ) / ( ( m_Current - m_InitializedTime ) / 60 ) );
                pUtil.Print( "Current WPM:", m_LastCalculatedWPM );

                m_CurrentTime = m_Current;
            }
            pUtil.Print( m_CurrentWord );
            m_WordHistory.add( m_CurrentWord );
            m_CurrentWord = "";
        }

    }

    static ArrayList< String > GetWordHistory(){
        return m_WordHistory;
    }
    static String GetKeyName(NativeKeyEvent event ){
        return NativeKeyEvent.getKeyText(event.getKeyCode());
    }
}
