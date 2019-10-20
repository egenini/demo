package com.example.demo.model;





import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@MappedSuperclass 


public abstract class Ejemplo1Base implements Serializable{

    private static final long serialVersionUID = 1L;


    private @Id @GeneratedValue(strategy=GenerationType.IDENTITY) int id;	@Column(name="attr_1", length=20, nullable=false  )    
    
    
    protected String attr1 = null;
	
	@Column(name="encriptado", length=80  )    
    
    
    protected String encriptado = null;
	

    public Integer getId(){
        return this.id;
    }
    public void setId( Integer id ){
        this.id = id;
    }

    public void setAttr1(String  attr1){
        this.attr1 = attr1;
    }
        
	public String  getAttr1(){
        return this.attr1;
    }
    public void setEncriptado(String  encriptado){
        this.encriptado = encriptado;
    }
        
	public String  getEncriptado(){
        return this.encriptado;
    }

    public boolean equals(Object another){
        boolean eq = another instanceof Ejemplo1 ;
        if( eq ){
            Ejemplo1 othr = (Ejemplo1) another;
            eq =   this.attr1.equals(othr.attr1);
        }
        return eq;
    }
    public String toString(){
        StringBuilder builder = new StringBuilder();

        builder.append("{");
        builder.append("\"ejemplo1\":{");

        builder.append("\"attr1\":");
        builder.append('"');
        builder.append(getAttr1());
        builder.append('"');
        builder.append(',');
        builder.append("\"encriptado\":");
        builder.append('"');
        builder.append(getEncriptado());
        builder.append('"');
        
        
        builder.append("}");

        builder.append("}");

        return builder.toString();
    }    }