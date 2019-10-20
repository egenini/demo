package com.example.demo.data.repository;




import java.util.Optional;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.model.Ejemplo2;

public interface Ejemplo2RepositoryBase extends PagingAndSortingRepository<Ejemplo2, Integer>, JpaSpecificationExecutor<Ejemplo2> {
    Optional<Ejemplo2> findById(Integer id);
	   
}