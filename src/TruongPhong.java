import java.util.Scanner;

public class TruongPhong extends NhanVien{
    private Double trachNhiem;
    public TruongPhong() {
    }
    public TruongPhong(String maNV, String hoTen, Double luong, Double trachNhiem) {
        super(maNV, hoTen, luong);
        this.trachNhiem = trachNhiem;
    }
    public Double getTrachNhiem() {
        return trachNhiem;
    }
    public void setTrachNhiem(Double trachNhiem) {
        this.trachNhiem = trachNhiem;
    }
    @Override
    public Double getThuNhap(){
        Double tongLuong=this.getLuong()+this.getTrachNhiem();
        return tongLuong - getThueTn(tongLuong);
    }
    @Override
    public String xuatThongTin() {
        return "-------------------------------\n"
                +"Chức vụ: trưởng phòng\n"+super.xuatThongTin()+ "\nLương: "+getThuNhap();
    }

    public TruongPhong nhap(Scanner scanner) {
        TruongPhong truongPhong;
        System.out.println("Nhập mã nhân viên: ");
        String maNV = scanner.nextLine();
        System.out.println("Nhập họ tên: ");
        String hoTen = scanner.nextLine();
        System.out.println("Nhập lương cơ bản: ");
        Double luong = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Nhập lương trách nhiệm: ");
        Double trachNhiem = scanner.nextDouble();
        scanner.nextLine();
        return truongPhong = new TruongPhong(maNV,hoTen,luong,trachNhiem);
    }
}
