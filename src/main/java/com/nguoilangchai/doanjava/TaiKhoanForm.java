
package com.nguoilangchai.doanjava;

import com.nguoilangchai.doanjava.database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TaiKhoanForm extends javax.swing.JFrame {
    
    private DefaultTableModel tblModel;
    DefaultComboBoxModel<String> modelCuaHang ;
    
    public void initListCuaHang()
    {
        modelCuaHang = new DefaultComboBoxModel<>();
        
        modelCuaHang.addElement("Tất cả");
        modelCuaHang.addElement("Cửa hàng 1");
        modelCuaHang.addElement("Cửa hàng 2");       
        
        cbxCuaHang.setModel(modelCuaHang);
    }
    
    public void initListTable() 
    {
        String[] columnNames = new String[] {"Mã", "Họ tên", "User name", "Password"};
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(columnNames);
        tblTaiKhoan.setModel(tblModel);
    }
    
    private void getData()
    {
        try {
            Connection con = Database.openConnection();
            
            String sql = "SELECT MaNV, HoTen ,Username, Password FROM NhanVienTT";
            PreparedStatement pstmt = con.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            
            tblModel.setRowCount(0);
            while(rs.next())
            {
                tblModel.addRow(new Object []
                {                  
                    rs.getString("manv"),
                    rs.getString("hoten"),
                    rs.getString("username"),
                    rs.getString("password"),
                });
            }
            tblModel.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public TaiKhoanForm() {
        
        initComponents();
        setLocationRelativeTo(null);
        initListTable();
        initListCuaHang();
        getData();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTaiKhoan = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        btnCapNhat = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cbxCuaHang = new javax.swing.JComboBox<>();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Quản lý tài khoản");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin tài khoản"));

        tblTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTaiKhoanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTaiKhoan);

        jLabel2.setText("User name");

        jLabel3.setText("Password");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(58, 58, 58)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(53, 53, 53)
                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(83, 83, 83))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nguoilangchai/slide4/demo/icon/Actions-edit-delete-icon-16.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cbxCuaHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCuaHang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCuaHangItemStateChanged(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnCapNhat)
                                .addGap(62, 62, 62)
                                .addComponent(btnReset)
                                .addGap(108, 108, 108))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addComponent(cbxCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cbxCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCapNhat)
                    .addComponent(btnReset))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTaiKhoanMouseClicked
        int r = tblTaiKhoan.getSelectedRow();
        
        if(r < 0)
            return ;
       
        if(tblTaiKhoan.getValueAt(r, 2) == null)
            txtUserName.setText("");
        else
            txtUserName.setText(tblTaiKhoan.getValueAt(r, 2).toString());
        if(tblTaiKhoan.getValueAt(r, 3) == null)
            txtPassword.setText("");
        else
            txtPassword.setText(tblTaiKhoan.getValueAt(r, 3).toString());
        
        
        
    }//GEN-LAST:event_tblTaiKhoanMouseClicked

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        try {
            int r = tblTaiKhoan.getSelectedRow();
            if(r < 0)
            {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên");
                return;
            }
            
            String sql1 = "";
            String sql2 = "";
            Connection con = Database.openConnection(); 
            if(cbxCuaHang.getSelectedItem().toString().compareTo("Cửa hàng 1") == 0)
            {
                sql1 = "UPDATE NhanVienCH1 set Username = ?, Password = ? WHERE MaNV = ?";
                sql2 = "UPDATE NhanVienTT set Username = ?, Password = ? WHERE MaNV = ?";
            }   
            else if(cbxCuaHang.getSelectedItem().toString().compareTo("Cửa hàng 2") == 0)
            {
                sql1 = "UPDATE NhanVienCH2 set Username = ?, Password = ? WHERE MaNV = ?";
                sql2 = "UPDATE NhanVienTT set Username = ?, Password = ? WHERE MaNV = ?";
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn cửa hàng !!!");
                return;
            }
            PreparedStatement pstmt = con.prepareStatement(sql1);
            PreparedStatement t_pstmt = con.prepareStatement(sql2);
  
            pstmt.setString(1, txtUserName.getText().trim());
            pstmt.setString(2, txtPassword.getText().trim());
            pstmt.setString(3, tblTaiKhoan.getValueAt(r, 0).toString());
            
            t_pstmt.setString(1, txtUserName.getText().trim());
            t_pstmt.setString(2, txtPassword.getText().trim());
            t_pstmt.setString(3, tblTaiKhoan.getValueAt(r, 0).toString());
            
            if(pstmt.executeUpdate() > 0 && t_pstmt.executeUpdate() > 0)         
            {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công");
            }   
            else
                JOptionPane.showMessageDialog(this, "Không tồn tại ID");              
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        new TrungTamForm().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbxCuaHangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCuaHangItemStateChanged
        try {
            String sql = "" ;
            Connection con = Database.openConnection();            
            if(cbxCuaHang.getSelectedItem().toString().compareTo("Cửa hàng 1") == 0)                 
                sql = "SELECT MaNV, HoTen ,Username, Password FROM NhanVienCH1";
            else if(cbxCuaHang.getSelectedItem().toString().compareTo("Cửa hàng 2") == 0)
                sql = "SELECT MaNV, HoTen ,Username, Password FROM NhanVienCH2";
            else
                sql = "SELECT MaNV, HoTen ,Username, Password FROM NhanVienTT";
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            ResultSet rs = pstmt.executeQuery();
            
            tblModel.setRowCount(0);
            while(rs.next())
            {                  
                tblModel.addRow(new Object []
                {
                    rs.getString("manv"),
                    rs.getString("hoten"),
                    rs.getString("username"),
                    rs.getString("password"),
                });    
            }
            tblModel.fireTableDataChanged();
            }
           
         catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbxCuaHangItemStateChanged

    private void reset()
    {
        txtPassword.setText("");
        txtUserName.setText("");
        
        cbxCuaHang.setSelectedIndex(0);
        getData();
    }
    
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TaiKhoanForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cbxCuaHang;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblTaiKhoan;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
