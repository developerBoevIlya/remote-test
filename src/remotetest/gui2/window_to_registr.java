package remotetest.gui2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class window_to_registr extends JPanel implements ActionListener {
    private String name_server;
    private String name_users;
    public void actionPerformed(ActionEvent e) {
        name_server=JOptionPane.showInputDialog("Введите имя сервера");
        name_users=JOptionPane.showInputDialog("Введите имя клиента");
        try(FileWriter writer = new FileWriter("name.txt", false))
        {
            writer.write(name_server);
            writer.append(' ');
            writer.write(name_users);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
