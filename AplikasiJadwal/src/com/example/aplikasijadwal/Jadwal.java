package com.example.aplikasijadwal;

public class Jadwal {
	public String hari="";
    public String jam="";
    public String pelajaran="";

    public Jadwal (String pday, String ptime, String plesson){
        this.hari = pday;
        this.jam = ptime;
        this.pelajaran = plesson;
    }
}
