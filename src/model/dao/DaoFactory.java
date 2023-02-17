package model.dao;

import model.dao.impl.SellerDaoJDBC;
import model.entities.DBConnections;

public class DaoFactory {
	
	public static SellerDao createSellerDao(){
		return new SellerDaoJDBC(DBConnections.getConnection());
	}
}
