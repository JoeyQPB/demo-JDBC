package application;

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

		DB.CloseConnection();
	}

}
