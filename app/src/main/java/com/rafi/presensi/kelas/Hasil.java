package com.rafi.presensi.kelas;

import com.google.gson.annotations.SerializedName;

public class Hasil {

    @SerializedName("error")
    private final Boolean error;
    @SerializedName("pesan")
    private final String pesan;

    public Hasil(Boolean error, String pesan) {
        this.error = error;
        this.pesan = pesan;
    }

    public Boolean getError() {
        return error;
    }

    public String getPesan() {
        return pesan;
    }
}
