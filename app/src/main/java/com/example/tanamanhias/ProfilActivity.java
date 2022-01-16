package com.example.tanamanhias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tanamanhias.model.Aglonema;
import com.example.tanamanhias.model.Kaktus;
import com.example.tanamanhias.model.Tanaman;

public class ProfilActivity extends AppCompatActivity {

    Tanaman tanaman;
    TextView txJudul,txJenis,txAsal,txDeskripsi;
    ImageView ivFotoTanaman;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_varian);
        Intent intent = getIntent();
        tanaman =(Tanaman) intent.getSerializableExtra(DaftarTumbuhanActivity.TANAMAN_TERPILIH);
        inisialisasiView();
        tampilkanProfil(tanaman);
    }
    private void inisialisasiView(){
        txJudul = findViewById(R.id.txJudul);
        txJenis = findViewById(R.id.txJenis);
        txAsal = findViewById(R.id.txAsal);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivFotoTanaman = findViewById(R.id.gambarTanaman);
        btnBack = findViewById(R.id.btn_back_to_list);
        btnBack.setOnClickListener(view -> {
            onBackPressed();
        });
    }
    private void tampilkanProfil(Tanaman tanaman){
        Log.d("Profil", "menampilkan " +tanaman.getJenis() );
        if (tanaman instanceof Kaktus){
            txJudul.setText(getString(R.string.kaktus));
        }else  if (tanaman instanceof Aglonema){
            txJudul.setText(getString(R.string.aglonema));
        }

        txJenis.setText(tanaman.getVarian());
        txAsal.setText(tanaman.getAsal());
        txDeskripsi.setText(tanaman.getDeskripsi());
        ivFotoTanaman.setImageDrawable(this.getDrawable(tanaman.getDrawableRes()));

    }

}