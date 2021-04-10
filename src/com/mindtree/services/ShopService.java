package com.mindtree.services;

import com.mindtree.model.Shop;

public interface ShopService {
	void addShops(Shop shop);

	void searchById();

	void displayShops();

	void deleteShop();

}
