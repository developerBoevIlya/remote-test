/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remotetest.gui;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;

/**
 *
 * @author nikit
 */
public abstract class AbstractTest {
    protected String name;
    protected String pathSettingsWindow;
    protected FXMLLoader loader  = new FXMLLoader();
    public AbstractTest(String name,String pathSettingsWindow ) 
    {
        this.name = name;
        this.pathSettingsWindow = pathSettingsWindow;
        
    }
    public String getName(){return this.name;};
    
    public void setName(String name){this.name = name;};
    
    public String getPathSettingsWindow(){return this.pathSettingsWindow;};
    
    public void setPathSettingsWindow(String pathSettingsWindow)
    {this.pathSettingsWindow = pathSettingsWindow;};
    
    public void setFXMLLoader(FXMLLoader loader){this.loader = loader;};
    
    public abstract void ChangeName();
    
    public abstract void  runTest();
    
    @Override
    public String toString(){return name;};
  
    
}
