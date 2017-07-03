package remotetest.gui2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class testing_Basic {
    public void  homepage(){
        Pair pair=new Pair();
        JButton begin = new JButton("Начать");
        JButton change = new JButton("Изменить параметры передачи");
        JButton registr = new JButton("Сервер/Клиент");
        //String logo_text=read("logo.txt");
        JButton logo = new JButton("Лог");
       // JLabel image=new JLabel(new ImageIcon("gif.png"));
        JFrame window = new JFrame("Программа тестирования локальной сети");
        window.setVisible(true);
        window.setDefaultCloseOperation(window.DISPOSE_ON_CLOSE);
        pair.setCenterPosition();
        window.setLocation(pair.width-200,pair.height-75);
        Container container=window.getContentPane();
        container.setLayout(new GridLayout(2,1));
        container.add(begin);
        ActionListener to_begin = new window_to_begin();//слушатель для данной кнопки
        begin.addActionListener(to_begin);
        container.add(change);
        ActionListener change_settings = new window_change_settings();//слушатель для данной кнопки
        change.addActionListener(change_settings);
        container.add(registr);
        ActionListener to_registr = new window_to_registr();//слушатель для данной кнопки
        registr.addActionListener(to_registr);
        //container.add(image);
        container.add(logo);
        ActionListener to_logo = new window_to_logo();//слушатель для данной кнопки
        logo.addActionListener(to_logo);
        window.pack();
    }
}
