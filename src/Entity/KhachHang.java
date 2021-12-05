
package Entity;

/**
 *
 * @author ADMIN
 */
public class KhachHang {
    private int MaKH;
    private String TenKH,GhiChu;
    private boolean GioiTinh;
    private String SDT;
    private int TrangThai;

    public KhachHang() {
    }

    public KhachHang(int MaKH, String TenKH, String GhiChu, boolean GioiTinh, String SDT, int TrangThai) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.GhiChu = GhiChu;
        this.GioiTinh = GioiTinh;
        this.SDT = SDT;
        this.TrangThai = TrangThai;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    
    @Override
    public String toString() {
        return "KhachHang{" + "TenKH=" + TenKH + ", SDT=" + SDT + '}';
    }

    
}
