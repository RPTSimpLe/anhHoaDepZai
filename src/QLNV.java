import java.util.*;

public class QLNV {
    private List<TruongPhong> truongPhongs = new ArrayList<>();
    private List<TiepThi> tiepThis = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    public void menu(){
        Integer luachon;
        Boolean lap = true;
        while (lap) {
            System.out.println();
            System.out.println("-----------------MENU------------");
            System.out.println("1. Nhập danh sách nhân viên");
            System.out.println("2. Xuất danh sách nhân viên");
            System.out.println("3. Tìm và hiển thị nhân viên theo mã");
            System.out.println("4. Xóa nhân viên theo mã");
            System.out.println("5. Cập nhật thông tin nhân viên theo mã");
            System.out.println("6. Tìm các nhân viên theo khoảng lương");
            System.out.println("7. Sắp xếp nhân viên theo họ và tên");
            System.out.println("8. Sắp xếp nhân viên theo thu nhập");
            System.out.println("9. Xuất 5 nhân viên có thu nhập cao nhất");
            System.out.println("0. Thoát");

            System.out.print("Chọn chức năng (0-9): ");
            luachon = scanner.nextInt();
            scanner.nextLine();

            switch (luachon) {
                case 1:
                    nhapDanhSachNV();
                    break;
                case 2:
                    xuatDanhSachNV();
                    break;
                case 3:
                    timKiemTheoMa();
                    break;
                case 4:
                    xoaTheoMa();
                    break;
                case 5:
                    capNhatTheoMa();
                    break;
                case 6:
                    timKiemTheoKhoangLuong();
                    break;
                case 7:
                    sapXepTheoTen();
                    break;
                case 8:
                    sapXepTheoThuNhap();
                    break;
                case 9:
                    thuNhapCaoNhat();
                    break;
                case 0:
                    System.out.println("Kết thúc chương trình.");
                    lap = false;
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ.");
            }
        }
    }

    public void nhapDanhSachNV(){
        Boolean lap=true;
        System.out.println("Chọn chức vụ: ");
        System.out.println("1.Trưởng phòng");
        System.out.println("2. Nhân viên tiếp thị");

        Integer luachon = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Số nhân viên cần thêm: ");
        Integer soNV = scanner.nextInt();
        scanner.nextLine();
        switch (luachon) {
            case 1:
                TruongPhong truongPhong = new TruongPhong();
                for (int i = 0; i < soNV; i++) {
                    System.out.println();
                    System.out.println("Trưởng phòng thứ "+(i+1));
                    truongPhongs.add(truongPhong.nhap(scanner));
                }
                break;
            case 2:
                TiepThi tiepThi = new TiepThi();
                for (int i = 0; i < soNV; i++) {
                    System.out.println();
                    System.out.println("Tiếp thị thứ "+(i+1));
                    tiepThis.add(tiepThi.nhap(scanner));
                }
                break;
            default:
                System.out.println("Chức năng không hợp lệ.");
        }
    }

    public void xuatDanhSachNV(){
        for (TruongPhong truongPhong :truongPhongs){
            System.out.println();
            System.out.println(truongPhong.xuatThongTin());
        }

        for (TiepThi tiepThi :tiepThis){
            System.out.println();
            System.out.println(tiepThi.xuatThongTin());
        }
    }

    public void timKiemTheoMa(){
        System.out.println("Nhập mã nhân viên cần tìm: ");
        String maNV = scanner.nextLine();
        for (TruongPhong truongPhong :truongPhongs){
            if(maNV.equals(truongPhong.getMaNV())){
                System.out.println(truongPhong.xuatThongTin());
            }
        }

        for (TiepThi tiepThi :tiepThis){
            if(maNV.equals(tiepThi.getMaNV())){
                System.out.println(tiepThi.xuatThongTin());
            }
        }
    }

    public void xoaTheoMa(){
        System.out.println("Nhập mã nhân viên cần xóa: ");
        String maNV = scanner.nextLine();
        for (int i = 0; i<truongPhongs.size();i++){
            if(maNV.equals(truongPhongs.get(i).getMaNV())){
                truongPhongs.remove(truongPhongs.get(i));
                System.out.println("xóa thành công!");
            }
        }

        for (int i = 0; i<tiepThis.size();i++){
            if(maNV.equals(tiepThis.get(i).getMaNV())){
                tiepThis.remove(tiepThis.get(i));
                System.out.println("xóa thành công!");
            }
        }
    }
    public void capNhatTheoMa(){
        System.out.println("Nhập mã nhân viên cần cập nhật: ");
        String maNV = scanner.nextLine();

        for (TruongPhong truongPhong :truongPhongs){
            if(maNV.equals(truongPhong.getMaNV())){
                System.out.println(truongPhong.xuatThongTin());
                System.out.println("Vui lòng nhập thông tin cập nhật: ");
                System.out.println("Họ tên: ");
                String hoTen = scanner.nextLine();
                System.out.println("Lương cơ bản: ");
                Double luong = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Lương trách nhiệm: ");
                Double trachNhiem = scanner.nextDouble();

                truongPhong.setHoTen(hoTen);
                truongPhong.setLuong(luong);
                truongPhong.setTrachNhiem(trachNhiem);

                System.out.println();
                System.out.println("Thông tin sau cập nhật: ");
                System.out.println(truongPhong.xuatThongTin());
            }
        }

        for (TiepThi tiepThi :tiepThis){
            if(maNV.equals(tiepThi.getMaNV())){
                System.out.println(tiepThi.xuatThongTin());
                System.out.println("Vui lòng nhập thông tin cập nhật: ");
                System.out.println("Họ tên: ");
                String hoTen = scanner.nextLine();
                System.out.println("Lương cơ bản: ");
                Double luong = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Doanh số bán hàng: ");
                Double doanhSo = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Huê hồng: ");
                Double hueHong = scanner.nextDouble();
                scanner.nextLine();

                tiepThi.setHoTen(hoTen);
                tiepThi.setLuong(luong);
                tiepThi.setDoanhSo(doanhSo);
                tiepThi.setHueHong(hueHong);

                System.out.println();
                System.out.println("Thông tin sau cập nhật: ");
                System.out.println(tiepThi.xuatThongTin());
            }
        }
    }
    public void timKiemTheoKhoangLuong(){
        System.out.println("Nhập khoảng lương cần tìm");
        System.out.print("Từ: ");
        Double tu = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Đến: ");
        Double den = scanner.nextDouble();
        scanner.nextLine();

        for (TruongPhong truongPhong :truongPhongs){
            if(tu<truongPhong.getLuong() && truongPhong.getLuong()<den){
                System.out.println(truongPhong.xuatThongTin());
            }
        }

        for (TiepThi tiepThi :tiepThis){
            if(tu<tiepThi.getLuong() && tiepThi.getLuong()<den){
                System.out.println(tiepThi.xuatThongTin());
            }
        }
    }
    public List<Double> danhSachThuNhap(){
        List<Double> thuNhaps = new ArrayList<>();

        for (TruongPhong truongPhong : truongPhongs) {
            thuNhaps.add(truongPhong.getThuNhap());
        }
        for (TiepThi tiepThi : tiepThis) {
            thuNhaps.add(tiepThi.getThuNhap());
        }
        Collections.sort(thuNhaps, new Comparator<Double>() {
            @Override
            public int compare(Double tp1, Double tp2) {
                return tp1.compareTo(tp2);
            }
        });
        return thuNhaps;
    }
    public void sapXepTheoThuNhap(){
        List<Double> thuNhaps = danhSachThuNhap();
        System.out.println("-------------Danh sách nhân viên theo thu nhập--------------- ");
        for (Double thuNhap : thuNhaps){
            for (TruongPhong truongPhong : truongPhongs) {
                if (thuNhap.equals(truongPhong.getThuNhap())){
                    System.out.println(truongPhong.xuatThongTin());
                }
            }
            for (TiepThi tiepThi : tiepThis) {
                if (thuNhap.equals(tiepThi.getThuNhap())){
                    System.out.println(tiepThi.xuatThongTin());
                }
            }
        }
    }
    public void thuNhapCaoNhat(){
        List<Double> thuNhaps = danhSachThuNhap();
        System.out.println("-------------Danh sách 5 nhân viên thu nhập cao nhất--------------- ");
        Integer n = thuNhaps.size() -1;
        Integer count =0;

        for (int i = n; i > 0; i--) {
            for (TruongPhong truongPhong : truongPhongs) {
                if (thuNhaps.get(i).equals(truongPhong.getThuNhap())){
                    System.out.println(truongPhong.xuatThongTin());
                    count++;
                }
            }
            for (TiepThi tiepThi : tiepThis) {
                if (thuNhaps.get(i).equals(tiepThi.getThuNhap())){
                    System.out.println(tiepThi.xuatThongTin());
                    count++;
                }
            }
            if (count == 5){
                break;
            }
        }
    }
    public void sapXepTheoTen(){
        List<String> hoTens = new ArrayList<>();
        System.out.println("-------------Danh sách trưởng phòng theo tên--------------- ");

        for (TruongPhong truongPhong : truongPhongs) {
           hoTens.add(truongPhong.getHoTen());
        }
        for (TiepThi tiepThi : tiepThis) {
           hoTens.add(tiepThi.getHoTen());
        }
        Collections.sort(hoTens, new Comparator<String>() {
            @Override
            public int compare(String tp1, String tp2) {
                return tp1.compareTo(tp2);
            }
        });

        for (String hoTen : hoTens){
            for (TruongPhong truongPhong : truongPhongs) {
                if (hoTen.equals(truongPhong.getHoTen())){
                    System.out.println(truongPhong.xuatThongTin());
                }
            }
            for (TiepThi tiepThi : tiepThis) {
                if (hoTen.equals(tiepThi.getHoTen())){
                    System.out.println(tiepThi.xuatThongTin());
                }
            }
        }
    }
}
