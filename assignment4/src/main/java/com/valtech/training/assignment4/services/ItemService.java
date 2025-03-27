package com.valtech.training.assignment4.services;

import java.util.List;

import com.valtech.training.assignment4.entities.Customer;
import com.valtech.training.assignment4.entities.Item;
import com.valtech.training.assignment4.vos.ItemVO;

public interface ItemService {

	ItemVO save(ItemVO itemVO);

	ItemVO update(ItemVO itemVO);

	void delete(Item i);
	
	ItemVO getItem(int id);
	
	List<ItemVO> getAll();
	
}
