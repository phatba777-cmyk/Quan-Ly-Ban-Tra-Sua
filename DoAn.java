package model;

public class DoAn extends SanPham {
    private double trongLuong;
    private String hanSuDung;

    public DoAn(String maSP, String tenSP, double giaBan, double giaNhap, int soLuongTon,
                String donViTinh, String maLoai, double trongLuong, String hanSuDung) {
        super(maSP, tenSP, giaBan, giaNhap, soLuongTon, donViTinh, maLoai);
        this.trongLuong = trongLuong;
        this.hanSuDung = hanSuDung;
    }

    @Override
    public String hienThongTin() {
        return super.hienThongTin() + String.format(" | %dg | HSD: %s", (int)trongLuong, hanSuDung);
    }
}