package barang.view;

import barang.controller.ControllerBarang;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewDetailBarang extends JFrame implements ActionListener {

    private JLabel labelNama, labelMassa, labelHargaSatuan, labelBanyak,
            isNama, isMassa, isHargaSatuan;
    private JTextField fieldBanyak;
    private JButton btnUpdate, btnDelete, btnBack, btnProcess;
    private String id;

    public void openDetail(String[] data) {
        this.id = data[0];
        setTitle("Detail " + data[1]);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 325);
        labelNama = new JLabel(" Nama Barang   : ");
        labelMassa = new JLabel(" Massa (gr)    : ");
        labelHargaSatuan = new JLabel(" Harga Satuan  : ");
        labelBanyak = new JLabel(" Banyak : ");

        isNama = new JLabel(data[1]);
        isMassa = new JLabel(data[2]);
        isHargaSatuan = new JLabel(data[3]);
        fieldBanyak = new JTextField(10);

        btnUpdate = new JButton("Edit");
        btnDelete = new JButton("Hapus");
        btnBack = new JButton("Kembali");
        btnProcess = new JButton("Total Harga");

        setLayout(null);
        add(labelNama);
        add(labelMassa);
        add(labelHargaSatuan);
        add(labelBanyak);
        add(isNama);
        add(isMassa);
        add(isHargaSatuan);
        add(fieldBanyak);

        add(btnUpdate);
        add(btnDelete);
        add(btnBack);
        add(btnProcess);

        labelNama.setBounds(10, 10, 120, 20);
        isNama.setBounds(130, 10, 190, 20);
        labelMassa.setBounds(10, 35, 120, 20);
        isMassa.setBounds(130, 35, 190, 20);
        labelHargaSatuan.setBounds(10, 60, 120, 20);
        isHargaSatuan.setBounds(130, 60, 190, 20);
        labelBanyak.setBounds(10, 85, 120, 20);
        fieldBanyak.setBounds(130, 85, 190, 20);

        btnProcess.setBounds(200, 150, 120, 20);
        btnProcess.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnProcess.addActionListener(this);
        btnBack.setBounds(10, 260, 90, 20);
        btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnBack.addActionListener(this);
        btnUpdate.setBounds(110, 260, 90, 20);
        btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnUpdate.addActionListener(this);
        btnDelete.setBounds(210, 260, 90, 20);
        btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDelete.addActionListener(this);

        setResizable(false);
        setLocation(450, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnUpdate) {
            ControllerBarang controllerBarang = new ControllerBarang();
            controllerBarang.updateBarang(id); //masih error
            dispose();
        } else if (e.getSource() == btnDelete) {
            ControllerBarang c = new ControllerBarang();
            c.delete(id);
            dispose();
        } else if (e.getSource() == btnProcess) {
            if (fieldBanyak.getText().matches("[a-zA-Z]+")) {
                setMessage("Banyak harus angka!");
            }
            if (fieldBanyak.getText().contains("-")) {
                setMessage("Banyak harus positif!");
            } else {
                ControllerBarang c = new ControllerBarang();
                c.Total(id, Double.parseDouble(fieldBanyak.getText()));
                dispose();
            }
        } else if (e.getSource() == btnBack) {
            ControllerBarang d = new ControllerBarang();
            d.readBarang();
            dispose();
        }
    }

    public void setMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
