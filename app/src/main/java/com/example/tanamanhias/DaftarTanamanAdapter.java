package com.example.tanamanhias;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tanamanhias.model.Tanaman;

import java.util.List;

public class DaftarTanamanAdapter extends ArrayAdapter<Tanaman> {

    Context context;
    public DaftarTanamanAdapter(Context context, List<Tanaman> tanamans){
        super(context, R.layout.row_daftar_tanaman, tanamans);
        this.context = context;
    }

    private static class ViewHolder  {
        TextView textJenis;
        TextView textAsal;
        ImageView gambar;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Tanaman tanaman = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater= LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_daftar_tanaman, parent, false);
            viewHolder.textJenis = convertView.findViewById(R.id.row_text_jenis);
            viewHolder.textAsal = (TextView) convertView.findViewById(R.id.row_text_asal);
            viewHolder.gambar = convertView.findViewById(R.id.row_image_tanaman);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textJenis.setText(tanaman.getVarian());
        viewHolder.textAsal.setText(tanaman.getAsal());
        viewHolder.gambar.setImageDrawable(context.getDrawable(tanaman.getDrawableRes()));
        return convertView;
    }
}
