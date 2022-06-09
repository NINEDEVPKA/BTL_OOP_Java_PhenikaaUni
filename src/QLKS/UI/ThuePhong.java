/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.UI;

//import QLKS.Login.login;
import QLKS.controller.DatPhongDao;
import QLKS.controller.HoaDonDao;
import QLKS.controller.ThongTinPhongDao;
import QLKS.controller.ThuePhongDao;
import QLKS.model.Datphong;
import QLKS.model.HoaDon;
import QLKS.model.Phong;
import QLKS.model.customer;
import QLKS.model.staff;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tan_Tan_Chin 
 */
public class ThuePhong extends javax.swing.JFrame {

    /**
     * Creates new form ThuePhong
     */
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    int demDatPhong;
    int demMaHD;
    int checkSoNg;
    DefaultTableModel dtmDanhSachPhong;
    DefaultTableModel dtmDanhSachDatPhong;
    DefaultTableModel dtmDanhSachThuePhong;
    Phong p = new Phong();
    String idUpdaePhong = "";
    String getIDDatPhong = "";
    String getMaHD = "";
    ThongTinPhongDao phongDao = new ThongTinPhongDao();
    DatPhongDao datPhongDao = new DatPhongDao();
    ThuePhongDao thuePhongDao = new ThuePhongDao();

    public ThuePhong() {
        initComponents();
        loadPhongToJTable();
        loadDatPhongPhongToJTable();
        loadThưePhongToJTable();

        Date today = new Date();
        dateNgaySinh1.setModel(new SpinnerDateModel(today, null, null, Calendar.MONTH));
        dateNgaySinh2.setModel(new SpinnerDateModel(today, null, null, Calendar.MONTH));
        JSpinner.DateEditor editor = new JSpinner.DateEditor(dateNgaySinh1, "dd/MM/yyyy");
        dateNgaySinh1.setEditor(editor);
        JSpinner.DateEditor editors = new JSpinner.DateEditor(dateNgaySinh2, "dd/MM/yyyy");
        dateNgaySinh2.setEditor(editors);

        addMaNV();
        addMaKH();
        Clear();

    }

    public void Clear() {
        txtIDDatPhong1.setEnabled(false);
        txtIDDatPhong2.setEnabled(false);
        txtMaPhong1.setText("");
        txtMaPhong2.setText("");
        txtTenPhong1.setText("");
        txtIDDatPhong1.setText("");
        txtTenKH1.setText("");
        txtTenNV1.setText("");
        txtSoNg1.setText("");
        txtDatCoc1.setText("");
        txtTenPhong2.setText("");
        txtIDDatPhong2.setText("");
        txtTenKH2.setText("");
        txtTenNV2.setText("");
        txtSoNg2.setText("");
        txtDatCoc2.setText("");
        txtTenKH1.setEnabled(false);
        txtTenNV1.setEnabled(false);
        txtTenKH2.setEnabled(false);
        txtTenNV2.setEnabled(false);
        dateNgaySinh1.setEnabled(false);
        dateNgaySinh2.setEnabled(false);

        txtMaPhong1.setEnabled(false);
        txtMaPhong2.setEnabled(false);
        txtTenPhong1.setEnabled(false);
        txtTenPhong2.setEnabled(false);
        btnThem1.setEnabled(false);

        btnSua1.setEnabled(false);
        btnXoa1.setEnabled(false);
        btnReset1.setEnabled(true);
        btnThem2.setEnabled(false);
        btnSua2.setEnabled(false);
        btnXoa2.setEnabled(false);
        btnReset2.setEnabled(false);
    }

    public void SetIDDatPhong() {

        for (Datphong dp : thuePhongDao.getListIDDatPhong()) {
            if (demDatPhong == 0) {
                getIDDatPhong = "dp000";
            }

            getIDDatPhong = dp.getID_DatPhong();

        }
        demDatPhong = datPhongDao.CoutDatPhong();

    }

    public void SetMaHD() {

        for (HoaDon hd : datPhongDao.getListMaHD()) {
            if (demDatPhong == 0) {
                getMaHD = "hd000";
            }

            getMaHD = hd.getMaHD();

        }
        demMaHD = datPhongDao.CoutHoaDon();

    }

    public void addMaNV() {
        for (staff nv : datPhongDao.getListMaNV()) {
            cboMaNV1.addItem(nv.getMaNV());
            cboMaNV2.addItem(nv.getMaNV());

        }
        
        cboSearch1.addItem("Mã phòng");
        cboSearch1.addItem("Tên phòng");
        cboSearch1.addItem("Loại phòng");
        cboSearch1.addItem("Số người tối đa");
        cboSearch1.addItem("Giá phòng");
        cboSearch1.addItem("Trạng Thái");
        cboSearch1.setSelectedIndex(0);
        
        cboSearch2.addItem("ID đặt phòng");
        cboSearch2.addItem("Mã phòng");
        cboSearch2.addItem("Mã nhân viên");
        cboSearch2.addItem("Mã khách hàng");
        cboSearch2.addItem("Tên phòng");
        cboSearch2.addItem("Loại phòng");
        cboSearch2.addItem("Giá phòng");
        cboSearch2.setSelectedIndex(0);
    }

    public void addMaKH() {
        for (customer c : datPhongDao.getListMaKH()) {
            cboMaKH1.addItem(c.getMaKH());
            cboMaKH2.addItem(c.getMaKH());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongTinPhong = new javax.swing.JTable();
        btnSearch1 = new javax.swing.JButton();
        txtSearch1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        cboSearch1 = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblThuePhong1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtIDDatPhong1 = new javax.swing.JTextField();
        txtMaPhong1 = new javax.swing.JTextField();
        txtTenPhong1 = new javax.swing.JTextField();
        txtTenKH1 = new javax.swing.JTextField();
        txtTenNV1 = new javax.swing.JTextField();
        txtSoNg1 = new javax.swing.JTextField();
        txtDatCoc1 = new javax.swing.JTextField();
        dateNgayNhanPhong1 = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        dateNgayDatPhong1 = new javax.swing.JSpinner();
        jLabel23 = new javax.swing.JLabel();
        cboMaKH1 = new javax.swing.JComboBox<>();
        cboMaNV1 = new javax.swing.JComboBox<>();
        dateNgaySinh1 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        btnThem1 = new javax.swing.JButton();
        btnXoa1 = new javax.swing.JButton();
        btnReset1 = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        btnSua1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDatPhong = new javax.swing.JTable();
        btnSearch2 = new javax.swing.JButton();
        txtSearch2 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        cboSearch2 = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblThuePhong2 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtIDDatPhong2 = new javax.swing.JTextField();
        txtMaPhong2 = new javax.swing.JTextField();
        txtTenPhong2 = new javax.swing.JTextField();
        txtTenKH2 = new javax.swing.JTextField();
        txtTenNV2 = new javax.swing.JTextField();
        txtSoNg2 = new javax.swing.JTextField();
        txtDatCoc2 = new javax.swing.JTextField();
        dateNgayNhanPhong2 = new javax.swing.JSpinner();
        jLabel21 = new javax.swing.JLabel();
        dateNgaySinh2 = new javax.swing.JSpinner();
        dateNgayDatPhong2 = new javax.swing.JSpinner();
        jLabel22 = new javax.swing.JLabel();
        cboMaKH2 = new javax.swing.JComboBox<>();
        cboMaNV2 = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        btnThem2 = new javax.swing.JButton();
        btnSua2 = new javax.swing.JButton();
        btnXoa2 = new javax.swing.JButton();
        btnReset2 = new javax.swing.JButton();
        btnThoat2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tblThongTinPhong.setAutoCreateRowSorter(true);
        tblThongTinPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblThongTinPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThongTinPhongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblThongTinPhong);

        btnSearch1.setBackground(new java.awt.Color(0, 153, 255));
        btnSearch1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearch1.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLKS/Image/icon_search.png"))); // NOI18N
        btnSearch1.setText("Search");
        btnSearch1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch1ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Tìm kiếm :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addGap(42, 42, 42)
                .addComponent(cboSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txtSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnSearch1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(512, 512, 512))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSearch1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(cboSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thuê phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tblThuePhong1.setAutoCreateRowSorter(true);
        tblThuePhong1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblThuePhong1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThuePhong1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblThuePhong1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi Tiết Đặt Phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("ID :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Mã phòng :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Mã KH :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Ngày sinh :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Nhân viên :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Ngày thuê phòng :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Số lượng người :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Đặt cọc :");

        txtTenKH1.setEnabled(false);

        dateNgayNhanPhong1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        dateNgayNhanPhong1.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1636945899119L), null, null, java.util.Calendar.DAY_OF_WEEK));
        dateNgayNhanPhong1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                dateNgayNhanPhong1ComponentAdded(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Tên phòng");

        dateNgayDatPhong1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        dateNgayDatPhong1.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1636945899119L), null, null, java.util.Calendar.DAY_OF_WEEK));
        dateNgayDatPhong1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                dateNgayDatPhong1ComponentAdded(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Ngày đặt phòng :");

        cboMaKH1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMaKH1ActionPerformed(evt);
            }
        });

        cboMaNV1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMaNV1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("VND");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(3, 3, 3)))
                            .addComponent(jLabel8)
                            .addComponent(jLabel23))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateNgaySinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(cboMaKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTenKH1))
                                .addComponent(dateNgayNhanPhong1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtMaPhong1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIDDatPhong1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenPhong1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(dateNgayDatPhong1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(cboMaNV1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTenNV1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel9)
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoNg1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtDatCoc1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)))
                .addGap(57, 57, 57))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIDDatPhong1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaPhong1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenPhong1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cboMaKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(dateNgaySinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboMaNV1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenNV1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel7)))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addComponent(dateNgayDatPhong1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateNgayNhanPhong1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSoNg1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDatCoc1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(8, 8, 8)))
                .addGap(123, 123, 123))
        );

        jPanel9.setBackground(new java.awt.Color(0, 0, 153));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setText("THUÊ PHÒNG");
        jLabel2.setToolTipText("");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(583, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(691, 691, 691))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        btnThem1.setBackground(new java.awt.Color(0, 153, 255));
        btnThem1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThem1.setForeground(new java.awt.Color(255, 255, 255));
        btnThem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLKS/Image/iconAdd.png"))); // NOI18N
        btnThem1.setText("Thêm");
        btnThem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        btnXoa1.setBackground(new java.awt.Color(0, 153, 255));
        btnXoa1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXoa1.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLKS/Image/trash-icon.png"))); // NOI18N
        btnXoa1.setText("Xóa");
        btnXoa1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa1ActionPerformed(evt);
            }
        });

        btnReset1.setBackground(new java.awt.Color(0, 153, 255));
        btnReset1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReset1.setForeground(new java.awt.Color(255, 255, 255));
        btnReset1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLKS/Image/documents-white-edit-icon.png"))); // NOI18N
        btnReset1.setText("Nhập lại");
        btnReset1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset1ActionPerformed(evt);
            }
        });

        btnThoat.setBackground(new java.awt.Color(0, 153, 255));
        btnThoat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThoat.setForeground(new java.awt.Color(255, 255, 255));
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLKS/Image/Windows-Close-Program-icon.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnSua1.setBackground(new java.awt.Color(0, 153, 255));
        btnSua1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSua1.setForeground(new java.awt.Color(255, 255, 255));
        btnSua1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLKS/Image/iconSua.png"))); // NOI18N
        btnSua1.setText("Sửa");
        btnSua1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThoat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem1)
                .addGap(18, 18, 18)
                .addComponent(btnSua1)
                .addGap(18, 18, 18)
                .addComponent(btnXoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Khách chưa đặt phòng", jPanel1);

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tblDatPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblDatPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatPhongMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDatPhong);

        btnSearch2.setBackground(new java.awt.Color(0, 153, 255));
        btnSearch2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearch2.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLKS/Image/icon_search.png"))); // NOI18N
        btnSearch2.setText("Search");
        btnSearch2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch2ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("Tìm kiếm :");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(cboSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(txtSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnSearch2)
                .addContainerGap(182, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(btnSearch2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel8.setBackground(new java.awt.Color(204, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đặt Phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tblThuePhong2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblThuePhong2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThuePhong2MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblThuePhong2);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(204, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi Tiết Đặt Phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("ID :");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Mã phòng :");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Mã KH :");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Ngày sinh :");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Nhân viên :");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Ngày đặt phòng :");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Số lượng người :");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Đặt cọc :");

        txtMaPhong2.setEnabled(false);

        txtTenKH2.setEnabled(false);

        dateNgayNhanPhong2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        dateNgayNhanPhong2.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1636945899119L), null, null, java.util.Calendar.DAY_OF_WEEK));
        dateNgayNhanPhong2.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                dateNgayNhanPhong2ComponentAdded(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Tên phòng");

        dateNgaySinh2.setEnabled(false);

        dateNgayDatPhong2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        dateNgayDatPhong2.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1636945899119L), null, null, java.util.Calendar.DAY_OF_WEEK));
        dateNgayDatPhong2.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                dateNgayDatPhong2ComponentAdded(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Ngày thuê phòng :");

        cboMaKH2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMaKH2ActionPerformed(evt);
            }
        });

        cboMaNV2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMaNV2ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 51, 0));
        jLabel24.setText("VND");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel22)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18)
                    .addComponent(jLabel15)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel21)
                        .addComponent(jLabel14)))
                .addGap(37, 37, 37)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenPhong2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(cboMaNV2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTenNV2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtIDDatPhong2, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                        .addComponent(txtMaPhong2))
                    .addComponent(dateNgaySinh2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtDatCoc2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoNg2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateNgayNhanPhong2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateNgayDatPhong2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel24))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(cboMaKH2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenKH2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDDatPhong2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtMaPhong2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(5, 5, 5))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenPhong2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboMaKH2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenKH2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addComponent(dateNgaySinh2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(cboMaNV2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenNV2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateNgayDatPhong2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(dateNgayNhanPhong2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtSoNg2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtDatCoc2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(0, 0, 153));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("THUÊ PHÒNG");
        jLabel12.setToolTipText("");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(589, 589, 589))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel12)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(204, 255, 255));

        btnThem2.setBackground(new java.awt.Color(0, 153, 255));
        btnThem2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThem2.setForeground(new java.awt.Color(255, 255, 255));
        btnThem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLKS/Image/iconAdd.png"))); // NOI18N
        btnThem2.setText("Thêm");
        btnThem2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem2ActionPerformed(evt);
            }
        });

        btnSua2.setBackground(new java.awt.Color(0, 153, 255));
        btnSua2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSua2.setForeground(new java.awt.Color(255, 255, 255));
        btnSua2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLKS/Image/iconSua.png"))); // NOI18N
        btnSua2.setText("Sửa");
        btnSua2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua2ActionPerformed(evt);
            }
        });

        btnXoa2.setBackground(new java.awt.Color(0, 153, 255));
        btnXoa2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXoa2.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLKS/Image/trash-icon.png"))); // NOI18N
        btnXoa2.setText("Xóa");
        btnXoa2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa2ActionPerformed(evt);
            }
        });

        btnReset2.setBackground(new java.awt.Color(0, 153, 255));
        btnReset2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReset2.setForeground(new java.awt.Color(255, 255, 255));
        btnReset2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLKS/Image/documents-white-edit-icon.png"))); // NOI18N
        btnReset2.setText("Nhập lại");
        btnReset2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset2ActionPerformed(evt);
            }
        });

        btnThoat2.setBackground(new java.awt.Color(0, 153, 255));
        btnThoat2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThoat2.setForeground(new java.awt.Color(255, 255, 255));
        btnThoat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLKS/Image/Windows-Close-Program-icon.png"))); // NOI18N
        btnThoat2.setText("Thoát");
        btnThoat2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThoat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoat2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnReset2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThoat2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSua2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReset2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThoat2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Khách đã đặt phòng", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDatPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatPhongMouseClicked
        int index = tblDatPhong.getSelectedRow();
        String valueAt = (String) tblDatPhong.getValueAt(index, 0);
        Datphong pUpdate = datPhongDao.get(valueAt + "").get();
        txtIDDatPhong2.setText(pUpdate.getID_DatPhong());
        txtMaPhong2.setText(pUpdate.getMaPhong());
        cboMaKH2.getModel().setSelectedItem(pUpdate.getMaKH());
        cboMaNV2.getModel().setSelectedItem(pUpdate.getMaNV());
        txtTenPhong2.setText(pUpdate.getTenPhong());
        dateNgayDatPhong2.setValue(pUpdate.getNgayDatPhong());
        txtSoNg2.setText(pUpdate.getSoNguoi() + "");
        txtDatCoc2.setText(pUpdate.getDatCoc() + "");
        idUpdaePhong = valueAt;
        dateNgayDatPhong2.setEnabled(false);
        btnThem2.setEnabled(true);
        txtSoNg2.setEnabled(false);
        txtDatCoc2.setEnabled(false);
        cboMaKH2.setEnabled(false);
        cboMaNV2.setEnabled(false);
    }//GEN-LAST:event_tblDatPhongMouseClicked

    private void tblThuePhong2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThuePhong2MouseClicked
        int index = tblThuePhong2.getSelectedRow();
        String valueAt = (String) tblThuePhong2.getValueAt(index, 0);
        Datphong pUpdate = thuePhongDao.get(valueAt + "").get();
        txtIDDatPhong2.setText(pUpdate.getID_DatPhong());
        txtMaPhong2.setText(pUpdate.getMaPhong());
        cboMaNV2.getModel().setSelectedItem(pUpdate.getMaNV());
        cboMaKH2.getModel().setSelectedItem(pUpdate.getMaKH());

        txtTenPhong2.setText(pUpdate.getTenPhong());
        dateNgayDatPhong2.setValue(pUpdate.getNgayDatPhong());
        dateNgayNhanPhong2.setValue(pUpdate.getNgayNhanPhong());
        txtSoNg2.setText(pUpdate.getSoNguoi() + "");
        txtDatCoc2.setText(pUpdate.getDatCoc() + "");
        idUpdaePhong = valueAt;
        btnThem2.setEnabled(false);
        btnSua2.setEnabled(true);
        btnXoa2.setEnabled(true);
        btnReset2.setEnabled(true);
    }//GEN-LAST:event_tblThuePhong2MouseClicked

    private void btnThem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem2ActionPerformed

        String MaHd = "";
        int chuoi3 = 0;
        String maphong = txtMaPhong2.getText();
        Date time1 = (Date) dateNgayNhanPhong2.getValue();
        Timestamp times1 = new Timestamp(time1.getTime());
        Date time2 = (Date) dateNgayDatPhong2.getValue();
        Timestamp times2 = new Timestamp(time2.getTime());
        String MaKH = (String) cboMaKH2.getSelectedItem();

        String ID = txtIDDatPhong2.getText();
        if (thuePhongDao.updateNgayNhanPhong(new Datphong(ID, times1)) > 0) {
            if (datPhongDao.updateTrangThaiDangThue(maphong) > 0) {
                if (demMaHD == 0) {
                        MaHd = "hd000";
                    } else {
                       
                        chuoi3 = Integer.parseInt(getMaHD.substring(2));
                        if (chuoi3 + 1 < 10) {
                            MaHd = "hd00" + (chuoi3 + 1);
                        } else if (chuoi3 + 1 < 100) {
                            MaHd = "hd0" + (chuoi3 + 1);
                        }
                    }
                if (datPhongDao.insertHoaDon(new HoaDon(MaHd,ID,MaKH)) > 0) {
                 JOptionPane.showMessageDialog(rootPane, "Thêm mới thành công!");
                loadPhongToJTable();
                loadDatPhongPhongToJTable();
                loadThưePhongToJTable();
                Clear();
                }
                
                
                
                
               
            } else {
                JOptionPane.showMessageDialog(rootPane, "Thêm mới không thành công! Backend có lỗi");
            }
        }
    }//GEN-LAST:event_btnThem2ActionPerformed

    private void btnSua2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua2ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(rootPane, "Bạn thật sự muốn sửa ?", "Cảnh báo nguy hiểm", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirm == 0) {
            try {
                int song = Integer.parseInt(txtSoNg2.getText());
                checkSoNg = phongDao.getSoNgToiDa(txtMaPhong2.getText());

                String maphong = txtMaPhong2.getText();
                String MaNV = (String) cboMaNV2.getSelectedItem();
                String MaKH = (String) cboMaKH2.getSelectedItem();
                Date time1 = (Date) dateNgayNhanPhong2.getValue();
                Timestamp times1 = new Timestamp(time1.getTime());
                Date time2 = (Date) dateNgayDatPhong2.getValue();
                Timestamp times2 = new Timestamp(time2.getTime());

                float datcoc = Float.parseFloat(txtDatCoc2.getText());

                if (txtTenPhong2.getText().trim().equals("")) {
                    txtTenPhong2.requestFocus();
                    JOptionPane.showMessageDialog(rootPane, "Bạn phải nhập tên phòng");
                    return;
                } else if (txtSoNg2.getText().trim().equals("")) {
                    txtTenPhong2.requestFocus();
                    JOptionPane.showMessageDialog(rootPane, "Bạn phải nhập số người");
                    return;
                } else if (song > checkSoNg) {
                    JOptionPane.showMessageDialog(rootPane, "Bạn phải nhập số người phải nhỏ hơn số người của phòng");
                    return;
                } else {

                    String IDDatPhong = idUpdaePhong;
                    if (thuePhongDao.update(new Datphong(IDDatPhong, maphong, MaNV, MaKH, datcoc, song, times2, times1)) > 0) {
                        JOptionPane.showMessageDialog(rootPane, "Sửa thành công!");

                        loadPhongToJTable();
                        loadDatPhongPhongToJTable();
                        loadThưePhongToJTable();

                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Sửa không thành công! Backend có lỗi");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Phải nhập đúng kiểu dữ liệu giá phòng !");
            }

        } else {
        }
    }//GEN-LAST:event_btnSua2ActionPerformed

    private void btnXoa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa2ActionPerformed
        try {
            int row = -1;
            int column = 0;
            String maphong = txtMaPhong2.getText();
            row = tblThuePhong2.getSelectedRow();

            int k = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa?");
            if (k == 0) {

                if (datPhongDao.updateTrangThai(maphong) > 0) {
                    JOptionPane.showMessageDialog(null, " Xóa dữ liệu thành công!");
                }
            }
            loadPhongToJTable();
            loadDatPhongPhongToJTable();
            loadThưePhongToJTable();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Bạn phải chọn dữ liệu để xóa!");
        }
    }//GEN-LAST:event_btnXoa2ActionPerformed

    private void dateNgayNhanPhong2ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_dateNgayNhanPhong2ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_dateNgayNhanPhong2ComponentAdded

    private void dateNgayDatPhong2ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_dateNgayDatPhong2ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_dateNgayDatPhong2ComponentAdded

    private void cboMaKH2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaKH2ActionPerformed
        String tenKH = (String) cboMaKH2.getSelectedItem();
        txtTenKH2.setText(datPhongDao.getTenKH(tenKH));
        dateNgaySinh2.setValue(datPhongDao.getNgaySinh(tenKH));


    }//GEN-LAST:event_cboMaKH2ActionPerformed

    private void cboMaNV2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaNV2ActionPerformed
        String tenNV = (String) cboMaNV2.getSelectedItem();
        txtTenNV2.setText(datPhongDao.getTenNV(tenNV));
    }//GEN-LAST:event_cboMaNV2ActionPerformed

    private void btnReset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset2ActionPerformed
        Clear();
    }//GEN-LAST:event_btnReset2ActionPerformed

    private void btnThoat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoat2ActionPerformed
        int anw = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn thoát không!", "Cảnh báo!", JOptionPane.YES_NO_OPTION);
        if (anw == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnThoat2ActionPerformed

    private void btnSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch2ActionPerformed
       String txtSearch = this.txtSearch2.getText();
        String colName = (String) this.cboSearch2.getSelectedItem();
        Vector row = null;
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID đặt phòng");
        model.addColumn("Mã phòng");
        model.addColumn("Mã NV");
        model.addColumn("Mã KH");
        model.addColumn("Tên phòng");
        model.addColumn("Loại phòng");
        model.addColumn("Giá phòng");
        model.addColumn("Số người");
        model.addColumn("Ngày đặt phòng");
        model.addColumn("Trạng thái");
        {
            Datphong dp;
            for (int i = 0; i < datPhongDao.find(txtSearch, colName).size(); i++) {
                dp = datPhongDao.find(txtSearch, colName).get(i);
                row = new Vector();
                row.add(dp.getID_DatPhong());
                row.add(dp.getMaPhong());
                row.add(dp.getMaNV());
                row.add(dp.getMaKH());
                row.add(dp.getTenPhong());
                row.add(dp.getLoaiPhong());     
                row.add(dp.getGiaPhong());
                row.add(dp.getSoNguoi());
                row.add(dp.getNgayDatPhong());
                row.add(dp.getTinhTrangPhong());     
                model.addRow(row);
            }
            tblDatPhong.setModel(model);
        }
    }//GEN-LAST:event_btnSearch2ActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed

        this.dispose();
        //login.h.setVisible(true);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void cboMaNV1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaNV1ActionPerformed
        String tenNV = (String) cboMaNV1.getSelectedItem();
        txtTenNV1.setText(datPhongDao.getTenNV(tenNV));
    }//GEN-LAST:event_cboMaNV1ActionPerformed

    private void cboMaKH1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaKH1ActionPerformed
        String tenKH = (String) cboMaKH1.getSelectedItem();
        txtTenKH1.setText(datPhongDao.getTenKH(tenKH));
        dateNgaySinh1.setValue(datPhongDao.getNgaySinh(tenKH));
    }//GEN-LAST:event_cboMaKH1ActionPerformed

    private void dateNgayDatPhong1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_dateNgayDatPhong1ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_dateNgayDatPhong1ComponentAdded

    private void dateNgayNhanPhong1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_dateNgayNhanPhong1ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_dateNgayNhanPhong1ComponentAdded

    private void btnReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset1ActionPerformed
        Clear();
    }//GEN-LAST:event_btnReset1ActionPerformed

    private void btnXoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa1ActionPerformed
        try {
            int row = -1;
            int column = 0;
            String maphong = txtMaPhong1.getText();
            row = tblThuePhong1.getSelectedRow();
            String value = tblThuePhong1.getModel().getValueAt(row, column).toString();
            int k = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa?");
            if (k == 0) {
                datPhongDao.delete(value);

                if (datPhongDao.updateTrangThaiTrong(maphong) > 0) {
                    JOptionPane.showMessageDialog(null, " Xóa dữ liệu thành công!");
                }
            }
            loadPhongToJTable();
            loadDatPhongPhongToJTable();
            loadThưePhongToJTable();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Bạn phải chọn dữ liệu để xóa!");
        }
    }//GEN-LAST:event_btnXoa1ActionPerformed

    private void btnSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua1ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(rootPane, "Bạn thật sự muốn sửa ?", "Cảnh báo nguy hiểm", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirm == 0) {
            try {
                int song = Integer.parseInt(txtSoNg1.getText());
                checkSoNg = phongDao.getSoNgToiDa(txtMaPhong1.getText());

                String maphong = txtMaPhong1.getText();
                String MaNV = (String) cboMaNV1.getSelectedItem();
                String MaKH = (String) cboMaKH1.getSelectedItem();
                Date time1 = (Date) dateNgayNhanPhong1.getValue();
                Timestamp times1 = new Timestamp(time1.getTime());
                Date time2 = (Date) dateNgayDatPhong1.getValue();
                Timestamp times2 = new Timestamp(time2.getTime());

                float datcoc = Float.parseFloat(txtDatCoc1.getText());

                String IDDatPhong = idUpdaePhong;
                if (thuePhongDao.update(new Datphong(IDDatPhong, maphong, MaNV, MaKH, datcoc, song, times1, times1)) > 0) {
                    JOptionPane.showMessageDialog(rootPane, "Sửa thành công!");

                    loadPhongToJTable();
                    loadDatPhongPhongToJTable();
                    loadThưePhongToJTable();

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Sửa không thành công! Backend có lỗi");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Phải nhập đúng kiểu dữ liệu giá phòng !");
            }
        } else {
        }
    }//GEN-LAST:event_btnSua1ActionPerformed

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        String idDatPhong = "";
        String MaHd = "";
        int chuoi2 = 0;
        int chuoi3= 0;
        int song = Integer.parseInt(txtSoNg1.getText());
        checkSoNg = phongDao.getSoNgToiDa(txtMaPhong1.getText());

        String maphong = txtMaPhong1.getText();
        String MaNV = (String) cboMaNV1.getSelectedItem();
        String MaKH = (String) cboMaKH1.getSelectedItem();
        Date time1 = (Date) dateNgayNhanPhong1.getValue();
        Timestamp times1 = new Timestamp(time1.getTime());
        Date time2 = (Date) dateNgayDatPhong1.getValue();
        Timestamp times2 = new Timestamp(time2.getTime());

        float datcoc = Float.parseFloat(txtDatCoc1.getText());

        if (demDatPhong == 0) {
            idDatPhong = "dp000";
        } else {
            System.out.println(getIDDatPhong);
            chuoi2 = Integer.parseInt(getIDDatPhong.substring(2));
            if (chuoi2 + 1 < 10) {
                idDatPhong = "dp00" + (chuoi2 + 1);
            } else if (chuoi2 + 1 < 100) {
                idDatPhong = "dp0" + (chuoi2 + 1);
            }
        }
        if (txtTenPhong1.getText().trim().equals("")) {
            txtTenPhong1.requestFocus();
            JOptionPane.showMessageDialog(rootPane, "Bạn phải nhập tên phòng");
            return;
        } else if (txtSoNg1.getText().trim().equals("")) {
            txtTenPhong1.requestFocus();
            JOptionPane.showMessageDialog(rootPane, "Bạn phải nhập số người");
            return;
        } else if (song > checkSoNg) {
            JOptionPane.showMessageDialog(rootPane, "Bạn phải nhập số người phải nhỏ hơn số người của phòng");
            return;
        } else {

            if (thuePhongDao.insert(new Datphong(idDatPhong, maphong, MaNV, MaKH, datcoc, song, times1, times1)) > 0) {
                if (datPhongDao.updateTrangThaiDangThue(maphong) > 0) {
                    if (demMaHD == 0) {
                        MaHd = "hd000";
                    } else {

                        chuoi3 = Integer.parseInt(getMaHD.substring(2));
                        if (chuoi3 + 1 < 10) {
                            MaHd = "hd00" + (chuoi3 + 1);
                        } else if (chuoi3 + 1 < 100) {
                            MaHd = "hd0" + (chuoi3 + 1);
                        }
                    }

                    if (datPhongDao.insertHoaDon(new HoaDon(MaHd,idDatPhong,MaKH)) > 0) {
                        JOptionPane.showMessageDialog(rootPane, "Thêm mới thành công!");
                        loadPhongToJTable();
                        loadDatPhongPhongToJTable();
                        loadThưePhongToJTable();
                        Clear();
                    } else {

                    }

                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Thêm mới không thành công! Backend có lỗi");
            }
        }
    }//GEN-LAST:event_btnThem1ActionPerformed

    private void tblThuePhong1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThuePhong1MouseClicked
        int index = tblThuePhong1.getSelectedRow();
        String valueAt = (String) tblThuePhong1.getValueAt(index, 0);
        Datphong pUpdate = thuePhongDao.get(valueAt + "").get();
        txtIDDatPhong1.setText(pUpdate.getID_DatPhong());
        txtMaPhong1.setText(pUpdate.getMaPhong());
        cboMaNV1.getModel().setSelectedItem(pUpdate.getMaNV());
        cboMaKH1.getModel().setSelectedItem(pUpdate.getMaKH());

        txtTenPhong1.setText(pUpdate.getTenPhong());
        dateNgayDatPhong1.setValue(pUpdate.getNgayDatPhong());
        dateNgayNhanPhong1.setValue(pUpdate.getNgayNhanPhong());
        txtSoNg1.setText(pUpdate.getSoNguoi() + "");
        txtDatCoc1.setText(pUpdate.getDatCoc() + "");
        idUpdaePhong = valueAt;
        btnThem1.setEnabled(false);
        btnSua1.setEnabled(true);
        btnXoa1.setEnabled(true);
        btnReset1.setEnabled(true);
    }//GEN-LAST:event_tblThuePhong1MouseClicked

    private void btnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch1ActionPerformed
        String txtSearch = this.txtSearch1.getText();
        String colName = (String) this.cboSearch1.getSelectedItem();
        Vector row = null;
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã phòng");
        model.addColumn("Tên phòng");
        model.addColumn("Loại phòng");
        model.addColumn("Số người tối đa");
        model.addColumn("Giá phòng");
        model.addColumn("Trạng thái");

        {
            Phong p;
            for (int i = 0; i < phongDao.find(txtSearch, colName).size(); i++) {
                p = phongDao.find(txtSearch, colName).get(i);
                row = new Vector();
                row.add(p.getMaPhong());
                row.add(p.getTenPhong());
                row.add(p.getLoaiPhong());
                row.add(p.getSoNguoiToiDa());
                row.add(p.getGiaPhong());
                row.add(p.getTinhTrangPhong());
                model.addRow(row);
            }
            tblThongTinPhong.setModel(model);
        }
    }//GEN-LAST:event_btnSearch1ActionPerformed

    private void tblThongTinPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongTinPhongMouseClicked
        int index = tblThongTinPhong.getSelectedRow();
        String valueAt = (String) tblThongTinPhong.getValueAt(index, 0);
        Phong pUpdate = phongDao.get(valueAt + "").get();
        txtMaPhong1.setText(pUpdate.getMaPhong());
        txtTenPhong1.setText(pUpdate.getTenPhong());

        idUpdaePhong = valueAt;
        dateNgayDatPhong1.setEnabled(false);
        btnThem1.setEnabled(true);
        btnSua1.setEnabled(false);
        btnXoa1.setEnabled(false);
        btnReset1.setEnabled(true);
    }//GEN-LAST:event_tblThongTinPhongMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThuePhong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset1;
    private javax.swing.JButton btnReset2;
    private javax.swing.JButton btnSearch1;
    private javax.swing.JButton btnSearch2;
    private javax.swing.JButton btnSua1;
    private javax.swing.JButton btnSua2;
    private javax.swing.JButton btnThem1;
    private javax.swing.JButton btnThem2;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnThoat2;
    private javax.swing.JButton btnXoa1;
    private javax.swing.JButton btnXoa2;
    private javax.swing.JComboBox<String> cboMaKH1;
    private javax.swing.JComboBox<String> cboMaKH2;
    private javax.swing.JComboBox<String> cboMaNV1;
    private javax.swing.JComboBox<String> cboMaNV2;
    private javax.swing.JComboBox<String> cboSearch1;
    private javax.swing.JComboBox<String> cboSearch2;
    private javax.swing.JSpinner dateNgayDatPhong1;
    private javax.swing.JSpinner dateNgayDatPhong2;
    private javax.swing.JSpinner dateNgayNhanPhong1;
    private javax.swing.JSpinner dateNgayNhanPhong2;
    private javax.swing.JSpinner dateNgaySinh1;
    private javax.swing.JSpinner dateNgaySinh2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblDatPhong;
    private javax.swing.JTable tblThongTinPhong;
    private javax.swing.JTable tblThuePhong1;
    private javax.swing.JTable tblThuePhong2;
    private javax.swing.JTextField txtDatCoc1;
    private javax.swing.JTextField txtDatCoc2;
    private javax.swing.JTextField txtIDDatPhong1;
    private javax.swing.JTextField txtIDDatPhong2;
    private javax.swing.JTextField txtMaPhong1;
    private javax.swing.JTextField txtMaPhong2;
    private javax.swing.JTextField txtSearch1;
    private javax.swing.JTextField txtSearch2;
    private javax.swing.JTextField txtSoNg1;
    private javax.swing.JTextField txtSoNg2;
    private javax.swing.JTextField txtTenKH1;
    private javax.swing.JTextField txtTenKH2;
    private javax.swing.JTextField txtTenNV1;
    private javax.swing.JTextField txtTenNV2;
    private javax.swing.JTextField txtTenPhong1;
    private javax.swing.JTextField txtTenPhong2;
    // End of variables declaration//GEN-END:variables
private void loadPhongToJTable() {
        SetIDDatPhong();

        dtmDanhSachPhong = new DefaultTableModel();
        String[] columnTitle = {"Mã phòng", "Tên phòng", "Loại phòng", "Mô tả phòng", "Số người tối đa", "Giá phòng", "Trạng thái"};
        dtmDanhSachPhong.setColumnIdentifiers(columnTitle);
        Object[] dataRow;

        List<Phong> lisPhong = datPhongDao.getAllPhong();
        for (Phong p : lisPhong) {
            dataRow = new Object[]{p.getMaPhong(), p.getTenPhong(), p.getLoaiPhong(), p.getMoTaPhong(), p.getSoNguoiToiDa(), p.getGiaPhong(), p.getTinhTrangPhong()};
            dtmDanhSachPhong.addRow(dataRow);
        }
        tblThongTinPhong.setModel(dtmDanhSachPhong);

    }

    private void loadDatPhongPhongToJTable() {
        dtmDanhSachDatPhong = new DefaultTableModel();
        String[] columnTitle = {"ID Đặt phòng", "Mã phòng", "Mã nhân viên", "Mã khách hàng", "Tên phòng", "Loại phòng", "Giá phòng", "Đặt cọc", "Số người", "Ngày đặt phòng", "Trạng thái"};
        dtmDanhSachDatPhong.setColumnIdentifiers(columnTitle);
        Object[] dataRow;

        List<Datphong> listDatPhong = datPhongDao.getAll();
        for (Datphong dp : listDatPhong) {
            dataRow = new Object[]{dp.getID_DatPhong(), dp.getMaPhong(), dp.getMaNV(), dp.getMaKH(), dp.getTenPhong(), dp.getLoaiPhong(), dp.getGiaPhong(), dp.getDatCoc(), dp.getSoNguoi(), dp.getNgayDatPhong(), dp.getTinhTrangPhong()};
            dtmDanhSachDatPhong.addRow(dataRow);
        }
        tblDatPhong.setModel(dtmDanhSachDatPhong);

    }

    private void loadThưePhongToJTable() {
        SetMaHD();
        dtmDanhSachThuePhong = new DefaultTableModel();
        String[] columnTitle = {"ID Đặt phòng", "Mã phòng", "Mã nhân viên", "Mã khách hàng", "Tên phòng", "Loại phòng", "Giá phòng", "Đặt cọc", "Số người", "Ngày đặt phòng", "Ngày nhận phòng", "Trạng thái"};
        dtmDanhSachThuePhong.setColumnIdentifiers(columnTitle);
        Object[] dataRow;

        List<Datphong> listThuePhong = thuePhongDao.getAllThuePhong();
        for (Datphong dp : listThuePhong) {
            dataRow = new Object[]{dp.getID_DatPhong(), dp.getMaPhong(), dp.getMaNV(), dp.getMaKH(), dp.getTenPhong(), dp.getLoaiPhong(), dp.getGiaPhong(), dp.getDatCoc(), dp.getSoNguoi(), dp.getNgayDatPhong(), dp.getNgayNhanPhong(), dp.getTinhTrangPhong()};
            dtmDanhSachThuePhong.addRow(dataRow);
        }
        tblThuePhong1.setModel(dtmDanhSachThuePhong);
        tblThuePhong2.setModel(dtmDanhSachThuePhong);

    }

}
