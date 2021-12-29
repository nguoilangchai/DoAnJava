package com.nguoilangchai.doanjava;

import com.nguoilangchai.doanjava.database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QuanLyBanHangForm extends javax.swing.JFrame {
    private DefaultTableModel tblModel;
    
    DefaultComboBoxModel<String> modelCuaHang ;
    
    private String getNgay(String x)
    {
        String []a = x.split("-");
        return a[2] + "-" + a[1] + "-" + a[0];      
    }
    
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
        String[] columnNames = new String[] {"Mã NV", "Tên NV","Tên KH","CMND","Tên điện thoại","Nơi sản xuất","Giá bán","Số lượng", "Ngày"};
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(columnNames);
        tblBanHang.setModel(tblModel);
    }
    
    private void getData()
    {
        try {
            Connection con = Database.openConnection();
            String sql = "select * from DonHangTT";
            PreparedStatement pstmt = con.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            
            tblModel.setRowCount(0);
            while(rs.next())
            {
                tblModel.addRow(new Object []
                {
                   
                    rs.getString("manv"),
                    rs.getString("hotennv"),
                    rs.getString("cmnd"),
                    rs.getString("HoTenKH"),
                    rs.getString("TenDT"),
                    rs.getString("NhaCungCap"),
                    rs.getString("GiaBan"),
                    rs.getString("SoLuong"),
                    getNgay(rs.getString("Ngay")),

                });
            }
            tblModel.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    public QuanLyBanHangForm() {
        initComponents();
        initListCuaHang();
        initListTable();
        getData();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbxCuaHang = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBanHang = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("QUẢN LÝ BÁN HÀNG");

        cbxCuaHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCuaHang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCuaHangItemStateChanged(evt);
            }
        });

        tblBanHang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblBanHang);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(cbxCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(223, 223, 223)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxCuaHangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCuaHangItemStateChanged
        try {
            String sql = "" ;
            Connection con = Database.openConnection();            
            if(cbxCuaHang.getSelectedItem().toString().compareTo("Cửa hàng 1") == 0)                 
                sql = "select * from DonHangCH1";
            else if(cbxCuaHang.getSelectedItem().toString().compareTo("Cửa hàng 2") == 0)
                sql = "select * from DonHangCH2";
            else
                sql = "select * from DonHangTT";
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            ResultSet rs = pstmt.executeQuery();
            
            tblModel.setRowCount(0);
            while(rs.next())
            {                  
                tblModel.addRow(new Object []
                {
                   
                    rs.getString("manv"),
                    rs.getString("hotennv"),
                    rs.getString("cmnd"),
                    rs.getString("HoTenKH"),
                    rs.getString("TenDT"),
                    rs.getString("NhaCungCap"),
                    rs.getString("GiaBan"),
                    rs.getString("SoLuong"),
                    getNgay(rs.getString("Ngay")),
                });    
            }
            tblModel.fireTableDataChanged();
            }
           
         catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_cbxCuaHangItemStateChanged


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyBanHangForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxCuaHang;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBanHang;
    // End of variables declaration//GEN-END:variables
}
