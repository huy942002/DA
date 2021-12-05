
package Entity;

/**
 *
 * @author ADMIN
 */
public class NgonNgu {
    private String MaNN;
    private String LoaiNN;
    private int TrangThai;

    public NgonNgu() {
    }

    public NgonNgu(String MaNN, String LoaiNN, int TrangThai) {
        this.MaNN = MaNN;
        this.LoaiNN = LoaiNN;
        this.TrangThai = TrangThai;
    }

    public String getMaNN() {
        return MaNN;
    }

    public void setMaNN(String MaNN) {
        this.MaNN = MaNN;
    }

    public String getLoaiNN() {
        return LoaiNN;
    }

    public void setLoaiNN(String LoaiNN) {
        this.LoaiNN = LoaiNN;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

   
    
}
