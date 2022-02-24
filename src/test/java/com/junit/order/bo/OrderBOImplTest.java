package com.junit.order.bo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.junit.order.bo.exception.BOException;
import com.junit.order.dao.OrderDAOImpl;
import com.junit.order.dto.Order;

public class OrderBOImplTest {

	@Mock
	OrderDAOImpl dao;
	private OrderBOImpl bo;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		bo = new OrderBOImpl();
		bo.setDao(dao);
	}

	@Test
	public void placeOrder_Should_Create_An_Order() throws SQLException, BOException {

		Order order = new Order();
		when(dao.create(any(Order.class))).thenReturn(Integer.valueOf(1));
		boolean result = bo.placeOrder(order);

		assertTrue(result);
		verify(dao, atLeast(1)).create(order);

	}

	@Test
	public void placeOrder_Should_not_Create_An_Order() throws SQLException, BOException {
		Order order = new Order();
		boolean result = bo.placeOrder(order);

		assertFalse(result);
		verify(dao).create(order);

	}

	@Test(expected = BOException.class)
	public void placeOrder_Should_Throw_BOException() throws SQLException, BOException {
		Order order = new Order();
		when(dao.create(any(Order.class))).thenThrow(SQLException.class);
		boolean result = bo.placeOrder(order);

	}

	}


