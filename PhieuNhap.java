package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhieuNhap implements java.io.Serializable {
    private String maPN, maNCC;
    private Date ngayNhap;
    private double tongTien;
    private List<ChiTietNhap> dsChiTiet = new ArrayList<>();

    public PhieuNhap(String maPN, Date ngayNhap, String maNCC, double tongTien) {
        this.maPN = maPN;
        this.ngayNhap = ngayNhap;
        this.maNCC = maNCC;
        this.tongTien = tongTien;
    }

    public void tinhTongTien() {
        tongTien = dsChiTiet.stream().mapToDouble(ct -> ct.getSoLuong() * ct.getDonGia()).sum();
    }

    // Getters
    public String getMaPN() { return maPN; }
    public Date getNgayNhap() { return ngayNhap; }
    public String getMaNCC() { return maNCC; }
    public double getTongTien() { return tongTien; }
    public List<ChiTietNhap> getDsChiTiet() { return dsChiTiet; }
}