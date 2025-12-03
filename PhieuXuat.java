package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhieuXuat implements java.io.Serializable {
    private String maPX, lyDo;
    private Date ngayXuat;
    private List<ChiTietXuat> dsChiTiet = new ArrayList<>();

    public PhieuXuat(String maPX, Date ngayXuat, String lyDo) {
        this.maPX = maPX;
        this.ngayXuat = ngayXuat;
        this.lyDo = lyDo;
    }

    public String getMaPX() { return maPX; }
    public String getLyDo() { return lyDo; }
    public List<ChiTietXuat> getDsChiTiet() { return dsChiTiet; }
}