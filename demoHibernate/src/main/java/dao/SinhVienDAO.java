package dao;

import entity.SinhVien;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class SinhVienDAO implements  InterfaceDAO<SinhVien>{
    private EntityManager entity;
    
    @Autowired
    public SinhVienDAO(EntityManager entity) {
        this.entity = entity;
    }

    @Override
    public Boolean saveG(SinhVien sinhVien) {
        try {
            this.entity.persist(sinhVien);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean deleteG(SinhVien sinhVien) {
        return null;
    }

    @Override
    public Boolean updateG(SinhVien sinhVien) {
        return null;
    }

    @Override
    public List<SinhVien> selectAll() {
        return null;
    }

    @Override
    public SinhVien selectG(SinhVien sinhVien) {
        return null;
    }
}
