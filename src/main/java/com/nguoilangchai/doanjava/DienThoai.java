
package com.nguoilangchai.doanjava;

public class DienThoai 
{
    private String maDt, tenDt, nhaCungCap, ngayNhap;
    private int soLuong;
    private double donGia, giaBan;

    public DienThoai() {
    }

    public DienThoai(String maDt, String tenDt, String nhaCungCap, String ngayNhap, int soLuong, double donGia) {
        this.maDt = maDt;
        this.tenDt = tenDt;
        this.nhaCungCap = nhaCungCap;
        this.ngayNhap = ngayNhap;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getMaDt() {
        return maDt;
    }

    public String getTenDt() {
        return tenDt;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setMaDt(String maDt) {
        this.maDt = maDt;
    }

    public void setTenDt(String tenDt) {
        this.tenDt = tenDt;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }
    
    
    
}
