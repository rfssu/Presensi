package com.rafi.presensi.api;

import com.rafi.presensi.kelas.Pegawai2;
import com.rafi.presensi.kelas.Hasil;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ServiceApi {

    //TAMPIL SEMUA DATA
    @GET("absensi/")
    Call<Pegawai2> tampilDataAll(
            @Query("kunci") String kunci
    );

    //TAMPIL DATA DENGAN ID
//    @GET("uri")
//    Call<NamaKelas> getFunction(@Query("param") String param);

    //SIMPAN DATA
    @FormUrlEncoded
    @POST("absensi/")
    Call<Hasil> simpanDataCloud(
            @Query("kunci") String kunci,
            @Field("id_absensi") String id_absensi,
            @Field("nidn") String nidn,
            @Field("nama") String nama,
            @Field("tanggal") String tanggal,
            @Field("jam") String jam,
            @Field("status") String status,
            @Field("telat") String telat
    );

}
