package com.capgemini.admin.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.admin.entities.RawMaterialOrderDetails;


@Repository
public interface RawMaterialOrderDetailsRepository extends JpaRepository<RawMaterialOrderDetails,Serializable>{

	
}