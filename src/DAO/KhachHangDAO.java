/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.KhachHang;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class KhachHangDAO extends DAO<KhachHang,Integer> {

    String INSERT_SQL = "INSERT INTO KhachHang (MAKH, TENKH, GIOITINH, SDT,GHICHU, TRANGTHAI) VALUES (?, ?, ?, ?,?,?)";
    String UPDATE_SQL = "UPDATE KhachHang SET TENKH=?, GIOITINH=?, SDT=?,GHICHU=?, TRANGTHAI=? WHERE MAKH=? ";
    String DELETE_SQL = "DELETE FROM KhachHang WHERE MAKH=? ";
    String SELECT_ALL_SQL = "SELECT * FROM KhachHang ";
    String SELECt_BY_ID_SQL = "SELECT*from KHACHHANG where MAKH= ?";

    @Override
    public void insert(KhachHang entity) {
        JDBCHelper.jdbcHelper.update(INSERT_SQL, entity.getMaKH(), entity.getTenKH(), entity.isGioiTinh(), entity.getSDT(), entity.getGhiChu(),entity.getTrangThai());
    }

    @Override
    public void update(KhachHang entity) {
        JDBCHelper.jdbcHelper.update(UPDATE_SQL, entity.getMaKH(), entity.getTenKH(), entity.isGioiTinh(), entity.getSDT(), entity.getGhiChu(),entity.getTrangThai());
    }

    @Override
    public List<KhachHang> selecALL() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

   

    @Override
    public List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.jdbcHelper.query(sql, args);
            while (rs.next()) {
                KhachHang entity = new KhachHang();
                entity.setMaKH(rs.getInt(1));
                entity.setTenKH(rs.getString(2));
                entity.setGioiTinh(rs.getBoolean(3));
                entity.setSDT(rs.getString(4));
                entity.setGhiChu(rs.getString(5));
                entity.setTrangThai(rs.getInt(6));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        JDBCHelper.jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public KhachHang selectById(Integer key) {
        List<KhachHang> list = this.selectBySql(SELECt_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    public List<KhachHang> selectByKH(Integer key) {
        return this.selectBySql(SELECt_BY_ID_SQL,key);
    }
}
