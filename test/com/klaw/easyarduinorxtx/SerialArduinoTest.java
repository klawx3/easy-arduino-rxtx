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

    /**
     * Test of initialize method, of class SerialArduino.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        SerialArduino instance = null;
        instance.initialize();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of send method, of class SerialArduino.
     */
    @Test
    public void testSend_int() {
        System.out.println("send");
        int value = 0;
        SerialArduino instance = null;
        instance.send(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of send method, of class SerialArduino.
     */
    @Test
    public void testSend_char() {
        System.out.println("send");
        char value = ' ';
        SerialArduino instance = null;
        instance.send(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of send method, of class SerialArduino.
     */
    @Test
    public void testSend_String() {
        System.out.println("send");
        String value = "";
        SerialArduino instance = null;
        instance.send(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isConnected method, of class SerialArduino.
     */
    @Test
    public void testIsConnected() {
        System.out.println("isConnected");
        SerialArduino instance = null;
        boolean expResult = false;
        boolean result = instance.isConnected();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class SerialArduino.
     */
    @Test
    public void testClose() {
        System.out.println("close");
        SerialArduino instance = null;
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addArduinoEvent method, of class SerialArduino.
     */
    @Test
    public void testAddArduinoEvent() {
        System.out.println("addArduinoEvent");
        ArduinoEvent event = null;
        SerialArduino instance = null;
        instance.addArduinoEvent(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeArduinoEvent method, of class SerialArduino.
     */
    @Test
    public void testRemoveArduinoEvent() {
        System.out.println("removeArduinoEvent");
        ArduinoEvent event = null;
        SerialArduino instance = null;
        instance.removeArduinoEvent(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of serialEvent method, of class SerialArduino.
     */
    @Test
    public void testSerialEvent() {
        System.out.println("serialEvent");
        SerialPortEvent oEvent = null;
        SerialArduino instance = null;
        instance.serialEvent(oEvent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
