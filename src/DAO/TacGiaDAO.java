package DAO;

import Entity.NhaXuatBan;
import Entity.TacGia;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TacGiaDAO extends DAO<TacGia, String> {

    String INSERT_SQL = "INSERT INTO TACGIA (MATG, TENTG,BUTDANH, DIACHI, TRANGTHAI) VALUES (?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE TACGIA SET TENTG=?, BUTDANH=?, DIACHI=?, TRANGTHAI=? WHERE MATG=? ";
    String DELETE_SQL = "DELETE FROM TACGIA WHERE MATG=? ";
    String SELECT_ALL_SQL = "SELECT * FROM TACGIA ";
    String SELECt_BY_ID_SQL = "SELECT*from TACGIA where MATG= ?";

    @Override
    public void insert(TacGia entity) {
        JDBCHelper.jdbcHelper.update(INSERT_SQL, entity.getMaTG(), entity.getTenTG(), entity.getButDanh(), entity.getDiaChi(), entity.isTrangThai());
    }

    @Override
    public void update(TacGia entity) {
        JDBCHelper.jdbcHelper.update(UPDATE_SQL, entity.getMaTG(), entity.getTenTG(), entity.getButDanh(), entity.getDiaChi(), entity.isTrangThai());
    }

    @Override
    public void delete(String id) {
        JDBCHelper.jdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<TacGia> selecALL() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public TacGia selectById(String key) {
        List<TacGia> list = this.selectBySql(SELECt_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<TacGia> selectBySql(String sql, Object... args) {
        List<TacGia> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.jdbcHelper.query(sql, args);
            while (rs.next()) {
                TacGia entity = new TacGia();
                entity.setMaTG(rs.getString(1));
                entity.setTenTG(rs.getString(2));
                entity.setButDanh(rs.getString(3));
                entity.setDiaChi(rs.getString(4));

                entity.setTrangThai(rs.getInt(5));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
