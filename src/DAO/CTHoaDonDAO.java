package DAO;

import Entity.CTHoaDon;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CTHoaDonDAO extends DAO<CTHoaDon, Integer> {

    String INSERT_SQL = "INSERT INTO CTHoaDon( MACTS, MAHD, GIABAN, SL, TIEUDE,GHICHU, TRANGTHAI) VALUES ( ?, ?, ?, ?, ?,?, ?)";
    String UPDATE_SQL = "UPDATE CTHoaDon SET MACTS=?, MAHD=?, GIABAN=?, SL=?, TIEUDE=?,TRANGTHAI=? WHERE MACTHD=? ";
    String UPDATESL_SQL = "UPDATE CTHoaDon SET SL=? WHERE MACTHD=? ";
    String DELETE_SQL = "DELETE FROM CTHoaDon WHERE MACTHD=? ";
    String SELECT_ALL_SQL = "SELECT * FROM CTHoaDon";
    String SELECt_BY_ID_SQL = "SELECT* from CTHoaDon where MAHD= ? AND TRANGTHAI=0";

    @Override
    public void insert(CTHoaDon entity) {
        JDBCHelper.jdbcHelper.update(INSERT_SQL, entity.getMaCTS(), entity.getMaHD(), entity.getGiaBan(), entity.getSoLuong(), entity.getTieude(), entity.getGhiChu(), entity.getTrangThai());
    }

    @Override
    public void update(CTHoaDon entity) {
        JDBCHelper.jdbcHelper.update(INSERT_SQL, entity.getMaCTHD(), entity.getMaHD(), entity.getMaCTS(), entity.getGiaBan(), entity.getSoLuong(), entity.getTieude());
    }

    public void updateSL(CTHoaDon entity) {
        JDBCHelper.jdbcHelper.update(UPDATESL_SQL, entity.getSoLuong(), entity.getMaCTHD());
    }
    public void updateSL2(int sl ,int mahdct) {
        JDBCHelper.jdbcHelper.update(UPDATESL_SQL,sl,mahdct);
    }


    @Override
    public List<CTHoaDon> selecALL() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    public List<CTHoaDon> selectbykey(int key) {
        return this.selectBySql(SELECt_BY_ID_SQL, key);
    }

    @Override
    public List<CTHoaDon> selectBySql(String sql, Object... args) {
        List<CTHoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.jdbcHelper.query(sql, args);
            while (rs.next()) {
                CTHoaDon entity = new CTHoaDon();
                entity.setMaCTHD(rs.getInt(1));
                entity.setMaCTS(rs.getInt(2));
                entity.setMaHD(rs.getInt(3));
                entity.setGiaBan(rs.getDouble(4));
                entity.setSoLuong(rs.getInt(5));
                entity.setTieude(rs.getString(6));
                entity.setGhiChu(rs.getString(7));
                entity.setTrangThai(rs.getInt(8));

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
    public CTHoaDon selectById(Integer key) {
        List<CTHoaDon> list = this.selectBySql(SELECt_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

}
