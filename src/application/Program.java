package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("---- Test -> Find by Id ----");
		Seller seller = sellerDao.findById(2);
		System.out.println(seller);
		
		System.out.println();
		
		System.out.println("---- Test -> Find by Department ----");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller x : list) {
			System.out.println(x);
		}
		
		System.out.println();
		
		System.out.println("---- Test -> Find All ----");
		List<Seller> list2 = sellerDao.findAll();
		for(Seller x : list2) {
			System.out.println(x);
		}
	}

}
