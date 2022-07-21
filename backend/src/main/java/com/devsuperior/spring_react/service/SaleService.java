package com.devsuperior.spring_react.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.spring_react.entities.Sale;
import com.devsuperior.spring_react.repositories.SaleRepository;

import lombok.val;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepository;
	
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		
		LocalDate localDateMin = minDate.isEmpty() ? getDateAYearAgo() : convertTextDate(minDate);
		LocalDate localDateMax = maxDate.isEmpty() ? getTodayDate() : convertTextDate(maxDate);
		
		return saleRepository.findSales(localDateMin, localDateMax, pageable);
	}
	
	private LocalDate getTodayDate() {
		return LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
	}
	
	private LocalDate getDateAYearAgo() {
		return getTodayDate().minusDays(365);
	}

	
	private LocalDate convertTextDate(String date) {
		return LocalDate.parse(date);
	}

}
