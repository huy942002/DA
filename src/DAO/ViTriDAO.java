/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.ViTri;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ViTriDAO extends DAO<ViTri, String> {

    String INSERT_SQL = "INSERT INTO ViTri (MAVITRI, TENHANG, TRANGTHAI) VALUES (?, ?, ?)";
    String UPDATE_SQL = "UPDATE ViTri SET TENHANG=?, TRANGTHAI=? WHERE MAVITRI=? ";
    String DELETE_SQL = "DELETE FROM ViTri WHERE MAVITRI=? ";
    String SELECT_ALL_SQL = "SELECT * FROM ViTri ";
    String SELECt_BY_ID_SQL = "SELECT*from ViTri where MAVITRI= ?";

    @Override
    public void insert(ViTri entity) {
        JDBCHelper.jdbcHelper.update(INSERT_SQL, entity.getMaVT(), entity.getTenHang(), entity.isTrangThai());
    }

    @Override
    public void update(ViTri entity) {
        JDBCHelper.jdbcHelper.update(UPDATE_SQL, entity.getMaVT(), entity.getTenHang(), entity.isTrangThai());
    }

    @Override
    public void delete(String id) {
        JDBCHelper.jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<ViTri> selecALL() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public ViTri selectById(String key) {
        List<ViTri> list = this.selectBySql(SELECt_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ViTri> selectBySql(String sql, Object... args) {
        List<ViTri> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.jdbcHelper.query(sql, args);
            while (rs.next()) {
                ViTri entity = new ViTri();
                entity.setMaVT(rs.getString(1));
                entity.setTenHang(rs.getString(2));

                entity.setTrangThai(rs.getInt(3));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
