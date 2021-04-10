package com.mindtree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mindtree.model.Shop;
import com.mindtree.utility.DBUtil;

public class ShopDaoImpl implements ShopDao {
	static Scanner sc = new Scanner(System.in);

	@Override
	public void addShops(Shop shop) {
		// TODO Auto-generated method stub
		Statement st = null;
		Connection con = DBUtil.getConnection();
		String sql = "INSERT INTO shop(id,name,address) VALUES(" + shop.getId() + ",'" + shop.getName() + "','"
				+ shop.getAddress() + "');";
		try {
			st = con.createStatement();
			st.execute(sql);
			System.out.println("Inserted Successfully...");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		finally {
			try {
				st.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

	}

	@Override
	public void searchById() {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet res = null;
		System.out.println("Enter the Id you need to search?");
		long id = sc.nextInt();
		String sql = "SELECT * FROM shop where id = ?;";
		try {
			st = con.prepareStatement(sql);
			st.setInt(1, (int) id);
			res = st.executeQuery();
			while (res.next()) {
				System.out.println("ID : " + res.getInt(1));
				System.out.println("Name : " + res.getString(2));
				System.out.println("Address : " + res.getString(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void displayShops() {
		// TODO Auto-generated method stub
		Statement st = null;
		Connection con = DBUtil.getConnection();
		ResultSet res = null;
		String sql = "SELECT * FROM shop";
		try {
			st = con.createStatement();
			System.out.println("The recors in the table are :");
			res = st.executeQuery(sql);
			while (res.next()) {
				System.out.println("ID : " + res.getInt(1));
				System.out.println("Name : " + res.getString(2));
				System.out.println("Address : " + res.getString(3));
				System.out.println("============================");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			try {
				res.close();
				st.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2.getMessage());
			}
		}

	}

	@Override
	public void deleteShop() {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		PreparedStatement st = null;
		int res = 0;
		System.out.println("Enter the ID you want to delete");
		long id = sc.nextLong();
		String sql = "DELETE FROM shop WHERE ID = ?;";

		try {
			st = con.prepareStatement(sql);
			st.setInt(1, (int) id);
			res = st.executeUpdate();
			System.out.println("Id with '" + id + "' was deleted");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			try {
				st.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2.getMessage());
			}
		}

	}

//	public void addShops(Shop shop) {
//		Connection con = DBUtil.getConnection();
//		PreparedStatement p = null;
//		String sql = "INSERT INTO shop VALUES(?,?,?);";
//		try {
//			p = con.prepareStatement(sql);
//			p.setInt(0, 4);
//			p.setString(1, "Vignesh");
//			p.setString(3, "Pune");
//			p.execute(sql);
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//		}
//	}

}
