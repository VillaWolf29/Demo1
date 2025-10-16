package com.example.service.Implementaciones;

import com.example.model.Project;
import com.example.repository.IGenericRepository;
import com.example.repository.IProjectRepository;
import com.example.service.IProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService extends GenericService<Project, Integer> implements IProjectService {

    private final IProjectRepository repo;
    @Override
    protected IGenericRepository<Project, Integer> getRepo() {
        return repo;
    }
}
