
package Entity;

/**
 *
 * @author ADMIN
 */
public class TheLoai {
    private int MaTL;
    private String TenTL;
    private String MaVT;
    private int TrangThai;

    public TheLoai() {
    }

    public TheLoai(int MaTL, String TenTL, String MaVT, int TrangThai) {
        this.MaTL = MaTL;
        this.TenTL = TenTL;
        this.MaVT = MaVT;
        this.TrangThai = TrangThai;
    }

    public int getMaTL() {
        return MaTL;
    }

    public void setMaTL(int MaTL) {
        this.MaTL = MaTL;
    }

    public String getTenTL() {
        return TenTL;
    }

    public void setTenTL(String TenTL) {
        this.TenTL = TenTL;
    }

    public String getMaVT() {
        return MaVT;
    }

    public void setMaVT(String MaVT) {
        this.MaVT = MaVT;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    
}
