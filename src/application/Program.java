package application;

import java.util.Date;
import java.util.List;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDAO sellerDao = DaoFactory.createSellerDao();

		System.out.println();
		System.out.println("=== TEST 1: Seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println();
		System.out.println("=== TEST 2: Seller findByDepartment ===");
		List<Seller> sellerListByDepartment = sellerDao.findByDepartment(new Department(2, null));
		sellerListByDepartment.forEach(System.out::println);

		System.out.println();
		System.out.println("=== TEST 3: Seller findByDepartment ===");
		List<Seller> sellerListfinAll = sellerDao.findAll();
		sellerListfinAll.forEach(System.out::println);

		System.out.println();
		System.out.println("=== TEST 4: Seller Insert ===");
		Seller newSeller = new Seller(null, "Kelly Maria", "KM@mail", new Date(), 4000.0, new Department(2, null));
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());

		System.out.println();
		DB.CloseConnection();
	}

}
