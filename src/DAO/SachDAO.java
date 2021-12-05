/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Entity.Sach;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
/**
 *
 * @author User
 */
public class SachDAO extends DAO<Sach, String>{
     String INSERT_SQL = "INSERT INTO SACH (MASACH, TIEUDE, TENNHAXUATBAN, TONGLUONGSACH, TRANGTHAI) VALUES (?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE SACH SET TIEUDE=?, TENNHAXUATBAN=?, TONGLUONGSACH=?, TRANGTHAI=? WHERE MASACH=? ";
    String DELETE_SQL = "DELETE FROM SACH WHERE MASACH=? ";
    String SELECT_ALL_SQL = "SELECT * FROM SACH where TRANGTHAI=1";
    String SELECt_BY_ID_SQL = "SELECT*from SACH where MASACH= ?";
    String UPDATESL_SQL = "UPDATE SACH SET TONGLUONGSACH=? WHERE MASACH=? ";
    @Override
    public void insert(Sach entity) {
        JDBCHelper.jdbcHelper.update(INSERT_SQL, entity.getMaSach(), entity.getTieuDe(), entity.getTenNhaXB(), entity.getTongSach(), entity.isTrangThai());
    }

    @Override
    public void update(Sach entity) {
        JDBCHelper.jdbcHelper.update(UPDATE_SQL, entity.getTieuDe(), entity.getTenNhaXB(), entity.getTongSach(), entity.isTrangThai(), entity.getMaSach());
    }
    public void updateSL(int SL,String MaS) {
        JDBCHelper.jdbcHelper.update(UPDATESL_SQL,SL,MaS);
    }
    public List<Sach> selectBykey(String key) {
        
        return selectBySql(SELECt_BY_ID_SQL,key);
    }
    @Override
    public void delete(String id) {
         JDBCHelper.jdbcHelper.update(DELETE_SQL, id);
    }
    public void deletems(Sach entity){
        JDBCHelper.jdbcHelper.update(INSERT_SQL,entity.isTrangThai(), entity.getMaSach());
    }
    @Override
    public List<Sach> selecALL() {
        
        return selectBySql(SELECT_ALL_SQL);
    }
    
    @Override
    public Sach selectById(String key) {
         List<Sach> list = this.selectBySql(SELECt_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Sach> selectBySql(String sql, Object... args) {
        List<Sach> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.jdbcHelper.query(sql, args);
            while (rs.next()) {                
                Sach s = new Sach();
                s.setMaSach(rs.getString("MASACH"));
                s.setTieuDe(rs.getString("TieuDe"));
                s.setTenNhaXB(rs.getString("TENNHAXUATBAN"));
                s.setTongSach(rs.getInt("TONGLUONGSACH"));
                s.setTrangThai(rs.getInt("TRANGTHAI"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  list;
    }
    
}
