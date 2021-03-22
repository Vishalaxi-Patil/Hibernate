package com.xworkz.icecream.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ice_cream")

@NamedQueries({
	@NamedQuery(name = "deleteByName", query = "delete IceCreamEntity ice where ice.name=:nm"),
	@NamedQuery(name = "updatePriceByName", query = "update IceCreamEntity ice set price=:pr where ice.name=:nm"),
	@NamedQuery(name = "getAll", query = "select ice from IceCreamEntity ice"),
	@NamedQuery(name = "findByNameAndPrice", query = "select ice from IceCreamEntity ice where name=:nm and price=:pr"),
	@NamedQuery(name = "getMaxPrice", query = "select max(ice.price) from IceCreamEntity ice"),
	@NamedQuery(name = "getMinPrice", query = "select min(ice.price) from IceCreamEntity ice"),
	@NamedQuery(name = "getBySumPrice", query = "select sum(ice.price) from IceCreamEntity ice"),
	@NamedQuery(name = "getPriceByName", query = "select ice.price from IceCreamEntity ice where name=:nm"),
	@NamedQuery(name = "getNameAndFlavourByPrice", query = "select ice.name,ice.flavour from IceCreamEntity ice where price=:pr")
})
public class IceCreamEntity {
	
	@Id
	@Column(name = "ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "COMPANY")
	private String company;
	@Column(name = "FLAVOUR")
	@Enumerated(EnumType.STRING)
	private Flavour flavour;
	@Column(name = "PRICE")
	private double price;
	@Column(name = "COLOR")
	@Enumerated(EnumType.STRING)
	private Color color;
	
	public enum Flavour{
		CHOCOLATE,VENILLA,STRAWBERRY,PISTA,REDVELVET,BLACKCURRENT,MIXED
	}
	
	public enum Color{
		BLUE,WHITE,PINK,BROWN,YELLOW,GREEN,MIXED,ORANGE
	}

}
