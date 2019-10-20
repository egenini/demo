package com.example.demo.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.repository.Ejemplo1Repository;

@RestController
public class Ejemplo1Controller extends AbstractEjemplo1Controller {

	public Ejemplo1Controller(Ejemplo1Repository repository) {
		super(repository);
	}

	@Override
	protected void preAdd( com.example.demo.model.Ejemplo1 ejemplo1  ) {
		
	}

	@Override
	protected void posAdd( com.example.demo.model.Ejemplo1 ejemplo1 ) {
		
	}

	@Override
	protected void preModify( com.example.demo.model.Ejemplo1 ejemplo1Stored, com.example.demo.model.Ejemplo1 ejemplo1  ) {

	}

	@Override
	protected void posModify( com.example.demo.model.Ejemplo1 ejemplo1 ) {
		
	}

	@Override
	protected boolean preDelete( Integer id ) {
		
		return true;
	}

	@Override
	protected void posDelete( Integer id ) {
		
	}
}