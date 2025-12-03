package model;

public class NhanVien implements java.io.Serializable {
    private String maNV, ten, chucVu;
    private double luongCoBan;

    public NhanVien(String maNV, String ten, String chucVu, double luongCoBan) {
        this.maNV = maNV;
        this.ten = ten;
        this.chucVu = chucVu;
        this.luongCoBan = luongCoBan;
    }

    @Override
    public String toString() {
        return maNV + " | " + ten + " | " + chucVu + " | Lương: " + String.format("%,.0f", luongCoBan);
    }

    public String getMaNV() { return maNV; }
}