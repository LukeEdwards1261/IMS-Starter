package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Items> {
	
	public static final Logger LOGGER = LogManager.getLogger();

	private ItemsDAO itemsDAO;
	private Utils utils;

	public ItemController(ItemsDAO itemsDAO, Utils utils) {
		super();
		this.itemsDAO = itemsDAO;
		this.utils = utils;
	}

	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Items> readAll() {
		List<Items> items = itemsDAO.readAll();
		for (Items item : items) {
			LOGGER.info(item.toString());
		}
		return items;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Items create() {
		LOGGER.info("Please enter a product name");
		String productName = utils.getString();
		LOGGER.info("Please enter product type");
		String productType = utils.getString();
		LOGGER.info("Please enter product price");
		float productPrice = utils.getFloat();
		Items item = itemsDAO.create(new Items(productName, productType, productPrice));
		LOGGER.info("Product created");
		return item;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Items update() {
		LOGGER.info("Please enter the id of the product you would like to update");
		Long productId = utils.getLong();
		LOGGER.info("Please enter a new product name");
		String productName = utils.getString();
		LOGGER.info("Please enter a product type");
		String productType = utils.getString();
		LOGGER.info("Please enter a new product price");
		float productPrice = utils.getFloat();
		Items item = itemsDAO.update(new Items(productId, productName, productType, productPrice));
		LOGGER.info("Product Updated");
		return item;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the product you would like to delete");
		Long productId = utils.getLong();
		LOGGER.info("Product deleted");
		return itemsDAO.delete(productId);
	}

}
