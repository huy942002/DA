/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Entity.NgonNgu;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NgonNguDAO extends DAO<NgonNgu, String>{
    String INSERT_SQL = "INSERT INTO NgonNgu (MANN, LOAINN, TRANGTHAI) VALUES (?, ?, ?)";
    String UPDATE_SQL = "UPDATE NgonNgu SET LOAINN=?, TRANGTHAI=? WHERE MANN=? ";
    String DELETE_SQL = "DELETE FROM NgonNgu WHERE MANN=? ";
    String SELECT_ALL_SQL = "SELECT * FROM NgonNgu ";
    String SELECt_BY_ID_SQL = "SELECT*from NgonNgu where MANN= ?";
    @Override
    public void insert(NgonNgu entity) {
     JDBCHelper.jdbcHelper.update(INSERT_SQL, entity.getMaNN(), entity.getLoaiNN(), entity.getTrangThai());
    }

    @Override
    public void update(NgonNgu entity) {
     JDBCHelper.jdbcHelper.update(UPDATE_SQL, entity.getMaNN(), entity.getLoaiNN(), entity.getTrangThai());
    }

    @Override
    public void delete(String id) {
      JDBCHelper.jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<NgonNgu> selecALL() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NgonNgu selectById(String key) {
    List<NgonNgu> list = this.selectBySql(SELECt_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);    }

    @Override
    public List<NgonNgu> selectBySql(String sql, Object... args) {
List<NgonNgu> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.jdbcHelper.query(sql, args);
            while (rs.next()) {
                NgonNgu entity = new NgonNgu();
                entity.setMaNN(rs.getString(1));
                entity.setLoaiNN(rs.getString(2));
               
                
                entity.setTrangThai(rs.getInt(3));
                
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
