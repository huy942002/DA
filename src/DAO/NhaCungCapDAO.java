/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Entity.NhaCungCap;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NhaCungCapDAO extends DAO<NhaCungCap, String>{
    String INSERT_SQL = "INSERT INTO NhaCungCap (TENNHACUNGCAP, DIACHI, SDT, TRANGTHAI) VALUES (?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE NhaCungCap SET DIACHI=?, SDT=?, TRANGTHAI=? WHERE TENNHACUNGCAP=? ";
    String DELETE_SQL = "DELETE FROM NhaCungCap WHERE TENNHACUNGCAP=? ";
    String SELECT_ALL_SQL = "SELECT * FROM NhaCungCap ";
    String SELECt_BY_ID_SQL = "SELECT*from NhaCungCap where TENNHACUNGCAP= ?";
    @Override
    public void insert(NhaCungCap entity) {
     JDBCHelper.jdbcHelper.update(INSERT_SQL, entity.getTenNhaCP(), entity.getDiaChi(), entity.getSDT(), entity.isTrangThai());
    }

    @Override
    public void update(NhaCungCap entity) {
     JDBCHelper.jdbcHelper.update(UPDATE_SQL, entity.getTenNhaCP(), entity.getDiaChi(), entity.getSDT(), entity.isTrangThai());
    }

    @Override
    public void delete(String id) {
      JDBCHelper.jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<NhaCungCap> selecALL() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NhaCungCap selectById(String key) {
 List<NhaCungCap> list = this.selectBySql(SELECt_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);      }

    @Override
    public List<NhaCungCap> selectBySql(String sql, Object... args) {
List<NhaCungCap> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.jdbcHelper.query(sql, args);
            while (rs.next()) {
                NhaCungCap entity = new NhaCungCap();
                entity.setTenNhaCP(rs.getString(1));
                entity.setDiaChi(rs.getString(2));
                entity.setSDT(rs.getString(3));
                
                
                entity.setTrangThai(rs.getInt(4));
                
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }            }
    
}
