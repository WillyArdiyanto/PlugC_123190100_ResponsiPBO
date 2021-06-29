package barang.view;

import barang.controller.ControllerBarang;
import barang.controller.ControllerMenu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewTotalHarga extends JFrame implements ActionListener {

    private JLabel labelNama, labelTotal, labelMassa, labelHargaSatuan,
            isNama, isMassa, isTotal, isHargaSatuan;
    private JButton btnBack;
    private String id, isisTotal;
    private Double harga, total;

    public void openTotal(String[] data, Double banyak) {
        id = data[0];
        setTitle(data[1]);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 225);

        labelNama = new JLabel(" Nama ");
        labelMassa = new JLabel(" Massa (gr) ");
        labelHargaSatuan = new JLabel(" Harga Satuan ");
        labelTotal = new JLabel("Total Harga");
        isNama = new JLabel(data[1]);
        isMassa = new JLabel(data[2]);
        isHargaSatuan = new JLabel(data[3]);
        harga = Double.parseDouble(data[3]);
        total = harga * banyak;
        //menghitung diskon
        if (banyak>=12) {
            total= 0.95 * total;
        }
        else if (banyak>=20) {
            total= 0.9 * total;
        }
        else if (banyak>=144) {
            total=0.75 * total;
        }
        else{
            total=total;
        }
        isisTotal = Double.toString(total);
        isTotal = new JLabel(isisTotal);
        btnBack = new JButton("Kembali");

        setLayout(null);
        add(labelNama);
        add(labelMassa);
        add(labelHargaSatuan);
        add(labelTotal);
        add(isNama);
        add(isMassa);
        add(isHargaSatuan);
        add(isTotal);
        add(btnBack);

        labelNama.setBounds(10, 10, 120, 20);
        isNama.setBounds(130, 10, 190, 20);
        labelMassa.setBounds(10, 35, 120, 20);
        isMassa.setBounds(130, 35, 190, 20);
        labelHargaSatuan.setBounds(10, 60, 120, 20);
        isHargaSatuan.setBounds(130, 60, 190, 20);
        labelTotal.setBounds(10, 85, 120, 20);
        isTotal.setBounds(130, 85, 190, 20);

        btnBack.setBounds(10, 155, 320, 20);
        btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnBack.addActionListener(this);

        setResizable(false);
        setLocation(450, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            ControllerBarang d = new ControllerBarang();
            d.readBarang();
            dispose();
        }
    }
}
