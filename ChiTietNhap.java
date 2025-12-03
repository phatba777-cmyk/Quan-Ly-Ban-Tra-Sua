package model;

public class ChiTietNhap implements java.io.Serializable {
    private String maCTN, maPN, maSP;
    private int soLuong;
    private double donGia;

    public ChiTietNhap(String maCTN, String maPN, String maSP, int soLuong, double donGia) {
        this.maCTN = maCTN;
        this.maPN = maPN;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getMaSP() { return maSP; }
    public int getSoLuong() { return soLuong; }
    public double getDonGia() { return donGia; }
}