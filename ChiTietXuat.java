package model;

public class ChiTietXuat implements java.io.Serializable {
    private String maCTX, maPX, maSP;
    private int soLuong;

    public ChiTietXuat(String maCTX, String maPX, String maSP, int soLuong) {
        this.maCTX = maCTX;
        this.maPX = maPX;
        this.maSP = maSP;
        this.soLuong = soLuong;
    }

    public String getMaSP() { return maSP; }
    public int getSoLuong() { return soLuong; }
}