/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remotetest.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nikit
 */
public class SettingsWindowController implements Initializable {
    
    //изменяем настройки в зависимости от теста
    
    private SimpleTest test;
    public void setTest(SimpleTest test) {
        this.test = test;
        setting1.setText(test.getName());
        txtIPClient.setText(test.getIPClient());
        txtIPServer.setText(test.getIPServer());
        txtSetting1.setText(test.getValueSettings());
    }
    /**
     * Initializes the controller class.
     */
    @FXML
    private  Label setting1;
    
    @FXML
    private TextField txtIPServer;
    
    @FXML
    private TextField txtIPClient;
    
     @FXML
    private TextField txtSetting1;
    
    public void actionClose(ActionEvent actionEvent)
    {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }
    public void actionSave(ActionEvent actionEvent)
    {
        test.setIPClient(txtIPClient.getText());
        test.setIPServer(txtIPServer.getText());
        test.setValueSettings(txtSetting1.getText());
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
    
}
