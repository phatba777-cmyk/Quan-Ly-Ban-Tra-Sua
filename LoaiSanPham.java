package model;

import java.io.Serializable;

public class LoaiSanPham implements Serializable {
    private String maLoai, tenLoai;

    public LoaiSanPham(String maLoai, String tenLoai) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }

    @Override
    public String toString() {
        return maLoai + " - " + tenLoai;
    }
}