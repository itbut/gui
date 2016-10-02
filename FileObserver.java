package gui;

import java.awt.Container;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kate
 */
public class FileObserver extends JFrame {

    private static final Dimension size = new Dimension(640, 480);
    private Container cp;
    private JTextField directory;
    private JButton chooseFile;
    private JButton ok;
    private JList<File> list;
    private JTextArea text;
    private File currentDir;

    public FileObserver() {
        setLocation(150, 80);
        setSize(size);
        setTitle("File Observer, ver. 1.0");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        init();
        setVisible(true);
    }

    public static void main(String[] args) {
        FileObserver fo = new FileObserver();
    }

    private void init() {
        cp = getContentPane();
        JLabel a = new JLabel("Current directory: ");
        a.setBounds(8, 6, 120, 32);
        cp.add(a);

        directory = new JTextField();
        currentDir = new File("./");
        try {
            directory.setText(currentDir.getCanonicalPath());
        } catch (IOException ex) {
            directory.setText(" ");
        }

        directory.setBounds(8, 35, 420, 28);
        cp.add(directory);
        chooseFile = new JButton("Choose file...");
        chooseFile.setBounds(432, 35, 120, 28);
        chooseFile.addActionListener(new ChooseFile(this));
        cp.add(chooseFile);
        ok = new JButton("OK");
        ok.setBounds(558, 35, 60, 28);
        ok.addActionListener(new Submit(this));
        cp.add(ok);
        JLabel b = new JLabel("File List:");
        b.setBounds(8, 65, 120, 28);
        cp.add(b);

        JLabel c = new JLabel("File content:");
        c.setBounds(216, 65, 120, 28);
        cp.add(c);

        list = new JList(currentDir.listFiles());
        JScrollPane sp = new JScrollPane(list);
        sp.setBounds(8, 100, 200, 340);
        cp.add(sp);
        text = new JTextArea();
        text.setBounds(216, 100, 408, 340);
        cp.add(text);

    }

    void setCurrentDirectory() {
        JFileChooser fc = new JFileChooser(currentDir);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int r = fc.showOpenDialog(this);
        if (r == JFileChooser.APPROVE_OPTION) {
           setList (fc.getSelectedFile());
        }    
    } 
    
    
    void setList (File dir){
       dir = (dir == null)?new File(directory.getText()):dir;
                
     try {
                directory.setText(dir.getCanonicalPath());
                currentDir = dir;
            } catch (IOException ex) {
                return;
            }
            list.setListData(currentDir.listFiles());
        }
    }

