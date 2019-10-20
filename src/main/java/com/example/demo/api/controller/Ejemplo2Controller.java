package com.example.demo.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.repository.Ejemplo2Repository;

@RestController
public class Ejemplo2Controller extends AbstractEjemplo2Controller {

	public Ejemplo2Controller(Ejemplo2Repository repository) {
		super(repository);
	}

	@Override
	protected void preAdd( com.example.demo.model.Ejemplo2 ejemplo2  ) {
		
	}

	@Override
	protected void posAdd( com.example.demo.model.Ejemplo2 ejemplo2 ) {
		
	}

	@Override
	protected void preModify( com.example.demo.model.Ejemplo2 ejemplo2Stored, com.example.demo.model.Ejemplo2 ejemplo2  ) {

	}

	@Override
	protected void posModify( com.example.demo.model.Ejemplo2 ejemplo2 ) {
		
	}

	@Override
	protected boolean preDelete( Integer id ) {
		
		return true;
	}

	@Override
	protected void posDelete( Integer id ) {
		
	}
}