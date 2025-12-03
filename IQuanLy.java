package service;

import java.io.Serializable;

public interface IQuanLy<T> extends Serializable {
    void them(T obj);
    void xoa(String id);
    void sua(String id, T ttMoi);
    T timKiem(String id);
    void hienDanhSach();
    void luu(String file);
    void tai(String file);
}