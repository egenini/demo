﻿package com.example.demo.data.filter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.model.Ejemplo1;

import ar.com.tbf.common.data.SpecSearchCriteria;

public class Ejemplo1SpecificationBase implements Specification<Ejemplo1> {

	private static final long serialVersionUID = 1L;
	
	protected SpecSearchCriteria criteria;
	
	public Ejemplo1SpecificationBase( SpecSearchCriteria criteria ) {
		
		this.criteria = criteria;
	}
	
	public Ejemplo1SpecificationBase() {
		
	}

	@Override
	public Predicate toPredicate( final Root<Ejemplo1> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

		switch (criteria.getOperation()) {
		
		case EQUALITY:
			return builder.equal(root.get(criteria.getKey()), criteria.getValue());
		case NEGATION:
			return builder.notEqual(root.get(criteria.getKey()), criteria.getValue());
		case GREATER_THAN:
			return builder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString());
		case LESS_THAN:
			return builder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString());
		case LIKE:
			return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
		case STARTS_WITH:
			return builder.like(root.get(criteria.getKey()), criteria.getValue() + "%");
		case ENDS_WITH:
			return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue());
		case CONTAINS:
			return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
		default:
			return null;
		}
	}

}