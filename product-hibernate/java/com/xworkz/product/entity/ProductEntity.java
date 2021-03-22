package com.xworkz.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="product")
public class ProductEntity {
	
	@Id
	@GenericGenerator(name="gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	@Column(name="PID")
	private int pId;
	@Column(name="NAME")
	private String name;
	@Enumerated(EnumType.STRING)
	@Column(name="P_TYPE")
	private ProductType type;
	@Column(name="PRICE")
	private double price;
	@Column(name="BRAND")
	private String brand;
	@Column(name="QUANTITY")
	private int quantity;
	@Column(name="QUALITY")
	private boolean quality;
	@Column(name="MANUFACTURER")
	private String manufacturer;
	
	
	public enum ProductType{
		HOME_APPLIANCES,ELECTRONIC,COMPUTERS,FASHION
	}


	public ProductEntity(String name, ProductType type, double price, int quantity,
			boolean quality,String brand, String manufacturer) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.brand = brand;
		this.quantity = quantity;
		this.quality = quality;
		this.manufacturer = manufacturer;
	}
	
	


}
