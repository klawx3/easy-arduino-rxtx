/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klaw.easyarduinorxtx;

import com.klaw.easyarduinorxtx.event.ArduinoEvent;
import gnu.io.SerialPortEvent;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Klaw Strife
 */
public class SerialArduinoTest {
    
    public SerialArduinoTest() {
    }

    @Test
    public void testEvent() {
        System.out.println("testEvent");
        SerialArduino instance = new SerialArduino("COM3");
        instance.initialize();
        instance.addArduinoEvent(new ArduinoEvent() {
            @Override
            public void arduinoEvent(String eventString) {
                System.out.println(eventString);
            }
        });

    }
    
}
