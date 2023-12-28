package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "sinh_vien")
public class SinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custom-generator")
    @GenericGenerator(name = "custom-generator", strategy = "customGenerator.SinhVienGene")
    @Column(name = "sinh_vien_id")
    private String id;

    @Column(name = "ho_ten", length = 45)
    private String hoTen;

    @Column(name = "tuoi")
    private Integer tuoi;

    @Column(name = "email", length = 255)
    private String email;

    public SinhVien() {

    }

    public SinhVien(String hoTen, Integer tuoi, String email) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Integer getTuoi() {
        return tuoi;
    }

    public void setTuoi(Integer tuoi) {
        this.tuoi = tuoi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "id='" + id + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", tuoi=" + tuoi +
                ", email='" + email + '\'' +
                '}';
    }
}
