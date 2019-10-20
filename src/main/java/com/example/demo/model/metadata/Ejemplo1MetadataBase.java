package com.example.demo.model.metadata;

import ar.com.tbf.common.application.Constants;
import ar.com.tbf.model.extension.Attribute;
import ar.com.tbf.model.extension.Extension;
import ar.com.tbf.model.extension.constraint.GreaterThanOrEquals;
import ar.com.tbf.model.extension.constraint.LessThanOrEquals;
import ar.com.tbf.model.extension.constraint.Required;

public class Ejemplo1MetadataBase extends Extension{

	public Ejemplo1MetadataBase() {
		
		super();
		
		this.fullClassname = "com.example.demo.model.Ejemplo1";
		
		this.addAttribute("id").withEditable(false);

		build();
		buildGroups();
	}
	
	public void build() {
		
		// un build por cada attributo
		buildAttr1();
		
	}
	
	public void buildAttr1() {
		
		Attribute attribute = this.addAttribute("attr1").withEditable(true)
		.withInfo("Una descripción")
		.withLabel("Attr 1")
		.withSearcheable(true)
		.withType("String").withLength(20);

		buildAttr1Constraints( attribute );
	}
	
	public void buildAttr1Constraints( Attribute attribute ) {
		
		Required required = new Required();
		
		attribute.addConstraint(required, Constants.CREATE, Constants.MODIFY);
		
		GreaterThanOrEquals greaterThanOrEquals = new GreaterThanOrEquals();
		
		greaterThanOrEquals.setLen((short)3);
		
		attribute.addConstraint(greaterThanOrEquals, Constants.CREATE, Constants.MODIFY);
		
		LessThanOrEquals lessThanOrEquals = new LessThanOrEquals();
		
		lessThanOrEquals.setLen( (short)  20 );
		
		attribute.addConstraint(lessThanOrEquals, Constants.CREATE, Constants.MODIFY);
	}
	
	public void buildGroups() {
		
	}
	
	public static void main(String[] args) {
		
		Ejemplo1MetadataBase m = new Ejemplo1MetadataBase();
		
		System.out.println(m.fullClassname);
	}
}