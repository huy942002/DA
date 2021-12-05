
package Entity;

/**
 *
 * @author ADMIN
 */
public class ViTri {
    private String MaVT;
    private String TenHang;
    private int TrangThai;

    public ViTri() {
    }

    public ViTri(String MaVT, String TenHang, int TrangThai) {
        this.MaVT = MaVT;
        this.TenHang = TenHang;
        this.TrangThai = TrangThai;
    }

    public String getMaVT() {
        return MaVT;
    }

    public void setMaVT(String MaVT) {
        this.MaVT = MaVT;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }

    public int isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
   
}
