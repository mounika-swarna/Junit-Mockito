package com.junit.order.dao;
import java.sql.SQLException;

import com.junit.order.dto.Order;


public interface OrderDAO {
	int create(Order order)throws SQLException;

	
	

}
