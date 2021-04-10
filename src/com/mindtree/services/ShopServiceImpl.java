package com.mindtree.services;

import com.mindtree.dao.ShopDao;
import com.mindtree.dao.ShopDaoImpl;
import com.mindtree.model.Shop;

public class ShopServiceImpl implements ShopService {
	private ShopDao dao = new ShopDaoImpl();

	@Override
	public void addShops(Shop shop) {
		// TODO Auto-generated method stub
		try {
			dao.addShops(shop);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void searchById() {
		// TODO Auto-generated method stub
		try {
			dao.searchById();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void displayShops() {
		// TODO Auto-generated method stub
		try {
			dao.displayShops();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void deleteShop() {
		// TODO Auto-generated method stub
		try {
			dao.deleteShop();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
