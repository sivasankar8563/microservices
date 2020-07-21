package com.hcl.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.orderservice.dto.OrderDto;
import com.hcl.orderservice.dto.StatusVo;
import com.hcl.orderservice.response.StandardResponse;
import com.hcl.orderservice.service.orderService;

@RestController
@RequestMapping(path="/orders")
@CrossOrigin(maxAge = 3600, origins = "*")
public class OrderController {
	@Autowired
	private orderService orderService;
	
	
	@PostMapping("/order")
	public StandardResponse<StatusVo> saveOrder(@RequestBody OrderDto orderDto) {
		StandardResponse<StatusVo> standardResponse = new StandardResponse<StatusVo>();
		standardResponse.setResponseOK();
		standardResponse.setData(orderService.saveOrder(orderDto));
		return standardResponse;
	}
	
	@GetMapping("/orders-list")
	public StandardResponse<List<OrderDto>> OrderedItems() {
		StandardResponse<List<OrderDto>> standardResponse = new StandardResponse<List<OrderDto>>();
		standardResponse.setResponseOK();
		standardResponse.setData(orderService.orders());
		return standardResponse;
	}


}
