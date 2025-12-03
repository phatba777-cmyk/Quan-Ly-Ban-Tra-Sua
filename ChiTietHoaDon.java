package model;

public class ChiTietHoaDon implements java.io.Serializable {
    private String maCT, maHD, maSP;
    private int soLuong;
    private double donGia;

    public ChiTietHoaDon(String maCT, String maHD, String maSP, int soLuong, double donGia) {
        this.maCT = maCT;
        this.maHD = maHD;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public double getThanhTien() {
        return soLuong * donGia;
    }

    public String getMaSP() { return maSP; }
    public int getSoLuong() { return soLuong; }
    public double getDonGia() { return donGia; }
}