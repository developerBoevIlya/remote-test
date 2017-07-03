package remotetest.gui2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class window_to_logo extends JPanel implements ActionListener {
    private String logo;
    public void actionPerformed(ActionEvent e) {
        Pair pair=new Pair();
        String nextString=new String();
        String bufer;
        try {
            final BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream("logo.txt"), "UTF8"));
            while ((bufer = br.readLine()) != null) {
                nextString+=bufer;
                nextString+='\n';
            }
        } catch (UnsupportedEncodingException | FileNotFoundException ex) {
            Logger.getLogger(window_to_logo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(window_to_logo.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFrame window = new JFrame("Ход программы");
        //JTextField text=new JTextField(nextString);
        JTextArea text=new JTextArea(20,30);
        window.setVisible(true);
        window.setDefaultCloseOperation(window.DISPOSE_ON_CLOSE);
        pair.setCenterPosition();
        window.setLocation(pair.width,pair.height);
        Container container=window.getContentPane();
        container.setLayout(new GridLayout(1,1));
        container.add(text);
        text.append(nextString);
        window.pack();
    }
}
