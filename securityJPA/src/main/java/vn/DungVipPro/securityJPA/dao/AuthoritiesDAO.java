package vn.DungVipPro.securityJPA.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.DungVipPro.securityJPA.model.Authorities;

@Repository
public interface AuthoritiesDAO extends JpaRepository<Authorities, Long> {

}
