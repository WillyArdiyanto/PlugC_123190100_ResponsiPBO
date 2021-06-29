package barang.view;

import barang.controller.ControllerBarang;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ViewMenu extends JFrame implements ActionListener {

    private JLabel labelMenu;
    private JButton btnCreate,btnRead;
    
    public ViewMenu(){
        setTitle("Menu");
        labelMenu = new JLabel("--Menu Utama--");
        labelMenu.setHorizontalAlignment(SwingConstants.CENTER);
        btnCreate = new JButton(" Tambah Barang");
        btnRead = new JButton(" Lihat Barang ");
        setLayout(new GridLayout(3,1));
        add(labelMenu);
        add(btnCreate);
        add(btnRead);
        pack();
        setResizable(true);
        setLocation(540,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRead.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCreate.addActionListener(this);
        btnRead.addActionListener(this);

        setVisible(true);
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnCreate){
            ControllerBarang barang = new ControllerBarang();
            barang.createBarang();
            dispose();
        }
        else if(e.getSource()== btnRead){
            ControllerBarang b = new ControllerBarang();
            b.readBarang();
            dispose();
        }
    }
}
