package service;

import model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuanLyTraSuaImpl implements IQuanLy<Object> {
    private List<SanPham> dsSP = new ArrayList<>();
    private List<HoaDon> dsHoaDon = new ArrayList<>();
    private List<PhieuNhap> dsPhieuNhap = new ArrayList<>();
    private List<PhieuXuat> dsPhieuXuat = new ArrayList<>();
    private List<KhachHang> dsKhachHang = new ArrayList<>();
    private List<NhanVien> dsNhanVien = new ArrayList<>();

    @Override
    public void them(Object obj) {
        if (obj instanceof SanPham) dsSP.add((SanPham) obj);
        else if (obj instanceof HoaDon) dsHoaDon.add((HoaDon) obj);
        else if (obj instanceof PhieuNhap) dsPhieuNhap.add((PhieuNhap) obj);
        else if (obj instanceof PhieuXuat) dsPhieuXuat.add((PhieuXuat) obj);
        else if (obj instanceof KhachHang) dsKhachHang.add((KhachHang) obj);
        else if (obj instanceof NhanVien) dsNhanVien.add((NhanVien) obj);
    }

    @Override
    public void xoa(String id) {
        dsSP.removeIf(sp -> sp.getMaSP().equalsIgnoreCase(id));
    }

    @Override
    public void sua(String id, Object ttMoi) {
        for (int i = 0; i < dsSP.size(); i++) {
            if (dsSP.get(i).getMaSP().equalsIgnoreCase(id)) {
                dsSP.set(i, (SanPham) ttMoi);
                return;
            }
        }
    }

    @Override
    public Object timKiem(String id) {
        return dsSP.stream().filter(sp -> sp.getMaSP().equalsIgnoreCase(id)).findFirst().orElse(null);
    }

    @Override
    public void hienDanhSach() {
        dsSP.forEach(sp -> System.out.println(sp.hienThongTin()));
    }

    @Override
    public void luu(String file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(this);
            System.out.println("ĐÃ LƯU THÀNH CÔNG vào " + file);
        } catch (Exception e) {
            System.out.println("Lỗi lưu file: " + e.getMessage());
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void tai(String file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            QuanLyTraSuaImpl temp = (QuanLyTraSuaImpl) ois.readObject();
            this.dsSP = temp.dsSP;
            this.dsHoaDon = temp.dsHoaDon;
            this.dsPhieuNhap = temp.dsPhieuNhap;
            this.dsPhieuXuat = temp.dsPhieuXuat;
            this.dsKhachHang = temp.dsKhachHang;
            this.dsNhanVien = temp.dsNhanVien;
            System.out.println("ĐÃ TẢI DỮ LIỆU THÀNH CÔNG từ " + file);
        } catch (Exception e) {
            System.out.println("Không tìm thấy file hoặc lỗi tải!");
        }
    }

    public double thongKeDoanhThu() {
        return dsHoaDon.stream().mapToDouble(HoaDon::tinhThanhTien).sum();
    }

    // Getters để MainTest dùng
    public List<SanPham> getDsSP() { return dsSP; }
    public List<HoaDon> getDsHoaDon() { return dsHoaDon; }
    public List<PhieuNhap> getDsPhieuNhap() { return dsPhieuNhap; }
    public List<PhieuXuat> getDsPhieuXuat() { return dsPhieuXuat; }
    public List<KhachHang> getDsKhachHang() { return dsKhachHang; }
    public List<NhanVien> getDsNhanVien() { return dsNhanVien; }
}