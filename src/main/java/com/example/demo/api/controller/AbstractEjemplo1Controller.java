package com.example.demo.api.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.data.filter.Ejemplo1Specification;
import com.example.demo.data.repository.Ejemplo1Repository;
import com.example.demo.model.Ejemplo1;

import ar.com.tbf.api.essential.exception.Constraint400Exception;
import ar.com.tbf.api.essential.utils.PageHeader;
import ar.com.tbf.common.api.exception.NotFoundException;
import ar.com.tbf.common.application.controller.CommonController;
import ar.com.tbf.common.data.CriteriaParser;
import ar.com.tbf.common.data.GenericSpecificationsBuilder;
import ar.com.tbf.common.share.RequestResponseAccessibility;

@RestController
@RequestMapping(value = "/", produces = "application/json")
public abstract class AbstractEjemplo1Controller extends CommonController {

	private final PageHeader pageHeader = new PageHeader();

	protected final Ejemplo1Repository repository;

	public AbstractEjemplo1Controller( Ejemplo1Repository repository ) {
		this.repository = repository;
	}

	@GetMapping("/ejemplo1s")
	
	ResponseEntity<String> list(Pageable pageable, @RequestParam(value = "search", defaultValue = "") String search) {
	
		Page<?> page = null;
		
		if( ! search.isEmpty() ) {
			
			CriteriaParser parser  = new CriteriaParser();
			GenericSpecificationsBuilder<Ejemplo1> builder = new GenericSpecificationsBuilder<>();
			
			Specification<Ejemplo1> specification = builder.build( parser.parse( search ), Ejemplo1Specification::new );
			
			page = repository.findAll( specification, pageable );
		}
		else {
			
			page = repository.findAll( pageable );
		}
		
		return new ResponseEntity<String>( this.Gson().toJson(this.pageHeader.build( page ).getContent()), HttpStatus.OK);
	}

	@PostMapping("/ejemplo1s")
	ResponseEntity<String>  create(@RequestBody Ejemplo1 ejemplo1) {

		this.init();

		// validaciones 
		
		preAdd( ejemplo1 );
	
		if( this.messageManager.hasErrors() ) {
			
			throw new Constraint400Exception( this.messageManager );
		}

		repository.save(ejemplo1);

		posAdd( ejemplo1 );
		
		return new ResponseEntity<String>( this.Gson().toJson(ejemplo1), HttpStatus.OK);
	}

	@GetMapping("/ejemplo1s/{id}")
	ResponseEntity<String>  read(@PathVariable Integer id) {
	
	    Ejemplo1 ejemplo1 = repository.findById(id).orElseThrow(() -> new NotFoundException(id));

		return new ResponseEntity<String>( this.Gson().toJson( ejemplo1 ), HttpStatus.OK);
	}

	@PutMapping("/ejemplo1s/{id}")
	com.example.demo.model.Ejemplo1 update(@RequestBody Ejemplo1 newEjemplo1, @PathVariable Integer id) {


		return repository.findById(id)
			.map(ejemplo1 -> {
				
				ejemplo1.setAttr1(newEjemplo1.getAttr1());
				
				ejemplo1.setEncriptado(newEjemplo1.getEncriptado());
				
				preModify( ejemplo1, newEjemplo1 );
				
				ejemplo1 = repository.save( ejemplo1 );
				
				posModify( ejemplo1 );
				
				return ejemplo1;
				
			}).orElseThrow(() -> new NotFoundException(id));
	}

	@DeleteMapping("/ejemplo1s/{id}")
	void delete(@PathVariable Integer id) {

		if( preDelete(id) ) {
			
			repository.deleteById(id);

			posDelete(id);
		}
	}

	protected abstract void preAdd( Ejemplo1 ejemplo1 );
	protected abstract void posAdd( Ejemplo1 ejemplo1 );
	
	protected abstract void preModify( Ejemplo1 ejemplo1Stored, Ejemplo1 ejemplo1 );
	protected abstract void posModify( Ejemplo1 ejemplo1 );
	
	protected abstract boolean preDelete( Integer id );
	protected abstract void posDelete( Integer id );
}