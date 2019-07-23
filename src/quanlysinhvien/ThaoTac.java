package quanlysinhvien;

import java.util.Scanner;

public class ThaoTac {
    public static void printFormat(){
        System.out.println();
        
        for(int i = 1; i <= 129; i++){
            if (i == 1 || i == 14 || i == 27 || i == 65 || i == 77 
                    || i == 90 || i == 103 || i == 116 || i == 129){ 
                System.out.print("+"); 
            }else{ 
                System.out.print("-"); 
            }
        }
    }
    
    public static void printTile(){
        printFormat();
        System.out.printf("\n| %-10s | %-10s | %-35s | %-9s | %-10s | %-10s "
                + "| %-10s | %-10s |", "STT", "Mã SV", "Họ Và Tên", 
                "Giới Tính", "Điểm Toán", "Điểm Lý", "Điểm Hóa", "Tổng Điểm");
        printFormat();
    }
    
    public static String removeSpace(String s, boolean check){
        try{
            // xoa tat ca dau cach dau va cuoi xau
            s = s.trim();
            
            // xoa 2 dau cach lien nhau
            while(s.lastIndexOf("  ") != -1){
                s = s.replaceAll("  ", " ");
            }
            
            // xoa tat ca dau cach con lai trong xau, dung cho maHS va Gioi Tinh
            if(check == true){
                while(s.lastIndexOf(" ") != -1){
                    s = s.replaceAll(" ", "");
                }
            }
            return s;
        }catch(Exception ex){
            throw ex;
            //System.err.println("Error Message: " + ex.getMessage());
        }
    }
    
    public static void standardized(SinhVien temp){
        try{
            temp.setMaSV(removeSpace(temp.getMaSV(), true));
            temp.setHoTen(removeSpace(temp.getHoTen(), false));
            temp.setGioiTinh(removeSpace(temp.getGioiTinh(), true));
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static int checkIDExists(SinhVien[] sinhVien, String ID, int n){
        try{
            int result = -1;
            
            if(n > 0){
                for(int i = 0; i < n; i++){
                    if(ID.equalsIgnoreCase(sinhVien[i].getMaSV())){
                        result = i;
                        break;
                    }
                }
            }
            return result;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static boolean checkID(String s){
        try{
            String regex = "^[A-Za-z0-9_.]+$";
            // ID chi chua ky tu (A-Z, a-z, 0-9), do dai = 10
            if(s.matches(regex)){
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static boolean checkFullName(String s){
        try{
            String regex = "[a-z A-Z]{5,40}";
            // ho ten chi chua ky tu (A-Z, a-z)
            if(s.matches(regex)){
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static boolean checkSex(String s){
        try{
            if(s.equalsIgnoreCase("nam") || s.equalsIgnoreCase("nu")){
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static boolean checkPoint(double point){
        try{
            // diem (0 - 10)
            if(point >= 0 && point <= 10){
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static boolean checkContinue(String s){
        try{
            if(s.equalsIgnoreCase("continue") || s.equalsIgnoreCase("new") 
                    || s.equalsIgnoreCase("cancel")){
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static boolean checkAll(SinhVien temp){
        try{
            if(checkID(temp.getMaSV()) && checkFullName(temp.getHoTen())
                    && checkSex(temp.getGioiTinh()) && checkPoint(temp.getDiemToan())
                    && checkPoint(temp.getDiemLy()) && checkPoint(temp.getDiemHoa())){
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static void inputSinhVien(SinhVien[] sinhVien, Count n){
        SinhVien temp = null;
        Scanner input = new Scanner(System.in);
        sinhVien = new SinhVien[99];
        try{
            do{
                System.out.print("\nNhap so luong sinh vien (0 < n < 100): ");
                n.setN(input.nextInt());
            }while(!(0 < n.getN() && n.getN() < 100));
            
            for(int i = 0; i < n.getN(); i++){
                System.out.print("Nhap thong tin sinh vien thu " + (i + 1) + ": ");
                temp = new SinhVien();
                
                do{
                    temp.inputSinhVien();
                    standardized(temp);
                    
                    if(checkIDExists(sinhVien, temp.getMaSV(), i) != -1){
                        System.err.println("Sinh vien " + temp.getMaSV() + " da co trong danh sach.\n"
                            + "Moi ban nhap lai");
                    }
                }while(!checkAll(temp) || checkIDExists(sinhVien, temp.getMaSV(), i) != -1);
                System.out.println("i = " + i);
                sinhVien[i] = temp;
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static void addSinhVien(SinhVien[] sinhVien, Count n){
        SinhVien temp = null;
        Scanner input = new Scanner(System.in);
        int count = 0, m = n.getN();
        
        try{
            do{
                System.out.print("\nNhap so luong sinh vien muon them (so luong <= " + (99 - n.getN()) + "): ");
                count = input.nextInt();
            }while(!(count <= (99 - n.getN())) || count <= 0);
            
            n.setN(n.getN() + count);
            
            for(int i = m; i < n.getN(); i++){
                System.out.print("Nhap thong tin sinh vien thu " + (i + 1) + ": ");
                temp = new SinhVien();
                
                do{
                    temp.inputSinhVien();
                    standardized(temp);
                    
                    if(checkIDExists(sinhVien, temp.getMaSV(), i) != -1){
                        System.err.println("Sinh vien " + temp.getMaSV() + " da co trong danh sach.\n"
                            + "Moi ban nhap lai");
                    }
                }while(!checkAll(temp) || checkIDExists(sinhVien, temp.getMaSV(), i) != -1);
                
                sinhVien[i] = temp;
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static void outputSinhVien(SinhVien[] sinhVien, int n){
        try{
            printTile(); // in ra tieu de
            
            for(int i = 0; i < n; i++){
                System.out.printf("\n| %-10d |", i + 1); 
                sinhVien[i].displaySinhVien();
                System.out.printf("| %-10.2f |", sum(sinhVien[i]));
                printFormat();
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static double sum(SinhVien temp) {
        try{
            return temp.getDiemToan()+ temp.getDiemLy()+ temp.getDiemHoa();
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static void sortSinhVien(SinhVien[] sinhVien, int n){
        SinhVien temp = null;
        try{ // sap xep sinh vien theo tong diem
            for(int i = 0; i < (n - 1); i++){
                for(int j = i + 1; j < n; j++){
                    if(sum(sinhVien[i]) < sum(sinhVien[j])){
                        temp = sinhVien[i];
                        sinhVien[i] = sinhVien[j];
                        sinhVien[j] = temp;
                    }
                }
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static void checkSort(SinhVien[] sinhVien, int n){
        try{
            int i = 0;
            for(i = 0; i < (n - 1); i++){
                if(sum(sinhVien[i]) < sum(sinhVien[i + 1])){
                    break;
                }
            }
            
            if(i == (n - 1)){
                System.out.println("Danh sach sinh vien DA DUOC SAP XEP THEO TONG DIEM.");
            }else{
                System.err.println("Danh sach CHUA DUOC SAP XEP THEO TONG DIEM.");
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static void insertSinhVien(SinhVien[] sinhVien, Count n){
        Scanner input = new Scanner(System.in);
        SinhVien temp = new SinhVien();
        String ID = "";
        int location = 0;
        
        try{
            do{
                System.out.print("\nBan nhap vao ma sinh vien (ma khong duoc trung, <= 10"
                        + " ky tu va khong chua ky tu dac biet): ");
                ID = input.nextLine();
                removeSpace(ID, true);
            }while(!checkID(ID));
            
            sortSinhVien(sinhVien, n.getN());
            location = checkIDExists(sinhVien, ID, n.getN());
            
            if(location == -1){
                //do{
                    System.out.printf("\nBan nhap vao thong tin sinh vien (ma sinh vien la %s): ", ID);
                    temp.editSinhVien();
                    temp.setMaSV(ID);
                    standardized(temp);
                //}while(ID.equalsIgnoreCase(temp.getMaSV()));
                
                if(sum(temp) <= sum(sinhVien[n.getN() - 1])){ // chen cuoi
                    sinhVien[n.getN()] = temp;
                }else if(sum(temp) >= sum(sinhVien[0])){ // chen dau
                    for(int i = (n.getN() - 1); i >= 0; i--){
                        sinhVien[i + 1] = sinhVien[i];
                    }
                    sinhVien[0] = temp;
                }else{ // chen giua
                    System.out.println("sum cua temp = " + sum(temp));
                    System.out.println("sum cua n - 1 = " + sum(sinhVien[0]));
                    for(int i = (n.getN() - 1); i >= 0; i--){
                        sinhVien[i + 1] = sinhVien[i];
                        
                        if(sum(temp) >= sum(sinhVien[i]) && sum(temp) <= sum(sinhVien[i - 1])){
                            sinhVien[i] = temp;
                            break;
                        }
                    }
                }
                n.setN(n.getN() + 1);
                
            }else{
                System.err.println("Da co sinh vien co ma so sinh vien: " + ID + ".");
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static int checkSumPoint(SinhVien[] sinhVien, int[] a, double sumPoint, int n){
        try{
            int count = 0;
            // kiểm tra nếu tổng điểm của học sinh bằng với điểm nhập vào 
            // thì thêm vị trí của học sinh đó vào mảng a. 
            for(int i = 0; i < n; i++){
                if(sumPoint == sum(sinhVien[i])){
                    a[count] = i;
                    count++;
                }
            }
            return count;
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static void findPoint(SinhVien[] sinhVien, int n){
        Scanner input = new Scanner(System.in); 
        int[] a = new int[n];
        double sumPoint;
        int count;
        
        try{
            System.out.print("Nhap vao tong diem can tim kiem: ");
            sumPoint = input.nextDouble();
            //lấy số lượng điểm trong danh sách bằng với điểm được nhập vào. 
            count = checkSumPoint(sinhVien, a, sumPoint, n);
            if(count > 0){
                printTile();
                for(int i = 0; i < count; i++){
                    System.out.printf("\n| %-10d |", (i + 1));
                    sinhVien[a[i]].displaySinhVien();
                    System.out.printf("| %-10.2f |", sum(sinhVien[a[i]]));
                    printFormat();
                }
            }else{
                System.out.printf("Không có sinh viên nào có tổng điểm = \"%-4.2f\"", sumPoint);
            }
            
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static void editSinhVien(SinhVien[] sinhVien, int n){
        SinhVien temp = new SinhVien();
        Scanner input = new Scanner(System.in);
        String ID = "";
        int location = 0;
        
        try{
            System.out.print("Nhap vao ma so sinh vien can chinh sua: ");
            ID = input.nextLine();
            removeSpace(ID, true);
            location = checkIDExists(sinhVien, ID, n);
            
            if(location >= 0){
                System.out.println("Chinh sua thong tin sinh vien ma so: " + ID + ".");
                temp.setMaSV(ID);
                temp.editSinhVien();
                standardized(temp);
                
                sinhVien[location] = temp;
            }else{
                System.err.println("Sinh vien \"" + ID + "\" khong ton tai trong danh sach.");
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static void removeAt(SinhVien[] sinhVien, Count n){
        Scanner input = new Scanner(System.in);
        String ID = "";
        int location = 0;
        
        try{
            System.out.print("Nhap vao ma so sinh vien can chinh xoa: ");
            ID = input.nextLine();
            removeSpace(ID, true);
            location = checkIDExists(sinhVien, ID, n.getN());
            
            if(location >= 0){
                for(int i = location; i < (n.getN() - 1); i++)
                {
                    sinhVien[i] = sinhVien[i + 1];
                }
                n.setN(n.getN() - 1);
                System.out.println("Xoa sinh vien co ma so \"" + ID + "\" thanh cong.");
            }else{
                System.err.println("Sinh vien \"" + ID + "\" khong ton tai trong danh sach.");
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static void selectInput(SinhVien[] sinhVien, Count n){
        Scanner input = new Scanner(System.in); 
        String Continue = ""; 
        
        try{
            if(n.getN() > 0){
                do{
                    System.out.println("Trong danh sach da co \"" + n.getN() + "\" sinh vien\n"
                        + "Ban co 2 lua chon.");
                    System.out.println("1. Nhap lai danh sach (go tu khoa \"new\").");
                    System.out.println("2. Tiep tuc them sinh vien moi vao danh sach. (go tu khoa \"continue\")");
                    Continue = input.nextLine();
                    
                    if(Continue.equalsIgnoreCase("new")){
                        inputSinhVien(sinhVien, n);
                    }else if(Continue.equalsIgnoreCase("continue")){
                        addSinhVien(sinhVien, n);
                    }
                }while(!checkContinue(Continue));
            }else{
                inputSinhVien(sinhVien, n);
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static void createSinhVien(SinhVien[] sinhVien, Count n){
        SinhVien a = new SinhVien("1165093", "Quang Bui", "Nam", 10, 9.75, 9.8);
        SinhVien b = new SinhVien("1165090", "Manh Quan", "Nam", 10, 9.9, 9.7);
        SinhVien c = new SinhVien("1165127", "Ngoc Thuong", "Nu", 8.9, 8.75, 9.7);
        SinhVien d = new SinhVien("1165067", "Van Minh", "Nam", 10, 9.9, 9.7);
        SinhVien e = new SinhVien("1165154", "Van Quang", "Nu", 10, 10, 9.21);
        for(int i = 0; i < 5; i++){
            if(i == 0) sinhVien[i] = a;
            if(i == 1) sinhVien[i] = b;
            if(i == 2) sinhVien[i] = c;
            if(i == 3) sinhVien[i] = d;
            if(i == 4) sinhVien[i] = e;
            n.setN(i + 1);
        }
    }
}
