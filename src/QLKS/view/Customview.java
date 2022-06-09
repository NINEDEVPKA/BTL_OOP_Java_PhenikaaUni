/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.view;

//import QLKS.Chart.ChartStaf;

//import QLKS.Home.pnLeft;
//import QLKS.Login.login;
import QLKS.controller.CustomerDao;
import QLKS.controller.StaffDao;
//import QLKS.controller.Xuatexcel;
import QLKS.controller.bophanDao;
import QLKS.model.bophan;
import QLKS.model.customer;
//import QLKS.model.staff;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import static javafx.util.Duration.millis;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TTC
 */
public class Customview extends javax.swing.JFrame {
    String idUpdae ="";
    
    /**
     * Creates new form Menu
     */
    public Customview(){
        initComponents();
        
        
        long millis=System.currentTimeMillis();   
        java.sql.Date date=new java.sql.Date(millis);   
        txtNgaySinh.setDate(date);
        txtMaKH.requestFocusInWindow();
        tblKH.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        setExtendedState(MAXIMIZED_BOTH);
        buttonGroup1.add(rdoNu);
        buttonGroup1.add(rdoNam);
        rdoNam.setSelected(true);
        btnS.setEnabled(false);
        btnX.setEnabled(false);
        
        loadTable();
        //Sự kiện click vào 1 dong trong table
        tblKH.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtMaKH.setEnabled(false);
                btnT.setEnabled(false);
                btnS.setEnabled(true);
                btnX.setEnabled(true);
                int index = tblKH.getSelectedRow();
                String valueAt = (String) tblKH.getValueAt(index, 0);
                customer pUpdate = customerdao.get(valueAt+"").get();
                
                txtMaKH.setText(pUpdate.getMaKH());
                txtemail.setText(pUpdate.getEmail());
                txtSDT.setText(pUpdate.getSdt());
                txtCMND.setText(pUpdate.getCmnd());
                txtTenKH.setText(pUpdate.getTenKH());
                txtDC.setText(pUpdate.getDiachi());
                try {
                    txtNgaySinh.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(pUpdate.getNgaySinh()));
                } catch (ParseException ex) {
                    Logger.getLogger(Customview.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(pUpdate.getGioiTinh()==1){
                    rdoNam.setSelected(true);
                }else
                    rdoNu.setSelected(true);
                
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
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    void setlabel(){
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnBorder1 = new QLKS.Home.pnBorder();
        pnSearch = new javax.swing.JPanel();
        iconSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        pnBorder2 = new QLKS.Home.pnBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKH = new javax.swing.JTable();
        pnBorder3 = new QLKS.Home.pnBorder();
        lblerro = new javax.swing.JLabel();
        btnS = new javax.swing.JButton();
        btnX = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnT = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pnBorder5 = new QLKS.Home.pnBorder();
        jLabel4 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        rdoNu = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý nhân viên");

        pnBorder1.setBackground(new java.awt.Color(0, 0, 153));

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
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1358, 1358, 1358))
        );
        pnSearchLayout.setVerticalGroup(
            pnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnSearchLayout.createSequentialGroup()
                .addGroup(pnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iconSearch))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pnBorder2.setBackground(new java.awt.Color(255, 255, 255));
        pnBorder2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách khách hàng"));

        tblKH.setAutoCreateRowSorter(true);
        tblKH.setBackground(new java.awt.Color(204, 255, 255));
        tblKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblKH);

        javax.swing.GroupLayout pnBorder2Layout = new javax.swing.GroupLayout(pnBorder2);
        pnBorder2.setLayout(pnBorder2Layout);
        pnBorder2Layout.setHorizontalGroup(
            pnBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnBorder2Layout.setVerticalGroup(
            pnBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))
        );

        pnBorder3.setBackground(new java.awt.Color(255, 255, 255));
        pnBorder3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblerro.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        lblerro.setForeground(new java.awt.Color(255, 0, 0));
        lblerro.setText(" ");

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

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/quay_lai_35.png"))); // NOI18N
        btnReset.setText("Nhập lại");
        btnReset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add_35_gradian.png"))); // NOI18N
        btnT.setText("Thêm");
        btnT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBorder3Layout = new javax.swing.GroupLayout(pnBorder3);
        pnBorder3.setLayout(pnBorder3Layout);
        pnBorder3Layout.setHorizontalGroup(
            pnBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBorder3Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addGroup(pnBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblerro)
                    .addGroup(pnBorder3Layout.createSequentialGroup()
                        .addComponent(btnT, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131)
                        .addComponent(btnS, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141)
                        .addComponent(btnX, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnBorder3Layout.setVerticalGroup(
            pnBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBorder3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnX, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnS, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnT, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblerro)
                .addGap(0, 0, Short.MAX_VALUE))
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

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 51));
        jLabel1.setText("QUẢN LÝ KHÁCH HÀNG");

        pnBorder5.setBackground(new java.awt.Color(204, 255, 255));
        pnBorder5.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết khách hàng"));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Họ và tên:");

        txtemail.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtemail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Ngày sinh:");

        txtDC.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtDC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Giới tính:");

        rdoNam.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rdoNam.setForeground(new java.awt.Color(51, 51, 51));
        rdoNam.setText("Nam");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Số điện thoại:");

        rdoNu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rdoNu.setForeground(new java.awt.Color(51, 51, 51));
        rdoNu.setText("Nữ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("CMND:");

        txtNgaySinh.setDateFormatString("yyyy/MM/dd");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Email:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Địa chỉ:");

        txtMaKH.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtMaKH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKHActionPerformed(evt);
            }
        });

        txtTenKH.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTenKH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtSDT.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtSDT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Mã khách hàng:");

        txtCMND.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtCMND.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnBorder5Layout = new javax.swing.GroupLayout(pnBorder5);
        pnBorder5.setLayout(pnBorder5Layout);
        pnBorder5Layout.setHorizontalGroup(
            pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBorder5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBorder5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBorder5Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBorder5Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(64, 64, 64)
                                .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBorder5Layout.createSequentialGroup()
                        .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnBorder5Layout.createSequentialGroup()
                                .addComponent(rdoNam)
                                .addGap(42, 42, 42)
                                .addComponent(rdoNu))
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(294, 294, 294)
                .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnBorder5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnBorder5Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addGap(87, 87, 87)
                        .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDC, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(372, 372, 372))
        );
        pnBorder5Layout.setVerticalGroup(
            pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBorder5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBorder5Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(pnBorder5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDC, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout pnBorder1Layout = new javax.swing.GroupLayout(pnBorder1);
        pnBorder1.setLayout(pnBorder1Layout);
        pnBorder1Layout.setHorizontalGroup(
            pnBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBorder1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(pnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBorder1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(552, 552, 552))
            .addGroup(pnBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnBorder5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnBorder1Layout.setVerticalGroup(
            pnBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBorder1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(pnBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnBorder5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 1528, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
    bophanview nbpv ;    bophanview nbpv2;
    private Boolean checkMa(String ma){
        List<customer> list = new ArrayList<>();
        list = customerdao.getAll();
        for (customer b : list) {
            if(ma.equals(b.getMaKH())){
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
    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKHActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void btnSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSActionPerformed
        lblerro.setText("");
        if (txtMaKH.getText().equals("")) {
            lblerro.setText("Hãy điền mã khách hàng");
        } else if(txtTenKH.getText().equals("")){
            lblerro.setText("Hãy điền tên khách hàng");
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
            int result = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn sửa khách hàng này không?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){

                String dd=df.format(txtNgaySinh.getDate());

                customer newcustomer = new customer(txtMaKH.getText(), txtTenKH.getText(),dd , checkGT(),txtSDT.getText(), txtCMND.getText(), txtemail.getText(), txtDC.getText());
                int a = customerdao.update(newcustomer);
                if (a==1) {
                    JOptionPane.showMessageDialog(this,"Sửa mới một khách hàng thành công!","Thêm mới khách hàng.",JOptionPane.INFORMATION_MESSAGE);
                    lblerro.setText("");
                    loadTable();
                }else
                JOptionPane.showMessageDialog(this,"Sửa mới một khách hàng thất bại!","Thêm mới khách hàng.",JOptionPane.INFORMATION_MESSAGE);

            }

        }
    }//GEN-LAST:event_btnSActionPerformed

    private void btnXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXActionPerformed
        int result = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn xoá khách hàng này không?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION){

            int a = customerdao.delete(txtMaKH.getText());
            if (a==1) {
                JOptionPane.showMessageDialog(this,"Xóa một khách hàng thành công!","Xóa khách hàng.",JOptionPane.INFORMATION_MESSAGE);
                lblerro.setText("");
                loadTable();
            }else
            JOptionPane.showMessageDialog(this,"Xóa một khách hàng thất bại!","Xóa khách hàng.",JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_btnXActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        this.dispose();
       // login.h.setVisible(true);   
    }//GEN-LAST:event_btnexitActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        
        loadTable();
        btnT.setEnabled(true);
        btnS.setEnabled(false);
        btnX.setEnabled(false);
        txtMaKH.setText("");
        txtSDT.setText("");
        txtCMND.setText("");
        txtemail.setText("");
        txtDC.setText("");
        txtTenKH.setText("");
        rdoNam.setSelected(true);
        long millis=System.currentTimeMillis();   
        java.sql.Date date=new java.sql.Date(millis);   
        txtNgaySinh.setDate(date);

    }//GEN-LAST:event_btnResetActionPerformed

    private void btnTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTActionPerformed
        lblerro.setText("");

        if (txtMaKH.getText().equals("")) {
            lblerro.setText("Hãy điền mã khách hàng");
        } else if(checkMa(txtMaKH.getText())==true){
            lblerro.setText("Mã khách hàng bị trùng");
        } else if(txtTenKH.getText().equals("")){
            lblerro.setText("Hãy điền tên khách hàng");
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
            int result = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn thêm mới khách hàng này không?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){

                String dd=df.format(txtNgaySinh.getDate());

                customer newcustomer = new customer(txtMaKH.getText(), txtTenKH.getText(),dd , checkGT(),txtSDT.getText(), txtCMND.getText(), txtemail.getText(), txtDC.getText());
                int a = customerdao.insert(newcustomer);
                if (a==1) {
                    JOptionPane.showMessageDialog(this,"Thêm mới một khách hàng thành công!","Thêm mới khách hàng.",JOptionPane.INFORMATION_MESSAGE);
                    lblerro.setText("");
                    loadTable();
                }else
                JOptionPane.showMessageDialog(this,"Thêm mới một khách hàng thất bại!","Thêm mới khách hàng.",JOptionPane.INFORMATION_MESSAGE);

            }

        }
    }//GEN-LAST:event_btnTActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> {
            
            new Customview().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnS;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnT;
    private javax.swing.JButton btnX;
    private javax.swing.JButton btnexit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel iconSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblerro;
    private QLKS.Home.pnBorder pnBorder1;
    private QLKS.Home.pnBorder pnBorder2;
    private QLKS.Home.pnBorder pnBorder3;
    private QLKS.Home.pnBorder pnBorder5;
    private javax.swing.JPanel pnSearch;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblKH;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtDC;
    private javax.swing.JTextField txtMaKH;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtemail;
    // End of variables declaration//GEN-END:variables
    //Load dư liêu vao list
    private DefaultListModel<bophan> dlmBP;
    public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private bophanDao std = new bophanDao();
    private StaffDao staffdao = new StaffDao();
    
    //Load dữ liệu vào bảng
    DefaultTableModel dtmDanhSach;
    CustomerDao customerdao = new CustomerDao();
    private void loadTable(){
        dtmDanhSach = new DefaultTableModel();
        String[] columnTitle = {"Mã khách hàng",  "Tên khách hàng", "Ngày sinh", "Giới tính", "Số điện thoại","CMND","Email","Địa chỉ"};
        dtmDanhSach.setColumnIdentifiers(columnTitle);
        Object[] dataRow;
        List<customer> liscustomer = customerdao.getAll();
        for (customer p : liscustomer) {

            dataRow = new Object[]{p.getMaKH(),  p.getTenKH(), p.getNgaySinh(), staffdao.doiGT(String.valueOf(p.getGioiTinh())), p.getSdt(), p.getCmnd(), p.getEmail(), p.getDiachi()};
            dtmDanhSach.addRow(dataRow);
        }

        tblKH.setModel(dtmDanhSach);
        
        
        tblKH.getColumnModel().getColumn(0).setPreferredWidth(15);
        tblKH.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblKH.getColumnModel().getColumn(2).setPreferredWidth(25);
        tblKH.getColumnModel().getColumn(3).setPreferredWidth(5);
        tblKH.getColumnModel().getColumn(4).setPreferredWidth(50);
        tblKH.getColumnModel().getColumn(5).setPreferredWidth(50);
        tblKH.getColumnModel().getColumn(6).setPreferredWidth(90);
        tblKH.getColumnModel().getColumn(7).setPreferredWidth(50);

        
    }
    private void loadTable(String key){
        dtmDanhSach = new DefaultTableModel();
        String[] columnTitle = {"Mã khách hàng",  "Tên khách hàng", "Ngày sinh", "Giới tính", "Số điện thoại","CMND","Email","Địa chỉ"};
        dtmDanhSach.setColumnIdentifiers(columnTitle);
        Object[] dataRow;
        List<customer> liscustomer = customerdao.getAll(key);
        for (customer p : liscustomer) {

            dataRow = new Object[]{p.getMaKH(), p.getTenKH(), p.getNgaySinh(), staffdao.doiGT(String.valueOf(p.getGioiTinh())), p.getSdt(), p.getCmnd(), p.getEmail(), p.getDiachi()};
            dtmDanhSach.addRow(dataRow);
        }

        tblKH.setModel(dtmDanhSach);
        
        
        tblKH.getColumnModel().getColumn(0).setPreferredWidth(15);
        tblKH.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblKH.getColumnModel().getColumn(2).setPreferredWidth(25);
        tblKH.getColumnModel().getColumn(3).setPreferredWidth(5);
        tblKH.getColumnModel().getColumn(4).setPreferredWidth(50);
        tblKH.getColumnModel().getColumn(5).setPreferredWidth(50);
        tblKH.getColumnModel().getColumn(6).setPreferredWidth(90);
        tblKH.getColumnModel().getColumn(7).setPreferredWidth(50);

        
    }
}
