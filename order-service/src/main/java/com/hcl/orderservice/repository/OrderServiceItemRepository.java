package com.hcl.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.orderservice.entity.OrderServiceItem;

@Repository
public interface OrderServiceItemRepository extends JpaRepository<OrderServiceItem, Integer> {
	
}
