
package Entity;

/**
 *
 * @author ADMIN
 */
public class HinhThuc {
    private String MaHT;
    private String KieuSach;
    private int TrangThai;

    public HinhThuc() {
    }

    public HinhThuc(String MaHT, String TenLoaiBia, String KieuSach, int TrangThai) {
        this.MaHT = MaHT;
        this.KieuSach = KieuSach;
        this.TrangThai = TrangThai;
    }

    public String getMaHT() {
        return MaHT;
    }

    public void setMaHT(String MaHT) {
        this.MaHT = MaHT;
    }


    public String getKieuSach() {
        return KieuSach;
    }

    public void setKieuSach(String KieuSach) {
        this.KieuSach = KieuSach;
    }

    public int isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
