package vn.DungVipPro.demoHibernate;

import dao.SinhVienDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class DemoHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoHibernateApplication.class, args);
	}

}
