/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JukeBox;

/**
 *
 * @author Luke
 */
public class JukeBoxEntry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JukeBox jb = new JukeBox();
        JukeUI ui =  new JukeUI(jb);
        //ui.setLibraryList(jb);
        ui.setVisible(true);
    }
    
}
