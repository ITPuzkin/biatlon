package view;

import com.alee.laf.WebLookAndFeel;
import com.alee.laf.button.WebButton;
import model.JGroup;
import model.JPerson;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.text.ParseException;
import java.util.Formatter;
import java.util.HashMap;

/**
 * Created by eroshin on 03.03.2016.
 */
public class biatlonWindow {
    private JTextField textYear;
    private JTextField textSurName;
    private JTextField textName;
    private JTextField textTown;
    private JTextField textNumber;
    private JTabbedPane tabbedPane1;
    private JButton buttonRedactor;
    private JButton buttonAdd;
    private JPanel panelWindow;

    public biatlonWindow local;
    public static JFrame localFrame;

    private HashMap<String, JGroup> groups;
    private HashMap<Integer, JPerson> particiants;

    public biatlonWindow(){
        local = this;
        groups = new HashMap<>();
        particiants = new HashMap<>();
        buttonRedactor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("groupWindow");
                frame.setContentPane(new groupEditWindow(local,frame).panelGroupEdit);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                localFrame.setVisible(false);
            }
        });

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //addPerson();
            }
        });
    }

    public void addPerson(int year,
                          String name,
                          String surName,
                          String town,
                          int number){
        JPerson p = new JPerson(name,surName,town,year,number);
        particiants.put(p.getpNumber(),p);
    }


    public void addGroup(JGroup g){
        groups.put(g.getgName(),g);
        drawGoup(g);
    }

    public void drawGoup(JGroup g){
        if(tabbedPane1.indexOfTab(g.getgName())==-1){
            addTab(g.getgName());
        }
    }

    public void addTab(String n){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout());
        JTable table = new JTable();
        JScrollPane sPane = new JScrollPane(table);
        sPane.setSize(panel.getSize());
        table.setFillsViewportHeight(true);
        panel.add(sPane);
        tabbedPane1.addTab(n,panel);
    }

    public static void main(String[] args) {
        WebLookAndFeel.install ();

        JFrame frame = new JFrame("biatlonWindow");
        localFrame = frame;
        frame.setContentPane(new biatlonWindow().panelWindow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
