/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remotetest.gui;





/**
 *
 * @author nikit
 */
//Тест с одним параметром
public class SimpleTest extends AbstractTest{

   
    private String IPServer = "0.0.0.0";
    private String IPClient = "0.0.0.0";
    private String valueSettings = "0";
    
    public SimpleTest(String name, String pathSettingsWindow){
        super(name, pathSettingsWindow);
       
    }
    
      public String getIPServer() {
        return IPServer;
    }

  
    public void setIPServer(String IPServer) {
        this.IPServer = IPServer;
    }

    
    public String getIPClient() {
        return IPClient;
    }


    public void setIPClient(String IPClient) {
        this.IPClient = IPClient;
    }

    
    public String getValueSettings() {
        return valueSettings;
    }

   
    public void setValueSettings(String valueSettings) {
        this.valueSettings = valueSettings;
    }
    
    
     @Override
    public void ChangeName()
    {
        SettingsWindowController swc = this.loader.getController();
        swc.setTest(this);
    }
   
    @Override
    public void runTest() {
        
     //cчитывание параметров, загрузка в файл и отправка
    }
    
}
