
package Entity;

/**
 *
 * @author ADMIN
 */
public class LoaiBia {
    private  int MaLB;
    private String TenLB;
    private int TrangThai;

    public LoaiBia() {
    }

    public LoaiBia(int MaLB, String TenLB, int TrangThai) {
        this.MaLB = MaLB;
        this.TenLB = TenLB;
        this.TrangThai = TrangThai;
    }

    public int getMaLB() {
        return MaLB;
    }

    public void setMaLB(int MaLB) {
        this.MaLB = MaLB;
    }

    public String getTenLB() {
        return TenLB;
    }

    public void setTenLB(String TenLB) {
        this.TenLB = TenLB;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
