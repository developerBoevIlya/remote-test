/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remotetest.gui;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author nikit
 */
public class ListTest {
    private ObservableList<AbstractTest> testList = FXCollections.observableArrayList();
    
    public void add(AbstractTest test)
    {
         this.testList.add(test);
    }
    public void example()
    {
       this.add(new SimpleTest("MTU","SettingsWindow.fxml"));
       this.add(new SimpleTest("Size packadge","SettingsWindow.fxml"));
    }
    @Override
    public String toString(){
         Iterator<AbstractTest> iter = testList.iterator();
         String list = null;
         while(iter.hasNext())
         {
             AbstractTest AbstractTest = iter.next();
             list += (AbstractTest.toString() + "\n");
         }
        return list;
    }
    
    public  ObservableList<AbstractTest> getTestList(){return testList;};

  
    
    
}
