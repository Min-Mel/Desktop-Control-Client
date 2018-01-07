package min.control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client implements KeyListener {

    private DataOutputStream out;
    private JFrame appWindow;

    public Client(String hostname, int port) {
        /*out = openConnection(hostname, port);
        if(out == null)
            return;
        */
        initGUI();

    }

    private void initGUI() {
        appWindow = new JFrame("Control Client");

        Container content = appWindow.getContentPane();
        content.setFocusable(true);
        content.addKeyListener(this);

        appWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        appWindow.setUndecorated(true);
        appWindow.setVisible(true);
    }

    private DataOutputStream openConnection(String hostname, int port) {
        try {
            Socket targetMachineSocket = new Socket(hostname, port);
            return new DataOutputStream(targetMachineSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DELETE)
            System.exit(0);
        System.out.print(e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
