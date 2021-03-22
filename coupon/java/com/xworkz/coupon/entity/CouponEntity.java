package com.xworkz.coupon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;


@Data
@Entity
@Table(name = "coupon")
public class CouponEntity {
	@Id
	@Column(name = "ID")
	@GenericGenerator(name = "coup", strategy = "increment")
	@GeneratedValue(generator = "coup")
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "TYPE")
	private String typeOfCoupon;
	@Column(name = "CODE")
	private String code;
	@Column(name = "VALID_MONTHS")
	private int validMonths;

}
