package com.xworkz.coupon;

import java.util.ArrayList;
import java.util.List;

import com.xworkz.coupon.dao.CouponDAO;
import com.xworkz.coupon.dao.CouponDAOImpl;
import com.xworkz.coupon.entity.CouponEntity;

public class CouponTester {

	public static void main(String[] args) {
		CouponEntity entity = new CouponEntity();
		entity.setCode("AJIO234");
		entity.setName("Offer");
		entity.setTypeOfCoupon("Dress");
		entity.setValidMonths(3);

		CouponEntity entity1 = new CouponEntity();
		entity1.setCode("MARTO245");
		entity1.setName("GROCERY");
		entity1.setTypeOfCoupon("Super Market");
		entity1.setValidMonths(1);

		CouponEntity entity2 = new CouponEntity();
		entity2.setCode("Bazar4563");
		entity2.setName("Sweets");
		entity2.setTypeOfCoupon("BIG BAZAR");
		entity2.setValidMonths(4);

		List<CouponEntity> lists = new ArrayList<CouponEntity>();
		lists.add(entity);
		lists.add(entity1);
		lists.add(entity2);

		CouponDAO dao = new CouponDAOImpl();
		dao.create(entity);

		dao.updateValidMonthsById(2, 5);

		dao.deleteById(3);

		dao.getById(2);

		dao.createAll(lists);
	}

}
