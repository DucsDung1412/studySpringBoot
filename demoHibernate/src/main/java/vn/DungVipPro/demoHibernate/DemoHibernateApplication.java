package vn.DungVipPro.demoHibernate;

import dao.SinhVienDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoHibernateApplication.class, args);
		SinhVienDAO sv = new SinhVienDAO();
	}

}
