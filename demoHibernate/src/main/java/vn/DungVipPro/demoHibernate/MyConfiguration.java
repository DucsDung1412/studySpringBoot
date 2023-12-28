package vn.DungVipPro.demoHibernate;

import dao.SinhVienDAO;
import entity.SinhVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Scanner;

@Configuration
@ComponentScan(basePackages = {"dao"})
@EntityScan(basePackages = "entity")
public class MyConfiguration {
    @Bean
    @Autowired
    public CommandLineRunner getMyConfiguration(SinhVienDAO svd){
        return runner -> {
            Scanner sc = new Scanner(System.in);
            while(true){
                printMenu();
                int i  = sc.nextInt();
                sc.nextLine();
                if(i == 0){
                    break;
                }
                if(i == 1){
                    System.out.println("Ho Ten: ");
                    String hoten = sc.nextLine();
                    System.out.println("Tuoi: ");
                    Integer tuoi = sc.nextInt();
                    System.out.println("Email: ");
                    sc.nextLine();
                    String email = sc.nextLine();
                    SinhVien sv = new SinhVien(hoten, tuoi, email);
                    svd.saveG(sv);
                }
                if(i == 5){
                    System.out.print("Id: ");
                    String id = sc.nextLine();
                    SinhVien sv = new SinhVien();
                    sv.setId(id);
                    SinhVien svDAO = svd.selectG(sv);
                    if(svDAO == null){
                        System.out.println("Khong tim thay");
                    } else {
                        System.out.println(svDAO.toString());
                    }
                }
                if(i == 4){
                    List<SinhVien> list = svd.selectAll();
                    for(SinhVien sv : list){
                        System.out.println(sv.getHoTen());
                    }
                }
                if(i == 6){
                    System.out.print("Ho Ten: ");
                    String hoTen = sc.nextLine();
                    List<SinhVien> list = svd.selectByTen(hoTen);
                    list.forEach(sv -> {
                        System.out.println(sv.getHoTen());
                    });
                }
                if(i == 2){
                    System.out.println("ID: ");
                    String id = sc.nextLine();
                    System.out.println("Ho Ten: ");
                    String hoten = sc.nextLine();
                    System.out.println("Tuoi: ");
                    Integer tuoi = sc.nextInt();
                    System.out.println("Email: ");
                    sc.nextLine();
                    String email = sc.nextLine();
                    SinhVien sv = new SinhVien(hoten, tuoi, email);
                    sv.setId(id);
                    svd.updateG(sv);
                }
                if(i == 7){
                    System.out.println("Ho Ten: ");
                    String hoten = sc.nextLine();
                    svd.updateListSVwithString(hoten);
                }
                if(i == 3){
                    System.out.println("ID: ");
                    String id = sc.nextLine();
                    SinhVien sv = new SinhVien();
                    sv.setId(id);
                    svd.deleteG(sv);
                }
                if(i == 8){
                    svd.removeAllTable();
                }
            }
        };
    }

    public void printMenu(){
        System.out.println("----------MENU----------");
        System.out.println("1. Add SinhVien");
        System.out.println("2. UPDATE SinhVien");
        System.out.println("3. DELETE SinhVien");
        System.out.println("4. Check List SinhVien");
        System.out.println("5. Check SinhVien with ID");
        System.out.println("6. Check SinhVien with HoTen");
        System.out.println("7. UPDATE List SV");
        System.out.println("8. DELETE ALL");
        System.out.println("0. QUIT");
    }
}
