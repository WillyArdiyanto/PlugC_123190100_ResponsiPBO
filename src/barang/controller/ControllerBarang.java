package barang.controller;

import barang.model.ModelBarang;
import barang.view.ViewBarang;
import barang.view.ViewBarangForm;
import barang.view.ViewDetailBarang;
import barang.view.ViewMenu;
import barang.view.ViewTotalHarga;
import barang.view.ViewUpdateBarangForm;

public class ControllerBarang {

    public void createBarang() {
        ViewBarangForm view = new ViewBarangForm();
        view.openForm();
    }

    public void createBarang(String[] data) {
        ModelBarang modelbarang = new ModelBarang();
        modelbarang.createBarang(data);
    }

    public void readBarang() {
        ModelBarang model = new ModelBarang();
        String[][] data = model.readBarang();
        if (data == null) {
            new ViewMenu();
        } else {
            new ViewBarang(data);
        }
    }

    public void readBarang(String kode) {
        ModelBarang model = new ModelBarang();
        ViewDetailBarang view = new ViewDetailBarang();
        view.openDetail(model.readBarang(kode));
    }

    public void Total(String kode, Double banyak) {
        ModelBarang model = new ModelBarang();
        ViewTotalHarga view = new ViewTotalHarga();
        view.openTotal(model.readBarang(kode), banyak);
    }

    public void updateBarang(String id) {
        ModelBarang m = new ModelBarang();
        String kode = id;
        ViewUpdateBarangForm update = new ViewUpdateBarangForm();
        update.openForm(m.readBarang(kode));
    }

    public void updateBarang(String[] data) {
        ModelBarang m = new ModelBarang();
        m.updateData(data);
    }

    public void delete(String id) {
        ModelBarang m = new ModelBarang();
        m.delete(id);
    }
}
