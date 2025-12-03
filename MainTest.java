// MainTest.java - PHIEN BAN KHONG DAU, TU NHAP DU LIEU
import model.*;
import service.QuanLyTraSuaImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainTest {
    private static final QuanLyTraSuaImpl ql = new QuanLyTraSuaImpl();
    private static final Scanner sc = new Scanner(System.in);
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        System.out.println("CHAO MUNG BAN DEN VOI HE THONG QUAN LY TRA SUA");

        int choice;
        do {
            menuChinh();
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> quanLySanPham();
                case 2 -> quanLyKhachHang();
                case 3 -> quanLyNhanVien();
                case 4 -> quanLyNhapKho();
                case 5 -> quanLyXuatKho();
                case 6 -> taoHoaDonMoi();
                case 7 -> xemTatCaHoaDon();
                case 8 -> System.out.println("TONG DOANH THU: " +
                        String.format("%,.0f VND", ql.thongKeDoanhThu()));
                case 9 -> {
                    ql.luu("trasua_data.dat");
                    System.out.println("DA LUU DU LIEU THANH CONG!");
                }
                case 10 -> {
                    ql.tai("trasua_data.dat");
                    System.out.println("DA TAI DU LIEU THANH CONG!");
                }
                case 0 -> System.out.println("HEN GAP LAI!");
                default -> System.out.println("LUA CHON KHONG HOP LE!");
            }
        } while (choice != 0);
    }

    private static void menuChinh() {
        System.out.println("\n==========================================");
        System.out.println("   QUAN LY CUA HANG TRA SUA XYZ");
        System.out.println("==========================================");
        System.out.println(" 1. Quan ly San pham (Tra sua/Topping/Do an)");
        System.out.println(" 2. Quan ly Khach hang");
        System.out.println(" 3. Quan ly Nhan vien");
        System.out.println(" 4. Nhap kho (Phieu nhap)");
        System.out.println(" 5. Xuat kho (Hong/Het han)");
        System.out.println(" 6. Tao hoa don ban hang moi");
        System.out.println(" 7. Xem tat ca hoa don");
        System.out.println(" 8. Xem tong doanh thu");
        System.out.println(" 9. Luu du lieu ra file");
        System.out.println("10. Tai du lieu tu file");
        System.out.println(" 0. Thoat");
        System.out.println("==========================================");
        System.out.print("=> Nhap lua chon: ");
    }

    // 1. QUAN LY SAN PHAM
    private static void quanLySanPham() {
        while (true) {
            System.out.println("\n--- QUAN LY SAN PHAM ---");
            System.out.println("1. Them san pham moi");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Tim kiem theo ma");
            System.out.println("4. Xoa san pham");
            System.out.println("0. Quay lai");
            int c = Integer.parseInt(sc.nextLine());
            if (c == 0) break;

            switch (c) {
                case 1 -> themSanPhamMoi();
                case 2 -> ql.getDsSP().forEach(sp -> System.out.println(sp.hienThongTin()));
                case 3 -> {
                    System.out.print("Nhap ma SP can tim: ");
                    SanPham sp = (SanPham) ql.timKiem(sc.nextLine());
                    System.out.println(sp != null ? sp.hienThongTin() : "Khong tim thay!");
                }
                case 4 -> {
                    System.out.print("Nhap ma SP can xoa: ");
                    ql.xoa(sc.nextLine());
                    System.out.println("DA XOA (neu ton tai)!");
                }
            }
        }
    }

    private static void themSanPhamMoi() {
        System.out.println("Loai san pham: 1.Tra sua | 2.Topping | 3.Do an");
        int loai = Integer.parseInt(sc.nextLine());

        System.out.print("Ma SP: "); String ma = sc.nextLine();
        System.out.print("Ten SP: "); String ten = sc.nextLine();
        System.out.print("Gia ban: "); double giaBan = Double.parseDouble(sc.nextLine());
        System.out.print("Gia nhap: "); double giaNhap = Double.parseDouble(sc.nextLine());
        System.out.print("So luong ton: "); int sl = Integer.parseInt(sc.nextLine());
        System.out.print("Don vi tinh: "); String donVi = sc.nextLine();
        System.out.print("Ma loai (TS/TP/DA): "); String maLoai = sc.nextLine();

        SanPham sp = null;
        switch (loai) {
            case 1 -> {
                System.out.print("Do ngot (%): "); int doNgot = Integer.parseInt(sc.nextLine());
                System.out.print("Do da (%): "); int doDa = Integer.parseInt(sc.nextLine());
                System.out.print("Size (S/M/L): "); String size = sc.nextLine();
                sp = new TraSua(ma, ten, giaBan, giaNhap, sl, donVi, maLoai, doNgot, doDa, size);
            }
            case 2 -> {
                System.out.print("Loai topping: "); String loaiTP = sc.nextLine();
                sp = new Topping(ma, ten, giaBan, giaNhap, sl, donVi, maLoai, loaiTP, giaBan);
            }
            case 3 -> {
                System.out.print("Trong luong (g): "); double trongLuong = Double.parseDouble(sc.nextLine());
                System.out.print("Han su dung (yyyy-MM-dd): "); String hsd = sc.nextLine();
                sp = new DoAn(ma, ten, giaBan, giaNhap, sl, donVi, maLoai, trongLuong, hsd);
            }
        }
        ql.them(sp);
        System.out.println("THEM SAN PHAM THANH CONG!");
    }

    // 2. QUAN LY KHACH HANG
    private static void quanLyKhachHang() {
        while (true) {
            System.out.println("\n1. Them khach hang moi");
            System.out.println("2. Xem danh sach");
            System.out.println("0. Quay lai");
            int c = Integer.parseInt(sc.nextLine());
            if (c == 0) break;
            if (c == 1) {
                System.out.print("Ma KH: "); String ma = sc.nextLine();
                System.out.print("Ho ten: "); String ten = sc.nextLine();
                System.out.print("SDT: "); String sdt = sc.nextLine();
                ql.them(new KhachHang(ma, ten, sdt, 0));
                System.out.println("THEM KHACH HANG THANH CONG!");
            }
            if (c == 2) {
                System.out.println("\n--- DANH SACH KHACH HANG ---");
                ql.getDsKhachHang().forEach(System.out::println);
            }
        }
    }

    // 3. QUAN LY NHAN VIEN
    private static void quanLyNhanVien() {
        while (true) {
            System.out.println("\n1. Them nhan vien");
            System.out.println("2. Xem danh sach");
            System.out.println("0. Quay lai");
            int c = Integer.parseInt(sc.nextLine());
            if (c == 0) break;
            if (c == 1) {
                System.out.print("Ma NV: "); String ma = sc.nextLine();
                System.out.print("Ho ten: "); String ten = sc.nextLine();
                System.out.print("Chuc vu: "); String cv = sc.nextLine();
                System.out.print("Luong co ban: "); double luong = Double.parseDouble(sc.nextLine());
                ql.them(new NhanVien(ma, ten, cv, luong));
                System.out.println("THEM NHAN VIEN THANH CONG!");
            }
            if (c == 2) {
                System.out.println("\n--- DANH SACH NHAN VIEN ---");
                ql.getDsNhanVien().forEach(System.out::println);
            }
        }
    }

    // 4. NHAP KHO
    private static void quanLyNhapKho() {
        System.out.print("Ma phieu nhap: "); String maPN = sc.nextLine();
        System.out.print("Ma NCC: "); String maNCC = sc.nextLine();
        PhieuNhap pn = new PhieuNhap(maPN, new Date(), maNCC, 0);

        System.out.println("Nhap chi tiet (nhap Enter o Ma SP de ket thuc):");
        while (true) {
            System.out.print("Ma SP: ");
            String maSP = sc.nextLine();
            if (maSP.isEmpty()) break;
            System.out.print("So luong: "); int sl = Integer.parseInt(sc.nextLine());
            System.out.print("Don gia nhap: "); double dg = Double.parseDouble(sc.nextLine());

            pn.getDsChiTiet().add(new ChiTietNhap("CTN" + (pn.getDsChiTiet().size() + 1), maPN, maSP, sl, dg));

            SanPham sp = (SanPham) ql.timKiem(maSP);
            if (sp != null) sp.setSoLuongTon(sp.getSoLuongTon() + sl);
        }
        pn.tinhTongTien();
        ql.them(pn);
        System.out.println("NHAP KHO THANH CONG!");
    }

    // 5. XUAT KHO
    private static void quanLyXuatKho() {
        System.out.print("Ma phieu xuat: "); String maPX = sc.nextLine();
        System.out.print("Ly do xuat: "); String lyDo = sc.nextLine();
        PhieuXuat px = new PhieuXuat(maPX, new Date(), lyDo);

        System.out.println("Nhap chi tiet xuat (Enter o Ma SP de ket thuc):");
        while (true) {
            System.out.print("Ma SP: ");
            String maSP = sc.nextLine();
            if (maSP.isEmpty()) break;
            System.out.print("So luong: "); int sl = Integer.parseInt(sc.nextLine());

            px.getDsChiTiet().add(new ChiTietXuat("CTX" + (px.getDsChiTiet().size() + 1), maPX, maSP, sl));

            SanPham sp = (SanPham) ql.timKiem(maSP);
            if (sp != null) sp.setSoLuongTon(sp.getSoLuongTon() - sl);
        }
        ql.them(px);
        System.out.println("XUAT KHO THANH CONG!");
    }

    // 6. TAO HOA DON MOI
    private static void taoHoaDonMoi() {
        System.out.print("Ma hoa don: "); String maHD = sc.nextLine();
        System.out.print("Ma khach hang: "); String maKH = sc.nextLine();
        System.out.print("Ma nhan vien: "); String maNV = sc.nextLine();
        System.out.print("Phuong thuc TT (Tien mat/Chuyen khoan): "); String pttt = sc.nextLine();

        HoaDon hd = new HoaDon(maHD, maKH, maNV, new Date(), pttt);

        System.out.println("Nhap chi tiet hoa don (Enter o Ma SP de ket thuc):");
        while (true) {
            System.out.print("Ma SP: ");
            String maSP = sc.nextLine();
            if (maSP.isEmpty()) break;

            SanPham sp = (SanPham) ql.timKiem(maSP);
            if (sp == null) {
                System.out.println("SAN PHAM KHONG TON TAI!");
                continue;
            }
            System.out.print("So luong: "); int sl = Integer.parseInt(sc.nextLine());
            if (sl > sp.getSoLuongTon()) {
                System.out.println("KHONG DU HANG TON KHO!");
                continue;
            }

            hd.getDsChiTiet().add(new ChiTietHoaDon(
                "CTHD" + (hd.getDsChiTiet().size() + 1), maHD, maSP, sl, sp.getGiaBan()));
            sp.setSoLuongTon(sp.getSoLuongTon() - sl);
        }

        hd.tinhTongTien();
        ql.them(hd);
        System.out.println("\n=== HOA DON MOI ===");
        inHoaDon(hd);
        System.out.println("TONG TIEN: " + String.format("%,.0f VND", hd.tinhThanhTien()));
        System.out.println("TAO HOA DON THANH CONG!");
    }

    // Ham in hoa don chi tiet
    private static void inHoaDon(HoaDon hd) {
        System.out.println("Hoa don: " + hd.getMaHD() + " | Ngay: " + sdf.format(hd.getNgayLap()));
        System.out.println("Khach hang: " + hd.getMaKH() + " | Nhan vien: " + hd.getMaNV());
        System.out.println("-------------------------------------");
        for (ChiTietHoaDon ct : hd.getDsChiTiet()) {
            SanPham sp = (SanPham) ql.timKiem(ct.getMaSP());
            String tenSP = sp != null ? sp.getTenSP() : ct.getMaSP();
            System.out.printf(" %dx %s : %,d VND%n", ct.getSoLuong(), tenSP, (long)ct.getThanhTien());
        }
        System.out.println("-------------------------------------");
    }

    // 7. XEM TAT CA HOA DON
    private static void xemTatCaHoaDon() {
        if (ql.getDsHoaDon().isEmpty()) {
            System.out.println("CHUA CO HOA DON NAO!");
            return;
        }
        System.out.println("\n=== TAT CA HOA DON ===");
        for (HoaDon hd : ql.getDsHoaDon()) {
            inHoaDon(hd);
            System.out.println("=> TONG: " + String.format("%,.0f VND\n", hd.tinhThanhTien()));
        }
    }
}