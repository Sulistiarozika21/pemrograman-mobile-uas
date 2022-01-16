package com.example.tanamanhias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tanamanhias.model.Aglonema;
import com.example.tanamanhias.model.Kaktus;
import com.example.tanamanhias.model.Tanaman;

import java.util.List;

public class DaftarTumbuhanActivity extends AppCompatActivity {
    public final static String TANAMAN_TERPILIH ="tanaman_obj_key";
    List<Tanaman> tanamans;
    ListView listView;
    String jenisTanaman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_tumbuhan);
        Intent intent = getIntent();
        jenisTanaman = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        tanamans = DataProvider.getTanamanByTipe(this,jenisTanaman);

        TextView txJudulList = findViewById(R.id.text_title_daftar);
        String judul = "";
        if (tanamans.get(0) instanceof Kaktus){
            judul = getString(R.string.kaktus_list_title);
        }else if (tanamans.get(0) instanceof Aglonema){
            judul = getString(R.string.aglonema_list_title);
        }
        txJudulList.setText(judul);
        setupListView();


    }

    private void setupListView() {
        listView = findViewById(R.id.listview_daftar_tanaman);
        DaftarTanamanAdapter adapter = new DaftarTanamanAdapter(this, tanamans);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onListClik);
    }

    private AdapterView.OnItemClickListener onListClik = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Tanaman terpilih = tanamans.get(position);
            bukaProfilTanaman(terpilih);

        }
    };

    private void bukaProfilTanaman(Tanaman tanamanTerpilih){
        Log.d("MAIN", "buka activity galeri");
        Intent intent = new Intent(this, ProfilActivity.class);
        intent.putExtra(TANAMAN_TERPILIH, tanamanTerpilih);
        startActivity(intent);
    }
}