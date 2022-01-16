package com.example.tanamanhias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnKaktus,btnAglonema;
    Button button;
    public static final String JENIS_GALERI_KEY = "JENIS_GALERI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();
    }

    private void inisialisasiView() {
        btnKaktus = findViewById(R.id.btn_buka_varian_kaktus);
        btnAglonema = findViewById(R.id.btn_buka_varian_aglonema);
        button = findViewById(R.id.dialog_button);
        btnKaktus.setOnClickListener(view -> bukaGaleri("Kaktus"));
        btnAglonema.setOnClickListener(view -> bukaGaleri("Aglonema"));
        button.setOnClickListener(view -> profilActivity());

    }

    private void bukaGaleri(String jenisTanaman) {
        Log.d("MAIN","Buka activity galeri");
        Intent intent = new Intent(this, DaftarTumbuhanActivity.class);
        intent.putExtra(JENIS_GALERI_KEY, jenisTanaman);
        startActivity(intent);
    }
    private void profilActivity() {
        Log.d("MAIN","Buka Activity profil");
        Intent intent = new Intent(this, Profil.class);
        startActivity(intent);
    }
}