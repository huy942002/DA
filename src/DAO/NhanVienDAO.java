/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;



import Entity.NhanVien;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NhanVienDAO extends DAO<NhanVien, String>{
    String INSERT_SQL = "INSERT INTO NhanVien (MANV, TENNV, MATKHAU, GIOITINH, TUOI, DIACHI, SDT, TRANGTHAI) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE NhanVien SET TENNV=?, MATKHAU=?, GIOITINH=?, TUOI=?, DIACHI=?, SDT=?, TRANGTHAI=? WHERE MANV=? ";
    String DELETE_SQL = "DELETE FROM NhanVien WHERE MANV=? ";
    String SELECT_ALL_SQL = "SELECT * FROM NhanVien ";
    String SELECt_BY_ID_SQL = "SELECT*from NhanVien where MANV= ?";
    @Override
    public void insert(NhanVien entity) {
            JDBCHelper.jdbcHelper.update(INSERT_SQL, entity.getManv(), entity.getTenNv(), entity.getMatKhau(), entity.isGioiTinh(), entity.getTuoi(), entity.getDiaChi(), entity.getSDT(), entity.getTrangThai());
    }

    @Override
    public void update(NhanVien entity) {
            JDBCHelper.jdbcHelper.update(INSERT_SQL, entity.getManv(), entity.getTenNv(), entity.getMatKhau(), entity.isGioiTinh(), entity.getTuoi(), entity.getDiaChi(), entity.getSDT(), entity.getTrangThai());
    }

    @Override
    public void delete(String id) {
      JDBCHelper.jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<NhanVien> selecALL() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NhanVien selectById(String key) {
 List<NhanVien> list = this.selectBySql(SELECt_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);    }

    @Override
    public List<NhanVien> selectBySql(String sql, Object... args) {
 List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.jdbcHelper.query(sql, args);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setManv(rs.getInt(1));
                entity.setTenNv(rs.getString(2));
                entity.setMatKhau(rs.getString(3));
                entity.setGioiTinh(rs.getBoolean(4));
                entity.setTuoi(rs.getInt(5));
                entity.setDiaChi(rs.getString(6));
                entity.setSDT(rs.getString(7));
                entity.setTrangThai(rs.getInt(8));
                
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }        }
    
}
