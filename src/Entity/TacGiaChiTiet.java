
package Entity;

/**
 *
 * @author ADMIN
 */
public class TacGiaChiTiet {
    private String MaTGCT;
    private String MaTG;
    private String MaCTS;
    private int TrangThai;

    public TacGiaChiTiet() {
    }

    public TacGiaChiTiet(String MaTGCT, String MaTG, String MaCTS, int TrangThai) {
        this.MaTGCT = MaTGCT;
        this.MaTG = MaTG;
        this.MaCTS = MaCTS;
        this.TrangThai = TrangThai;
    }

    public String getMaTGCT() {
        return MaTGCT;
    }

    public void setMaTGCT(String MaTGCT) {
        this.MaTGCT = MaTGCT;
    }

    public String getMaTG() {
        return MaTG;
    }

    public void setMaTG(String MaTG) {
        this.MaTG = MaTG;
    }

    public String getMaCTS() {
        return MaCTS;
    }

    public void setMaCTS(String MaCTS) {
        this.MaCTS = MaCTS;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    
}
