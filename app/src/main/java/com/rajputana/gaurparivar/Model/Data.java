package com.rajputana.gaurparivar.Model;

/**
 * Created by Yazdani on 9/16/2018.
 */

public class Data {

    String name;
    String fname;
    String note;


    public Data(String name, String fname, String note) {
        this.name = name;
        this.fname = fname;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    public Data(){}
}
