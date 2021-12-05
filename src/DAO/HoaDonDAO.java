/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.HoaDon;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class HoaDonDAO extends DAO<HoaDon, String> {

    String INSERT_SQL = "INSERT INTO HOADON ( MAKH, MANV, TONGSOLUONG, TONGTIEN, NGAYMUA,GHICHU, TRANGTHAI) VALUES(?, ?, ?, ?, ?, ?,?)";
    String UPDATE_SQL = "UPDATE HOADON SET MAKH=?, MANV=?, TONGSOLUONG=?, TONGTIEN=?, NGAYMUA=?, TRANGTHAI=? WHERE MAHD=? ";
    String UPDATETH_SQL = "UPDATE HOADON SET  TONGSOLUONG=?, TONGTIEN=?, NGAYMUA=?,GHICHU=? TRANGTHAI=? WHERE MAHD=? ";
    String DELETE_SQL = "DELETE FROM HOADON WHERE MAHD=? ";
    String SELECT_ALL_SQL = "SELECT * FROM HOADON";
    String SELECT_ALL2_SQL = "SELECT * FROM HOADON WHERE TRANGTHAI >0";
    String SELECt_BY_ID_SQL = "SELECT*from HOADON where MAHD= ?";
    String UPDATETT_SQL = "UPDATE HOADON SET TONGSOLUONG=?, TONGTIEN=? WHERE MAHD=?";
    String UPDATETTHD_SQL = "UPDATE HOADON SET GHICHU=?,TRANGTHAI=? WHERE MAHD=? ";
    String UPDATEghichu_SQL = "UPDATE HOADON SET GHICHU=? WHERE MAHD=? ";

    @Override
    public void insert(HoaDon entity) {
        JDBCHelper.jdbcHelper.update(INSERT_SQL, entity.getMaKH(), entity.getMaNV(), entity.getTongSL(), entity.getTongTien(), entity.getNgaymua(),entity.getGhiChu(), entity.getTrangThai());

    }

    @Override
    public void update(HoaDon entity) {
        JDBCHelper.jdbcHelper.update(UPDATE_SQL, entity.getMaKH(), entity.getMaNV(), entity.getTongSL(), entity.getTongTien(), entity.getNgaymua(), entity.getTrangThai(), entity.getMaHd());
    }

    public void updateTHD(HoaDon entity) {
        JDBCHelper.jdbcHelper.update(UPDATETH_SQL, entity.getTongSL(), entity.getTongTien(), entity.getNgaymua(),entity.getGhiChu(), entity.getTrangThai(), entity.getMaHd());
    }

    public void updateTT(HoaDon entity) {
        JDBCHelper.jdbcHelper.update(UPDATETT_SQL, entity.getTongSL(), entity.getTongTien(), entity.getMaHd());
    }

    public void updateTTHD(String ghichu,int trangthai, int maHD) {
        JDBCHelper.jdbcHelper.update(UPDATETTHD_SQL, ghichu,trangthai, maHD);
    }
    public void updateGhiChu(String ghichu, int maHD) {
        JDBCHelper.jdbcHelper.update(UPDATEghichu_SQL, ghichu, maHD);
    }

    @Override
    public void delete(String id) {
        JDBCHelper.jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<HoaDon> selecALL() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    public List<HoaDon> selectHDChuaTT() {
        return this.selectBySql(SELECT_ALL2_SQL);
    }

    @Override
    public HoaDon selectById(String key) {
        List<HoaDon> list = this.selectBySql(SELECt_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.jdbcHelper.query(sql, args);
            while (rs.next()) {
                HoaDon entity = new HoaDon();
                entity.setMaHd(rs.getInt(1));
                entity.setMaKH(rs.getInt(2));
                entity.setMaNV(rs.getInt(3));
                entity.setTongSL(rs.getInt(4));
                entity.setTongTien(rs.getFloat(5));
                entity.setNgaymua(rs.getDate(6));
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

}
