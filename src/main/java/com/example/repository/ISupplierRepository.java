package com.example.repository;

import com.example.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupplierRepository extends IGenericRepository<Supplier,Integer> {
}
