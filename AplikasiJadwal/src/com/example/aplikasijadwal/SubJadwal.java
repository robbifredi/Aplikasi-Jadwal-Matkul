package com.example.aplikasijadwal;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SubJadwal extends ArrayAdapter<Jadwal>{
    private Activity activity;
    private ArrayList<Jadwal> lJadwal;
    private static LayoutInflater inflater = null;
public SubJadwal (Activity activity, int textViewResourceId, ArrayList<Jadwal> al_Jadwal) {
            super(activity, textViewResourceId, al_Jadwal);
        try {
            this.activity = activity;
            this.lJadwal = al_Jadwal;

            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        } catch (Exception e) {
        }
    }

    public int getCount() {
        return lJadwal.size();
    }
    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        public TextView jam;
        public TextView pelajaran;
        public TextView dosen;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final ViewHolder holder;
        try {
            if (convertView == null) {
                vi =inflater.inflate(R.layout.row_jadwal, null);
                holder = new ViewHolder();

                holder.jam = (TextView) vi.findViewById(R.id.textViewRowJam);
                holder.pelajaran = (TextView) vi.findViewById(R.id.textViewRowPelajaran);
      

                vi.setTag(holder);
            } else {
                holder = (ViewHolder) vi.getTag();
            }

           holder.jam.setText(lJadwal.get(position).jam);
           holder.pelajaran.setText(lJadwal.get(position).pelajaran);

        } catch (Exception e) {

        }
        return vi;
    }
}