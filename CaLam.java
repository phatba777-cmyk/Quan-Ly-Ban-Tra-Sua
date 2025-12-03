package model;

import java.util.Date;

public class CaLam implements java.io.Serializable {
    private String maCa, maNV;
    private Date gioBD, gioKT;

    public CaLam(String maCa, String maNV, Date gioBD, Date gioKT) {
        this.maCa = maCa;
        this.maNV = maNV;
        this.gioBD = gioBD;
        this.gioKT = gioKT;
    }

    @Override
    public String toString() {
        return maCa + " | NV: " + maNV + " | " + gioBD + " → " + gioKT;
    }
}