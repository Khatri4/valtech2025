package com.valtech.training.assignment4.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.assignment4.entities.LineItem;

@Repository
public interface LineItemRepo extends JpaRepository<LineItem, Integer>{

}
