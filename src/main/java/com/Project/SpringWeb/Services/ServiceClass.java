package com.Project.SpringWeb.Services;

import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.Project.SpringWeb.Repo.DetailRepo;
import com.Project.SpringWeb.entities.Students;

@Service
@SuppressWarnings("nullness")
public class ServiceClass implements DetailRepo{
	
	private final DetailRepo D;


    ServiceClass(DetailRepo D) {
        this.D = D;
    }
	
	
	@Override
	public <S extends Students> S save( S entity) {
		 
		return D.save(entity);
	}

	@Override
	public <S extends Students> Iterable<S> saveAll( Iterable<S> entities) {
		 
		return D.saveAll(entities);
	}

	@Override
	public Optional<Students> findById(BigDecimal id) {
		 
		return D.findById(id);
	}

	@Override
	public boolean existsById(BigDecimal id) {
		 
		return D.existsById(id);
	}
	public boolean existByRoll(BigDecimal roll) {
		return  D.existsByRoll(roll);
	}

	@Override
	public Iterable<Students> findAll() {
		
		return D.findAll();
	}

	@Override
	public Iterable<Students> findAllById(Iterable<BigDecimal> ids) {
		 
		return D.findAll();
	}

	@Override
	public long count() {
		 
		return D.count();
	}

	@Override
	public void deleteById(BigDecimal id) {
		 
		D.deleteById(id);
	}
	
	public void deleteByRoll(BigDecimal Roll) {
		 
		D.deleteByRoll(Roll);
	}

	@Override
	public void delete(Students entity) {
		 
		D.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends BigDecimal> ids) {
		 
		D.deleteAllById(ids);
	}

	@Override
	
	public void deleteAll(Iterable<? extends Students> entities) {
		 
		D.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		 
		D.deleteAll();
	}


	@Override
	public boolean existsByRoll(BigDecimal roll) {
		 
		return D.existsByRoll(roll);
	}


	@Override
	public void updateStudentName(BigDecimal slno, String name) {
		 
		D.updateStudentName(slno, name);
	}
	
	

}
