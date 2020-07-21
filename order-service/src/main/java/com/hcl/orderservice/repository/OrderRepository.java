package com.hcl.orderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.orderservice.dto.OrderDto;
import com.hcl.orderservice.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
   
	
	@Query(value="select new com.hcl.orderservice.dto.OrderDto(order.orderId,order.customerName,order.orderDate,order.shippingAddress,order.total)"
			+ " from Order order")
	List<OrderDto> Orders();
}
