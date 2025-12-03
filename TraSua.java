package model;

public class TraSua extends SanPham {
    private int doNgot, doDa;
    private String size;

    public TraSua(String maSP, String tenSP, double giaBan, double giaNhap, int soLuongTon,
                  String donViTinh, String maLoai, int doNgot, int doDa, String size) {
        super(maSP, tenSP, giaBan, giaNhap, soLuongTon, donViTinh, maLoai);
        this.doNgot = doNgot;
        this.doDa = doDa;
        this.size = size.toUpperCase();
    }

    @Override
    public double tinhTienGiam() {
        return size.equals("L") ? giaBan * 0.1 : 0;
    }

    @Override
    public String hienThongTin() {
        return super.hienThongTin() + String.format(" | Size: %s | Đường: %d%% | Đá: %d%%", size, doNgot, doDa);
    }
}