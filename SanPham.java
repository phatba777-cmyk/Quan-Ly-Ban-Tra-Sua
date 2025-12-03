package model;

import service.IKhuyenMai;
import java.io.Serializable;

public abstract class SanPham implements IKhuyenMai, Serializable {
    protected String maSP, tenSP, donViTinh, maLoai;
    protected double giaBan, giaNhap;
    protected int soLuongTon;

    public SanPham(String maSP, String tenSP, double giaBan, double giaNhap, int soLuongTon, String donViTinh, String maLoai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.soLuongTon = soLuongTon;
        this.donViTinh = donViTinh;
        this.maLoai = maLoai;
    }

    public String hienThongTin() {
        return String.format("[%s] %s - Giá: %,dđ | Tồn: %d %s", maSP, tenSP, (long)giaBan, soLuongTon, donViTinh);
    }

    @Override
    public double tinhTienGiam() {
        return 0;
    }

    @Override
    public boolean kiemTraHopLe() {
        return true;
    }

    // Getters & Setters
    public String getMaSP() { return maSP; }
    public String getTenSP() { return tenSP; }
    public double getGiaBan() { return giaBan; }
    public int getSoLuongTon() { return soLuongTon; }
    public void setSoLuongTon(int soLuongTon) { this.soLuongTon = soLuongTon; }
}