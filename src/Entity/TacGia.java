
package Entity;

/**
 *
 * @author ADMIN
 */
public class TacGia {
    private String MaTG;
    private String TenTG;
    private String ButDanh;
    private String DiaChi;
    private int TrangThai;

    public TacGia() {
    }

    public TacGia(String MaTG, String TenTG, String ButDanh, String DiaChi, int TrangThai) {
        this.MaTG = MaTG;
        this.TenTG = TenTG;
        this.ButDanh = ButDanh;
        this.DiaChi = DiaChi;
        this.TrangThai = TrangThai;
    }

    public String getMaTG() {
        return MaTG;
    }

    public void setMaTG(String MaTG) {
        this.MaTG = MaTG;
    }

    public String getTenTG() {
        return TenTG;
    }

    public void setTenTG(String TenTG) {
        this.TenTG = TenTG;
    }

    public String getButDanh() {
        return ButDanh;
    }

    public void setButDanh(String ButDanh) {
        this.ButDanh = ButDanh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }


    public int isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    
}
