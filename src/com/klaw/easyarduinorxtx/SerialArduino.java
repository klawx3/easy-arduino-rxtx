package com.klaw.easyarduinorxtx;



import com.klaw.easyarduinorxtx.event.ArduinoEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier; 
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent; 
import gnu.io.SerialPortEventListener; 
import gnu.io.UnsupportedCommOperationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Klaw Strife
 */
public class SerialArduino implements SerialPortEventListener {

    private SerialPort serialPort;
    private final String portName;
    private BufferedReader input;
    private OutputStream output;

    private boolean connected;

    private static final int TIME_OUT = 2000;
    private static final int DATA_RATE = 9600;
    
    private List<ArduinoEvent> arduinoEvents;

    public SerialArduino(String portName) {
        this.portName = portName;
        connected = false;
    }
    
    public void initialize() {
        if(SODetector.isUnix()){
            System.setProperty("gnu.io.rxtx.SerialPorts", portName);
        }
        CommPortIdentifier portId = null;
        Enumeration portEnum;
        try {
            portEnum = CommPortIdentifier.getPortIdentifiers();
        } catch (UnsatisfiedLinkError ex) {
            System.err.println(ex.toString());
            return;
        }
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            if (currPortId.getName().equals(portName)) {
                portId = currPortId;
                break;
            }
        }
        if (portId == null) {
            System.err.println("port " + portName + " not found");
            return;
        }

        try {
            serialPort = (SerialPort) portId.open(this.getClass().getName(),
                    TIME_OUT);

            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
            connected = true;
        } catch (PortInUseException | UnsupportedCommOperationException | IOException | TooManyListenersException e) {
            System.err.println(e.toString());
        }
    }
    
    public synchronized void send(int value) {
        if (serialPort != null) {
            try {
                output.write(value);
                output.flush();
            } catch (IOException ex) {
                Logger.getLogger(SerialArduino.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public synchronized void send(char value) {
        if (serialPort != null) {
            try {
                output.write(value);
                output.flush();
            } catch (IOException ex) {
                Logger.getLogger(SerialArduino.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public synchronized void send(String value) {
        if (serialPort != null) {
            try {
                output.write(value.getBytes());
                output.flush();
            } catch (IOException ex) {
                Logger.getLogger(SerialArduino.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean isConnected() {
        return connected;
    }

    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
            connected = false;
        }
    }

    public void addArduinoEvent(ArduinoEvent event) {
        if (arduinoEvents == null) {
            arduinoEvents = new ArrayList<>();
        }
        arduinoEvents.add(event);
    }

    public void removeArduinoEvent(ArduinoEvent event) {
        if (arduinoEvents != null) {
            arduinoEvents.remove(event);
        }
    }
    
    @Override
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String inputLine = input.readLine();
                for (ArduinoEvent event : arduinoEvents) {
                    event.arduinoEvent(inputLine);
                }
            } catch (IOException ex) {
                Logger.getLogger(SerialArduino.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    

}
