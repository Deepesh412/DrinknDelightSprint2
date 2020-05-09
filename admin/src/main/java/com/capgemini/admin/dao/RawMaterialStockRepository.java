package com.capgemini.admin.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.admin.entities.RawMaterialStock;


@Repository
public interface RawMaterialStockRepository extends JpaRepository<RawMaterialStock,Serializable> {

}