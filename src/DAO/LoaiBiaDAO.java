/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.LoaiBia;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class LoaiBiaDAO extends DAO<LoaiBia, String>{
     String INSERT_SQL = "INSERT INTO LoaiBia (MALB, TENLB, TRANGTHAI) VALUES (?, ?, ?)";
    String UPDATE_SQL = "UPDATE LoaiBia SET TENLB=?, TRANGTHAI=? WHERE MALB=? ";
    String DELETE_SQL = "DELETE FROM LoaiBia WHERE MALB=? ";
    String SELECT_ALL_SQL = "SELECT * FROM LoaiBia ";
    String SELECt_BY_ID_SQL = "SELECT*from LoaiBia where MALB= ?";
    @Override
    public void insert(LoaiBia entity) {
     JDBCHelper.jdbcHelper.update(INSERT_SQL, entity.getMaLB(), entity.getMaLB(), entity.getTrangThai());
    }

    @Override
    public void update(LoaiBia entity) {
     JDBCHelper.jdbcHelper.update(UPDATE_SQL, entity.getMaLB(), entity.getMaLB(), entity.getTrangThai());
    }

    @Override
    public void delete(String id) {
      JDBCHelper.jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<LoaiBia> selecALL() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public LoaiBia selectById(String key) {
List<LoaiBia> list = this.selectBySql(SELECt_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);    }

    @Override
    public List<LoaiBia> selectBySql(String sql, Object... args) {
List<LoaiBia> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.jdbcHelper.query(sql, args);
            while (rs.next()) {
                LoaiBia entity = new LoaiBia();
                entity.setMaLB(rs.getInt(1));
                entity.setTenLB(rs.getString(2));
               
                
                entity.setTrangThai(rs.getInt(3));
                
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }    }
    
}
