package com.Project.SpringWeb.Services;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.Project.SpringWeb.Repo.DetailRepo;
import com.Project.SpringWeb.entities.Students;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class ServiceClass {

	@Autowired
    private EntityManager entityManager;

    @Transactional
    @Query(value = "ALTER SEQUENCE pkey INCREMENT BY -99999", nativeQuery = true)
    public void alterSequenceDecrement() {
        entityManager.createNativeQuery("ALTER SEQUENCE pkey INCREMENT BY -99999").executeUpdate();
    }

    @Transactional
    @Query(value = "SELECT pkey.NEXTVAL FROM dual", nativeQuery = true)
    public BigDecimal getNextValFromSequence() {
        return (BigDecimal) entityManager.createNativeQuery("SELECT pkey.NEXTVAL FROM dual").getSingleResult();
    }

    @Transactional
    @Query(value = "ALTER SEQUENCE your_sequence_name INCREMENT BY 1", nativeQuery = true)
    public void alterSequenceIncrement() {
        entityManager.createNativeQuery("ALTER SEQUENCE your_sequence_name INCREMENT BY 1").executeUpdate();
    }


	@Autowired
	private final DetailRepo D;


    ServiceClass(DetailRepo D) {
        this.D = D;
    }
	
	
	
	public <S extends Students> S save( S entity) {
		 
		return D.save(entity);
	}

	
	public <S extends Students> Iterable<S> saveAll( Iterable<S> entities) {
		 
		return D.saveAll(entities);
	}

	
	public Optional<Students> findById(BigDecimal id) {
		 
		return D.findById(id);
	}

	
	public boolean existsById(BigDecimal id) {
		 
		return D.existsById(id);
	}
	public boolean existByRoll(BigDecimal roll) {
		return  D.existsByRoll(roll);
	}

	
	public Iterable<Students> findAll() {
		
		return D.findAll();
	}

	
	public Iterable<Students> findAllById(Iterable<BigDecimal> ids) {
		 
		return D.findAll();
	}

	
	public long count() {
		 
		return D.count();
	}

	
	public void deleteById(BigDecimal id) {
		 
		D.deleteById(id);
	}
	
	public void deleteByRoll(BigDecimal Roll) {
		 
		D.deleteByRoll(Roll);
	}

	
	public void delete(Students entity) {
		 
		D.delete(entity);
	}

	
	public void deleteAllById(Iterable<? extends BigDecimal> ids) {
		 
		D.deleteAllById(ids);
	}

	
	
	public void deleteAll(Iterable<? extends Students> entities) {
		 
		D.deleteAll(entities);
	}

	
	public void deleteAll() {
		 
		D.deleteAll();
	}


	
	public boolean existsByRoll(BigDecimal roll) {
		 
		return D.existsByRoll(roll);
	}


	
	public void updateStudentName(BigDecimal slno, String name) {
		 
		D.updateStudentName(slno, name);
	}
	
	

}
