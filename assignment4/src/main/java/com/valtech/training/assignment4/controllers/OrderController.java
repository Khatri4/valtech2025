package com.valtech.training.assignment4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.valtech.training.assignment4.entities.LineItem;
import com.valtech.training.assignment4.entities.Order;
import com.valtech.training.assignment4.entities.Order.Status;
import com.valtech.training.assignment4.services.CustomerService;
import com.valtech.training.assignment4.services.ItemService;
import com.valtech.training.assignment4.services.OrderService;
import com.valtech.training.assignment4.vos.LineItemVO;
import com.valtech.training.assignment4.vos.OrderVO;
import com.valtech.training.assignment4.vos.PlaceOrderVO;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/order")
	public String addOrders(@ModelAttribute PlaceOrderVO poVO, Model model) {
//		int cusId = poVO.cusId();
//		int itemId = poVO.itemId();
//		int quantity = poVO.quantity();
//		
//		LineItem li = new LineItem();
//		li.setItem(itemService.getItem(itemId).to());
//		li.setQuantity(quantity);
//		
//		Order order = new Order();
//		order.setCustomer(customerService.get(cusId).to());
//		order.addLineItem(li);
//		order.setStatus(Status.IN_WAREHOUSE);
		
		
		orderService.save(poVO);
		
		return "order";
	}
	
	
	@GetMapping("/order")
	public String getOrder(Model model) {
//		model.addAttribute(model)
		return "order";
	}
}
