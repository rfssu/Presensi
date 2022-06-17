package com.rafi.presensi.kelas;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Pegawai2 {

    @SerializedName("absensi")
    private ArrayList<Pegawai> pegawaiArrayList;

    public Pegawai2() {

    }

    public ArrayList<Pegawai> getPegawaiArrayList() {
        return pegawaiArrayList;
    }

    public void setPegawaiArrayList(ArrayList<Pegawai> pegawaiArrayList) {
        this.pegawaiArrayList = pegawaiArrayList;
    }

}
