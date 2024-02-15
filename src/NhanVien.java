import java.util.Scanner;

public class NhanVien {
    private String maNV,hoTen;
    private Double luong;
    public NhanVien() {
    }
    public NhanVien(String maNV, String hoTen, Double luong) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.luong = luong;
    }

    public String getMaNV() {
        return maNV;
    }
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public double getLuong() {
        return luong;
    }
    public void setLuong(Double luong) {
        this.luong = luong;
    }
    public Double getThuNhap(){
        return this.getLuong();
    }
    public Double getThueTn(Double tongLuong){
        Double thue;
        if (tongLuong < 9000000){
            thue=0.0;
        }else if (tongLuong < 15000000){
            thue=tongLuong*0.1;
        }else {
            thue=tongLuong*0.12;
        }
        return thue;
    }

    public String xuatThongTin() {
        return "Mã nhân viên: "+getMaNV()+
                "\nHọ tên: "+getHoTen();
    }
}
