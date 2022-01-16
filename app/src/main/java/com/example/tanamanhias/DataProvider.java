package com.example.tanamanhias;

import android.content.Context;

import com.example.tanamanhias.model.Aglonema;
import com.example.tanamanhias.model.Kaktus;
import com.example.tanamanhias.model.Tanaman;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    private static List<Tanaman> tanamans = new ArrayList<>();

    private static List<Kaktus> initDataKaktus(Context ctx){
        List<Kaktus> kaktuses = new ArrayList<>();
        kaktuses.add(new Kaktus(ctx.getString(R.string.senilis_nama), ctx.getString(R.string.senilis_asal), ctx.getString(R.string.senilis_deskripsi), R.drawable.sinilis_kaktus ));
        kaktuses.add(new Kaktus(ctx.getString(R.string.grusonii_nama), ctx.getString(R.string.grusonii_asal), ctx.getString(R.string.grusonii_deskripsi), R.drawable.grusonii_kaktus));
        kaktuses.add(new Kaktus(ctx.getString(R.string.echinofossulocactus_nama), ctx.getString(R.string.echinofossulocactus_asal), ctx.getString(R.string.echinofossulocactus_deskripsi), R.drawable.echinofossulocactus_kaktus));
        kaktuses.add(new Kaktus(ctx.getString(R.string.ferocactus_nama), ctx.getString(R.string.ferocactus_asal), ctx.getString(R.string.ferocactus_deskripsi), R.drawable.ferocactus_kaktus));
        kaktuses.add(new Kaktus(ctx.getString(R.string.gymnocalycium_nama), ctx.getString(R.string.gymnocalycium_asal), ctx.getString(R.string.gymnocalycium_deskripsi), R.drawable.gymnocalycium_kaktus ));


        return kaktuses;
    }

    private static List<Aglonema> initDataAglonema(Context ctx){
        List<Aglonema> aglonemas = new ArrayList<>();
        aglonemas.add(new Aglonema(ctx.getString(R.string.tricolor_nama), ctx.getString(R.string.tricolor_asal), ctx.getString(R.string.tricolor_deskripsi), R.drawable.tricolor_aglonema ));
        aglonemas.add(new Aglonema(ctx.getString(R.string.suksom_nama), ctx.getString(R.string.suksom_asal), ctx.getString(R.string.suksom_deskripsi), R.drawable.suksom_aglonema ));
        aglonemas.add(new Aglonema(ctx.getString(R.string.pride_nama), ctx.getString(R.string.pride_asal), ctx.getString(R.string.pride_deskripsi), R.drawable.pride_aglonema ));
        aglonemas.add(new Aglonema(ctx.getString(R.string.legacy_nama), ctx.getString(R.string.legacy_asal), ctx.getString(R.string.legacy_deskripsi), R.drawable.legacy_aglonema ));
        aglonemas.add(new Aglonema(ctx.getString(R.string.silver_nama), ctx.getString(R.string.silver_asal), ctx.getString(R.string.silver_deskripsi), R.drawable.silver_aglonema ));


        return aglonemas;
    }

    private static void initAllTanamans(Context ctx){
        tanamans.addAll(initDataKaktus(ctx));
        tanamans.addAll(initDataAglonema(ctx));
    }
    public static List<Tanaman> getAllTanaman(Context ctx){
        if (tanamans.size() == 0){
            initAllTanamans(ctx);
        }
        return tanamans;
    }

    public static List<Tanaman> getTanamanByTipe(Context ctx, String jenis){
        List<Tanaman> tanamanByTipe = new ArrayList<>();
        if (tanamans.size() == 0){
            initAllTanamans(ctx);
        }
        for (Tanaman t : tanamans){
            if (t.getJenis().equals(jenis)){
                tanamanByTipe.add(t);
            }
        }

        return tanamanByTipe;
    }
}
