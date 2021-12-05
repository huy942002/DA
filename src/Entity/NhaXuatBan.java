
package Entity;

/**
 *
 * @author ADMIN
 */
public class NhaXuatBan {
   private  String TenNhaXB;
   private  String DiaChi;
   private String SDT;
   private int TrangThai;

    public NhaXuatBan() {
    }

    public NhaXuatBan(String TenNhaXB, String DiaChi, String SDT, int TrangThai) {
        this.TenNhaXB = TenNhaXB;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.TrangThai = TrangThai;
    }

    public String getTenNhaXB() {
        return TenNhaXB;
    }

    public void setTenNhaXB(String TenNhaXB) {
        this.TenNhaXB = TenNhaXB;
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
