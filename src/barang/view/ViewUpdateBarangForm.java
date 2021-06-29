package barang.view;

import barang.controller.ControllerBarang;
import barang.controller.ControllerMenu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewUpdateBarangForm extends JFrame implements ActionListener {

    private JTextField fieldNama, fieldMassa, fieldHargaSatuan;
    private JLabel labelJudul, labelNama, labelMassa, labelHargaSatuan;
    private JButton btnSubmit, btnReset, btnBack;
    private String id;

    public void openForm(String[] data) {
        id = data[0];
        setTitle("Update Barang");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 225);

        fieldNama = new JTextField(data[1],10);
        fieldMassa = new JTextField(data[2],10);
        fieldHargaSatuan = new JTextField(data[3],10);
        labelJudul = new JLabel(" Update Barang ");
        labelNama = new JLabel(" Nama ");
        labelMassa = new JLabel(" Massa (gr) ");
        labelHargaSatuan = new JLabel(" Harga Satuan ");
        btnSubmit = new JButton("Submit");
        btnReset = new JButton("Reset");
        btnBack = new JButton("Kembali");

        setLayout(null);
        add(labelJudul);
        add(fieldNama);
        add(labelNama);
        add(labelMassa);
        add(fieldMassa);
        add(labelHargaSatuan);
        add(fieldHargaSatuan);
        add(btnSubmit);
        add(btnReset);
        add(btnBack);

        labelJudul.setBounds(10, 10, 120, 20);
        labelNama.setBounds(10, 35, 120, 20);
        fieldNama.setBounds(130, 35, 190, 20);
        labelMassa.setBounds(10, 60, 120, 20);
        fieldMassa.setBounds(130, 60, 190, 20);
        labelHargaSatuan.setBounds(10, 85, 120, 20);
        fieldHargaSatuan.setBounds(130, 85, 190, 20);
        btnSubmit.setBounds(75, 125, 120, 20);
        btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSubmit.addActionListener(this);
        btnReset.setBounds(200, 125, 120, 20);
        btnReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnReset.addActionListener(this);
        btnBack.setBounds(10, 155, 320, 20);
        btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnBack.addActionListener(this);

        setResizable(false);
        setLocation(450, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            if (fieldNama.getText().equals("")) {
                setMessage("Nama barang harus diisi!");
            }
            if (fieldMassa.getText().equals("")) {
                setMessage("Massa barang harus diisi!");
            }
            if (fieldHargaSatuan.getText().equals("")) {
                setMessage("Harga satuan barang harus diisi!");
            }
            if (fieldMassa.getText().matches("[a-zA-Z]+")) {
                setMessage("Massa barang harus angka!");
            }
            if (fieldHargaSatuan.getText().matches("[a-zA-Z]+")) {
                setMessage("Harga satuan barang harus angka!");
            }
            if (fieldMassa.getText().contains("-")) {
                setMessage("Massa harus positif!");
            }
            if (fieldHargaSatuan.getText().contains("-")) {
                setMessage("Harga harus positif!");
            } else {
                String[] data = {
                    fieldNama.getText(), fieldMassa.getText(), fieldHargaSatuan.getText()
                };
                ControllerBarang barang = new ControllerBarang();
                barang.updateBarang(data);
            }
        } else if (e.getSource() == btnReset) {
            reset();
        } else if (e.getSource() == btnBack) {
            dispose();
            ControllerMenu m = new ControllerMenu();
            m.openMenu();
        }
    }

    public void reset() {
        fieldNama.setText("");
        fieldMassa.setText("");
        fieldHargaSatuan.setText("");
    }

    public void setMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
