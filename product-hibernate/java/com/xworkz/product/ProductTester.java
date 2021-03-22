package com.xworkz.product;

import java.util.List;

import com.xworkz.product.dao.ProductDAO;
import com.xworkz.product.dao.ProductDAOImpl;
import com.xworkz.product.entity.ProductEntity;
import com.xworkz.product.entity.ProductEntity.ProductType;

public class ProductTester {

	public static void main(String[] args) {
		
		
		
		ProductEntity entity=new ProductEntity("Speaker", ProductType.ELECTRONIC, 8000, 2, true, "Philiphs","Philiphs");
		
		ProductEntity entity1=new ProductEntity("Shoe", ProductType.FASHION, 1500, 1, true, "Puma","Footware");
		
		ProductEntity entity2=new ProductEntity("Furniture", ProductType.HOME_APPLIANCES, 6500, 1, false,"Bagmar", "Sakshi Furnitures");
		
		ProductDAO dao=new ProductDAOImpl();
		//dao.persist(entity1);
		//dao.persist(entity);
		//dao.persist(entity2);
		
	//	ProductEntity ent=dao.findByNameAndManufacturer("Speaker", "Philiphs");
	//	System.out.println(ent);
		
	//	ProductEntity prod=dao.findByTypeAndBrandAndName("Speaker", "Philiphs", ProductType.ELECTRONIC);
	//	System.out.println(prod);
		
    //    Double dd=dao.findPriceByTypeAndBrandAndName("Speaker", "Philiphs", ProductType.ELECTRONIC);
    //    System.out.println(dd);
        
        Object[] price=dao.findPriceAndQuantityByTypeAndBrandAndName("Speaker", "Philiphs", ProductType.ELECTRONIC);
        System.out.println(price.length);
        System.out.println(price[0]);
        System.out.println(price[1]);
        
        ProductEntity ent=dao.findByTypeAndBrandAndQuality("Speaker", "Philiphs", true);
        System.out.println(ent);
        
        
        Object[] obj=dao.findNameAndTypeById(3);
        System.out.println(obj[0]);
        System.out.println(obj[1]);
        
        int max=dao.findMaxId();
        System.out.println(max);
        
        double pr=dao.findMaxPrice();
        System.out.println(pr);
        
        double prc=dao.findSumOfPrice();
        System.out.println(prc);
        
        int min=dao.findMinId();
        System.out.println(min);
        
        long size=dao.findSize();
        System.out.println(size);
        
        
        List<ProductEntity> obje=dao.findDistinct();
        System.out.println(obje);
	}

}
