package com.mindtree.dao;

import com.mindtree.model.Shop;

public interface ShopDao {

	void addShops(Shop shop);

	void searchById();

	void displayShops();

	void deleteShop();
	

}
