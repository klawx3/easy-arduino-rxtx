/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klaw.easyarduinorxtx;

import gnu.io.SerialPortEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import com.klaw.easyarduinorxtx.event.ArduinoEventHandler;

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
        SerialArduino arduino = new SerialArduino("COM3");
        arduino.initialize();
        arduino.addArduinoEvent(new ArduinoEventHandler() {
            @Override
            public void arduinoEvent(String eventString) {
                System.out.println(eventString);
            }
        });

    }
    
}
