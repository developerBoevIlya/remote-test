/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remotetest.gui;

import java.util.ArrayList;

/**
 *
 * @author nikit
 */
public class ListTest {
    private ArrayList<AbstractTest> testList = new ArrayList<AbstractTest>();
    public void add(AbstractTest test)
    {
         this.testList.add(test);
    }
    
}
