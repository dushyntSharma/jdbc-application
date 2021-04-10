package com.mindtree.client;

import java.util.Scanner;
import com.mindtree.model.Shop;
import com.mindtree.services.ShopService;
import com.mindtree.services.ShopServiceImpl;

public class ShopApp {
	static Scanner sc = new Scanner(System.in);
	static private ShopService service = new ShopServiceImpl();

	public static void main(String[] args) {
		boolean flag = true;
		int choice = 0;
		do {
			displayMenu();
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				addShops();
				break;
			case 2:
				searchById();
				break;
			case 3:
				displayShops();
				break;
			case 4:
				deleteShop();
				break;

			default:
				System.out.println("Invalid choice!!");
				break;
			}

		} while (flag == false);
	}

	private static void deleteShop() {
		// TODO Auto-generated method stub
		try {
			service.deleteShop();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

	private static void displayShops() {
		// TODO Auto-generated method stub
		try {
			service.displayShops();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static void searchById() {
		// TODO Auto-generated method stub
		try {
			service.searchById();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void addShops() {
		// TODO Auto-generated method stub
		System.out.println("Enter the id");
		int id = sc.nextInt();
		System.out.println("Enter the name");
		String name = sc.next();
		sc.nextLine();
		System.out.println("Enter the address");
		String address = sc.nextLine();
		Shop shop = new Shop(id, name, address);
		try {
			service.addShops(shop);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void displayMenu() {
		// TODO Auto-generated method stub
		System.out.println("1.Add shops");
		System.out.println("2.Search Shop by ID");
		System.out.println("3.Display Shops");
		System.out.println("4.Delete the shop");
		System.out.println();

	}

}
