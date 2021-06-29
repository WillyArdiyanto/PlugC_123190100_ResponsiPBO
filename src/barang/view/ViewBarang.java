package barang.view;

import barang.controller.ControllerBarang;
import barang.controller.ControllerMenu;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewBarang extends JFrame implements ActionListener {
    private JTable table;
    private JButton btnBalik;
    private String kode;
    public ViewBarang(String[][] data){
        try{
            kode = data[0][0];
            final String[] tableTitle = {"Id","Nama","Massa","Harga"};
            setTitle("Data Barang");
            setSize(900,375);
            
            btnBalik = new JButton("Kembali");
            table = new JTable(data, tableTitle);
            table.setBounds(30,40,400,600);
            JScrollPane sp = new JScrollPane(table);
            sp.setPreferredSize(new Dimension(500,80));
            this.getContentPane().add(BorderLayout.CENTER, sp);
            this.getContentPane().add(BorderLayout.SOUTH, btnBalik);
            btnBalik.addActionListener(this);
            btnBalik.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                public void valueChanged(ListSelectionEvent event) {
                    dispose();
                    kode = table.getValueAt(table.getSelectedRow(), 0).toString();
                    ControllerBarang controllerBarang = new ControllerBarang();
                    controllerBarang.readBarang(kode);
                    }
                });
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocation(200,150);
            setVisible(true);
        }
        catch (Exception e){
            System.out.println("Error : " + e);
        }
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnBalik){
            ControllerMenu menu = new ControllerMenu();
            menu.openMenu();
            dispose();
        }
    }
}
