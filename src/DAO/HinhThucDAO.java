/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.HinhThuc;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class HinhThucDAO extends DAO<HinhThuc, String>{
     String INSERT_SQL = "INSERT INTO HinhThuc (MAHINHTHUC, KIEUSACH, TRANGTHAI) VALUES (?, ?, ?)";
    String UPDATE_SQL = "UPDATE HinhThuc SET KIEUSACH=?, TRANGTHAI=? WHERE MAHINHTHUC=? ";
    String DELETE_SQL = "DELETE FROM HinhThuc WHERE MAHINHTHUC=? ";
    String SELECT_ALL_SQL = "SELECT * FROM HinhThuc ";
    String SELECt_BY_ID_SQL = "SELECT*from HinhThuc where MAHINHTHUC= ?";
    @Override
    public void insert(HinhThuc entity) {
     JDBCHelper.jdbcHelper.update(INSERT_SQL, entity.getMaHT(), entity.getKieuSach(), entity.isTrangThai());
    }

    @Override
    public void update(HinhThuc entity) {
     JDBCHelper.jdbcHelper.update(UPDATE_SQL, entity.getMaHT(), entity.getKieuSach(), entity.isTrangThai());
    }

    @Override
    public void delete(String id) {
      JDBCHelper.jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<HinhThuc> selecALL() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public HinhThuc selectById(String key) {
List<HinhThuc> list = this.selectBySql(SELECt_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);     }

    @Override
    public List<HinhThuc> selectBySql(String sql, Object... args) {
List<HinhThuc> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.jdbcHelper.query(sql, args);
            while (rs.next()) {
                HinhThuc entity = new HinhThuc();
                entity.setMaHT(rs.getString(1));
                entity.setKieuSach(rs.getString(2));
               
                
                entity.setTrangThai(rs.getInt(3));
                
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }    }
    
}
