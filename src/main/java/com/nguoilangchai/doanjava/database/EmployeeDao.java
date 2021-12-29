package com.nguoilangchai.doanjava.database;
import com.nguoilangchai.doanjava.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDao 
{
    public boolean insertTT(Employee employee) throws Exception
    {
        String sql = "insert into NhanVienTT(manv, hoten, email, sodt, gioitinh, diachi, ngaySinh, ngayVaoLam,username) values(?,?,?,?,?,?,?,?,?)";
        try(
                Connection con = Database.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            )
        {
            pstmt.setString(1, employee.getMaNV());
            pstmt.setString(2, employee.getHoTen());
            pstmt.setString(3, employee.getEmail());
            pstmt.setString(4, String.valueOf(employee.getSoDT()));
            pstmt.setString(5, employee.getGioiTinh());
            pstmt.setString(6, employee.getDiaChi());
            pstmt.setString(7, employee.getNgaySinh());
            pstmt.setString(8, employee.getNgayVaoLam());
            pstmt.setString(9, employee.getUserName());
            return pstmt.executeUpdate() > 0;
        }
    }
    
    public boolean insertCH1(Employee employee) throws Exception
    {
        String sql = "insert into NhanVienCH1(manv, hoten, email, sodt, gioitinh, diachi, ngaySinh, ngayVaoLam,username) values(?,?,?,?,?,?,?,?,?)";
        try(
                Connection con = Database.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            )
        {
            pstmt.setString(1, employee.getMaNV());
            pstmt.setString(2, employee.getHoTen());
            pstmt.setString(3, employee.getEmail());
            pstmt.setString(4, String.valueOf(employee.getSoDT()));
            pstmt.setString(5, employee.getGioiTinh());
            pstmt.setString(6, employee.getDiaChi());
            pstmt.setString(7, employee.getNgaySinh());
            pstmt.setString(8, employee.getNgayVaoLam());
            pstmt.setString(9, employee.getUserName());
            return pstmt.executeUpdate() > 0;
        }
    }
    
    public boolean insertCH2(Employee employee) throws Exception
    {
        String sql = "insert into NhanVienCH2(manv, hoten, email, sodt, gioitinh, diachi, ngaySinh, ngayVaoLam,username) values(?,?,?,?,?,?,?,?,?)";
        try(
                Connection con = Database.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            )
        {
            pstmt.setString(1, employee.getMaNV());
            pstmt.setString(2, employee.getHoTen());
            pstmt.setString(3, employee.getEmail());
            pstmt.setString(4, String.valueOf(employee.getSoDT()));
            pstmt.setString(5, employee.getGioiTinh());
            pstmt.setString(6, employee.getDiaChi());
            pstmt.setString(7, employee.getNgaySinh());
            pstmt.setString(8, employee.getNgayVaoLam());
            pstmt.setString(9, employee.getUserName());
            return pstmt.executeUpdate() > 0;
        }
    }
    public ResultSet findById(String maNV) throws Exception
    {
        String sql = "select * from NhanVien where hoten like ?";
        try(
                Connection con = Database.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            )
        {
            pstmt.setString(1, maNV);           
            ResultSet rs = pstmt.executeQuery();  
            
            if(rs.next())           
                return rs;
            
            return null;
        }
    }
    
    
    public boolean deleteTT(String maNV) throws Exception
    {
        String sql = "delete from nhanvienTT where manv = ?";
        try(
                Connection con = Database.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            )
        {
            pstmt.setString(1, maNV);
            
            return pstmt.executeUpdate() > 0;
        }
    }
    
    public boolean deleteCH1(String maNV) throws Exception
    {
        String sql = "delete from nhanvienCH1 where manv = ?";
        try(
                Connection con = Database.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            )
        {
            pstmt.setString(1, maNV);
            
            return pstmt.executeUpdate() > 0;
        }
    }
    
    public boolean deleteCH2(String maNV) throws Exception
    {
        String sql = "delete from nhanvienCH2 where manv = ?";
        try(
                Connection con = Database.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
            )
        {
            pstmt.setString(1, maNV);
            
            return pstmt.executeUpdate() > 0;
        }
    }
}
