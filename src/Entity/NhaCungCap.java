
package Entity;

/**
 *
 * @author ADMIN
 */
public class NhaCungCap {
    private String TenNhaCP;
    private String DiaChi;
    private String SDT;
    private int TrangThai;

    public NhaCungCap() {
    }

    public NhaCungCap(String TenNhaCP, String DiaChi, String SDT, int TrangThai) {
        this.TenNhaCP = TenNhaCP;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.TrangThai = TrangThai;
    }

    public String getTenNhaCP() {
        return TenNhaCP;
    }

    public void setTenNhaCP(String TenNhaCP) {
        this.TenNhaCP = TenNhaCP;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public int isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
     
}
