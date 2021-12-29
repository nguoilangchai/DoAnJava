package com.nguoilangchai.doanjava.database;

import com.nguoilangchai.doanjava.DienThoai;
import com.nguoilangchai.doanjava.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DienThoaiDao {
    public boolean insertTT(DienThoai dth) throws Exception
    {
        String sql = "insert into SanPhamTT(maDt, tenDt, nhaCungCap, ngayNhap, soLuong, donGia, giaban) values(?,?,?,?,?,?,?)";
        try(
                Connection con = Database.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            )
        {
            pstmt.setString(1, dth.getMaDt());
            pstmt.setString(2, dth.getTenDt());
            pstmt.setString(3, dth.getNhaCungCap());
            pstmt.setString(4, dth.getNgayNhap());
            pstmt.setString(5, String.valueOf(dth.getSoLuong()));
            pstmt.setString(6, String.valueOf(dth.getDonGia()));
            pstmt.setString(7, String.valueOf(dth.getGiaBan()));
            
            return pstmt.executeUpdate() > 0;
        }
    }
    
    public boolean insertCH1(DienThoai dth) throws Exception
    {
        String sql = "insert into SanPhamCH1(maDt, tenDt, nhaCungCap, ngayNhap, soLuong, donGia, giaban) values(?,?,?,?,?,?,?)";
        try(
                Connection con = Database.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            )
        {
            pstmt.setString(1, dth.getMaDt());
            pstmt.setString(2, dth.getTenDt());
            pstmt.setString(3, dth.getNhaCungCap());
            pstmt.setString(4, dth.getNgayNhap());
            pstmt.setString(5, String.valueOf(dth.getSoLuong()));
            pstmt.setString(6, String.valueOf(dth.getDonGia()));
            pstmt.setString(7, String.valueOf(dth.getGiaBan()));
            return pstmt.executeUpdate() > 0;
        }
    }
    public boolean insertCH2(DienThoai dth) throws Exception
    {
        String sql = "insert into SanPhamCH2(maDt, tenDt, nhaCungCap, ngayNhap, soLuong, donGia, giaban) values(?,?,?,?,?,?,?)";
        try(
                Connection con = Database.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            )
        {
            pstmt.setString(1, dth.getMaDt());
            pstmt.setString(2, dth.getTenDt());
            pstmt.setString(3, dth.getNhaCungCap());
            pstmt.setString(4, dth.getNgayNhap());
            pstmt.setString(5, String.valueOf(dth.getSoLuong()));
            pstmt.setString(6, String.valueOf(dth.getDonGia()));
            pstmt.setString(7, String.valueOf(dth.getGiaBan()));
            return pstmt.executeUpdate() > 0;
            
        }
    }
    
    public boolean deleteTT(String maDt) throws Exception
    {
        String sql = "delete from SanPhamTT where madt = ?";
        try(
                Connection con = Database.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            )
        {
            pstmt.setString(1, maDt);
            
            return pstmt.executeUpdate() > 0;
        }
    }
    
    public boolean deleteCH1(String maDt) throws Exception
    {
        String sql = "delete from SanPhamCH1 where madt = ?";
        try(
                Connection con = Database.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            )
        {
            pstmt.setString(1, maDt);
            
            return pstmt.executeUpdate() > 0;
        }
    }
    
    public boolean deleteCH2(String maDt) throws Exception
    {
        String sql = "delete from SanPhamCH2 where madt = ?";
        try(
                Connection con = Database.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            )
        {
            pstmt.setString(1, maDt);
            
            return pstmt.executeUpdate() > 0;
        }
    }
}
