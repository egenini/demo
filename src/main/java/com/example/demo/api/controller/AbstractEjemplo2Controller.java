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


import com.example.demo.data.filter.Ejemplo2Specification;
import com.example.demo.data.repository.Ejemplo2Repository;
import com.example.demo.model.Ejemplo2;

import ar.com.tbf.api.essential.exception.Constraint400Exception;
import ar.com.tbf.api.essential.utils.PageHeader;
import ar.com.tbf.common.api.exception.NotFoundException;
import ar.com.tbf.common.application.controller.CommonController;
import ar.com.tbf.common.data.CriteriaParser;
import ar.com.tbf.common.data.GenericSpecificationsBuilder;
import ar.com.tbf.common.share.RequestResponseAccessibility;

@RestController
@RequestMapping(value = "/", produces = "application/json")
public abstract class AbstractEjemplo2Controller extends CommonController {

	private final PageHeader pageHeader = new PageHeader();

	protected final Ejemplo2Repository repository;

	public AbstractEjemplo2Controller( Ejemplo2Repository repository ) {
		this.repository = repository;
	}

	@GetMapping("/ejemplo2s")
	
	ResponseEntity<String> list(Pageable pageable, @RequestParam(value = "search", defaultValue = "") String search) {
	
		Page<?> page = null;
		
		if( ! search.isEmpty() ) {
			
			CriteriaParser parser  = new CriteriaParser();
			GenericSpecificationsBuilder<Ejemplo2> builder = new GenericSpecificationsBuilder<>();
			
			Specification<Ejemplo2> specification = builder.build( parser.parse( search ), Ejemplo2Specification::new );
			
			page = repository.findAll( specification, pageable );
		}
		else {
			
			page = repository.findAll( pageable );
		}
		
		return new ResponseEntity<String>( this.Gson().toJson(this.pageHeader.build( page ).getContent()), HttpStatus.OK);
	}

	@PostMapping("/ejemplo2s")
	ResponseEntity<String>  create(@RequestBody Ejemplo2 ejemplo2) {

		this.init();

		// validaciones 
		
		preAdd( ejemplo2 );
	
		if( this.messageManager.hasErrors() ) {
			
			throw new Constraint400Exception( this.messageManager );
		}

		repository.save(ejemplo2);

		posAdd( ejemplo2 );
		
		return new ResponseEntity<String>( this.Gson().toJson(ejemplo2), HttpStatus.OK);
	}

	@GetMapping("/ejemplo2s/{id}")
	ResponseEntity<String>  read(@PathVariable Integer id) {
	
	    Ejemplo2 ejemplo2 = repository.findById(id).orElseThrow(() -> new NotFoundException(id));

		return new ResponseEntity<String>( this.Gson().toJson( ejemplo2 ), HttpStatus.OK);
	}

	@PutMapping("/ejemplo2s/{id}")
	com.example.demo.model.Ejemplo2 update(@RequestBody Ejemplo2 newEjemplo2, @PathVariable Integer id) {


		return repository.findById(id)
			.map(ejemplo2 -> {
				
				ejemplo2.setAttr1(newEjemplo2.getAttr1());
				
				ejemplo2.setAttr2(newEjemplo2.getAttr2());
				
				ejemplo2.setAttr3(newEjemplo2.getAttr3());
				
				preModify( ejemplo2, newEjemplo2 );
				
				ejemplo2 = repository.save( ejemplo2 );
				
				posModify( ejemplo2 );
				
				return ejemplo2;
				
			}).orElseThrow(() -> new NotFoundException(id));
	}

	@DeleteMapping("/ejemplo2s/{id}")
	void delete(@PathVariable Integer id) {

		if( preDelete(id) ) {
			
			repository.deleteById(id);

			posDelete(id);
		}
	}

	protected abstract void preAdd( Ejemplo2 ejemplo2 );
	protected abstract void posAdd( Ejemplo2 ejemplo2 );
	
	protected abstract void preModify( Ejemplo2 ejemplo2Stored, Ejemplo2 ejemplo2 );
	protected abstract void posModify( Ejemplo2 ejemplo2 );
	
	protected abstract boolean preDelete( Integer id );
	protected abstract void posDelete( Integer id );
}