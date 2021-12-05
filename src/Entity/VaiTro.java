
package Entity;

/**
 *
 * @author ADMIN
 */
public class VaiTro {
    private String IDVaiTro;
    private boolean VaiTro;
    private String Manv;
    private String TenNv;
    private int CaLamVcTu;
    private int CaLamVcDen;
    private int TrangThai;

    public VaiTro() {
    }

    public VaiTro(String IDVaiTro, boolean VaiTro, String Manv, String TenNv, int CaLamVcTu, int CaLamVcDen, int TrangThai) {
        this.IDVaiTro = IDVaiTro;
        this.VaiTro = VaiTro;
        this.Manv = Manv;
        this.TenNv = TenNv;
        this.CaLamVcTu = CaLamVcTu;
        this.CaLamVcDen = CaLamVcDen;
        this.TrangThai = TrangThai;
    }

    public String getIDVaiTro() {
        return IDVaiTro;
    }

    public void setIDVaiTro(String IDVaiTro) {
        this.IDVaiTro = IDVaiTro;
    }

    public boolean isVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(boolean VaiTro) {
        this.VaiTro = VaiTro;
    }

    public String getManv() {
        return Manv;
    }

    public void setManv(String Manv) {
        this.Manv = Manv;
    }

    public String getTenNv() {
        return TenNv;
    }

    public void setTenNv(String TenNv) {
        this.TenNv = TenNv;
    }

    public int getCaLamVcTu() {
        return CaLamVcTu;
    }

    public void setCaLamVcTu(int CaLamVcTu) {
        this.CaLamVcTu = CaLamVcTu;
    }

    public int getCaLamVcDen() {
        return CaLamVcDen;
    }

    public void setCaLamVcDen(int CaLamVcDen) {
        this.CaLamVcDen = CaLamVcDen;
    }

    public int isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    
}
