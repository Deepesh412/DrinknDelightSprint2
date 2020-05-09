package com.capgemini.customer.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.customer.entities.ProductStock;


@Repository
public interface ProductStockRepository extends JpaRepository<ProductStock,Serializable> {

}