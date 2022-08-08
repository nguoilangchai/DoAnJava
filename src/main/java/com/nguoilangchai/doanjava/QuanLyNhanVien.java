package com.nguoilangchai.doanjava;

import com.nguoilangchai.doanjava.database.Database;
import com.nguoilangchai.doanjava.database.EmployeeDao;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QuanLyNhanVien extends javax.swing.JFrame 
{
    private DefaultTableModel tblModel;
    
    DefaultComboBoxModel<String> modelTimKiem ;
    
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
    
    public void initListTimKiem()
    {
        modelTimKiem = new DefaultComboBoxModel<>();
        
        modelTimKiem.addElement("Mã nhân viên");
        modelTimKiem.addElement("Họ tên");
        modelTimKiem.addElement("Email");
        modelTimKiem.addElement("Số điện thoại");
        modelTimKiem.addElement("Giới tính");
        modelTimKiem.addElement("Quê quán");
        modelTimKiem.addElement("Năm sinh");
        modelTimKiem.addElement("Ngày vào làm");
        
        cbxTimKiem.setModel(modelTimKiem);
    }
    
    private String getNgay(String x)
    {
        String []a = x.split("-");
        return a[2] + "-" + a[1] + "-" + a[0];      
    }
    
    public void initListNgaySinh()
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
        
        for(int i = 1980;i <= 2004;i++)
        {
            modelNam.addElement(""+i);
        }
        
        cbxNgay.setModel(modelNgay);
        cbxThang.setModel(modelThang);
        cbxNam.setModel(modelNam);
    }
    
    public void initListTable() 
    {
        String[] columnNames = new String[] {"Mã", "Họ tên", "Email", "SĐT", "Giới tính", "Quê quán", "Ngày sinh", "Ngày vào làm"};
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(columnNames);
        tblEmployees.setModel(tblModel);
    }
    
   private void getData()
    {
        try {
            Connection con = Database.openConnection();
            String sql = "select * from NhanVienTT";
            PreparedStatement pstmt = con.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            
            tblModel.setRowCount(0);
            while(rs.next())
            {
                tblModel.addRow(new Object []
                {
                   
                    rs.getString("manv"),
                    rs.getString("hoten"),
                    rs.getString("email"),
                    rs.getString("sodt"),
                    rs.getString("gioitinh"),
                    rs.getString("diachi"),
                    getNgay(rs.getString("ngaysinh")),
                    getNgay(rs.getString("ngayvaolam")),
                });
            }
            tblModel.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    
    public QuanLyNhanVien() {
        initComponents();
        setLocationRelativeTo(null);
        initListCuaHang();
        initListTable();
        getData();
        initListNgaySinh();
        initListTimKiem();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        rdoGioiTinh = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtDienThoai = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployees = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbxNgay = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbxThang = new javax.swing.JComboBox<>();
        cbxNam = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnLuu = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtNgayVaoLam = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtThangVaoLam = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtNamVaoLam = new javax.swing.JTextField();
        cbxTimKiem = new javax.swing.JComboBox<>();
        btnThoat = new javax.swing.JButton();
        cbxCuaHang = new javax.swing.JComboBox<>();

        buttonGroup1.add(rdoGioiTinh);
        rdoGioiTinh.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Quản Lý Nhân Viên");

        jLabel2.setText("Mã NV");

        jLabel3.setText("Họ Tên");

        jLabel4.setText("Email");

        jLabel5.setText("SĐT");

        jLabel6.setText("Giới tính");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        jLabel7.setText("Địa chỉ");

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nguoilangchai/slide4/demo/icon/search-icon-24.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        tblEmployees.setModel(new javax.swing.table.DefaultTableModel(
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
        tblEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployeesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmployees);

        jLabel8.setText("Ngày sinh : ");

        jLabel9.setText("/");

        jLabel10.setText("/");

        cbxNgay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngày", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Ngày :");

        jLabel12.setText("Tháng :");

        jLabel13.setText("Năm :");

        cbxThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tháng", "Item 2", "Item 3", "Item 4" }));

        cbxNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Năm", "Item 2", "Item 3", "Item 4" }));

        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nguoilangchai/slide4/demo/icon/Save-icon.png"))); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nguoilangchai/slide4/demo/icon/Actions-edit-delete-icon-16.png"))); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nguoilangchai/slide4/demo/icon/new-icon-16.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nguoilangchai/slide4/demo/icon/Actions-document-edit-icon-16.png"))); // NOI18N
        btnCapNhat.setText("Cập nhât");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnCapNhat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnXoa)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel14.setText("Ngày làm");

        jLabel15.setText("(dd/mm/yyyy)");

        jLabel16.setText("/");

        jLabel17.setText("/");

        cbxTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nguoilangchai/slide4/demo/icon/Login-icon-16.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        cbxCuaHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxCuaHang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCuaHangItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
            .addGroup(layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(jLabel1)
                .addGap(59, 59, 59)
                .addComponent(cbxCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThoat)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel2))
                                        .addGap(17, 17, 17))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(rdoNu))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(rdoNam)
                                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtHoTen)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(42, 42, 42)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtDiaChi)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cbxNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel9))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cbxThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cbxNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(txtNgayVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtThangVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNamVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnTimKiem)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbxTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnThoat)
                    .addComponent(cbxCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel9)
                    .addComponent(cbxThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13)
                    .addComponent(cbxNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtNgayVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(txtThangVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtNamVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reset()
    {
        txtMaNV.setText("");
        txtHoTen.setText("");
        txtEmail.setText("");
        txtDienThoai.setText("");
        rdoGioiTinh.setSelected(true);
        txtDiaChi.setText("");
        cbxNgay.setSelectedIndex(0);
        cbxThang.setSelectedIndex(0);
        cbxNam.setSelectedIndex(0);    
        txtNgayVaoLam.setText("");
        
        txtNgayVaoLam.setText("");
        txtThangVaoLam.setText("");
        txtNamVaoLam.setText("");
        
        txtTimKiem.setText("");
        cbxTimKiem.setSelectedIndex(0);
        
        cbxCuaHang.setSelectedIndex(0);
        getData();
    }
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
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
        
        if(txtMaNV.getText().trim().equals(""))
        {
            sb.append("Mã nhân viên không được để trống");
        }
        if(txtHoTen.getText().trim().equals(""))
        {
            sb.append("\nTên nhân viên không được để trống");
        }
        if(!rdoNam.isSelected() && !rdoNu.isSelected())
        {
            sb.append("\nGiới tính nhân viên không được để trống");
        }
        if(sb.length() > 0)
        {
            JOptionPane.showMessageDialog(this, sb.toString());
            return;
        }
        try {
            Employee emp = new Employee(); 
            emp.setMaNV(t + txtMaNV.getText().trim().toUpperCase());
            emp.setHoTen(txtHoTen.getText().trim());
            emp.setEmail(txtEmail.getText().trim());
            emp.setSoDT(Integer.parseInt(txtDienThoai.getText()));         
            emp.setGioiTinh(rdoNam.isSelected() ? "Nam" : "Nữ");
            emp.setDiaChi(txtDiaChi.getText().trim());
            
            String temp = cbxNam.getSelectedItem().toString() + cbxThang.getSelectedItem().toString() + cbxNgay.getSelectedItem().toString();
            
            emp.setNgaySinh(temp.trim());
            
            String t_ngay = txtNgayVaoLam.getText().trim();
            if(txtNgayVaoLam.getText().length() == 1)
            {
                t_ngay = "0" + txtNgayVaoLam.getText();
            }
            
            String t_thang = txtThangVaoLam.getText().trim();
            if(txtThangVaoLam.getText().length() == 1)
            {
                t_thang = "0" + txtThangVaoLam.getText();
            }
            
            String tempNgayVaoLam = txtNamVaoLam.getText() + t_thang + t_ngay;
            
            emp.setNgayVaoLam(tempNgayVaoLam.trim());
            
            //set username la maNV
            emp.setUserName((t + txtMaNV.getText().trim()).toLowerCase());
            
            EmployeeDao dao = new EmployeeDao();
            
            if(cbxCuaHang.getSelectedItem().toString().compareTo("Cửa hàng 1") == 0)
            {
                dao.insertCH1(emp);
                dao.insertTT(emp);
            }
            else if(cbxCuaHang.getSelectedItem().toString().compareTo("Cửa hàng 2") == 0)
            {
                dao.insertCH2(emp);
                dao.insertTT(emp);
            }

            JOptionPane.showMessageDialog(this, "Nhân viên mới đã được lưu vào CSDL");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        try {
            String sql = "";
            Connection con = Database.openConnection();
          
            String t = "";
            if(cbxCuaHang.getSelectedItem().toString().compareTo("Cửa hàng 1") == 0)
                t = "NhanVienCH1";
            else if(cbxCuaHang.getSelectedItem().toString().compareTo("Cửa hàng 2") == 0)
                t = "NhanVienCH2";
            else
            {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn cửa hàng !!!");
                return;
            }
            
            if(cbxTimKiem.getSelectedItem().toString().compareTo("Mã nhân viên") == 0)           
                sql = "select * from " + t + " where manv like ?";
            else if(cbxTimKiem.getSelectedItem().toString().compareTo("Họ tên") == 0)
                sql = "select * from " + t + " where hoten like ?";
            else if(cbxTimKiem.getSelectedItem().toString().compareTo("Email") == 0)
                sql = "select * from " + t + " where email like ?";
            else if(cbxTimKiem.getSelectedItem().toString().compareTo("Số điện thoại") == 0)
                sql = "select * from " + t + " where sodt like ?";
            else if(cbxTimKiem.getSelectedItem().toString().compareTo("Giới tính") == 0)
                sql = "select * from " + t + " where gioitinh like ?";
            else if(cbxTimKiem.getSelectedItem().toString().compareTo("Quê quán") == 0)
                sql = "select * from " + t + " where diachi like ?";
            else if(cbxTimKiem.getSelectedItem().toString().compareTo("Năm sinh") == 0)
                sql = "select * from " + t + " where ngaysinh like ?";
            else if(cbxTimKiem.getSelectedItem().toString().compareTo("Ngày vào làm") == 0)
                sql = "select * from " + t + " where ngayvaolam like ?";
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            String searchCriteria = "%";
            
            if(!(txtTimKiem.getText().equals("")))       
                searchCriteria += txtTimKiem.getText() + "%";
            
            
            pstmt.setString(1, searchCriteria);
            
            ResultSet rs = pstmt.executeQuery();
            
            tblModel.setRowCount(0);
            while(rs.next())
            {
                tblModel.addRow(new Object []
                {
                   
                    rs.getString("manv"),
                    rs.getString("hoten"),
                    rs.getString("email"),
                    rs.getString("sodt"),
                    rs.getString("gioitinh"),
                    rs.getString("diachi"),
                    getNgay(rs.getString("ngaysinh")),
                    getNgay(rs.getString("ngayvaolam")),
                });
            }
            tblModel.fireTableDataChanged();
            }
           
         catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        StringBuilder sb = new StringBuilder();
        if(txtMaNV.getText().trim().equals(""))
        {
            sb.append("Mã nhân viên không được để trống");
        }

        if(sb.length() > 0)
        {
            JOptionPane.showMessageDialog(this, sb.toString());
            return;
        }
        try {            
            EmployeeDao dao = new EmployeeDao();
            int t = JOptionPane.showConfirmDialog(this, "Bạn có đồng ý xoá hay không");   
            if(t == 0)
            {
                if(cbxCuaHang.getSelectedItem().toString().compareTo("Cửa hàng 1") == 0)
                {
                    dao.deleteCH1(txtMaNV.getText());
                    dao.deleteTT(txtMaNV.getText());
                }   
                else if(cbxCuaHang.getSelectedItem().toString().compareTo("Cửa hàng 2") == 0)
                {
                    dao.deleteCH2(txtMaNV.getText());
                    dao.deleteTT(txtMaNV.getText());
                }    
                else
                {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn cửa hàng !!!");
                    return;
                }
                
                JOptionPane.showMessageDialog(this, "Nhân viên đã được xoá khỏi CSDL ");

            }          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblEmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeesMouseClicked
        int r = tblEmployees.getSelectedRow();
        
        if(r < 0)
            return ;
        
        txtMaNV.setText(tblEmployees.getValueAt(r, 0).toString());
        txtHoTen.setText(tblEmployees.getValueAt(r, 1).toString());
        txtEmail.setText(tblEmployees.getValueAt(r, 2).toString());
        txtDienThoai.setText(tblEmployees.getValueAt(r, 3).toString());
        
        String tempGioiTinh = tblEmployees.getValueAt(r, 4).toString();
        
        if(tempGioiTinh.compareTo("Nam") == 0)
        {
            rdoNam.doClick();
        }
        else
            rdoNu.doClick();
        
        txtDiaChi.setText(tblEmployees.getValueAt(r, 5).toString());
        String t = tblEmployees.getValueAt(r, 6).toString();
        
        String []a = t.split("-");
        
        int tempNgay = Integer.parseInt(a[0].trim());
        int tempThang = Integer.parseInt(a[1].trim());
        int tempNam = Integer.parseInt(a[2].trim());
        
        cbxNgay.setSelectedIndex(tempNgay - 1);
        cbxThang.setSelectedIndex(tempThang - 1);
        cbxNam.setSelectedIndex(tempNam - 1980);
         
        String tNgayVaoLam = tblEmployees.getValueAt(r, 7).toString();
        
        String []aNVL = tNgayVaoLam.split("-");
        
        txtNgayVaoLam.setText(aNVL[0]);
        txtThangVaoLam.setText(aNVL[1]);
        txtNamVaoLam.setText(aNVL[2]);
        
        
    }//GEN-LAST:event_tblEmployeesMouseClicked

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        try {
            String sql = "";
            String t_sql = "";
            Connection con = Database.openConnection();
            if(cbxCuaHang.getSelectedItem().toString().compareTo("Cửa hàng 1") == 0)                 
            {
                sql = "update NhanVienCH1 set hoten = ?, email = ?, sodt = ?, gioitinh = ?, diachi = ?, NgaySinh = ?, NgayVaoLam = ?\n" +
"where MaNV = ?";
                t_sql = "update NhanVienTT set hoten = ?, email = ?, sodt = ?, gioitinh = ?, diachi = ?, NgaySinh = ?, NgayVaoLam = ?\n" +
"where MaNV = ?"; 
            }
            else if(cbxCuaHang.getSelectedItem().toString().compareTo("Cửa hàng 2") == 0)
            {
                sql = "update NhanVienCH2 set hoten = ?, email = ?, sodt = ?, gioitinh = ?, diachi = ?, NgaySinh = ?, NgayVaoLam = ?\n" +
"where MaNV = ?"; 
                t_sql = "update NhanVienTT set hoten = ?, email = ?, sodt = ?, gioitinh = ?, diachi = ?, NgaySinh = ?, NgayVaoLam = ?\n" +
"where MaNV = ?";
            }    
            else
            {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn cửa hàng !!!");
                return;
            }
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            PreparedStatement t_pstmt = con.prepareStatement(t_sql);
            
            Employee emp = new Employee(); 
            
            emp.setMaNV(txtMaNV.getText().trim());
            emp.setHoTen(txtHoTen.getText().trim());
            emp.setEmail(txtEmail.getText().trim());
            emp.setSoDT(Integer.parseInt(txtDienThoai.getText()));
            emp.setGioiTinh(rdoNam.isSelected() ? "Nam" : "Nữ");
            emp.setDiaChi(txtDiaChi.getText().trim());
            
            String temp = cbxNam.getSelectedItem().toString() + cbxThang.getSelectedItem().toString() + cbxNgay.getSelectedItem().toString();
            
            emp.setNgaySinh(temp.trim());
            
            String t_ngay = txtNgayVaoLam.getText().trim();
            if(txtNgayVaoLam.getText().length() == 1)
            {
                t_ngay = "0" + txtNgayVaoLam.getText();
            }
            
            String t_thang = txtThangVaoLam.getText().trim();
            if(txtThangVaoLam.getText().length() == 1)
            {
                t_thang = "0" + txtThangVaoLam.getText();
            }
            
            String tempNgayVaoLam = txtNamVaoLam.getText() + t_thang + t_ngay;
            
            emp.setNgayVaoLam(tempNgayVaoLam.trim());
            
            pstmt.setString(1, emp.getHoTen());
            pstmt.setString(2, emp.getEmail());
            pstmt.setString(3, String.valueOf(emp.getSoDT()));
            pstmt.setString(4, emp.getGioiTinh());
            pstmt.setString(5, emp.getDiaChi());
            pstmt.setString(6, emp.getNgaySinh());
            pstmt.setString(7, emp.getNgayVaoLam());
            pstmt.setString(8, emp.getMaNV());
            
            t_pstmt.setString(1, emp.getHoTen());
            t_pstmt.setString(2, emp.getEmail());
            t_pstmt.setString(3, String.valueOf(emp.getSoDT()));
            t_pstmt.setString(4, emp.getGioiTinh());
            t_pstmt.setString(5, emp.getDiaChi());
            t_pstmt.setString(6, emp.getNgaySinh());
            t_pstmt.setString(7, emp.getNgayVaoLam());
            t_pstmt.setString(8, emp.getMaNV());
            
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

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.dispose();
        new TrungTamForm().setVisible(true);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void cbxCuaHangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCuaHangItemStateChanged
        try {
            String sql = "" ;
            Connection con = Database.openConnection();            
            if(cbxCuaHang.getSelectedItem().toString().compareTo("Cửa hàng 1") == 0)                 
                sql = "select * from NhanVienCH1";
            else if(cbxCuaHang.getSelectedItem().toString().compareTo("Cửa hàng 2") == 0)
                sql = "select * from NhanVienCH2";
            else
                sql = "select * from NhanVienTT";
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            ResultSet rs = pstmt.executeQuery();
            
            tblModel.setRowCount(0);
            while(rs.next())
            {                  
                tblModel.addRow(new Object []
                {
                   
                    rs.getString("manv"),
                    rs.getString("hoten"),
                    rs.getString("email"),
                    rs.getString("sodt"),
                    rs.getString("gioitinh"),
                    rs.getString("diachi"),
                    getNgay(rs.getString("ngaysinh")),
                    getNgay(rs.getString("ngayvaolam")),
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
        
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() {
                new QuanLyNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxCuaHang;
    private javax.swing.JComboBox<String> cbxNam;
    private javax.swing.JComboBox<String> cbxNgay;
    private javax.swing.JComboBox<String> cbxThang;
    private javax.swing.JComboBox<String> cbxTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JRadioButton rdoGioiTinh;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblEmployees;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDienThoai;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNamVaoLam;
    private javax.swing.JTextField txtNgayVaoLam;
    private javax.swing.JTextField txtThangVaoLam;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
