package com.example.service.Implementaciones;

import com.example.model.Supplier;
import com.example.repository.IGenericRepository;
import com.example.repository.ISupplierRepository;
import com.example.service.ISupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService extends GenericService<Supplier, Integer> implements ISupplierService {
    //@Autowired
    private final ISupplierRepository repo;


    @Override
    protected IGenericRepository<Supplier, Integer> getRepo() {
        return repo;
    }
}
