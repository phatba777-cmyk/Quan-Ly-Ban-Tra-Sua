package model;

public class NhaCungCap implements java.io.Serializable {
    private String maNCC, tenNCC, diaChi, sdt;

    public NhaCungCap(String maNCC, String tenNCC, String diaChi, String sdt) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return maNCC + " - " + tenNCC + " | " + sdt;
    }
}