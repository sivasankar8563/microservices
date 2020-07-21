package com.hcl.orderservice.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.orderservice.constants.ExceptionConstants;
import com.hcl.orderservice.dto.CommonUtils;
import com.hcl.orderservice.dto.OrderDto;
import com.hcl.orderservice.dto.OrderItemsDto;
import com.hcl.orderservice.dto.StatusVo;
import com.hcl.orderservice.entity.Order;
import com.hcl.orderservice.entity.OrderServiceItem;
import com.hcl.orderservice.exceptions.BaseException;
import com.hcl.orderservice.feignclient.OrderItemsServiceFeignClient;
import com.hcl.orderservice.repository.OrderRepository;
import com.hcl.orderservice.response.StandardResponse;
import com.hcl.orderservice.service.orderService;

@Service
public class OrderServiceImpl implements orderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired(required=true)
	private OrderItemsServiceFeignClient orderItemsServiceFeignClient;
	
	@Override
	@Transactional
	public StatusVo saveOrder(OrderDto orderDto) {
		StatusVo statusVo=new StatusVo();		
		StandardResponse<List<OrderItemsDto>> itemsDtos=orderItemsServiceFeignClient.OrderedItems();
		List<OrderItemsDto> orderItemsDto =new ArrayList<OrderItemsDto>();
		
		for(OrderItemsDto oid:itemsDtos.getData())
			orderItemsDto.add(oid);
	
		if(Objects.nonNull(orderDto))
		{
			Order order=new Order();
			order.setCustomerName(orderDto.getCustomerName());
			order.setOrderDate(orderDto.getOrderDate());
			order.setShippingAddress(orderDto.getShippingAddress());
			order.setTotal(orderDto.getTotal());
			order=orderRepository.save(order);
		    statusVo.setKey(order.getOrderId());
		    statusVo.setStatus(CommonUtils.SUCCESS);
		    
		    OrderServiceItem orderServiceItem=new OrderServiceItem();
		    orderServiceItem.setOrderItemId(itemsDtos.getData().iterator().next().getOrderItemId());
		    orderServiceItem.setOrderId(order.getOrderId());
		}
		else {
			throw new BaseException(ExceptionConstants.ORDER_SAVE,ExceptionConstants.ORDER_SERVICE_MANAGMENT); 
		}
		return statusVo;
	}

	@Override
	public List<OrderDto> orders() {
		List<OrderDto> orders=new ArrayList<OrderDto>();
		orders=orderRepository.Orders();
		if(Objects.nonNull(orders))
		{
			return orders;

		}
		else
		{
			throw new BaseException(ExceptionConstants.ORDERS_NOT_FOUND,ExceptionConstants.ORDER_SERVICE_MANAGMENT); 
		}
	}		    

	
	
	
	
	
	
	

}
