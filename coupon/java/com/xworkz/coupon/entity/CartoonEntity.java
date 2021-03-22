package com.xworkz.coupon.entity;


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
@NoArgsConstructor
@ToString
@Entity
@Table(name = "cartoons")

public class CartoonEntity {
	
	
	@Id
	@Column(name = "CID")
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")

	private int cid;
	@Column(name = "NAME")
	private String name;
	@Column(name = "SHOW_NAME")
	private String show_name;
	@Enumerated(EnumType.STRING)
	@Column(name = "CHANNEL_NAME")
	public Channel channel;

	@Column(name = "LANGUAGE")
	private String language;

	public enum Channel {

		CN, POGO,HUNGMA,NICK,DISNEY,CHINTU;
	}

	public CartoonEntity(String name, String show_name, Channel channel, String language) {
		super();
		this.name = name;
		this.show_name = show_name;
		this.channel = channel;
		this.language = language;
	}
	

}
