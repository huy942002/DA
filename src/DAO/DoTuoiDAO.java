/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.DoTuoi;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class DoTuoiDAO extends DAO<DoTuoi, String>{
    String INSERT_SQL = "INSERT INTO DoTuoi (MADTUOI, DOTUOI, TRANGTHAI) VALUES (?, ?, ?)";
    String UPDATE_SQL = "UPDATE DoTuoi SET DOTUOI=?, TRANGTHAI=? WHERE MADTUOI=? ";
    String DELETE_SQL = "DELETE FROM DoTuoi WHERE MADTUOI=? ";
    String SELECT_ALL_SQL = "SELECT * FROM DoTuoi ";
    String SELECt_BY_ID_SQL = "SELECT*from DoTuoi where MADTUOI= ?";
    @Override
    public void insert(DoTuoi entity) {
     JDBCHelper.jdbcHelper.update(INSERT_SQL, entity.getMaDTuoi(), entity.getDoTuoi(), entity.getTrangThai());
    }

    @Override
    public void update(DoTuoi entity) {
     JDBCHelper.jdbcHelper.update(UPDATE_SQL, entity.getMaDTuoi(), entity.getDoTuoi(), entity.getTrangThai());
    }

    @Override
    public void delete(String id) {
      JDBCHelper.jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<DoTuoi> selecALL() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public DoTuoi selectById(String key) {
List<DoTuoi> list = this.selectBySql(SELECt_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);    }

    @Override
    public List<DoTuoi> selectBySql(String sql, Object... args) {
List<DoTuoi> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.jdbcHelper.query(sql, args);
            while (rs.next()) {
                DoTuoi entity = new DoTuoi();
                entity.setMaDTuoi(rs.getInt(1));
                entity.setDoTuoi(rs.getString(2));
               
                
                entity.setTrangThai(rs.getInt(3));
                
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }    }
    
}
