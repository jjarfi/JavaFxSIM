/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author pacevil
 */
public class kampung {

    private final StringProperty idka;
    private final StringProperty nama;

    public kampung(String idka, String nama) {
        this.idka = new SimpleStringProperty(idka);
        this.nama = new SimpleStringProperty(nama);
    }

    public final String getIdka() {
        return idka.get();
    }

    public final void setIdka(String value) {
        idka.set(value);
    }

    public StringProperty idkaProperty() {
        return idka;
    }

    public final String getNama() {
        return nama.get();
    }

    public final void setNama(String value) {
        nama.set(value);
    }

    public StringProperty namaProperty() {
        return nama;
    }
    

}
