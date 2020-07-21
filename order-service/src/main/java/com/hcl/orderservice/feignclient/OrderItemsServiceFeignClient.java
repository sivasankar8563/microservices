package com.hcl.orderservice.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.hcl.orderservice.dto.OrderItemsDto;
import com.hcl.orderservice.response.StandardResponse;

@FeignClient(name="orderItem-management",url="localhost:8081")
public interface OrderItemsServiceFeignClient {
	
	@GetMapping("/orderItems/order-items")
	public StandardResponse<List<OrderItemsDto>> OrderedItems();
	
}