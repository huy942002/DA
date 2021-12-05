/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Entity.CTSach;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author User
 */
import java.util.List;/**
 *
 * @author User
 */
public class CTSachDAO extends DAO<CTSach, Integer>{
     String INSERT_SQL = "INSERT INTO CHITIETSACH (MASACH, GIA, SOLUONG, SOTRANG, HINH, MAHINHTHUC, TENNHACUNGCAP, MALB, MADTUOI, MANN, TRANGTHAI) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE CHITIETSACH SET MASACH=?, GIA=?, SOLUONG=?, SOTRANG=?, HINH=?, MAHINHTHUC=?, TENNHACUNGCAP=?, MALB=?, MADTUOI=?, MANN=?  TRANGTHAI=? WHERE MACTS=? ";
    String DELETE_SQL = "DELETE FROM CHITIETSACH WHERE MACTS=? ";
    String SELECT_ALL_SQL = "SELECT * FROM CHITIETSACH where TRANGTHAI=1";
    String SELECt_BY_ID_SQL = "SELECT * from CHITIETSACH where MACTS= ?";
    String SELECt_BY_HinhThuc_SQL = "SELECT*from CHITIETSACH where MAHINHTHUC=?";
    String SELECT_MAS_SQL = "SELECT * FROM CHITIETSACH WHERE MACTS=?";
    String UPDATESL_SQL = "UPDATE CHITIETSACH SET SOLUONG=? WHERE MACTS=? ";
    String SELECT_BYTL_SQL = "SELECT * FROM CHITIETSACH WHERE MASACH=?";
    String SELECT_BYDT_SQL = "SELECT * FROM CHITIETSACH WHERE MADTUOI=?";
    
    @Override
    public void insert(CTSach entity) {
            JDBCHelper.jdbcHelper.update(INSERT_SQL, entity.getMaSach(), entity.getGia(), entity.getSl(), entity.getSoTrang(), entity.getHinh(), entity.getMaHT(), entity.getTenNhaCP(), entity.getMaLB(), entity.getMaDTuoi(), entity.getMaNN(), entity.getTrangThai());
    }

    @Override
    public void update(CTSach entity) {
            JDBCHelper.jdbcHelper.update(UPDATE_SQL, entity.getMaSach(), entity.getGia(), entity.getSl(), entity.getSoTrang(), entity.getHinh(), entity.getMaHT(), entity.getTenNhaCP(), entity.getMaLB(), entity.getMaDTuoi(), entity.getMaNN(), entity.getTrangThai(), entity.getMaCTS());
    }
    public void updateSL(int SL,int MaCTS) {
            JDBCHelper.jdbcHelper.update(UPDATESL_SQL,SL,MaCTS);
    }
    @Override
    public List<CTSach> selecALL() {
        return this.selectBySql(SELECT_ALL_SQL);
    }
     public List<CTSach> selectBykey(int key) {
        return this.selectBySql(SELECT_MAS_SQL,key);
    }
     public List<CTSach> selectByTL(String key) {
        return this.selectBySql(SELECT_BYTL_SQL,key);
    }
    
    public void deletems(CTSach entity){
        JDBCHelper.jdbcHelper.update(INSERT_SQL,entity.getTrangThai(), entity.getMaCTS());
    }
    @Override
    public List<CTSach> selectBySql(String sql, Object... args) {
     List<CTSach> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.jdbcHelper.query(sql, args);
            while (rs.next()) {
                CTSach entity = new CTSach();
                entity.setMaCTS(rs.getInt(1));
                entity.setMaSach(rs.getString(2));
                entity.setGia(rs.getFloat(3));
                entity.setSl(rs.getInt(4));
                entity.setSoTrang(rs.getInt(5));
                entity.setHinh(rs.getString(6));
                entity.setMaHT(rs.getString(7));
                entity.setTenNhaCP(rs.getString(8));
                entity.setMaLB(rs.getInt(9));
                entity.setMaDTuoi(rs.getInt(10));
                entity.setMaNN(rs.getString(11));
                entity.setTrangThai(rs.getInt(12));
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
    public CTSach selectById(Integer key) {
        List<CTSach> list = this.selectBySql(SELECt_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
}
