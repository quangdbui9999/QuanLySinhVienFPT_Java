package quanlysinhvien;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SinhVien {
    private String maSV;
    private String hoTen;
    private String gioiTinh;
    private double diemToan;
    private double diemLy;
    private double diemHoa;

    public SinhVien(String maSV, String hoTen, String gioiTinh, 
            double diemToan, double diemLy, double diemHoa) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
    }
    
    public SinhVien(){
        this("", "", "", 0, 0, 0);
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public double getDiemToan() {
        return diemToan;
    }

    public void setDiemToan(double diemToan) {
        this.diemToan = diemToan;
    }

    public double getDiemLy() {
        return diemLy;
    }

    public void setDiemLy(double diemLy) {
        this.diemLy = diemLy;
    }

    public double getDiemHoa() {
        return diemHoa;
    }

    public void setDiemHoa(double diemHoa) {
        this.diemHoa = diemHoa;
    }
    
    public void inputSinhVien(){
        Scanner input = new Scanner(System.in);
        BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(System.in));
        
        try{
            
            do{
                System.out.print("\nBan nhap vao ma sinh vien (ma khong duoc trung, <= 10"
                        + " ky tu va khong chua ky tu dac biet): ");
                this.setMaSV(inputBuffer.readLine());
            }while(!ThaoTac.checkID(maSV));
            
            do{
                System.out.print("Ban nhap vao ho ten sinh vien (>= 5 ky tu): ");
                this.setHoTen(inputBuffer.readLine());
            }while(!ThaoTac.checkFullName(hoTen));
            
            do{
                System.out.print("Nhap vao gioi tinh sinh vien (khong de trong, nam hoac nu): ");
                setGioiTinh(inputBuffer.readLine());
            }while(!ThaoTac.checkSex(gioiTinh));
            
            do{
                System.out.print("Nhap vao diem Toan (0 - 10): ");
                setDiemToan(input.nextDouble());
            }while(!ThaoTac.checkPoint(diemToan));
            
            do{
                System.out.print("Nhap vao diem Ly (0 - 10): ");
                setDiemLy(input.nextDouble());
            }while(!ThaoTac.checkPoint(diemLy));
            
            do{
                System.out.print("Nhap vao diem Hoa (0 - 10): ");
                setDiemHoa(input.nextDouble());
            }while(!ThaoTac.checkPoint(diemHoa));
            System.out.flush();
        }catch(Exception ex){
            System.err.println("Error Message: " + ex.getMessage());
        }
    }
    
    public void editSinhVien(){
        Scanner input = new Scanner(System.in);
        BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(System.in));
        
        try{
            do{
                System.out.print("Ban nhap vao ho ten sinh vien (>= 5 ky tu): ");
                this.setHoTen(inputBuffer.readLine());
            }while(!ThaoTac.checkFullName(hoTen));
            
            do{
                System.out.print("Nhap vao gioi tinh sinh vien (khong de trong, nam hoac nu): ");
                setGioiTinh(inputBuffer.readLine());
            }while(!ThaoTac.checkSex(gioiTinh));
            
            do{
                System.out.print("Nhap vao diem Toan (0 - 10): ");
                setDiemToan(input.nextDouble());
            }while(!ThaoTac.checkPoint(diemToan));
            
            do{
                System.out.print("Nhap vao diem Ly (0 - 10): ");
                setDiemLy(input.nextDouble());
            }while(!ThaoTac.checkPoint(diemLy));
            
            do{
                System.out.print("Nhap vao diem Hoa (0 - 10): ");
                setDiemHoa(input.nextDouble());
            }while(!ThaoTac.checkPoint(diemHoa));
            System.out.flush();
        }catch(Exception ex){
            System.err.println("Error Message: " + ex.getMessage());
        }
    }
    
    public void displaySinhVien(){
        try{
            System.out.printf(" %-10s | %-35s | %-9s | %-10.2f | %-10.2f "
                + "| %-10.2f ", maSV, hoTen, gioiTinh,
                diemToan, diemLy, diemHoa);
        }catch(Exception ex){
            System.err.println("Error Message: " + ex.getMessage());
        }
    }
}
