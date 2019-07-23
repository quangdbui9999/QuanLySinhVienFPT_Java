package quanlysinhvien;

import java.util.Scanner;

public class SinhVienTest {
    
    public static void printLine(){
        System.out.println();
        
        for(int i = 1; i <= 100; i++){
            if(i == 1 || i == 100){
                System.out.print("+");
            }else{
                System.out.print("-");
            }
        }
    }
    
    public static void printMenu(){
        printLine();
        System.out.printf("\n| %-90s %7s", "Menu", "|");
        System.out.printf("\n| %-90s %7s", "1. Nhap mot sinh vien moi.", "|");
        System.out.printf("\n| %-90s %7s", "2. Xem danh sach sin vien.", "|");
        System.out.printf("\n| %-90s %7s", "3. Sap xep danh sach tang dan theo tongg diem.", "|");
        System.out.printf("\n| %-90s %7s", "4. Kiem tra danh sach da duoc sap tang dan theo tong diem.", "|");
        System.out.printf("\n| %-90s %7s", "5. Tim kiem tuyen tinh theo tong diem.", "|");
        System.out.printf("\n| %-90s %7s", "6. Sua thong tin sinh vien (theo ma so sinh vien).", "|");
        System.out.printf("\n| %-90s %7s", "7. Xoa mot sinh vien ra khoi danh sach (theo ma so sinh vien).", "|");
        System.out.printf("\n| %-90s %7s", "8. Chen mot sinh vien vao danh sach da sap xep "
                + "ma tinh sap xep van duoc bao ton.", "|");
        System.out.printf("\n| %-90s %7s", "0. Ket thuc chuong trinh", "|");
        printLine();
    }
    
    public static void main(String[] args) {
        try{
            final int MAX = 100;
            Count n = new Count();
            SinhVien[] sinhVien = new SinhVien[MAX];
            int selected = -1;
            Scanner input = new Scanner(System.in);
            
            ThaoTac.createSinhVien(sinhVien, n);
            
            do{
                printMenu();
                System.out.print("\nBan chon chuc nang: ");
                selected = input.nextInt();
                System.out.flush();
                
                switch(selected){
                    case 1:{
                        System.out.print("\n1. Nhập một sinh viên mới."); 
                        ThaoTac.selectInput(sinhVien, n);
                        break;
                    }
                    case 2:{
                        System.out.print("\n2. Xem danh sách sinh viên.");
                        if(n.getN() == 0 ) 
                        { 
                            System.out.println("Chưa có sinh viên nào trong danh sách bạn hãy chọn menu 1 để nhập các thông tin cho sinh viên."); 
                        } 
                        else 
                        { 
                            ThaoTac.outputSinhVien(sinhVien, n.getN()); 
                        }
                        break;
                    }
                    case 3:{
                        System.out.print("\n3. Sắp xếp danh sách theo thứ tự tăng dần theo tổng điểm.");
                        if(n.getN() == 0 ) 
                        { 
                            System.out.println("Chưa có sinh viên nào trong danh sách bạn hãy chọn menu 1 để nhập các thông tin cho sinh viên."); 
                        } 
                        else 
                        { 
                            ThaoTac.sortSinhVien(sinhVien, n.getN()); 
                            System.out.println("\nDanh sách đã được sắp xếp theo tổng điểm."); 
                        } 
                        break;
                    }
                    case 4:{
                        System.out.print("\n4. Kiểm tra xem danh sách đã sắp xếp theo tổng điểm hay chưa.");
                        if(n.getN() == 0 ) 
                        { 
                            System.out.println("Chưa có sinh viên nào trong danh sách bạn hãy chọn menu 1 để nhập các thông tin cho sinh viên."); 
                        } 
                        else 
                        { 
                            ThaoTac.checkSort(sinhVien, n.getN()); 
                        }
                        break;
                    }
                    case 5:{
                        System.out.println("5. Tìm kiếm tuyến tính theo tổng điểm.");
                        if(n.getN() == 0 ) 
                        { 
                            System.out.println("Chưa có sinh viên nào trong danh sách bạn hãy chọn menu 1 để nhập các thông tin cho sinh viên."); 
                        } 
                        else 
                        { 
                            ThaoTac.findPoint(sinhVien, n.getN()); 
                        }
                        break;
                    }
                    case 6:{
                        System.out.print("\n6. Sửa tên sinh viên có mã được nhập từ bàn phím.");
                        if(n.getN() == 0 ) 
                        { 
                            System.out.println("Chưa có sinh viên nào trong danh sách bạn hãy chọn menu 1 để nhập các thông tin cho sinh viên."); 
                        } 
                        else 
                        { 
                            ThaoTac.editSinhVien(sinhVien, n.getN()); 
                        } 
                        break;
                    }
                    case 7:{
                        System.out.print("\n7. Xóa sinh viên có mã sinh viên được nhập từ bàn phím.");
                        if(n.getN() == 0 ) 
                        { 
                            System.out.println("Chưa có sinh viên nào trong danh sách bạn hãy chọn menu 1 để nhập các thông tin cho sinh viên."); 
                        } 
                        else 
                        { 
                            ThaoTac.removeAt(sinhVien, n); 
                        } 
                        break;
                    }
                    case 8:{
                        System.out.print("\n8. Chèn một sinh viên vào danh sách đã sắp xếp mà tính sắp xếp vẫn được bảo tồn. ");
                        if(n.getN() == 0 ) 
                        { 
                            System.out.println("Chưa có sinh viên nào trong danh sách bạn hãy chọn menu 1 để nhập các thông tin cho sinh viên."); 
                        } 
                        else 
                        { 
                            ThaoTac.insertSinhVien(sinhVien, n); 
                        }
                        break;
                    }
                    case 0:{
                        System.out.println("Ket thuc chuong trinh.");
                        break;
                    }
                    default:{
                        System.err.println("Chuong tring khong co chuc nang ma ban da lua chon.");
                        break;
                    }
                }
            }while(selected != 0);
        }catch(Exception ex){
            System.err.print("Bạn nhập sai chương trình tự động kết thúc."); 
            System.exit(0); 
        }
    }
}