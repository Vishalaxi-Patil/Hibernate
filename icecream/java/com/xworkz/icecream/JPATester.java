package com.xworkz.icecream;

import java.util.List;

import com.xworkz.icecream.entity.IceCreamEntity;
import com.xworkz.icecream.entity.IceCreamEntity.Color;
import com.xworkz.icecream.entity.IceCreamEntity.Flavour;
import com.xworkz.icecream.repository.IceCreamRepository;
import com.xworkz.icecream.repository.IceCreamRepositoryImpl;

public class JPATester {

	public static void main(String[] args) {
		
		IceCreamEntity entity=new IceCreamEntity();
		entity.setId(1);
		entity.setName("Honey Moon");
		entity.setCompany("Baskin Robin");
		entity.setFlavour(Flavour.MIXED);
		entity.setColor(Color.MIXED);
		entity.setPrice(300);
		
		IceCreamEntity entity1=new IceCreamEntity();
		entity1.setId(2);
		entity1.setName("Chacobar");
		entity1.setCompany("Amul");
		entity1.setFlavour(Flavour.CHOCOLATE);
		entity1.setColor(Color.BROWN);
		entity1.setPrice(10);
		
		IceCreamEntity entity2=new IceCreamEntity();
		entity2.setId(3);
		entity2.setName("Gadbad");
		entity2.setCompany("Amul");
		entity2.setFlavour(Flavour.MIXED);
		entity2.setColor(Color.PINK);
		entity2.setPrice(40);
		
		IceCreamEntity entity3=new IceCreamEntity();
		entity3.setId(4);
		entity3.setName("Gadbad");
		entity3.setCompany("Amul");
		entity3.setFlavour(Flavour.MIXED);
		entity3.setColor(Color.PINK);
		entity3.setPrice(40);
		
		IceCreamEntity entity4=new IceCreamEntity();
		entity4.setId(5);
		entity4.setName("Blue Moon");
		entity4.setCompany("Hudso");
		entity4.setFlavour(Flavour.PISTA);
		entity4.setColor(Color.BLUE);
		entity4.setPrice(300);
		
		IceCreamEntity entity5=new IceCreamEntity();
		entity5.setId(6);
		entity5.setName("Chocolate Chip");
		entity5.setCompany("Haagen Dazs");
		entity5.setFlavour(Flavour.VENILLA);
		entity5.setColor(Color.BROWN);
		entity5.setPrice(230);
		
		IceCreamRepository repository=new IceCreamRepositoryImpl();
		//repository.persist(entity);
		//repository.persist(entity1);
        //repository.persist(entity2);
		//repository.persist(entity3);
		//repository.persist(entity4);
		repository.persist(entity5);
		
		
		
		
		//repository.deleteByName("Gadbad");
		
		//repository.updatePriceByName("Chacobar", 15);
		
//		List<IceCreamEntity> list=repository.getAll();
//		System.out.println(list);
//		
//		Object en=repository.findByNameAndPrice("Honey Moon", 300);
//		System.out.println(en);
//		
		
		Object max=repository.getMaxPrice();
		System.out.println(max);
		
		Object min=repository.getMinPrice();
		System.out.println(min);
		
		Object sum=repository.getBySumPrice();
		System.out.println(sum);
		
		Object ob=repository.getPriceByName("Honey Moon");
		System.out.println("price of Honey Moon icecream "+ob);
		
		List<Object[]> price=repository.getNameAndFlavourByPrice(300);
		System.out.println(price);
		

	}

}
