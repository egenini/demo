package com.example.demo.data.repository;




import java.util.Optional;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.model.Ejemplo1;

public interface Ejemplo1RepositoryBase extends PagingAndSortingRepository<Ejemplo1, Integer>, JpaSpecificationExecutor<Ejemplo1> {
    Optional<Ejemplo1> findById(Integer id);
    Ejemplo1 findByAttr1( String attr1 );
    Boolean existsByAttr1( String attr1 );
	   
}