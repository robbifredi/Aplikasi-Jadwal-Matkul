package com.example.aplikasijadwal;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
    ArrayList <Jadwal> list_jadwal = new ArrayList<Jadwal>();
    TextView tvhari;
    ListView listviewjadwal ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvhari = (TextView) findViewById(R.id.textViewHari);
listviewjadwal = (ListView) findViewById(R.id.listViewJadwal);

        initData();
            }
public void initData() {

list_jadwal.add(new Jadwal("Senin","------","TIDAK ADA JADWAL"));
list_jadwal.add(new Jadwal("Selasa","18:30-20:00","Keamanan Komputer"));
list_jadwal.add(new Jadwal("Selasa","20:00-21:30","Sistem Informasi Akutansi"));
list_jadwal.add(new Jadwal("Rabu","18:30-20:00","Management Proyek Sistem Informasi"));
list_jadwal.add(new Jadwal("Kamis","18:30-20:00","VBnet"));
list_jadwal.add(new Jadwal("Kamis","20:00-21:30","Java 2"));
list_jadwal.add(new Jadwal("Jumat","-------","TIDAK ADA JADWAL"));
list_jadwal.add(new Jadwal("Sabtu","16:30-18.00","Etika Profesi IT"));
list_jadwal.add(new Jadwal("Sabtu","18:30-20:00","Perancangan Sistem"));
list_jadwal.add(new Jadwal("Minggu","------","LIBUR COY TANGGAL MERAH"));
   
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

     /**
     * On selecting action bar
     * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
        case R.id.action_senin:
            // location found
            showJadwal("Senin");
            return true;   
        case R.id.action_selasa:
            // location found
            showJadwal("Selasa");
            return true;
        case R.id.action_rabu:
            showJadwal("Rabu");
            return true;
        case R.id.action_kamis:
            showJadwal("Kamis");
            return true;
        case R.id.action_jumat:
            showJadwal("Jumat");
            return true;
        case R.id.action_sabtu:
            showJadwal("Sabtu");
            return true;
        case R.id.action_minggu:
            showJadwal("Minggu");
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }

    public void showJadwal(String hari) {

        tvhari.setText("Hari " + hari);
        ArrayList<Jadwal> jadwal_terpilih = new ArrayList<Jadwal>();
            for (int i = 0; i < list_jadwal.size(); i++) {
                Jadwal jadwal = list_jadwal.get(i);
                if (jadwal.hari.equals(hari)) {
                    jadwal_terpilih.add(jadwal);
       

                }

            }

        SubJadwal adapterjadwal = new SubJadwal(MainActivity.this, 0,
                jadwal_terpilih);
        listviewjadwal.setAdapter(adapterjadwal);
    }
}
