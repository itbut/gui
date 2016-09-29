/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author JAVA
 */
public class Submit implements ActionListener {

    private FileObserver gui;

    public Submit(FileObserver gui) {
        this.gui = gui;
    }

    public void actionPerformed(ActionEvent e) {
        gui.setList(null);
    }

}
