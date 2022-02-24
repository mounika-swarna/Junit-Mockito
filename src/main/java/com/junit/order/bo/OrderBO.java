package com.junit.order.bo;

import com.junit.order.bo.exception.BOException;
import com.junit.order.dto.Order;

public interface OrderBO {

	boolean placeOrder(Order order) throws BOException;


}
