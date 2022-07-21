package com.devsuperior.spring_react.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.devsuperior.spring_react.entities.Sale;
import com.devsuperior.spring_react.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;
	
	@Autowired
	private SaleRepository saleRepository;

	public void sendSms(Integer saleId) {
		
		Sale sale = saleRepository.findById(saleId).get();
		String date = sale.getDate().getMonthValue() + "/" + sale.getDate().getYear();
		String mensage = "O Vendedor: " + sale.getSellerName() + " foi destaque em " + date + " com um total de R$ " + sale.getAmount();

		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message message = Message.creator(to, from, mensage).create();

		System.out.println(message.getSid());
	}
}