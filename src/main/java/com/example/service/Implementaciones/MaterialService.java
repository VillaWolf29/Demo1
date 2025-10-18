package com.example.service.Implementaciones;

import lombok.RequiredArgsConstructor;
import com.example.model.Material;
import com.example.repository.IMaterialRepository;
import com.example.repository.IGenericRepository;
import com.example.service.IMaterialService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MaterialService extends GenericService<Material,Integer> implements IMaterialService {
    private final IMaterialRepository repo;

    @Override
    protected IGenericRepository<Material,Integer> getRepo() {
        return repo;
    }
}
