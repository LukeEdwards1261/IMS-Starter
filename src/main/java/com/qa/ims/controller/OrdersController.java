package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

public class OrdersController implements CrudController<Orders> {
	
	public static final Logger LOGGER = LogManager.getLogger();

	private OrdersDAO ordersDAO;
	private Utils utils;

	public OrdersController(OrdersDAO ordersDAO, Utils utils) {
		super();
		this.ordersDAO = ordersDAO;
		this.utils = utils;
	}
	
	
	@Override
	public List<Orders> readAll() {
		List<Orders> orders = ordersDAO.readAll();
		for (Orders order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Orders create() {
		LOGGER.info("Please enter the customer id of the customer placing the order");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter the product id you would like to order");
		Long orderProducts = utils.getLong();
		LOGGER.info("Please enter quantity");
		Long productQuantity = utils.getLong();
		Orders order = ordersDAO.create(new Orders(orderId, orderProducts, productQuantity));
		LOGGER.info("Order created");
		return order;
	}

	/**
	 * Updates an existing customer by taking in user input. UP TO HERE
	 */
	@Override
	public Orders update() {
		LOGGER.info("Please enter the order id of the order you would like to update");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter the new product ID that you would like to order");
		Long productId = utils.getLong();
		LOGGER.info("Please enter the quantity you would like of that product");
		Long quantity = utils.getLong();
		Orders order = ordersDAO.update(new Orders(orderId, productId, quantity));
		LOGGER.info("Order Updated");
		return order;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long orderId = utils.getLong();
		LOGGER.info("Order deleted");
		return ordersDAO.delete(orderId);
	}

}
