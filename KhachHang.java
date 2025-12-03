package model;

public class KhachHang implements java.io.Serializable {
    private String maKH, ten, sdt;
    private int diemTichLuy;

    public KhachHang(String maKH, String ten, String sdt, int diemTichLuy) {
        this.maKH = maKH;
        this.ten = ten;
        this.sdt = sdt;
        this.diemTichLuy = diemTichLuy;
    }

    @Override
    public String toString() {
        return maKH + " | " + ten + " | " + sdt + " | Điểm: " + diemTichLuy;
    }

    public String getMaKH() { return maKH; }
    public int getDiemTichLuy() { return diemTichLuy; }
    public void setDiemTichLuy(int diemTichLuy) { this.diemTichLuy = diemTichLuy; }
}