package vn.DungVipPro.securityJPA.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.DungVipPro.securityJPA.model.Users;

@Repository
public interface UsersDAO extends JpaRepository<Users, String> {

}
