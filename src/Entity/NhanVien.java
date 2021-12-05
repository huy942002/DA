
package Entity;

/**
 *
 * @author ADMIN
 */
public class NhanVien {
    private int Manv;
    private String TenNv;
    private String MatKhau;
    private boolean GioiTinh; 
    private int Tuoi; 
    private String DiaChi;
    private String SDT;
    private int TrangThai;

    public NhanVien() {
    }

    public NhanVien(int Manv, String TenNv, String MatKhau, boolean GioiTinh, int Tuoi, String DiaChi, String SDT, int TrangThai) {
        this.Manv = Manv;
        this.TenNv = TenNv;
        this.MatKhau = MatKhau;
        this.GioiTinh = GioiTinh;
        this.Tuoi = Tuoi;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.TrangThai = TrangThai;
    }

    public int getManv() {
        return Manv;
    }

    public void setManv(int Manv) {
        this.Manv = Manv;
    }

    public String getTenNv() {
        return TenNv;
    }

    public void setTenNv(String TenNv) {
        this.TenNv = TenNv;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public void setTuoi(int Tuoi) {
        this.Tuoi = Tuoi;
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

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    

}
