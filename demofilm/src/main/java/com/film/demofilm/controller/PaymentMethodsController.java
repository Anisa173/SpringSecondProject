package com.film.demofilm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.film.demofilm.domain.dto.PaymentMethodsDto;
import com.film.demofilm.entity.PaymentMethods;
import com.film.demofilm.service.PaymentMethodsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/paymentmethods")
public class PaymentMethodsController {

	@Autowired
	private final PaymentMethodsService pmService;

	public PaymentMethodsController(PaymentMethodsService pmService) {
		this.pmService = pmService;

	}

	@PostMapping("/create")
	public ResponseEntity<PaymentMethodsDto> create(@Valid @RequestBody PaymentMethodsDto pmDto) throws Exception {

		return ResponseEntity.ok(pmService.create(pmDto));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
		pmService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@PutMapping("/update/{pmId}")
	public ResponseEntity<PaymentMethodsDto> update(@PathVariable Integer pmId, @RequestBody PaymentMethodsDto pmDto)
			throws Exception {
		return ResponseEntity.ok(pmService.update(pmDto, pmId));

	}

	@GetMapping("all")
	public ResponseEntity<List<PaymentMethodsDto>> getAllPaymentMethods() throws Exception {
		return ResponseEntity.ok(pmService.getAllPaymentMethods());

	}

	@GetMapping("/fetch/{pmId}")
	public ResponseEntity<PaymentMethods> getCartpaymentMethod(@PathVariable Integer pmId) throws Exception {
		return ResponseEntity.ok(pmService.getCartpaymentMethod(pmId));
	}

	@GetMapping("/{pmId}")
	public ResponseEntity<PaymentMethods> getApaymentMethod(@PathVariable Integer pmId) throws Exception {
		return ResponseEntity.ok(pmService.getApaymentMethod(pmId));
	}

	@GetMapping("/read/{pmId}")
	public ResponseEntity<PaymentMethodsDto> getPayMethodById(@PathVariable Integer pmId) throws Exception {
		return ResponseEntity.ok(pmService.getPayMethodById(pmId));
	}

	@GetMapping("/read/{id}/paymentMethod")
	public ResponseEntity<PaymentMethodsDto> getUserPaymentMethods(@PathVariable Integer id, @RequestParam Integer pmId)
			throws Exception {
		return ResponseEntity.ok(pmService.getUserPaymentMethods(id, pmId));
	}

}
