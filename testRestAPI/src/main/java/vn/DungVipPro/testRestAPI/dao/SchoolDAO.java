package vn.DungVipPro.testRestAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.DungVipPro.testRestAPI.model.School;

@Repository
public interface SchoolDAO extends JpaRepository<School, Long> {

}
