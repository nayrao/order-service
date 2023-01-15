package com.example.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.OrderRequest;
import com.example.entity.Order;
import com.example.entity.OrderLineItems;
import com.example.repo.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public String saveOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());

		 List<OrderLineItems> collect = orderRequest.getOrderLineItemsDtoList().stream()
				.map(e -> new OrderLineItems(e.getId(), e.getSkuCode(), e.getPrice(), e.getQuantity()))
				.collect(Collectors.toList());
		 
		order.setOrderLineItemsList(collect);
		
		orderRepository.save(order);
		return "Record saved successfully...";
	}

}
