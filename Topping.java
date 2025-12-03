package model;

public class Topping extends SanPham {
    private String loaiTopping;
    private double giaThem;

    public Topping(String maSP, String tenSP, double giaBan, double giaNhap, int soLuongTon,
                   String donViTinh, String maLoai, String loaiTopping, double giaThem) {
        super(maSP, tenSP, giaBan, giaNhap, soLuongTon, donViTinh, maLoai);
        this.loaiTopping = loaiTopping;
        this.giaThem = giaThem;
        this.giaBan = giaThem;
    }

    @Override
    public String hienThongTin() {
        return super.hienThongTin() + " | Loại: " + loaiTopping;
    }
}