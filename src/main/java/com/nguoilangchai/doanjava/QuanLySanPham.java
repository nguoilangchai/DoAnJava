package com.nguoilangchai.doanjava;

import com.nguoilangchai.doanjava.database.Database;
import com.nguoilangchai.doanjava.database.DienThoaiDao;
import com.nguoilangchai.doanjava.database.EmployeeDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QuanLySanPham extends javax.swing.JFrame {

    DefaultTableModel tblModel;
    
    DefaultComboBoxModel<String> modelCuaHang ;
    
    DefaultComboBoxModel<String> modelNgay ;
    DefaultComboBoxModel<String> modelThang ;
    DefaultComboBoxModel<String> modelNam ;
    
    public void initListCuaHang()
    {
        modelCuaHang = new DefaultComboBoxModel<>();
        
        modelCuaHang.addElement("Tất cả");
        modelCuaHang.addElement("Cửa hàng 1");
        modelCuaHang.addElement("Cửa hàng 2");       
        
        cbxCuaHang.setModel(modelCuaHang);
    }
    
    public void initListNgayNhap()
    {
        modelNgay = new DefaultComboBoxModel<>();
        modelThang = new DefaultComboBoxModel<>();
        modelNam = new DefaultComboBoxModel<>();
        
        for(int i = 1;i <= 31;i++)
        {
            String temp;
            if(i <= 9)
                temp = "0" + i;
            else
                temp ="" + i;
            modelNgay.addElement(temp);
        }
        
        for(int i = 1;i <= 12;i++)
        {
            String temp;
            if(i <= 9)
                temp = "0" + i;
            else
                temp ="" + i;
            modelThang.addElement(temp);
        }
        
        for(int i = 2015;i <= 2022;i++)
        {
            modelNam.addElement(""+i);
        }
        
        cbxNgay.setModel(modelNgay);
        cbxThang.setModel(modelThang);
        cbxNam.setModel(modelNam);
    }
    
    public void initListTable() {
        String[] columnNames = new String[] {"Mã", "Ten SP", "Noi san xuat", "Ngay nhap", "So luong", "Giá nhập", "Giá bán" };
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(columnNames);
        tblProduct.setModel(tblModel);
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
            Connection con = Database.openConnection();
            
            String sql = "select * from SanPhamTT";
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
                    getDonGia(rs.getString("DonGia")),
                    getDonGia(rs.getString("GiaBan"))    
                });
            }
            tblModel.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public QuanLySanPham() {
        initComponents();
        setLocationRelativeTo(null);
        initListCuaHang();
        initListTable();
        initListNgayNhap();
        getData();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        txtNhaCungCap = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        cbxTimKiem = new javax.swing.JComboBox<>();
        btnTimKiem = new javax.swing.JButton();
        cbxNgay = new javax.swing.JComboBox<>();
        cbxThang = new javax.swing.JComboBox<>();
        cbxNam = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        cbxCuaHang = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sach", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduct);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
        );

        jPanel2.setBackground(java.awt.Color.lightGray);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel1.setText("Mã");

        jLabel2.setText("Tên");

        jLabel3.setText("Số lượng");

        jLabel4.setText("Giá nhập");

        jLabel5.setText("Nơi sản xuất");

        txtMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaActionPerformed(evt);
            }
        });

        jLabel7.setText("Ngày nhập");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        cbxTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã", "Tên", "Nơi sản xuất" }));
        cbxTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTimKiemActionPerformed(evt);
            }
        });

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nguoilangchai/slide4/demo/icon/search-icon-32.png"))); // NOI18N
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(cbxTimKiem, 0, 102, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63))))
        );

        cbxNgay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("/");

        jLabel8.setText("/");

        jLabel11.setText("Giá bán");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                .addComponent(txtDonGia, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                .addComponent(txtGiaBan)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cbxNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxThang, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbxNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41))))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(cbxNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );

        jPanel3.setBackground(java.awt.Color.lightGray);

        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btnEdit)
                .addGap(38, 38, 38)
                .addComponent(btnDelete)
                .addGap(39, 39, 39)
                .addComponent(btnReset)
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnReset))
                .addContainerGap())
        );

        cbxCuaHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCuaHang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCuaHangItemStateChanged(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("QUẢN LÝ SẢN PHẨM");

        jLabel10.setText("Chọn cửa hàng");

        btnOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nguoilangchai/slide4/demo/icon/Actions-edit-delete-icon-16.png"))); // NOI18N
        btnOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(cbxCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOut, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(btnOut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {
            String sql = "";
            String t_sql = "";
            Connection con = Database.openConnection();
            if(cbxCuaHang.getSelectedItem().toString().compareTo("Cửa hàng 1") == 0)
            {
                sql = "update SanPhamCH1 set TenDT = ?,NhaCungCap = ?, NgayNhap = ?, SoLuong = ?, DonGia = ?, GiaBan = ?\n" +
"where MaDt = ?";    
                t_sql = "update SanPhamTT set TenDT = ?, NhaCungCap = ?, NgayNhap = ?, SoLuong = ?, DonGia = ?, GiaBan = ?\n" +
"where MaDt = ?";
            }
            else if(cbxCuaHang.getSelectedItem().toString().compareTo("Cửa hàng 2") == 0)
            {
                sql = "update SanPhamCH2 set TenDT = ?,NhaCungCap = ?, NgayNhap = ?, SoLuong = ?, DonGia = ?, GiaBan = ?\n" +
"where MaDt = ?";    
                t_sql = "update SanPhamTT set TenDT = ?, NhaCungCap = ?, NgayNhap = ?, SoLuong = ?, DonGia = ?, GiaBan = ?\n" +
"where MaDt = ?";
            }
            
            else
            {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn cửa hàng !!!");
                return;   
            }
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            PreparedStatement t_pstmt = con.prepareStatement(t_sql);   
                 
            String temp = cbxNam.getSelectedItem().toString() + cbxThang.getSelectedItem().toString() + cbxNgay.getSelectedItem().toString();
            
            pstmt.setString(1, txtTen.getText().trim());
            pstmt.setString(2, txtNhaCungCap.getText().trim());
            pstmt.setString(3, temp.trim());
            pstmt.setString(4, txtSoLuong.getText());
            pstmt.setString(5, txtDonGia.getText());
            pstmt.setString(6, txtGiaBan.getText());
            pstmt.setString(7, txtMa.getText().trim());
            
            t_pstmt.setString(1, txtTen.getText().trim());
            t_pstmt.setString(2, txtNhaCungCap.getText().trim());
            t_pstmt.setString(3, temp.trim());
            t_pstmt.setString(4, txtSoLuong.getText());
            t_pstmt.setString(5, txtDonGia.getText());
            t_pstmt.setString(6, txtGiaBan.getText());
            t_pstmt.setString(7, txtMa.getText().trim());
            
            if(pstmt.executeUpdate() > 0 && t_pstmt.executeUpdate() > 0)         
                JOptionPane.showMessageDialog(this, "Cập nhật thành công");
            else
                JOptionPane.showMessageDialog(this, "Không tồn tại ID");
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        StringBuilder sb = new StringBuilder();
        
        String t = "";
        if(cbxCuaHang.getSelectedItem().toString().compareTo("Cửa hàng 1") == 0)
            t = "CH1_";
        else if(cbxCuaHang.getSelectedItem().toString().compareTo("Cửa hàng 2") == 0)
            t = "CH2_";
        else
        {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn cửa hàng !!!");
            return;
        }
        
        if(txtMa.getText().trim().equals(""))
        {
            sb.append("Mã điện thoại không được để trống");
        }
        if(txtTen.getText().trim().equals(""))
        {
            sb.append("\nTên sản phẩm không được để trống");
        }
        
        if(sb.length() > 0)
        {
            JOptionPane.showMessageDialog(this, sb.toString());
            return;
        }
        try {
            DienThoai dth = new DienThoai(); 
            dth.setMaDt(t + txtMa.getText().trim().toUpperCase());
            dth.setTenDt(txtTen.getText().trim());
            dth.setNhaCungCap(txtNhaCungCap.getText().trim());
            
            String temp = cbxNam.getSelectedItem().toString() + cbxThang.getSelectedItem().toString() + cbxNgay.getSelectedItem().toString();
  
            dth.setNgayNhap(temp);
            
            dth.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
            dth.setDonGia(Double.parseDouble(txtDonGia.getText()));
            dth.setGiaBan(Double.parseDouble(txtGiaBan.getText()));
            
            DienThoaiDao dao = new DienThoaiDao();
            if(cbxCuaHang.getSelectedItem().toString().compareTo("Cửa hàng 1") == 0)
            {
                dao.insertCH1(dth);
                dao.insertTT(dth);
            }
            else if(cbxCuaHang.getSelectedItem().toString().compareTo("Cửa hàng 2") == 0)
            {
                dao.insertCH2(dth);
                dao.insertTT(dth);
            }
            
            
            JOptionPane.showMessageDialog(this, "Sản phẩm mới đã được lưu vào CSDL");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        StringBuilder sb = new StringBuilder();
        if(txtMa.getText().trim().equals(""))
        {
            sb.append("Mã điện thoại không được để trống");
        }

        if(sb.length() > 0)
        {
            JOptionPane.showMessageDialog(this, sb.toString());
            return;
        }           
        
        try {            
            DienThoaiDao dao = new DienThoaiDao();
            int t = JOptionPane.showConfirmDialog(this, "Bạn có đồng ý xoá hay không");   
            if(t == 0)
            {
                if(cbxCuaHang.getSelectedItem().toString().compareTo("Cửa hàng 1") == 0)
                {
                    dao.deleteCH1(txtMa.getText());
                    dao.deleteTT(txtMa.getText());
                }   
                else if(cbxCuaHang.getSelectedItem().toString().compareTo("Cửa hàng 2") == 0)
                {
                    dao.deleteCH2(txtMa.getText());
                    dao.deleteTT(txtMa.getText());
                }    
                else
                {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn cửa hàng !!!");
                    return;
                }
                JOptionPane.showMessageDialog(this, "Sản phẩm đã được xoá khỏi CSDL ");
            }          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMouseClicked
        int r = tblProduct.getSelectedRow();

        if (r < 0) {
            return;
        }

        txtMa.setText(tblProduct.getValueAt(r, 0).toString());
        txtTen.setText(tblProduct.getValueAt(r, 1).toString());
        txtNhaCungCap.setText(tblProduct.getValueAt(r, 2).toString());
  
        String t = tblProduct.getValueAt(r, 3).toString();
        
        String []a = t.split("-");
        
        int tempNgay = Integer.parseInt(a[0].trim());
        int tempThang = Integer.parseInt(a[1].trim());
        int tempNam = Integer.parseInt(a[2].trim());
        
        cbxNgay.setSelectedIndex(tempNgay - 1);
        cbxThang.setSelectedIndex(tempThang - 1);
        cbxNam.setSelectedIndex(tempNam - 2015);
        
        txtSoLuong.setText(tblProduct.getValueAt(r, 4).toString());
        txtDonGia.setText(tblProduct.getValueAt(r, 5).toString());
        txtGiaBan.setText(tblProduct.getValueAt(r, 6).toString());
    }//GEN-LAST:event_tblProductMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtTen.setText("");
        txtMa.setText("");
        txtSoLuong.setText("");
        txtDonGia.setText("");
        txtGiaBan.setText("");
        txtNhaCungCap.setText("");
       
        cbxCuaHang.setSelectedIndex(0);
        txtTimKiem.setText("");
        cbxTimKiem.setSelectedIndex(0);
        
        cbxNgay.setSelectedIndex(0);
        cbxThang.setSelectedIndex(0);
        cbxNam.setSelectedIndex(0); 
        
        getData();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
try {
            String sql = "";
            Connection con = Database.openConnection();
                            
            if(cbxTimKiem.getSelectedItem().toString().trim().compareTo("Mã") == 0)           
                sql = "select * from SanPhamTT where madt like ?";
            else if(cbxTimKiem.getSelectedItem().toString().trim().compareTo("Tên") == 0)
                sql = "select * from SanPhamTT where tendt like ?";
            else if(cbxTimKiem.getSelectedItem().toString().trim().compareTo("Nơi sản xuất") == 0)
                sql = "select * from SanPhamTT where nhacungcap like ?";
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            String searchCriteria = "%";
            
            if(!(txtTimKiem.getText().equals("")))       
                searchCriteria += txtTimKiem.getText().trim() + "%";
            
            
            pstmt.setString(1, searchCriteria);
            
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
                    getDonGia(rs.getString("DonGia")),
                    getDonGia(rs.getString("GiaBan"))
                });
            }
            tblModel.fireTableDataChanged();
            }
           
         catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void timKiem(String temp, int n)//tim kiem theo Mã, temp = Mã, n = 0
    {

        DefaultTableModel modelProducts2;

        String[] headers = {"Mã", "Tên", "Số lượng", "Đơn giá", "Nơi sản xuất", "Ngày nhap"};
        String[][] data
                = {};
        modelProducts2 = new DefaultTableModel(data, headers);

        for (int i = 0; i < tblProduct.getRowCount(); i++) {
            if (tblProduct.getValueAt(i, 0).toString().compareTo("SP01") == 0) {
                Vector dataRow = new Vector();
                dataRow.add(tblProduct.getValueAt(i, 0).toString());
                dataRow.add(tblProduct.getValueAt(i, 1).toString());
                dataRow.add(tblProduct.getValueAt(i, 2).toString());
                dataRow.add(tblProduct.getValueAt(i, 3).toString());
                dataRow.add(tblProduct.getValueAt(i, 4).toString());
                dataRow.add(tblProduct.getValueAt(i, 5).toString());

                modelProducts2.addRow(dataRow);

            }

            tblProduct.setModel(modelProducts2);
        }
    }
    private void cbxTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTimKiemActionPerformed

    private void cbxCuaHangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCuaHangItemStateChanged
        try {
            String sql = "" ;
            Connection con = Database.openConnection();            
            if(cbxCuaHang.getSelectedItem().toString().compareTo("Cửa hàng 1") == 0)                 
                sql = "select * from SanPhamCH1 where madt like '%CH1%'";
            else if(cbxCuaHang.getSelectedItem().toString().compareTo("Cửa hàng 2") == 0)
                sql = "select * from SanPhamCH2 where madt like '%CH2%'";
            else
                sql = "select * from SanPhamTT where madt like '%CH%'";
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
                    getDonGia(rs.getString("DonGia")),
                    getDonGia(rs.getString("GiaBan"))
                });    
            }
            tblModel.fireTableDataChanged();
            }
           
         catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbxCuaHangItemStateChanged

    private void btnOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOutActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLySanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnOut;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cbxCuaHang;
    private javax.swing.JComboBox<String> cbxNam;
    private javax.swing.JComboBox<String> cbxNgay;
    private javax.swing.JComboBox<String> cbxThang;
    private javax.swing.JComboBox<String> cbxTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNhaCungCap;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
