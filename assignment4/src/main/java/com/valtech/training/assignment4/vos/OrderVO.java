package com.valtech.training.assignment4.vos;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.valtech.training.assignment4.entities.Customer;
import com.valtech.training.assignment4.entities.Item;
import com.valtech.training.assignment4.entities.LineItem;
import com.valtech.training.assignment4.entities.Order;
import com.valtech.training.assignment4.entities.Order.Status;

public record OrderVO(int orderId, Customer customer, List<LineItem> lineItems) {
	

	public static OrderVO from(Order o) {
//		String orderStatus = o.getStatus().name();		
		return new OrderVO(o.getOrderId(), o.getCustomer(), o.getLineItems());
	}
	
	
	public static List<OrderVO> from(List<Order> orders){
		return orders.stream().map(order -> OrderVO.from(order)).collect(Collectors.toList());
	}
	
	public Order to() {
//		Status orderStatus = Status.valueOf(status);
		Order o = new Order(orderId, customer, lineItems)  ;
		return o;
	}

}
