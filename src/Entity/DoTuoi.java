
package Entity;

/**
 *
 * @author ADMIN
 */
public class DoTuoi {
    private int MaDTuoi;
    private String DoTuoi;
    private int TrangThai;

    public DoTuoi() {
    }

    public DoTuoi(int MaDTuoi, String DoTuoi, int TrangThai) {
        this.MaDTuoi = MaDTuoi;
        this.DoTuoi = DoTuoi;
        this.TrangThai = TrangThai;
    }

    public int getMaDTuoi() {
        return MaDTuoi;
    }

    public void setMaDTuoi(int MaDTuoi) {
        this.MaDTuoi = MaDTuoi;
    }

    public String getDoTuoi() {
        return DoTuoi;
    }

    public void setDoTuoi(String DoTuoi) {
        this.DoTuoi = DoTuoi;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    

    
    
}
