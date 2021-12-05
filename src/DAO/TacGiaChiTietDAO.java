/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.TacGiaChiTiet;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class TacGiaChiTietDAO extends DAO<TacGiaChiTiet, String> {

    String INSERT_SQL = "INSERT INTO TacGiaChiTiet (MATGCT, MATG, MACTS, TRANGTHAI) VALUES (?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE TacGiaChiTiet SET MATG=?, MACTS=?,  TRANGTHAI=? WHERE MATGCT=? ";
    String DELETE_SQL = "DELETE FROM TacGiaChiTiet WHERE MATGCT=? ";
    String SELECT_ALL_SQL = "SELECT * FROM TacGiaChiTiet ";
    String SELECt_BY_ID_SQL = "SELECT*from TacGiaChiTiet where MATGCT= ?";

    @Override
    public void insert(TacGiaChiTiet entity) {
        JDBCHelper.jdbcHelper.update(INSERT_SQL, entity.getMaTGCT(), entity.getMaTG(), entity.getMaCTS(), entity.getTrangThai());
    }

    @Override
    public void update(TacGiaChiTiet entity) {
        JDBCHelper.jdbcHelper.update(UPDATE_SQL, entity.getMaTGCT(), entity.getMaTG(), entity.getMaCTS(), entity.getTrangThai());
    }

    @Override
    public void delete(String id) {
        JDBCHelper.jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<TacGiaChiTiet> selecALL() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public TacGiaChiTiet selectById(String key) {
        List<TacGiaChiTiet> list = this.selectBySql(SELECt_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<TacGiaChiTiet> selectBySql(String sql, Object... args) {
        List<TacGiaChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.jdbcHelper.query(sql, args);
            while (rs.next()) {
                TacGiaChiTiet entity = new TacGiaChiTiet();
                entity.setMaTGCT(rs.getString(1));
                entity.setMaTG(rs.getString(2));
                entity.setMaCTS(rs.getString(3));

                entity.setTrangThai(rs.getInt(4));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
