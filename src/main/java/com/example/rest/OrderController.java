package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.OrderRequest;
import com.example.service.OrderService;

@RequestMapping("/api/order")
@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/new")
	public ResponseEntity<String> saveOrder(@RequestBody OrderRequest orderRequest) {
		String saveOrder = orderService.saveOrder(orderRequest);
		return new ResponseEntity<String>(saveOrder, HttpStatus.CREATED);

	}
    @GetMapping("/bug101")
	public String bug101() {
		return "BUG 101 issue";
	}
}
