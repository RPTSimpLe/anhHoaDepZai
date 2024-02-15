import java.util.Scanner;

public class TiepThi extends NhanVien{
    private Double doanhSo, hueHong;
    public TiepThi() {
    }
    public TiepThi(String maNV, String hoTen, Double luong, Double doanhSo, Double hueHong) {
        super(maNV, hoTen, luong);
        this.doanhSo = doanhSo;
        this.hueHong = hueHong;
    }

    public Double getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(Double doanhSo) {
        this.doanhSo = doanhSo;
    }

    public Double getHueHong() {
        return hueHong;
    }

    public void setHueHong(Double hueHong) {
        this.hueHong = hueHong;
    }

    @Override
    public Double getThuNhap() {
        Double tongLuong=this.getLuong()+(this.getDoanhSo()*this.getHueHong());
        return tongLuong - getThueTn(tongLuong);
    }
    @Override
    public String xuatThongTin() {
        return  "-------------------------------\n"
                +"Chức vụ: tiếp thị\n"+super.xuatThongTin()+ "\nLương: "+getThuNhap();
    }
    public TiepThi nhap(Scanner scanner) {
        TiepThi tiepThi;
        System.out.println("Nhập mã nhân viên: ");
        String maNV = scanner.nextLine();
        System.out.println("Nhập họ tên: ");
        String hoTen = scanner.nextLine();
        System.out.println("Nhập lương cơ bản: ");
        Double luong = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Nhập doanh số bán hàng: ");
        Double doanhSo = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Nhập huê hồng: ");
        Double hueHong = scanner.nextDouble();
        scanner.nextLine();
        return tiepThi = new TiepThi(maNV,hoTen,luong,doanhSo,hueHong);
    }
}
