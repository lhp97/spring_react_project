package com.devsuperior.spring_react.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.spring_react.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Integer>{

}
