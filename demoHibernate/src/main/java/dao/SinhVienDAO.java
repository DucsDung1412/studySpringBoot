package dao;

import entity.SinhVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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
        List<SinhVien> list = null;
        try {
            String hql = "FROM SinhVien sv";
            Query query = entity.createQuery(hql);
            list = query.getResultList();
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public SinhVien selectG(SinhVien sinhVien) {
        SinhVien sv = null;
        try {
            sv = entity.find(SinhVien.class, sinhVien.getId());
        } catch(Exception e){
            e.printStackTrace();
        }
        return sv;
    }

    public List<SinhVien> selectByTen(String hoten) {
        List<SinhVien> list = null;
        try {
            String hql = "FROM SinhVien sv WHERE sv.hoTen like :ten";
            Query query = entity.createQuery(hql);
            query.setParameter("ten", "%"+hoten+"%");
            list = query.getResultList();
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
