
package DAO;

import Entity.NhaXuatBan;
import Entity.TheLoai;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class NhaXuatBanDAO extends DAO<NhaXuatBan, String>{
    String INSERT_SQL = "INSERT INTO NHAXUATBAN (TENNHAXUATBAN, DIACHI,SDT, TRANGTHAI) VALUES (?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE NHAXUATBAN SET DIACHI=?, SDT=?, TRANGTHAI=? WHERE TENNHAXUATBAN=? ";
    String DELETE_SQL = "DELETE FROM NHAXUATBAN WHERE TENNHAXUATBAN=? ";
    String SELECT_ALL_SQL = "SELECT * FROM NHAXUATBAN ";
    String SELECt_BY_ID_SQL = "SELECT*from NHAXUATBAN where TENNHAXUATBAN= ?";
    @Override
    public void insert(NhaXuatBan entity) {
        JDBCHelper.jdbcHelper.update(INSERT_SQL, entity.getTenNhaXB(), entity.getDiaChi(), entity.getSDT(), entity.isTrangThai());
    }

    @Override
    public void update(NhaXuatBan entity) {
        JDBCHelper.jdbcHelper.update(UPDATE_SQL, entity.getTenNhaXB(), entity.getDiaChi(), entity.getSDT(), entity.isTrangThai());
    }

    @Override
    public void delete(String id) {
         JDBCHelper.jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<NhaXuatBan> selecALL() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NhaXuatBan selectById(String key) {
         List<NhaXuatBan> list = this.selectBySql(SELECt_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhaXuatBan> selectBySql(String sql, Object... args) {
        List<NhaXuatBan> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.jdbcHelper.query(sql, args);
            while (rs.next()) {
                NhaXuatBan entity = new NhaXuatBan();
                entity.setTenNhaXB(rs.getString(1));
                entity.setDiaChi(rs.getString(2));
                entity.setSDT(rs.getString(3));
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
