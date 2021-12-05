
package Entity;

/**
 *
 * @author ADMIN
 */
public class CTHoaDon {
    private int MaCTHD;
    private int MaCTS;
    private int MaHD;
    private double GiaBan;
    private int SoLuong;
    private String Tieude,GhiChu;
    private int TrangThai;

    public CTHoaDon() {
    }

    public CTHoaDon(int MaCTHD, int MaCTS, int MaHD, double GiaBan, int SoLuong, String Tieude, String GhiChu, int TrangThai) {
        this.MaCTHD = MaCTHD;
        this.MaCTS = MaCTS;
        this.MaHD = MaHD;
        this.GiaBan = GiaBan;
        this.SoLuong = SoLuong;
        this.Tieude = Tieude;
        this.GhiChu = GhiChu;
        this.TrangThai = TrangThai;
    }

    public int getMaCTHD() {
        return MaCTHD;
    }

    public void setMaCTHD(int MaCTHD) {
        this.MaCTHD = MaCTHD;
    }

    public int getMaCTS() {
        return MaCTS;
    }

    public void setMaCTS(int MaCTS) {
        this.MaCTS = MaCTS;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getTieude() {
        return Tieude;
    }

    public void setTieude(String Tieude) {
        this.Tieude = Tieude;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    @Override
    public String toString() {
        return "CTHoaDon{" + "MaCTHD=" + MaCTHD + ", MaCTS=" + MaCTS + ", MaHD=" + MaHD + ", GiaBan=" + GiaBan + ", SoLuong=" + SoLuong + ", Tieude=" + Tieude + ", GhiChu=" + GhiChu + ", TrangThai=" + TrangThai + '}';
    }

    
}
