/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.view;


import QLKS.controller.StaffDao;
//import QLKS.controller.Xuatexcel;
import QLKS.controller.bophanDao;
import QLKS.model.bophan;
import QLKS.model.staff;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zzgia
 */
public class Staffview extends javax.swing.JFrame {
    String idUpdae ="";
    /**
     * Creates new form Menu
     */
    public Staffview()  {
        initComponents();
        
        long millis=System.currentTimeMillis();   
        java.sql.Date date=new java.sql.Date(millis);   
        txtNgaySinh.setDate(date);
        txtMaNV.requestFocusInWindow();
        tblNV.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        setExtendedState(MAXIMIZED_BOTH);
        cboBP.setBackground(Color.white);
        buttonGroup1.add(rdoNu);
        buttonGroup1.add(rdoNam);
        rdoNam.setSelected(true);
        btnS.setEnabled(false);
        btnX.setEnabled(false);
        
        loadStaff();
        loadTable();
        //Sự kiện click vào 1 dong trong table
        tblNV.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtMaNV.setEnabled(false);
                btnT.setEnabled(false);
                btnS.setEnabled(true);
                btnX.setEnabled(true);
                int index = tblNV.getSelectedRow();
                String valueAt = (String) tblNV.getValueAt(index, 0);
                staff pUpdate = staffdao.get(valueAt+"").get();
                
                txtMaNV.setText(pUpdate.getMaNV());
                txtemail.setText(pUpdate.getEmail());
                txtSDT.setText(pUpdate.getSdt());
                txtCMND.setText(pUpdate.getCmnd());
                txtTenNV.setText(pUpdate.getTenNV());
                txtDC.setText(pUpdate.getDiachi());
                txtLuong.setText(pUpdate.getLuong());
                try {
                    txtNgaySinh.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(pUpdate.getNgaySinh()));
                } catch (ParseException ex) {
                    Logger.getLogger(Staffview.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(pUpdate.getGioiTinh()==1){
                    rdoNam.setSelected(true);
                }else
                    rdoNu.setSelected(true);
                bophanDao bpdao = new bophanDao();
                System.out.println((bophan)bpdao.get(pUpdate.getMaBP()).get());
                cboBP.getModel().setSelectedItem((bophan)bpdao.get(pUpdate.getMaBP()).get());
                idUpdae = valueAt;

            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("");
            }

            

            @Override
            public void mouseExited(MouseEvent e) {
               System.out.println("");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("");
            }

        });

    }

    void setlabel(){
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnBorder1 = new QLKS.Home.pnBorder();
        pnBorder2 = new QLKS.Home.pnBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNV = new javax.swing.JTable();
        pnBorder3 = new QLKS.Home.pnBorder();
        btnT = new javax.swing.JButton();
        btnS = new javax.swing.JButton();
        btnX = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        lblerro = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        btnBieuDo = new javax.swing.JButton();
        pnBorder5 = new QLKS.Home.pnBorder();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtCMND = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtDC = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        cboBP = new javax.swing.JComboBox<>();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        txtLuong = new java.awt.TextField();
        jLabel11 = new javax.swing.JLabel();
        pnBorder4 = new QLKS.Home.pnBorder();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstBoPhan = new javax.swing.JList<>();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnSearch = new javax.swing.JPanel();
        iconSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý nhân viên");

        pnBorder1.setBackground(new java.awt.Color(204, 255, 255));

        pnBorder2.setBackground(new java.awt.Color(255, 255, 255));
        pnBorder2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách nhân viên"));

        tblNV.setAutoCreateRowSorter(true);
        tblNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblNV.setRowHeight(60);
        jScrollPane1.setViewportView(tblNV);

        javax.swing.GroupLayout pnBorder2Layout = new javax.swing.GroupLayout(pnBorder2);
        pnBorder2.setLayout(pnBorder2Layout);
        pnBorder2Layout.setHorizontalGroup(
            pnBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(628, Short.MAX_VALUE))
        );
        pnBorder2Layout.setVerticalGroup(
            pnBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBorder2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnBorder3.setBackground(new java.awt.Color(204, 255, 255));
        pnBorder3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add_35_gradian.png"))); // NOI18N
        btnT.setText("Thêm");
        btnT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTActionPerformed(evt);
            }
        });

        btnS.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update_35_gradian.png"))); // NOI18N
        btnS.setText("Sửa");
        btnS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSActionPerformed(evt);
            }
        });

        btnX.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete_35_gradien.png"))); // NOI18N
        btnX.setText("Xóa");
        btnX.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXActionPerformed(evt);
            }
        });

        btnexit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/thoat_35.png"))); // NOI18N
        btnexit.setText("Thoát");
        btnexit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        lblerro.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        lblerro.setForeground(new java.awt.Color(255, 0, 0));
        lblerro.setText(" ");

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/quay_lai_35.png"))); // NOI18N
        btnReset.setText("Nhập lại");
        btnReset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnBieuDo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBieuDo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/chart_35.png"))); // NOI18N
        btnBieuDo.setText("Thống kê");
        btnBieuDo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBieuDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBieuDoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBorder3Layout = new javax.swing.GroupLayout(pnBorder3);
        pnBorder3.setLayout(pnBorder3Layout);
        pnBorder3Layout.setHorizontalGroup(
            pnBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBorder3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnT, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnS, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnX, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(btnBieuDo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBorder3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblerro, javax.swing.GroupLayout.PREFERRED_SIZE, 1210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
        );
        pnBorder3Layout.setVerticalGroup(
            pnBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBorder3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnS)
                    .addGroup(pnBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnexit)
                        .addComponent(btnReset)
                        .addComponent(btnBieuDo)
                        .addComponent(btnT)
                        .addComponent(btnX)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblerro)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pnBorder5.setBackground(new java.awt.Color(255, 255, 255));
        pnBorder5.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết nhân viên"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Mã nhân viên:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Bộ phận:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Họ và tên:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Ngày sinh:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Giới tính:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Số điện thoại:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("CMND:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Email:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Địa chỉ:");

        txtMaNV.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtMaNV.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNVActionPerformed(evt);
            }
        });

        txtTenNV.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTenNV.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtSDT.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtSDT.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        txtCMND.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtCMND.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtemail.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtemail.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtDC.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtDC.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtDC.setName(""); // NOI18N

        rdoNam.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rdoNam.setForeground(new java.awt.Color(51, 51, 51));
        rdoNam.setText("Nam");

        rdoNu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rdoNu.setForeground(new java.awt.Color(51, 51, 51));
        rdoNu.setText("Nữ");

        txtNgaySinh.setDateFormatString("yyyy / MM / dd");

        txtLuong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Lương (VND)");

        javax.swing.GroupLayout pnBorder5Layout = new javax.swing.GroupLayout(pnBorder5);
        pnBorder5.setLayout(pnBorder5Layout);
        pnBorder5Layout.setHorizontalGroup(
            pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBorder5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnBorder5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnBorder5Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnBorder5Layout.createSequentialGroup()
                        .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnBorder5Layout.createSequentialGroup()
                                .addComponent(rdoNam)
                                .addGap(41, 41, 41)
                                .addComponent(rdoNu))
                            .addComponent(cboBP, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(108, 108, 108)
                .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnBorder5Layout.createSequentialGroup()
                        .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(35, 35, 35)
                        .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCMND, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtemail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBorder5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(203, 203, 203))
        );
        pnBorder5Layout.setVerticalGroup(
            pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBorder5Layout.createSequentialGroup()
                .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBorder5Layout.createSequentialGroup()
                        .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnBorder5Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addGap(34, 34, 34)
                        .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnBorder5Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboBP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pnBorder5Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))))
                    .addGroup(pnBorder5Layout.createSequentialGroup()
                        .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(88, 88, 88)))
                .addGap(16, 16, 16)
                .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(txtLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addGap(9, 9, 9))
        );

        pnBorder4.setBackground(new java.awt.Color(255, 255, 255));
        pnBorder4.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách bộ phận"));

        jScrollPane2.setViewportView(lstBoPhan);

        btnThem.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add_35_gradian.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update_35_gradian.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete_35_gradien.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBorder4Layout = new javax.swing.GroupLayout(pnBorder4);
        pnBorder4.setLayout(pnBorder4Layout);
        pnBorder4Layout.setHorizontalGroup(
            pnBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBorder4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBorder4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(pnBorder4Layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(30, 30, 30)
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(btnXoa)
                        .addGap(34, 34, 34))))
        );
        pnBorder4Layout.setVerticalGroup(
            pnBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBorder4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa))
                .addGap(21, 21, 21))
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(505, 505, 505)
                .addComponent(jLabel1)
                .addContainerGap(681, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pnSearch.setBackground(new java.awt.Color(255, 255, 255));
        pnSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        iconSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search30.png"))); // NOI18N
        iconSearch.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtSearch.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtSearch.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtSearch.setBorder(null);
        txtSearch.setName(""); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnSearchLayout = new javax.swing.GroupLayout(pnSearch);
        pnSearch.setLayout(pnSearchLayout);
        pnSearchLayout.setHorizontalGroup(
            pnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSearchLayout.createSequentialGroup()
                .addComponent(iconSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        pnSearchLayout.setVerticalGroup(
            pnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnSearchLayout.createSequentialGroup()
                .addGroup(pnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(iconSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        btnSearch.setBackground(new java.awt.Color(51, 204, 255));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBorder1Layout = new javax.swing.GroupLayout(pnBorder1);
        pnBorder1.setLayout(pnBorder1Layout);
        pnBorder1Layout.setHorizontalGroup(
            pnBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBorder1Layout.createSequentialGroup()
                        .addComponent(pnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnBorder4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBorder1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(pnBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnBorder1Layout.createSequentialGroup()
                        .addGroup(pnBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnBorder5, javax.swing.GroupLayout.PREFERRED_SIZE, 1043, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnBorder1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnBorder1Layout.setVerticalGroup(
            pnBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBorder1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBorder1Layout.createSequentialGroup()
                        .addComponent(pnBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnBorder5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnBorder1Layout.createSequentialGroup()
                        .addGroup(pnBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(pnBorder4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 1524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (txtSearch.getText().equals("Tìm kiếm...")) {
            loadTable();
        } else {
            loadTable(txtSearch.getText());
        }
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed
    bophanview nbpv ;
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        nbpv = new bophanview(this);
        nbpv.setVisible(true);
        loadStaff();
        loadTable();
    }//GEN-LAST:event_btnThemActionPerformed
    bophanview nbpv2;
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int selectedIndex = lstBoPhan.getSelectedIndex();
        if (selectedIndex >= 0) {
            bophan selectedValue = lstBoPhan.getSelectedValue();
            nbpv2 = new bophanview(this, selectedValue);
            nbpv2.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn ít nhất một danh mục để sửa!");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int selectedIndex = lstBoPhan.getSelectedIndex();
        if (selectedIndex >= 0) {
            bophan bp = lstBoPhan.getSelectedValue();
            int result = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn xóa bộ phận này không?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            
            if(result == JOptionPane.YES_OPTION)
            {
                bophanDao bpd = new bophanDao();
                int a= bpd.delete(bp.getMaBP());
                if (a==1) {
                    JOptionPane.showMessageDialog(this,"Xóa bộ phận thành công!","Xóa bộ phận.",JOptionPane.INFORMATION_MESSAGE);
                }else
                    JOptionPane.showMessageDialog(this,"Xóa bộ phận thất bại!","Sửa bộ phận.",JOptionPane.INFORMATION_MESSAGE);
                
            }
            
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn ít nhất một danh mục để sửa!");
        }
        loadStaff();
        loadTable();
    }//GEN-LAST:event_btnXoaActionPerformed

    private Boolean checkMa(String ma){
        List<staff> list = new ArrayList<>();
        list = staffdao.getAll();
        for (staff b : list) {
            if(ma.equals(b.getMaNV())){
                return true;
            }
        }
        return false;
    }
    private int checkGT(){
        if (rdoNam.isSelected()) {
            return 1;
        }else
            return 0;
    }
    private void btnTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTActionPerformed
        lblerro.setText(" ");
        bophan bo =  (bophan) cboBP.getSelectedItem();
        if (txtMaNV.getText().equals("")) {
            lblerro.setText("Hãy điền mã nhân viên");
        } else if(checkMa(txtMaNV.getText())==true){
            lblerro.setText("Mã nhân viên bị trùng");
        }else if(bo.getMaBP()=="-1000"){
            lblerro.setText("Bạn chưa chọn bộ phận");
        } else if(txtTenNV.getText().equals("")){
            lblerro.setText("Hãy điền tên nhân viên");
        }else if(txtNgaySinh.getDate()==null){
            lblerro.setText("Hãy chọn ngày sinh");
        } else if(txtSDT.getText().equals("")){
            lblerro.setText("Hãy điền số điện thoại");
        }else if(txtCMND.getText().equals("")){
            lblerro.setText("Hãy điền số cmnd");
        }else if(txtemail.getText().equals("")){
            lblerro.setText("Hãy điền email");
        }else if(txtDC.getText().equals("")){
            lblerro.setText("Hãy điền dịa chỉ");
        }else {
            int result = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn thêm mới nhân viên này không?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
                
                String dd=df.format(txtNgaySinh.getDate());
                
                staff newstaff = new staff(txtMaNV.getText(),bo.getMaBP(), txtTenNV.getText(),dd , checkGT(),txtSDT.getText(), txtCMND.getText(), txtemail.getText(), txtDC.getText(), txtLuong.getText());
                int a = staffdao.insert(newstaff);
                if (a==1) {
                    JOptionPane.showMessageDialog(this,"Thêm mới một nhân viên thành công!","Thêm mới nhân viên.",JOptionPane.INFORMATION_MESSAGE);
                    lblerro.setText(" ");
                    loadTable();
                }else
                    JOptionPane.showMessageDialog(this,"Thêm mới một nhân viên thất bại!","Thêm mới nhân viên.",JOptionPane.INFORMATION_MESSAGE);
                
            }

        }
    }//GEN-LAST:event_btnTActionPerformed

    private void txtMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNVActionPerformed

    private void btnXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXActionPerformed
        int result = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn xoá nhân viên này không?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
                
                int a = staffdao.delete(txtMaNV.getText());
                if (a==1) {
                    JOptionPane.showMessageDialog(this,"Xóa một nhân viên thành công!","Xóa nhân viên.",JOptionPane.INFORMATION_MESSAGE);
                    lblerro.setText(" ");
                    loadTable();
                }else
                    JOptionPane.showMessageDialog(this,"Xóa một nhân viên thất bại!","Xóa nhân viên.",JOptionPane.INFORMATION_MESSAGE);
                
            }
    }//GEN-LAST:event_btnXActionPerformed

    private void btnSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSActionPerformed
        lblerro.setText(" ");
        if (txtMaNV.getText().equals("")) {
            lblerro.setText("Hãy điền mã nhân viên");
        } else if(txtTenNV.getText().equals("")){
            lblerro.setText("Hãy điền tên nhân viên");
        }else if(txtNgaySinh.getDate()==null){
            lblerro.setText("Hãy chọn ngày sinh");
        } else if(txtSDT.getText().equals("")){
            lblerro.setText("Hãy điền số điện thoại");
        }else if(txtCMND.getText().equals("")){
            lblerro.setText("Hãy điền số cmnd");
        }else if(txtemail.getText().equals("")){
            lblerro.setText("Hãy điền email");
        }else if(txtDC.getText().equals("")){
            lblerro.setText("Hãy điền dịa chỉ");
        } else if(txtLuong.getText().equals("")){
            lblerro.setText("Hãy điền Lương");
        }else {
            int result = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn sửa nhân viên này không?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
                bophan bo =  (bophan) cboBP.getSelectedItem();
                String dd=df.format(txtNgaySinh.getDate());
                
                staff newstaff = new staff(txtMaNV.getText(),bo.getMaBP(), txtTenNV.getText(),dd , checkGT(),txtSDT.getText(), txtCMND.getText(), txtemail.getText(), txtDC.getText(), txtLuong.getText());
                int a = staffdao.update(newstaff);
                if (a==1) {
                    JOptionPane.showMessageDialog(this,"Sửa mới một nhân viên thành công!","Thêm mới nhân viên.",JOptionPane.INFORMATION_MESSAGE);
                    lblerro.setText(" ");
                    loadTable();
                }else
                    JOptionPane.showMessageDialog(this,"Sửa mới một nhân viên thất bại!","Thêm mới nhân viên.",JOptionPane.INFORMATION_MESSAGE);
                
                
            }

        }
    }//GEN-LAST:event_btnSActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        this.dispose();
       // login.h.setVisible(true);
    }//GEN-LAST:event_btnexitActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        loadStaff();
        loadTable();
        btnT.setEnabled(true);
        btnS.setEnabled(false);
        btnX.setEnabled(false);
        txtMaNV.setText("");
        txtSDT.setText("");
        txtCMND.setText("");
        txtemail.setText("");
        txtDC.setText("");
        txtTenNV.setText("");
        cboBP.setSelectedIndex(0);
        rdoNam.setSelected(true);
        long millis=System.currentTimeMillis();   
        java.sql.Date date=new java.sql.Date(millis);   
        txtNgaySinh.setDate(date);
        
    }//GEN-LAST:event_btnResetActionPerformed
  
    private void btnBieuDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBieuDoActionPerformed

    }//GEN-LAST:event_btnBieuDoActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Staffview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBieuDo;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnS;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnT;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnX;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnexit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<bophan> cboBP;
    private javax.swing.JLabel iconSearch;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblerro;
    private javax.swing.JList<bophan> lstBoPhan;
    private QLKS.Home.pnBorder pnBorder1;
    private QLKS.Home.pnBorder pnBorder2;
    private QLKS.Home.pnBorder pnBorder3;
    private QLKS.Home.pnBorder pnBorder4;
    private QLKS.Home.pnBorder pnBorder5;
    private javax.swing.JPanel pnSearch;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblNV;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtDC;
    private java.awt.TextField txtLuong;
    private javax.swing.JTextField txtMaNV;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtemail;
    // End of variables declaration//GEN-END:variables
    //Load dư liêu vao list
    private DefaultListModel<bophan> dlmBP;
    public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private bophanDao std = new bophanDao();
    public void loadStaff(){
        bophan bpm = new bophan();
        bpm.setMaBP("-1000");
        bpm.setTenBP("Tất cả");
        
        bophan bpm2 = new bophan();
        bpm2.setMaBP("-1000");
        bpm2.setTenBP("Chọn một bộ phận");
        
        cboBP.removeAllItems();
        cboBP.addItem(bpm2);
        dlmBP =new DefaultListModel<>();
        dlmBP.addElement(bpm);
        for (bophan st : std.getAll()) {
            dlmBP.addElement(st);
            cboBP.addItem(st);
        }
        lstBoPhan.setModel(dlmBP);
    }
    //Load dữ liệu vào bảng
    DefaultTableModel dtmDanhSach;
    StaffDao staffdao = new StaffDao();
    private void loadTable(){
        dtmDanhSach = new DefaultTableModel();
        String[] columnTitle = {"Mã nhân viên", "Mã bộ phận", "Tên nhân viên", "Ngày sinh", "Giới tính", "Số điện thoại","CMND","Email","Địa chỉ","Lương"};
        dtmDanhSach.setColumnIdentifiers(columnTitle);
        Object[] dataRow;
        List<staff> lisstaff = staffdao.getAll();
        for (staff p : lisstaff) {

            dataRow = new Object[]{p.getMaNV(), p.getMaBP(), p.getTenNV(), p.getNgaySinh(), staffdao.doiGT(String.valueOf(p.getGioiTinh())), p.getSdt(), p.getCmnd(), p.getEmail(), p.getDiachi(), p.getLuong()};
            dtmDanhSach.addRow(dataRow);
        }

        tblNV.setModel(dtmDanhSach);
        
        
        tblNV.getColumnModel().getColumn(0).setPreferredWidth(15);
        tblNV.getColumnModel().getColumn(1).setPreferredWidth(15);
        tblNV.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblNV.getColumnModel().getColumn(3).setPreferredWidth(25);
        tblNV.getColumnModel().getColumn(4).setPreferredWidth(5);
        tblNV.getColumnModel().getColumn(5).setPreferredWidth(50);
        tblNV.getColumnModel().getColumn(6).setPreferredWidth(50);
        tblNV.getColumnModel().getColumn(7).setPreferredWidth(90);
        tblNV.getColumnModel().getColumn(8).setPreferredWidth(50);
        tblNV.getColumnModel().getColumn(9).setPreferredWidth(5);

        lstBoPhan.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()) {
                    txtMaNV.setText("");
                    btnT.setEnabled(true);
                    btnS.setEnabled(false);
                    btnX.setEnabled(false);
                    txtMaNV.setText("");
                    txtemail.setText("");
                    txtSDT.setText("");
                    txtCMND.setText("");
                    txtTenNV.setText("");
                    txtDC.setText("");
                    txtNgaySinh.setDate(null);
                    rdoNam.setSelected(true);
                    cboBP.getModel().setSelectedItem("Chọn một bộ phận");
                    
                    // code here
                    List<bophan> selectedValuesList = lstBoPhan.getSelectedValuesList();
                    System.out.println(selectedValuesList.size());
                    Object[] dataRow;
                    dtmDanhSach.setRowCount(0);
                    for (bophan c : selectedValuesList) {
                        if(c.getMaBP().equals("-1000")){
                            List<staff> lisst = staffdao.getAll();
                            for (staff p : lisst) {
                                dataRow = new Object[]{p.getMaNV(), p.getMaBP(), p.getTenNV(), p.getNgaySinh(), staffdao.doiGT(String.valueOf(p.getGioiTinh())), p.getSdt(), p.getCmnd(), p.getEmail(), p.getDiachi()};
                                dtmDanhSach.addRow(dataRow);
                            }
                        }else{
                            List<staff> lisst = staffdao.get(c);
                            for (staff p : lisst) {
                                dataRow = new Object[]{p.getMaNV(), p.getMaBP(), p.getTenNV(), p.getNgaySinh(), staffdao.doiGT(String.valueOf(p.getGioiTinh())), p.getSdt(), p.getCmnd(), p.getEmail(), p.getDiachi()};
                                dtmDanhSach.addRow(dataRow);
                            }
                            
                        }
                        
                    }
                    tblNV.setModel(dtmDanhSach);
                }
            }
        });
    }
    private void loadTable(String key){
        dtmDanhSach = new DefaultTableModel();
        String[] columnTitle = {"Mã nhân viên", "Mã bộ phận", "Tên nhân viên", "Ngày sinh", "Giới tính", "Số điện thoại","CMND","Email","Địa chỉ"};
        dtmDanhSach.setColumnIdentifiers(columnTitle);
        Object[] dataRow;
        List<staff> lisstaff = staffdao.getAll(key);
        for (staff p : lisstaff) {

            dataRow = new Object[]{p.getMaNV(), p.getMaBP(), p.getTenNV(), p.getNgaySinh(),staffdao.doiGT(String.valueOf(p.getGioiTinh())), p.getSdt(), p.getCmnd(), p.getEmail(), p.getDiachi()};
            dtmDanhSach.addRow(dataRow);
        }

        tblNV.setModel(dtmDanhSach);
        
        
        tblNV.getColumnModel().getColumn(0).setPreferredWidth(15);
        tblNV.getColumnModel().getColumn(1).setPreferredWidth(15);
        tblNV.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblNV.getColumnModel().getColumn(3).setPreferredWidth(25);
        tblNV.getColumnModel().getColumn(4).setPreferredWidth(5);
        tblNV.getColumnModel().getColumn(5).setPreferredWidth(50);
        tblNV.getColumnModel().getColumn(6).setPreferredWidth(50);
        tblNV.getColumnModel().getColumn(7).setPreferredWidth(90);
        tblNV.getColumnModel().getColumn(8).setPreferredWidth(50);

        lstBoPhan.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()) {
                    
                    // code here
                    List<bophan> selectedValuesList = lstBoPhan.getSelectedValuesList();
                    System.out.println(selectedValuesList.size());
                    Object[] dataRow;
                    dtmDanhSach.setRowCount(0);
                    for (bophan c : selectedValuesList) {
                        if(c.getMaBP().equals("-1000")){
                            List<staff> lisst = staffdao.getAll();
                            for (staff p : lisst) {
                                dataRow = new Object[]{p.getMaNV(), p.getMaBP(), p.getTenNV(), p.getNgaySinh(), staffdao.doiGT(String.valueOf(p.getGioiTinh())), p.getSdt(), p.getCmnd(), p.getEmail(), p.getDiachi()};
                                dtmDanhSach.addRow(dataRow);
                            }
                        }else{
                            List<staff> lisst = staffdao.get(c);
                            for (staff p : lisst) {
                                dataRow = new Object[]{p.getMaNV(), p.getMaBP(), p.getTenNV(), p.getNgaySinh(), staffdao.doiGT(String.valueOf(p.getGioiTinh())), p.getSdt(), p.getCmnd(), p.getEmail(), p.getDiachi()};
                                dtmDanhSach.addRow(dataRow);
                            }
                            
                        }
                        
                    }
                    tblNV.setModel(dtmDanhSach);
                }
            }
        });
    }
}
