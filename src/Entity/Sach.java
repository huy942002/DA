
package Entity;

/**
 *
 * @author ADMIN
 */
public class Sach {
    private String MaSach;
    private String TieuDe;
    private String TenNhaXB;
    private int TongSach;
    private int TrangThai;

    public Sach() {
    }

    public Sach(String MaSach, String TieuDe, String TenNhaXB, int TongSach, int TrangThai) {
        this.MaSach = MaSach;
        this.TieuDe = TieuDe;
        this.TenNhaXB = TenNhaXB;
        this.TongSach = TongSach;
        this.TrangThai = TrangThai;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getTieuDe() {
        return TieuDe;
    }

    public void setTieuDe(String TieuDe) {
        this.TieuDe = TieuDe;
    }

    public String getTenNhaXB() {
        return TenNhaXB;
    }

    public void setTenNhaXB(String TenNhaXB) {
        this.TenNhaXB = TenNhaXB;
    }


    public int getTongSach() {
        return TongSach;
    }

    public void setTongSach(int TongSach) {
        this.TongSach = TongSach;
    }

    public int isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
