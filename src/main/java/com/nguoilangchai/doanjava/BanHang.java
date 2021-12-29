
package com.nguoilangchai.doanjava;

import static com.nguoilangchai.doanjava.DangNhap.a;
import static com.nguoilangchai.doanjava.DangNhap.b;
import com.nguoilangchai.doanjava.database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class BanHang extends javax.swing.JFrame {
    DefaultTableModel tblModel;
    
    public void initListTable() {
        String[] columnNames = new String[] {"Mã", "Tên điện thoại", "Nơi sản xuất", "Ngày nhập", "Số lượng", "Đơn giá" };
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(columnNames);
        tblDienthoai.setModel(tblModel);
    }
    private String getNgayNhap(String x)
    {
        String []a = x.split("-");
        
        return a[2] + "-" + a[1] + "-" + a[0];      
    }
    
    private String getDonGia(String x)
    {
         double t = Double.parseDouble(x);
         return String.valueOf(t);
    }
    
    private void getData()
    {
        try {
            String sql = "";
            Connection con = Database.openConnection();
            if(init_CuaHang(init_CuaHang(DangNhap.a)).equals("CH1"))
                sql = "select * from SanPhamCH1";
            if(init_CuaHang(init_CuaHang(DangNhap.a)).equals("CH2"))
                sql = "select * from SanPhamCH2";
            
            PreparedStatement pstmt = con.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            
            tblModel.setRowCount(0);
            while(rs.next())
            {
                tblModel.addRow(new Object []
                {
                   
                    rs.getString("MaDT"),
                    rs.getString("TenDT"),
                    rs.getString("NhaCungCap"),
                    getNgayNhap(rs.getString("NgayNhap")),
                    rs.getString("SoLuong"),
                    getDonGia(rs.getString("GiaBan"))    
                });
            }
            tblModel.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private String init_CuaHang(String a)
    {
        String []x = a.split("_");
        return x[0];
    }
    private void setCuaHang()
    {
        txtMaNV.setText(DangNhap.a);
        txtHoTen.setText(DangNhap.b);
        
        if(init_CuaHang(init_CuaHang(DangNhap.a)).equals("CH1"))
            txtCuaHang.setText("CỬA HÀNG 1");
        else if(init_CuaHang(init_CuaHang(DangNhap.a)).equals("CH2"))
            txtCuaHang.setText("CỬA HÀNG 2");
        else
            txtCuaHang.setText("Không xác định");
        
    }
    public BanHang() {
        initComponents();
        setLocationRelativeTo(null);
        setCuaHang();
        initListTable();
        getData();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtHoTenKH = new javax.swing.JTextField();
        txtCMNDKH = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnKhachHangMoi = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblNhapSoLuong = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDienthoai = new javax.swing.JTable();
        btnThanhTien = new javax.swing.JButton();
        txtThanhTien = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCuaHang = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNgay = new javax.swing.JTextField();
        txtThang = new javax.swing.JTextField();
        txtNam = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("GIAO DIỆN BÁN HÀNG :");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin nhân viên"));

        jLabel2.setText("Mã nhân viên");

        jLabel3.setText("Họ tên");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHoTen))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin khách hàng"));

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jLabel4.setText("Họ tên");

        jLabel5.setText("CMND");

        txtTimKiem.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        txtTimKiem.setText("Nhập CMND");
        txtTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusGained(evt);
            }
        });

        btnKhachHangMoi.setText("Tra tài khoản");
        btnKhachHangMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGap(27, 27, 27)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCMNDKH, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                .addComponent(txtHoTenKH)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnTimKiem)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btnKhachHangMoi)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiem)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCMNDKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btnKhachHangMoi)
                .addGap(19, 19, 19))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Điện thoại"));

        lblNhapSoLuong.setText("Nhập số lượng");

        tblDienthoai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblDienthoai);

        btnThanhTien.setText("Thành tiền");
        btnThanhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhTienActionPerformed(evt);
            }
        });

        jLabel6.setText("VNĐ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 54, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThanhTien)
                    .addComponent(lblNhapSoLuong))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(txtThanhTien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNhapSoLuong)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhTien)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtCuaHang.setBackground(new java.awt.Color(181, 204, 206));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nguoilangchai/slide4/demo/icon/Actions-edit-delete-icon-16.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jLabel7.setText("Ngày :");

        jLabel8.setText("/");

        jLabel9.setText("/");

        txtNgay.setText("Ngày");
        txtNgay.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNgayFocusGained(evt);
            }
        });

        txtThang.setText("Tháng");
        txtThang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtThangFocusGained(evt);
            }
        });

        txtNam.setText("Năm");
        txtNam.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNamFocusGained(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtThang, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(92, 92, 92))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(214, 214, 214)
                                .addComponent(btnThanhToan)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThanhToan)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        
        try {
            Connection con = Database.openConnection();                            
            String sql = "SELECT * FROM KhachHang WHERE CMND = ?";
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, txtTimKiem.getText().trim());
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next())
            {        
                
                txtHoTenKH.setText(rs.getString("CMND"));
                txtCMNDKH.setText(rs.getString("Hoten"));
            }
            else
                JOptionPane.showMessageDialog(this, "Không tìm thấy");
            }
           
         catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusGained
        txtTimKiem.setText("");
    }//GEN-LAST:event_txtTimKiemFocusGained

    private void btnKhachHangMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangMoiActionPerformed
        new KhachHang().setVisible(true);
    }//GEN-LAST:event_btnKhachHangMoiActionPerformed

    private void btnThanhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhTienActionPerformed
        int r = tblDienthoai.getSelectedRow();

        if (r < 0) {
            return;
        }
        
        double tempGiaBan = Double.parseDouble(tblDienthoai.getValueAt(r, 5).toString());
        double thanhTien = tempGiaBan * Double.parseDouble(txtSoLuong.getText());
        
        String tempThanhTien = String.valueOf(thanhTien);
        txtThanhTien.setText(tempThanhTien);

          //txtThanhTien.setText(tblDienthoai.getValueAt(r, 5).toString());
         
    }//GEN-LAST:event_btnThanhTienActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        try {
            int r = tblDienthoai.getSelectedRow();

            if (r < 0) {
                return;
            }
            
            String sql = "";
            String t_sql = "";
            Connection con = Database.openConnection();
            
            if(txtCuaHang.getText().equals("CỬA HÀNG 1"))                 
            {             
                sql = "INSERT INTO DonHangCH1(MaNV, HotenNV, CMND, HoTenKH, soluong, tenDt,NhaCungCap, giaBan,Ngay) VALUES (?,?,?,?,?,?,?,?,?)";
                t_sql = "INSERT INTO DonHangTT(MaNV, HotenNV, CMND, HoTenKH,soluong, tendt,NhaCungCap, giaBan,Ngay)VALUES (?,?,?,?,?,?,?,?,?)";
            }
            else if(txtCuaHang.getText().equals("CỬA HÀNG 2"))                 
            {             
                sql = "INSERT INTO DonHangCH2(MaNV, HotenNV, CMND, HoTenKH,soluong,tenDt,NhaCungCap,giaBan,Ngay)VALUES (?,?,?,?,?,?,?,?,?)";
                t_sql = "INSERT INTO DonHangTT(MaNV, HotenNV, CMND, HoTenKH,soluong,tenDt,NhaCungCap,giaBan,Ngay)VALUES (?,?,?,?,?,?,?,?,?)";
            }    
            else
            {
                JOptionPane.showMessageDialog(this, "Thanh toán không thành công !!!");
                return;
            }
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            PreparedStatement t_pstmt = con.prepareStatement(t_sql);
           
            
            String temp_TenDt = tblDienthoai.getValueAt(r, 1).toString();
            String temp_nhaCungCap = tblDienthoai.getValueAt(r, 2).toString();
            String temp_GiaBan = tblDienthoai.getValueAt(r, 5).toString();
            
            String t_ngay = txtNgay.getText().trim();
            if(txtNgay.getText().trim().length() == 1)
            {
                t_ngay = "0" + txtNgay.getText();
            }
            
            String t_thang = txtThang.getText().trim();
            if(txtThang.getText().length() == 1)
            {
                t_thang = "0" + txtThang.getText();
            }
            
            String tempNgayBan= txtNam.getText() + t_thang + t_ngay;
            
            pstmt.setString(1, txtMaNV.getText().trim());
            pstmt.setString(2, txtHoTen.getText().trim());
            pstmt.setString(3, txtCMNDKH.getText().trim());
            pstmt.setString(4, txtHoTenKH.getText().trim());
            pstmt.setString(6, temp_TenDt);
            pstmt.setString(7, temp_nhaCungCap);
            pstmt.setString(8, temp_GiaBan);
            pstmt.setString(9, tempNgayBan);
            pstmt.setString(5, txtSoLuong.getText().trim());
            
            t_pstmt.setString(1, txtMaNV.getText().trim());
            t_pstmt.setString(2, txtHoTen.getText().trim());
            t_pstmt.setString(3, txtCMNDKH.getText().trim());
            t_pstmt.setString(4, txtHoTenKH.getText().trim());
            t_pstmt.setString(6, temp_TenDt);
            t_pstmt.setString(7, temp_nhaCungCap);
            t_pstmt.setString(8, temp_GiaBan);
            t_pstmt.setString(9, tempNgayBan);
            t_pstmt.setString(5, txtSoLuong.getText().trim());
            
            if(pstmt.executeUpdate() > 0 && t_pstmt.executeUpdate() > 0)         
            {
                JOptionPane.showMessageDialog(this, "Thanh toán thành công");
            }   
            else
                JOptionPane.showMessageDialog(this, "Thanh toán thất bại");
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
           
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void txtNgayFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNgayFocusGained
        txtNgay.setText("");
    }//GEN-LAST:event_txtNgayFocusGained

    private void txtThangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtThangFocusGained
        txtThang.setText("");
    }//GEN-LAST:event_txtThangFocusGained

    private void txtNamFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNamFocusGained
        txtNam.setText("");
    }//GEN-LAST:event_txtNamFocusGained

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BanHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKhachHangMoi;
    private javax.swing.JButton btnThanhTien;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblNhapSoLuong;
    private javax.swing.JTable tblDienthoai;
    private javax.swing.JTextField txtCMNDKH;
    private javax.swing.JTextField txtCuaHang;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtHoTenKH;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNam;
    private javax.swing.JTextField txtNgay;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtThang;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}