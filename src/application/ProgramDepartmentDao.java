package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramDepartmentDao {

	public static void main(String[] args) {
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		/*System.out.println("--- Test -> Insert ---");
		Department newDep = new Department(null, "Books");
		departmentDao.insert(newDep);*/
		
		System.out.println("--- Test -> Find by Id ---");
		Department dep = departmentDao.findById(2);
		System.out.println(dep);
		
		System.out.println();
		
		System.out.println("--- Test -> Update ---");
		dep = departmentDao.findById(4);
		dep.setName("Phones");
		departmentDao.update(dep);
		
		System.out.println("--- Test -> Delete ---");
		departmentDao.deleteBtId(5);
		
		System.out.println();
		
		System.out.println("---- Test -> Find All ----");
		List<Department> list = departmentDao.findAll();
		for(Department x : list) {
			System.out.println(x);
		}
	}

}
