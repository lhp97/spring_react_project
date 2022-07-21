package com.devsuperior.spring_react.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.spring_react.entities.Sale;
import com.devsuperior.spring_react.service.SaleService;
import com.devsuperior.spring_react.service.SmsService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService saleService;

	@Autowired
	private SmsService smsService;

	@GetMapping
	public Page<Sale> findSales(
			@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate, 
			Pageable pageable) {
		return saleService.findSales(minDate, maxDate, pageable);
	}

	@GetMapping("/{id}/notification")
	public void notifySms(@PathVariable Integer id) {
		smsService.sendSms(id);
	}

}