/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remotetest.gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import static jdk.nashorn.internal.objects.NativeRegExp.source;

/**
 *
 * @author nikit
 */
public  class FXMLDocumentController implements Initializable {
    
   // private 
    @FXML
    private TableView tableTest;
     
    @FXML
    private TableColumn<AbstractTest, String> columnName;
    
     @FXML
    private Button btnSelectResult;
     
    public void openFile(ActionEvent actionEvent)
    {
        FileChooser fileChooser = new FileChooser();//Класс работы с диалогом выборки и сохранения
        fileChooser.setTitle("Open Document");//Заголовок диалога
        FileChooser.ExtensionFilter extFilter = 
        new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html");//Расширение
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(((Node)actionEvent.getSource()).getScene().getWindow());//Указываем текущую сцену CodeNote.mainStage
       if (file != null) {
////Open
        System.out.println("Процесс открытия файла");
        }
    }
     
    @FXML
    public void showDialog(ActionEvent actionEvent)
    {
        Object source = actionEvent.getSource();
        
        if(!(source instanceof Button))
            return;
        
        Button clickedButton = (Button)source;
        AbstractTest selectTest = (AbstractTest)tableTest.getSelectionModel().getSelectedItem();
        
        switch(clickedButton.getId())
        {
            case("btnSettings"):
           
                this.showSettingsDialog(actionEvent, selectTest);
                System.out.println("Settings "+ selectTest);
                break;
                
                
                
            case("btnTest"):
                System.out.println("Begin test " + selectTest);
                //запускаем тест
                break;
                
                
             case("btnSelectResult"):
                System.out.println("Select Result ");
                openFile(actionEvent);
                //запускаем тест
                break;
        }
        
    }
    void showSettingsDialog(ActionEvent actionEvent,AbstractTest selectTest )
    {
        try
        {
            Stage stage = new Stage();
            FXMLLoader loader  = new FXMLLoader();
            loader.setLocation(getClass().getResource(selectTest.getPathSettingsWindow()));
            Parent root = loader.load();
            selectTest.setFXMLLoader(loader);
            selectTest.ChangeName();// добавляем тест в контроллер
            stage.setTitle("Настройки теста");
            stage.setResizable(false); //
            stage.setScene(new Scene(root));
          
            stage.initModality(Modality.WINDOW_MODAL); //
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch(Exception e)
        {
              System.out.println("" + e.getMessage());
        }
    }
    @FXML
    @Override
     public void initialize(URL url, ResourceBundle rb){
    
         ListTest lt = new ListTest();
         columnName.setCellValueFactory(new PropertyValueFactory<AbstractTest, String>("name"));
         lt.example();
         tableTest.setItems(lt.getTestList());
    } 


 }
    

