package application;

import java.util.Date;
import java.util.List;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDAO;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDAO sellerDao = DaoFactory.createSellerDao();
		DepartmentDAO departmentDao = DaoFactory.createDepartmentDao();

		System.out.println();
		System.out.println("=== TEST 1: Department insert ===");
		Department newDep = new Department("Fashion");
		departmentDao.insert(newDep);
		Department newDepBD = departmentDao.findById(newDep.getId());
		System.out.println(newDepBD);

		System.out.println();
		System.out.println("=== TEST 2: Department findById ===");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);

		System.out.println();
		System.out.println("=== TEST 3: Department findAll ===");
		List<Department> depList = departmentDao.findAll();
		depList.forEach(System.out::println);

		System.out.println();
		System.out.println("=== TEST 4: Department update ===");
		Department upDep = departmentDao.findById(4);
		departmentDao.update(upDep);
		System.out.println(departmentDao.findById(upDep.getId()));

		System.out.println();
		System.out.println("=== TEST 5: Department delete ===");
		List<Department> depBefore = departmentDao.findAll();
		departmentDao.deleteById(6);
		List<Department> depAfter = departmentDao.findAll();
		System.out.println("Length before: " + depBefore.size() + " - Length now: " + depAfter.size());
		System.out.println("Delet completed");

		System.out.println();
		System.out.println("=== TEST 1: Seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println();
		System.out.println("=== TEST 2: Seller findByDepartment ===");
		List<Seller> sellerListByDepartment = sellerDao.findByDepartment(newDep);
		sellerListByDepartment.forEach(System.out::println);

		System.out.println();
		System.out.println("=== TEST 3: Seller findByDepartment ===");
		List<Seller> sellerListfinAll = sellerDao.findAll();
		sellerListfinAll.forEach(System.out::println);

		System.out.println();
		System.out.println("=== TEST 4: Seller Insert ===");
		Seller newSeller = new Seller(null, "Kelly Maria", "KM@mail", new Date(), 4000.0, newDep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());

		System.out.println();
		System.out.println("=== TEST 5: Seller update ===");
		Seller updateSeller = sellerDao.findById(1);
		System.out.println("Before: " + updateSeller.toString());
		updateSeller.setName("Bob Brown");
		sellerDao.update(updateSeller);
		System.out.println("Then: " + updateSeller.toString());

		System.out.println();
		System.out.println("=== TEST 6: Seller delete ===");
		List<Seller> sellerListfinAllBefore = sellerDao.findAll();
		sellerDao.deleteById(11);
		List<Seller> sellerListfinAllAfter = sellerDao.findAll();
		System.out.println(
				"Length before: " + sellerListfinAllBefore.size() + " - Length now: " + sellerListfinAllAfter.size());
		System.out.println("Delet completed");

		System.out.println();
		DB.CloseConnection();
	}

}
