package com.rafi.presensi.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.rafi.presensi.R;
import com.rafi.presensi.adapter.ListAdapter;
import com.rafi.presensi.api.UrlApi;
import com.rafi.presensi.api.ServiceApi;
import com.rafi.presensi.kelas.Pegawai;
import com.rafi.presensi.kelas.Pegawai2;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CloudDaftarActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private ListAdapter mAdapter;

    private ArrayList<Pegawai> absenArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloud_daftar);

        setTitle("Daftar Hadir Cloud");

        recyclerView = findViewById(R.id.rv_daftar_cloud);

        absenArrayList = new ArrayList<>();
        mAdapter = new ListAdapter(this, absenArrayList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));

        getAbsen();
    }

    private void getAbsen(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        ServiceApi service = retrofit.create(ServiceApi.class);

        Call<Pegawai2> call = service.tampilDataAll(UrlApi.API_KEY);

        call.enqueue(new Callback<Pegawai2>() {
            @Override
            public void onResponse(Call<Pegawai2> call, Response<Pegawai2> response) {

                assert response.body() != null;

                absenArrayList.clear();

//                for (int i = 0; i < response.body().getAbsens().size(); i++) {
//
//                    String id = response.body().getAbsens().get(i).getId_pengguna();
//
//                    Kelas m = new Kelas(idp);
//
//                    absenArrayList.add(m);
//                }

                mAdapter.notifyDataSetChanged();

                mAdapter = new ListAdapter(getApplicationContext(), response.body().getPegawaiArrayList());

                recyclerView.setAdapter(mAdapter);

            }

            @Override
            public void onFailure(Call<Pegawai2> call, Throwable t) {

                Log.d("onFailure DCA", t.toString());
            }
        });

    }
}