package com.hcl.orderitemservice.service;

import java.util.List;

import com.hcl.orderitemservice.dto.OrderItemsDto;
import com.hcl.orderitemservice.dto.StatusVo;

public interface OrderItemsService {
	
	List<OrderItemsDto> OrderedItems();

	StatusVo addOrderItem(OrderItemsDto orderItemsDto);
}
