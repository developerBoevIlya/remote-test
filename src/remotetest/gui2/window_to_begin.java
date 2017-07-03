package remotetest.gui2;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class window_to_begin extends JPanel implements ActionListener {
    private double[] xData  ;
    private double[] yData ;
    public void actionPerformed(ActionEvent e) {
        String FileX=new String();
        String FileY=new String();
        try {
            FileX = read("x.txt");
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            FileY = read("y.txt");
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        xData=new double[FileX.length()];
        yData=new double[FileX.length()];
        Scanner scanner_X = new Scanner(FileX);
        int indexX=0;
        while(scanner_X.hasNext()) {
            if (scanner_X.hasNextInt()) {
                xData[indexX]=(double)scanner_X.nextInt();
                indexX++;
            } else
                scanner_X.next();
        }
        Scanner scanner_Y = new Scanner(FileY);
        indexX=0;
        while(scanner_Y.hasNext()) {
            if (scanner_Y.hasNextInt()) {
                yData[indexX]=(double)scanner_Y.nextInt();
                indexX++;
            } else
                scanner_Y.next();
        }
        XYChart chart = QuickChart.getChart("Зависимость скорости передачи от размера пакета", "X", "Y", "y(x)", xData, yData);
        new SwingWrapper(chart).displayChart();
    }
    public static String read(String fileName) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader( fileName));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}