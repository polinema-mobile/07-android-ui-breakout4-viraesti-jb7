package com.example.jb7;

import android.os.Parcel;
import android.os.Parcelable;

public class FomMhs implements Parcelable {
    private String nama;
    private String nim;
    private String date;
    private String gender;
    private String jurusan;

    public FomMhs(String nama, String nim, String date, String gender, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.date = date;
        this.gender = gender;
        this.jurusan = jurusan;
    }

    public FomMhs(Parcel parcel) {
        nama = parcel.readString();
        nim = parcel.readString();
        date = parcel.readString();
        gender = parcel.readString();
        jurusan = parcel.readString();
    }

    public static final Creator<FomMhs> CREATOR = new Creator<FomMhs>() {
        @Override
        public FomMhs createFromParcel(Parcel in) {
            return new FomMhs(in);
        }

        @Override
        public FomMhs[] newArray(int size) {
            return new FomMhs[0];
        }
    };

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getDate() {
        return date;
    }

    public String getGender() {
        return gender;
    }

    public String getJurusan() {
        return jurusan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(nim);
        dest.writeString(date);
        dest.writeString(gender);
        dest.writeString(jurusan);
    }
}
