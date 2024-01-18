package com.Project.SpringWeb.Repo;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Project.SpringWeb.entities.Students;

import jakarta.transaction.Transactional;

@Repository
public interface DetailRepo extends CrudRepository<Students, BigDecimal> {

	@Query("SELECT CASE WHEN COUNT(e.roll) > 0 THEN true ELSE false END FROM Students e WHERE e.roll = :roll")
	boolean existsByRoll(@Param("roll") BigDecimal roll);

	@Modifying
	@Transactional
	@Query("DELETE FROM Students S WHERE S.roll = :roll")
	void deleteByRoll(@Param("roll")BigDecimal roll);
	
	@Transactional
    @Modifying
    @Query("UPDATE Students s SET s.name = :name WHERE s.roll = :roll")
    void updateStudentName(@Param("roll") BigDecimal roll, @Param("name") String name);

}
