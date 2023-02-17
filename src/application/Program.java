package application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Department dept = new Department(1, "Books");
		System.out.println(dept);
		
		Seller seller = new Seller(1, "Gustavo", "l@gmail.com", new Date(), 4000.0, dept);
		System.out.println(seller);
	}

}
