/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import menu.MenuItem;
import GUI.*;

/**
 *
 * @author User
 */
public class HomeFrom extends javax.swing.JFrame {

    /**
     * Creates new form HomeFrom
     */
    int index = 0;
    
    public HomeFrom() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        execute();
    }

    public static void loadfrom() {
        panelBody.removeAll();
        panelBody.add(new BanHangFromms());
    }

    private void execute() {
        ImageIcon iconStaff = new ImageIcon("D:\\test menu\\src\\menu\\user.png");
        ImageIcon iconSetting = new ImageIcon("D:\\test menu\\src\\menu\\setting.png");
        ImageIcon iconDatabase = new ImageIcon("D:\\test menu\\src\\menu\\database.png");
        ImageIcon iconMessage = new ImageIcon("D:\\test menu\\src\\menu\\message.png");
        ImageIcon iconSubMenu = new ImageIcon("D:\\test menu\\src\\menu\\subMenu.png");
        ImageIcon iconNext = new ImageIcon("D:\\test menu\\src\\menu\\next.png");
        //Tạo Menu Quản Lý Sách
        MenuItem menuStaff1 = new MenuItem(iconSubMenu, "Sách và Chi Tiết Sách", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new CTS());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new CTS());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
            }
        });
        MenuItem menuStaff2 = new MenuItem(iconSubMenu, "Tác Giả và Thể Loại", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new TacGiaTheLoaiFrom());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new TacGiaTheLoaiFrom());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
            }
        });
        MenuItem menuStaff4 = new MenuItem(iconSubMenu, "Nhà Xuất Bản và Nhà Cung Cấp", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new NhaXBvsCC());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new NhaXBvsCC());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
            }
        });
        MenuItem menuNNDT = new MenuItem(iconSubMenu, "Ngôn Ngữ Và Độ Tuổi", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new NgonNguFrom());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new NgonNguFrom());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
            }
        });
        MenuItem menuHTLB = new MenuItem(iconSubMenu, "Hình Thức,Loại Bìa", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new HinhThucLoaiBia());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new HinhThucLoaiBia());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
            }
        });
        //Tạo Menu Giao Dịch
        MenuItem menuBanHang = new MenuItem(iconNext, "Bán Hàng", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new BanHangFromms());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new BanHangFromms());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
            }
        });
        MenuItem menuNhanHang = new MenuItem(iconNext, "Nhập Hàng", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {

                } else {
                    index = 1;

                }
            }
        });
        MenuItem menuQLHD = new MenuItem(iconNext, "QL Hóa Đơn", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {
                  panelBody.removeAll();
                    panelBody.add(new QLHoaDon());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new QLHoaDon());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
            }
        });
        MenuItem menuDoanhThu = new MenuItem(iconNext, "Doanh Thu", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {
                    panelBody.removeAll();
//                    panelBody.add(new );
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();  
//                    panelBody.add(new BanHangFromms());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
            }
        });

        MenuItem menuHome = new MenuItem(iconStaff, "Trang Chủ", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new BanHangFromms());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new BanHangFromms());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
            }
        });
        MenuItem menuQLSach = new MenuItem(iconSetting, "Quản Lý Sách", null, menuStaff1, menuStaff2, menuStaff4, menuNNDT, menuHTLB);
        MenuItem menuQLGD = new MenuItem(iconDatabase, "Quản Lý Giao Dịch", null, menuBanHang, menuNhanHang, menuDoanhThu,menuQLHD);
        MenuItem menuQLNV = new MenuItem(iconDatabase, "Quản Lý Nhân viên", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new NhanVienvsVaitro());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new NhanVienvsVaitro());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
            }
        });
        MenuItem menuQLKH = new MenuItem(iconDatabase, "Quản Lý Khách Hàng", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index == 1) {
                    panelBody.removeAll();
                    panelBody.add(new KhachHangFrom1());
                    panelBody.repaint();
                    panelBody.revalidate();
                } else {
                    index = 1;
                    panelBody.removeAll();
                    panelBody.add(new KhachHangFrom1());
                    panelBody.repaint();
                    panelBody.revalidate();
                }
            }
        });
        addMenu(menuHome, menuQLSach, menuQLGD, menuQLNV, menuQLKH);

    }

    private void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            menus.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        menus.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menus = new javax.swing.JPanel();
        panelBody = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMenu.setBackground(new java.awt.Color(0, 51, 153));
        panelMenu.setPreferredSize(new java.awt.Dimension(250, 486));

        jScrollPane1.setBorder(null);

        menus.setBackground(new java.awt.Color(40, 16, 157));
        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(menus);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );

        getContentPane().add(panelMenu, java.awt.BorderLayout.LINE_START);

        panelBody.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelBody, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(859, 575));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(HomeFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeFrom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel menus;
    public static javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables

}
