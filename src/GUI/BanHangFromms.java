/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
import Entity.*;
import DAO.*;
import java.awt.Color;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import GUI.HomeFrom;

/**
 *
 * @author User
 */
public class BanHangFromms extends javax.swing.JPanel implements ActionListener {

    /**
     * Creates new form BanHangFromms
     */
    int t, IconIndex1 = 0, idhang = 0;
    int f = -1;
    int a;
    float b;
    String k = "Người tạo" + utils.Auth.user + "/n";
    String update ="Đã up date Trạng Thái Lúc"+ utils.XDate.now();
    TheLoaiDAO tlDao = new TheLoaiDAO();
    TheLoaiSachDAO tlsDao = new TheLoaiSachDAO();
    HoaDonDAO hdD = new HoaDonDAO();
    CTSachDAO CTSD = new CTSachDAO();
    SachDAO sD = new SachDAO();
    TKDAO dao = new TKDAO();
    List<TheLoai> listTL = tlDao.selecALL();
    List<TheLoaiSach> listTLS = tlsDao.selecALL();
    List<Sach> listS;
    List<CTSach> list;
    List<HoaDon> listHD;
    int x, y;
    CTHoaDonDAO ctD = new CTHoaDonDAO();
    List<CTHoaDon> listCT;
    KhachHangDAO khDao = new KhachHangDAO();
    List<KhachHang> listkh;

    public BanHangFromms() {
        initComponents();
        listS = sD.selecALL();
        list = CTSD.selecALL();
        listHD = hdD.selectHDChuaTT();
        listkh = khDao.selecALL();
        addArrayButtonHh();
        addIcon();
        addArrayButtonHD();
        LoadCbbKH();
        System.out.println(list.get(4).getMaCTS());
        btnchuyen.setLabel("<");
        btnchuyen2.setLabel(">");
        
    }

    void ComboBoxTheLoai() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbTheLoai.getModel();
        model.removeAllElements();
        for (TheLoai tl : listTL) {
            cbbTheLoai.addItem(tl.getTenTL());
        }
    }

    String getMaSach(int s) {
        list = CTSD.selectBykey(s);
        for (CTSach cTSach : list) {
            return cTSach.getMaSach();
        }
        return null;
    }

    String getTieuDe(String s) {
        listS = sD.selectBykey(s);
        for (Sach ss : listS) {
            return ss.getTieuDe();
        }
        return null;
    }

    void LoadDTableHDCT(int key) {
        int index = 1;
        listCT = ctD.selectbykey(key);
        DefaultTableModel model = (DefaultTableModel) Tblcth.getModel();
        model.setRowCount(0);
        for (CTHoaDon cTH : listCT) {
            model.addRow(new Object[]{index++, getMaSach(cTH.getMaCTS()), cTH.getTieude(), cTH.getGiaBan(), cTH.getSoLuong()});
        }
    }

    void LoadCbbKH() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbKH.getModel();
        model.removeAllElements();
        for (KhachHang kh : listkh) {
            cbbKH.addItem(kh.getMaKH() + "");
        }
    }
    private int row = 0;
    private JButton[] btn;

    void insertHoaDon(String k) {

        HoaDon h = getHD(k);
        hdD.insert(h);
    }

    public void addArrayButtonHh() {
        t = listHD.size();
        int q = t + 16;
        btn = new JButton[q];
        for (int i = 0; i < 16; i++) {
            btn[i] = createButton(i + "");
            btn[i].setText("Sản Phẩm" + i);
            btn[i].setPreferredSize(new Dimension(100, 100));
            Pbody3.add(btn[i]);
        }

    }

    public void addArrayButtonHD() {
        t = listHD.size();
        int q = t + 16;
        btn = new JButton[q];
        for (int i = 16; i < q; i++) {
            btn[i] = createButton(i + "");
            btn[i].setText("Hoa Đơn " + i);
            btn[i].setPreferredSize(new Dimension(100, 100));
            PBody2.add(btn[i]);
        }

    }

    public void addArrayButtonHD2() {
        int q = t + 16;
        btn = new JButton[q];
        btn[q - 1] = createButton((q - 1) + "");
        btn[q - 1].setText("Hoa Đơn " + (q - 1));
        btn[q - 1].setPreferredSize(new Dimension(100, 100));
        PBody2.add(btn[q - 1]);
    }

    public JButton createButton(String buttonName) {
        JButton btn = new JButton(buttonName);
        btn.addActionListener(this);
        return btn;
    }

    void addIcon() {
        y = list.size();
        if (y >= 16) {
            if (IconIndex1 + 16 <= list.size()) {
                for (int i = IconIndex1; i < IconIndex1 + 16; i++) {
                    for (int j = 0; j < 16; j++) {
                        btn[j].setIcon(utils.XImage.readLogo(list.get(i).getHinh()));
                    }
                }
                if (IconIndex1 + 16 > list.size() || IconIndex1 > list.size()) {
                    for (int i = IconIndex1; i < y; i++) {
                        for (int j = 0; j < 16; j++) {
                            btn[j].setIcon(utils.XImage.readLogo(list.get(i).getHinh()));
                        }
                    }
                    for (int i = y; i < 16; i++) {
                        btn[i].setEnabled(false);
                    }
                }
            }
        } else if (y < 16) {
            for (int i = 0; i < y; i++) {
                btn[i].setIcon(utils.XImage.readLogo(list.get(i).getHinh()));
            }
            for (int i = y; i < 16; i++) {
                btn[i].setEnabled(false);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btnIndex = e.getActionCommand();
        String s1 = btnIndex.substring(8);
        x = Integer.parseInt(s1);
        if (x > 15) {
            for (int i = 0; i < t; i++) {
                if (x == 16 + i) {
                    f = i;
                    row = x;
                    HoaDon h = getFrom(i);
                    Setfrom(h);
                    LoadDTableHDCT(listHD.get(i).getMaHd());
                    break;
                }
            }
        } else if (x < 15) {
            if (f < 0) {
                utils.MsgBox.alert(this, "Mời bạn chọn hóa đơn");
            } else {
                for (int i = 0; i < 16; i++) {
                    if (x == i) {
                        idhang = i + IconIndex1;
                        list = CTSD.selecALL();
                        checkh();
                    }
                }

            }
        }

    }

    int getSLS(String mas) {
        List<Sach> listSach = sD.selectBykey(mas);
        for (Sach sach : listSach) {
            System.out.println(sach.getTongSach());
            return sach.getTongSach();
        }
        return 0;

    }

    int getSLSCT(int ms) {
        list = CTSD.selectBykey(ms);
        for (CTSach cTSach : list) {
            return cTSach.getSl();
        }
        return 0;

    }

    int getMaCTHD(int x) {
        listHD = hdD.selectHDChuaTT();
        for (CTHoaDon cT : listCT) {
            if (list.get(x).getMaCTS() == cT.getMaCTS()) {
                return cT.getMaCTHD();
            }
        }
        return 0;
    }

    void checkh() {
        listHD = hdD.selectHDChuaTT();
        int a = 0;
        for (CTHoaDon cT : listCT) {
            if (list.get(idhang).getMaCTS() == cT.getMaCTS() && listHD.get(f).getMaHd() == cT.getMaHD()) {
                utils.MsgBox.alert(this, "Mặt Hàng Đã có xin chỉnh số luong trên bảng!");
                break;
            }
            a++;
        }
        if (a == listCT.size()) {
            String sl = utils.MsgBox.prompt(this, "Mời bạn nhập số lượng");
            if (sl.length() == 0) {

            } else if (sl.matches("\\d{0,5}")) {
                int c = Integer.parseInt(sl.trim());
                if (c > 0 && c < list.get(idhang).getSl()) {
                    CTHoaDon cthd = UpdateCTHD(idhang, f, c, c);
                    ctD.insert(cthd);
                    LoadDTableHDCT(listHD.get(f).getMaHd());
                } else {
                    utils.MsgBox.alert(this, "Quá số lượng hàng có trong Kho!");
                }

            } else {
                utils.MsgBox.alert(this, "Nhập Không Đúng Định Dạng!");
            }

        }
    }

    CTHoaDon UpdateCTHD(int x, int f, int sl, int a) {
        CTHoaDon ct = new CTHoaDon();
        ct.setMaCTHD(getMaCTHD(x));
        ct.setMaCTS(list.get(x).getMaCTS());
        ct.setMaHD(listHD.get(f).getMaHd());
        ct.setGiaBan(list.get(x).getGia());
        ct.setSoLuong(sl);
        ct.setTieude(getTieuDe(list.get(x).getMaSach()));
        ct.setGhiChu("");
        if (a > 0) {
            ct.setTrangThai(0);
        } else if (a == 0) {
            ct.setTrangThai(1);
        }

        return ct;
    }

    void getSLTT(int i) {
        listCT = ctD.selecALL();
        a = 0;
        b = 0;
        for (CTHoaDon cT : listCT) {
            if (listHD.get(i).getMaHd() == cT.getMaHD()) {
                a = cT.getSoLuong() + a;
                b = (float) (cT.getGiaBan() + b);
            }
        }
        System.out.println(a + "...." + b);
    }

    HoaDon getFrom(int i) {
        HoaDon hd = new HoaDon();
        getSLTT(i);
        hd.setMaHd(listHD.get(i).getMaHd());
        hd.setTongSL(a);
        hd.setTongTien(b);
        hd.setTrangThai(listHD.get(i).getTrangThai());
        return hd;
    }

    HoaDon getHD(String k) {
        HoaDon hd = new HoaDon();
        hd.setMaNV(utils.Auth.iSMaNV());
        String makh = (String) cbbKH.getSelectedItem();
        hd.setMaKH(Integer.parseInt(makh));
        hd.setNgaymua(utils.XDate.now());
        hd.setTongSL(0);
        hd.setTongTien(0);
        hd.setGhiChu(k);
        hd.setTrangThai(1);
        return hd;
    }

    HoaDon getUpdateFrom(int i) {
        HoaDon hd = new HoaDon();
        getSLTT(i);
        hd.setMaHd(listHD.get(i).getMaHd());
        hd.setTongSL(a);
        hd.setTongTien(b);
        hd.setNgaymua(utils.XDate.now());
        hd.setTrangThai(0);
        return hd;
    }

    void Setfrom(HoaDon h) {
        cbbKH.setSelectedItem(h.getMaKH());
        txtSL.setText(a + "");
        txtTongTien.setText(b + "");
        txtKhacPhaiTra.setText("");
        if (h.getTrangThai() == 1) {
            rdbChuaTT.setSelected(true);
        } else if (h.getTrangThai() == 2) {
            rdbGH.setSelected(true);
        } else if (h.getTrangThai() == 3) {
            rdbHH.setSelected(true);
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        menuS = new javax.swing.JMenuItem();
        menux = new javax.swing.JMenuItem();
        s = new javax.swing.JPanel();
        Pbody3 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnTT = new javax.swing.JButton();
        lbldongho = new javax.swing.JLabel();
        cbbKH = new javax.swing.JComboBox<>();
        lblKh = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSL = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtGiamGia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtThuKhac = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtKhacPhaiTra = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtThanhToan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        rdbGH = new javax.swing.JRadioButton();
        rdbChuaTT = new javax.swing.JRadioButton();
        rdbHH = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        txtKH = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnTaoHD = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        PBody2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tblcth = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btnchuyen = new java.awt.Button();
        btnchuyen2 = new java.awt.Button();
        cbbTheLoai = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtGhiChus = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbbDoTuoi = new javax.swing.JComboBox<>();

        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        menuS.setText("jMenuItem2");
        menuS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSActionPerformed(evt);
            }
        });
        jPopupMenu2.add(menuS);

        menux.setText("jMenuItem3");
        menux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuxActionPerformed(evt);
            }
        });
        jPopupMenu2.add(menux);

        setLayout(new java.awt.BorderLayout());

        s.setPreferredSize(new java.awt.Dimension(1345, 300));

        Pbody3.setLayout(new java.awt.GridLayout(2, 0));

        javax.swing.GroupLayout sLayout = new javax.swing.GroupLayout(s);
        s.setLayout(sLayout);
        sLayout.setHorizontalGroup(
            sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pbody3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1535, Short.MAX_VALUE)
        );
        sLayout.setVerticalGroup(
            sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(Pbody3, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(s, java.awt.BorderLayout.PAGE_END);

        btnTT.setBackground(new java.awt.Color(0, 204, 0));
        btnTT.setText("Thanh Toán");
        btnTT.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        btnTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTTActionPerformed(evt);
            }
        });

        cbbKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cbbKHMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbbKHMousePressed(evt);
            }
        });
        cbbKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKHActionPerformed(evt);
            }
        });

        lblKh.setText("Khách Hàng");
        lblKh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblKhMouseExited(evt);
            }
        });

        jLabel1.setText("Tổng Tiền");

        txtTongTien.setEditable(false);

        jLabel2.setText("Số lượng");

        txtSL.setEditable(false);

        jLabel3.setText("Giảm giá");

        jLabel4.setText("Thu Khác");

        jLabel5.setText("Khách Phải trả");

        jLabel6.setText("Khách Thanh Toán");

        txtThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThanhToanActionPerformed(evt);
            }
        });

        jLabel7.setText("Tiền Thừa");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 255, 51));
        jLabel8.setText("+");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        buttonGroup1.add(rdbGH);
        rdbGH.setText("Đang Giao Hàng");
        rdbGH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbGHActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbChuaTT);
        rdbChuaTT.setText("Chưa Thanh Toan");
        rdbChuaTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbChuaTTActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbHH);
        rdbHH.setText("Hủy Hàng");
        rdbHH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbHHActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 255, 51));
        jLabel9.setText("+");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        txtKH.setForeground(new java.awt.Color(153, 153, 153));
        txtKH.setText("Nhập Tên Khách Hàng");
        txtKH.setActionCommand("<Not Set>");
        txtKH.setName(""); // NOI18N
        txtKH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtKHFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtKHFocusLost(evt);
            }
        });
        txtKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKHActionPerformed(evt);
            }
        });

        jButton1.setText("Giao Hàng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdbGH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblKh, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtKH, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(210, 210, 210)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(182, 182, 182)
                                        .addComponent(lbldongho, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(cbbKH, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtKhacPhaiTra, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(rdbChuaTT)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdbHH)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSL))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTongTien))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtGiamGia))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(26, 26, 26)
                                .addComponent(btnTT, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtThuKhac, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(lbldongho, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblKh, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtThuKhac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKhacPhaiTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbGH)
                    .addComponent(rdbChuaTT)
                    .addComponent(rdbHH))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(btnTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(149, Short.MAX_VALUE))
        );

        txtKH.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 340, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(jPanel15, java.awt.BorderLayout.LINE_END);

        btnTaoHD.setText("Tạo Hóa đơn");
        btnTaoHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaoHDMouseClicked(evt);
            }
        });
        btnTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTaoHD)
                .addContainerGap(192, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTaoHD)
                .addContainerGap())
        );

        PBody2.setLayout(new java.awt.GridLayout(10, 2));
        jScrollPane2.setViewportView(PBody2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(jPanel24, java.awt.BorderLayout.LINE_START);

        jPanel1.setPreferredSize(new java.awt.Dimension(900, 570));

        Tblcth.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Stt", "Mã sách", "Tên sách", "Giá tiền", "Số Lượng"
            }
        ));
        Tblcth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblcthMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TblcthMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(Tblcth);

        jTextField1.setToolTipText("Tìm kiếm sản phẩm");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1)
        );

        btnchuyen.setActionCommand("<");
        btnchuyen.setLabel("button1");
        btnchuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchuyenActionPerformed(evt);
            }
        });

        btnchuyen2.setLabel("button1");
        btnchuyen2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchuyen2ActionPerformed(evt);
            }
        });

        cbbTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTheLoaiActionPerformed(evt);
            }
        });

        jLabel10.setText("Thể Loại");

        txtGhiChus.setColumns(20);
        txtGhiChus.setRows(5);
        txtGhiChus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtGhiChusMouseEntered(evt);
            }
        });
        jScrollPane3.setViewportView(txtGhiChus);

        jLabel11.setText("Ghi Chú");

        jLabel12.setText("Độ Tuổi");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnchuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbTheLoai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(cbbDoTuoi, 0, 224, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnchuyen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3))
                .addGap(21, 21, 21))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbDoTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnchuyen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnchuyen2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHDActionPerformed

        insertHoaDon(k);
        listHD = hdD.selectHDChuaTT();
        t = listHD.size();
        addArrayButtonHD2();
        updateUI();
    }//GEN-LAST:event_btnTaoHDActionPerformed

    private void btnTaoHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaoHDMouseClicked

    }//GEN-LAST:event_btnTaoHDMouseClicked

    private void cbbKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKHActionPerformed

        List<KhachHang> list = khDao.selectByKH(listkh.get(cbbKH.getSelectedIndex()).getMaKH());
        for (KhachHang khachHang : list) {
            jMenuItem1.setText(khachHang + "");
        }
    }//GEN-LAST:event_cbbKHActionPerformed

    private void lblKhMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKhMouseExited

    }//GEN-LAST:event_lblKhMouseExited

    private void cbbKHMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKHMouseExited
//        int m = MouseInfo.getPointerInfo().getLocation().x;
//        int n = MouseInfo.getPointerInfo().getLocation().y;
//        
//        pop.show(this, n, n);
    }//GEN-LAST:event_cbbKHMouseExited

    private void cbbKHMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKHMousePressed
        int m = MouseInfo.getPointerInfo().getLocation().x;
        int n = MouseInfo.getPointerInfo().getLocation().y;
        this.jPopupMenu1.show(this, m, n);
    }//GEN-LAST:event_cbbKHMousePressed

    private void TblcthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblcthMouseClicked

    }//GEN-LAST:event_TblcthMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTTActionPerformed
        boolean tt = utils.MsgBox.comfirm(this, "Bạn chắc chắn muốn thanh toán đơn hàng!");
        if (tt) {
            if (row > 15) {
                int q = t + 16;
                HoaDon hd = getUpdateFrom(f);
                hdD.updateTHD(hd);
                HomeFrom.loadfrom();
                updateUI();
            } else {
                utils.MsgBox.comfirm(this, "Mời bạn chọn hóa đơn cần thanh toán!");
            }
        }
    }//GEN-LAST:event_btnTTActionPerformed

    private void rdbChuaTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbChuaTTActionPerformed
        if (f == -1) {
            utils.MsgBox.alert(this, "Mời Bạn chọn Hóa đơn");
        } else {
            
            hdD.updateTTHD((k+update),1, listHD.get(f).getMaHd());
        }
    }//GEN-LAST:event_rdbChuaTTActionPerformed

    private void txtKHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtKHFocusGained
        if (txtKH.getText().equals("Nhập Tên Khách Hàng")) {
            txtKH.setText("");
            txtKH.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtKHFocusGained

    private void txtKHFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtKHFocusLost
        if (txtKH.getText().equals("")) {
            txtKH.setText("Nhập Tên Khách Hàng");
            txtKH.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtKHFocusLost

    private void rdbGHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbGHActionPerformed
        if (f == -1) {
            utils.MsgBox.alert(this, "Mời Bạn chọn Hóa đơn");
        } else {
            hdD.updateTTHD((k+update),2, listHD.get(f).getMaHd());
        }
    }//GEN-LAST:event_rdbGHActionPerformed

    private void rdbHHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbHHActionPerformed
        if (f == -1) {
            utils.MsgBox.alert(this, "Mời Bạn chọn Hóa đơn");
        } else {
            hdD.updateTTHD((k+update),3, listHD.get(f).getMaHd());
        }
    }//GEN-LAST:event_rdbHHActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        new KhachHangFrom().setVisible(true);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked

    }//GEN-LAST:event_jLabel8MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void TblcthMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblcthMousePressed
        int m = MouseInfo.getPointerInfo().getLocation().x;
        int n = MouseInfo.getPointerInfo().getLocation().y;
        menuS.setText("Sửa số lượng");
        menux.setText("Xóa");
        this.jPopupMenu2.show(this, m, n);
    }//GEN-LAST:event_TblcthMousePressed

    private void menuSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSActionPerformed
        int roww = Tblcth.getSelectedRow();
        System.out.println("Max row" + roww);
        list = CTSD.selecALL();
        listCT = ctD.selectbykey(listHD.get(f).getMaHd());
        String sl = utils.MsgBox.prompt(this, "Mời bạn nhập số lượng");
        if (sl.length() == 0) {

        } else if (sl.matches("\\d{0,5}")) {
            int c = Integer.parseInt(sl.trim());
            if (c > 0 && c < getSLS(getMaSach(listCT.get(roww).getMaCTS())) && c > listCT.get(roww).getSoLuong()) {
                sD.updateSL((getSLS(getMaSach(listCT.get(roww).getMaCTS())) - c) + listCT.get(roww).getSoLuong(), getMaSach(listCT.get(roww).getMaCTS()));
                CTSD.updateSL((getSLSCT(listCT.get(roww).getMaCTS()) - c) + listCT.get(roww).getSoLuong(), listCT.get(roww).getMaCTS());
                System.out.println("Max CTHD" + listCT.get(roww).getMaCTHD());
                ctD.updateSL2(c, listCT.get(roww).getMaCTHD());
                LoadDTableHDCT(listHD.get(f).getMaHd());
                HoaDon hd = getFrom(f);
                hdD.updateTT(hd);
            } else if (c > 0 && c < getSLS(getMaSach(listCT.get(roww).getMaCTS())) && c < listCT.get(roww).getSoLuong()) {
                sD.updateSL((getSLS(getMaSach(listCT.get(roww).getMaCTS())) + listCT.get(roww).getSoLuong()) - c, getMaSach(listCT.get(roww).getMaCTS()));
                CTSD.updateSL(getSLSCT(listCT.get(roww).getMaCTS()) + (listCT.get(roww).getSoLuong() - c), listCT.get(roww).getMaCTS());
                ctD.updateSL2(c, listCT.get(roww).getMaCTHD());
                LoadDTableHDCT(listHD.get(f).getMaHd());
                HoaDon hd = getFrom(f);
                hdD.updateTT(hd);
            } else if (c == 0) {
                CTSD.updateSL(getSLSCT(listCT.get(roww).getMaCTS()) + (listCT.get(roww).getSoLuong() - c), list.get(roww).getMaCTS());
                sD.updateSL(getSLS(getMaSach(listCT.get(roww).getMaCTS())) + (listCT.get(roww).getSoLuong() - c), getMaSach(listCT.get(roww).getMaCTS()));
                ctD.updateSL2(c, listCT.get(roww).getMaCTHD());
                LoadDTableHDCT(listHD.get(f).getMaHd());
                HoaDon hd = getFrom(f);
                hdD.updateTT(hd);
            } else {
                utils.MsgBox.alert(this, "Quá số lượng hàng có trong Kho!");
            }
        } else {
            utils.MsgBox.alert(this, "Nhập Không Đúng Định Dạng!");
        }

    }//GEN-LAST:event_menuSActionPerformed

    private void menuxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuxActionPerformed
        int roww = Tblcth.getSelectedRow();
        CTSD.updateSL(getSLSCT(listCT.get(roww).getMaCTS()) + (listCT.get(roww).getSoLuong()), list.get(roww).getMaCTS());
        sD.updateSL(getSLS(getMaSach(listCT.get(roww).getMaCTS())) + (listCT.get(roww).getSoLuong()), getMaSach(listCT.get(roww).getMaCTS()));
        ctD.delete(listCT.get(roww).getMaCTHD());
        LoadDTableHDCT(listHD.get(f).getMaHd());
    }//GEN-LAST:event_menuxActionPerformed

    private void txtKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKHActionPerformed
        if (true) {

        }
    }//GEN-LAST:event_txtKHActionPerformed

    private void btnchuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchuyenActionPerformed
        if (IconIndex1 >= 16) {
            IconIndex1 = IconIndex1 - 16;
            addIcon();
        }
    }//GEN-LAST:event_btnchuyenActionPerformed

    private void cbbTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTheLoaiActionPerformed
        int i = cbbTheLoai.getSelectedIndex();
        for (TheLoaiSach tls : listTLS) {
            if (tls.getMaTL() == listTL.get(i).getMaTL()) {
                list = CTSD.selectByTL(tls.getMaSach());
                addIcon();
                break;
            }
        }

    }//GEN-LAST:event_cbbTheLoaiActionPerformed

    private void txtGhiChusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGhiChusMouseEntered
       hdD.updateGhiChu((k+update)+txtGhiChus.getText(), listHD.get(f).getMaHd());
    }//GEN-LAST:event_txtGhiChusMouseEntered

    private void txtThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThanhToanActionPerformed

    }//GEN-LAST:event_txtThanhToanActionPerformed

    private void btnchuyen2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchuyen2ActionPerformed
        if (list.size() > 16) {
            IconIndex1 = IconIndex1 + 16;
            addIcon();
        }
    }//GEN-LAST:event_btnchuyen2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PBody2;
    private javax.swing.JPanel Pbody3;
    private javax.swing.JTable Tblcth;
    private javax.swing.JButton btnTT;
    private javax.swing.JButton btnTaoHD;
    private java.awt.Button btnchuyen;
    private java.awt.Button btnchuyen2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbDoTuoi;
    private javax.swing.JComboBox<String> cbbKH;
    private javax.swing.JComboBox<String> cbbTheLoai;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblKh;
    private javax.swing.JLabel lbldongho;
    private javax.swing.JMenuItem menuS;
    private javax.swing.JMenuItem menux;
    private javax.swing.JRadioButton rdbChuaTT;
    private javax.swing.JRadioButton rdbGH;
    private javax.swing.JRadioButton rdbHH;
    private javax.swing.JPanel s;
    private javax.swing.JTextArea txtGhiChus;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtKH;
    private javax.swing.JTextField txtKhacPhaiTra;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtThanhToan;
    private javax.swing.JTextField txtThuKhac;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables

}
