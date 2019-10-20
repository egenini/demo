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


public abstract class Ejemplo2Base implements Serializable{

    private static final long serialVersionUID = 1L;


    private @Id @GeneratedValue(strategy=GenerationType.IDENTITY) int id;	@Column(name="attr_1", length=60  )    
    
    
    protected String attr1 = null;
	
	@Column(name="attr_2"  )    
    
    
    protected Integer attr2;
	
	@Column(name="attr_3"  )    
    
    
    protected Timestamp attr3 = null;
	

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
    public void setAttr2(Integer  attr2){
        this.attr2 = attr2;
    }
        
	public Integer  getAttr2(){
        return this.attr2;
    }
    public void setAttr3(Timestamp  attr3){
        this.attr3 = attr3;
    }
        
	public Timestamp  getAttr3(){
        return this.attr3;
    }

    public boolean equals(Object another){
        boolean eq = another instanceof Ejemplo2 ;
        return eq;
    }
    public String toString(){
        StringBuilder builder = new StringBuilder();

        builder.append("{");
        builder.append("\"ejemplo2\":{");

        builder.append("\"attr1\":");
        builder.append('"');
        builder.append(getAttr1());
        builder.append('"');
        builder.append(',');
        builder.append("\"attr2\":");
        builder.append(getAttr2());
        builder.append(',');
        builder.append("\"attr3\":");
        builder.append(getAttr3());
        
        
        builder.append("}");

        builder.append("}");

        return builder.toString();
    }    }