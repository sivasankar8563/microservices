package com.hcl.orderservice.service;

import java.util.List;

import com.hcl.orderservice.dto.OrderDto;
import com.hcl.orderservice.dto.StatusVo;

public interface orderService {
	
	StatusVo saveOrder(OrderDto orderDto);
	List<OrderDto> orders();
}
