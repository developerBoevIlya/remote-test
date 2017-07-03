package remotetest.gui2;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class window_change_settings implements ActionListener  {
    private String input;
    private int size;
    public void actionPerformed(ActionEvent e) {
        input=JOptionPane.showInputDialog("Введите размер пакета");
        size = Integer.parseInt(input);
    }
}
