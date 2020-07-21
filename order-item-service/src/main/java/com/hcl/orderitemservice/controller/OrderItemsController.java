package com.hcl.orderitemservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.orderitemservice.dto.OrderItemsDto;
import com.hcl.orderitemservice.dto.StatusVo;
import com.hcl.orderitemservice.response.StandardResponse;
import com.hcl.orderitemservice.service.OrderItemsService;

@RestController
@RequestMapping(path="/orderItems")
@CrossOrigin(maxAge = 3600, origins = "*")
public class OrderItemsController {
	
	@Autowired
	private OrderItemsService orderItemsService;
	
	
	@GetMapping("/order-items")
	public StandardResponse<List<OrderItemsDto>> OrderedItems() {
		System.out.println("order-items");
		StandardResponse<List<OrderItemsDto>> standardResponse = new StandardResponse<List<OrderItemsDto>>();
		standardResponse.setResponseOK();
		standardResponse.setData(orderItemsService.OrderedItems());
		return standardResponse;
	}
	
	@PostMapping("/orderItems")
	public StandardResponse<StatusVo> addOrderItem(@RequestBody OrderItemsDto orderItemsDto) {
		System.out.println("post-items");
		StandardResponse<StatusVo> standardResponse = new StandardResponse<StatusVo>();
		standardResponse.setResponseOK();
		standardResponse.setData(orderItemsService.addOrderItem(orderItemsDto));
		return standardResponse;
	}
}




