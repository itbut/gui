package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JAVA
 */
public class ChooseFile implements ActionListener {

    private FileObserver gui;

    public ChooseFile(FileObserver gui) {
        this.gui = gui;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gui.setCurrentDirectory();
    }
}
