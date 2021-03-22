package com.xworkz.bbc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "bbc")
public class BBCEntity {
	@Id
	@Column(name = "ID")
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "SEASON")
	private int season;
	@Column(name = "TYPE_OF_CONTESTENT")
	private String typeOfContestent;
	@Column(name = "DAYS_IN")
	private int daysIn;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "NO_OF_TASKS")
	private int noOfTasks;

}
