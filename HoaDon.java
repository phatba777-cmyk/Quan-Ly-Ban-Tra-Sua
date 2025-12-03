package model;

import service.IThanhToan;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HoaDon implements IThanhToan, java.io.Serializable {
    private String maHD, maKH, maNV, phuongThucTT;
    private Date ngayLap;
    private double tongTien;
    private List<ChiTietHoaDon> dsChiTiet = new ArrayList<>();

    public HoaDon(String maHD, String maKH, String maNV, Date ngayLap, String phuongThucTT) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.ngayLap = ngayLap;
        this.phuongThucTT = phuongThucTT;
    }

    public void tinhTongTien() {
        tongTien = dsChiTiet.stream().mapToDouble(ChiTietHoaDon::getThanhTien).sum();
    }

    @Override
    public double tinhThanhTien() {
        return tongTien;
    }

    @Override
    public boolean thanhToan() {
        System.out.println("Thanh toán thành công hóa đơn " + maHD);
        return true;
    }

    // Getters
    public String getMaHD() { return maHD; }
    public String getMaKH() { return maKH; }
    public String getMaNV() { return maNV; }
    public Date getNgayLap() { return ngayLap; }
    public List<ChiTietHoaDon> getDsChiTiet() { return dsChiTiet; }
}