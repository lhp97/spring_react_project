package com.devsuperior.spring_react.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.spring_react.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Integer>{
	
	@Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :dateMin AND :dateMax ORDER BY obj.amount DESC")
	Page<Sale> findSales(LocalDate dateMin, LocalDate dateMax, Pageable pageable);

}
