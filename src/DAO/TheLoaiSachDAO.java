/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Entity.TheLoaiSach;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class TheLoaiSachDAO extends DAO<TheLoaiSach, String>{
    String INSERT_SQL = "INSERT INTO TheLoaiSach (MATLS, MATL, MASACH, TENTL, TRANGTHAI) VALUES (?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE TheLoaiSach SET MATL=?, MASACH=?, TENTL=?, TRANGTHAI=? WHERE MATLS=? ";
    String DELETE_SQL = "DELETE FROM TheLoaiSach WHERE MATLS=? ";
    String SELECT_ALL_SQL = "SELECT * FROM TheLoaiSach ";
    String SELECt_BY_ID_SQL = "SELECT*from TheLoaiSach where MATLS= ?";
    @Override
    public void insert(TheLoaiSach entity) {
     JDBCHelper.jdbcHelper.update(INSERT_SQL, entity.getMaTLS(), entity.getMaTL(), entity.getMaSach(), entity.getTenTL(), entity.getTrangThai());
    }

    @Override
    public void update(TheLoaiSach entity) {
     JDBCHelper.jdbcHelper.update(UPDATE_SQL, entity.getMaTLS(), entity.getMaTL(), entity.getMaSach(), entity.getTenTL(), entity.getTrangThai());
    }

    @Override
    public void delete(String id) {
      JDBCHelper.jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<TheLoaiSach> selecALL() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public TheLoaiSach selectById(String key) {
List<TheLoaiSach> list = this.selectBySql(SELECt_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);    }

    @Override
    public List<TheLoaiSach> selectBySql(String sql, Object... args) {
List<TheLoaiSach> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.jdbcHelper.query(sql, args);
            while (rs.next()) {
                TheLoaiSach entity = new TheLoaiSach();
                entity.setMaTLS(rs.getString(1));
                entity.setMaTL(rs.getInt(2));
                entity.setMaSach(rs.getString(3));
                entity.setTenTL(rs.getString(4));
                
                entity.setTrangThai(rs.getInt(5));
                
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }       }
    
}
