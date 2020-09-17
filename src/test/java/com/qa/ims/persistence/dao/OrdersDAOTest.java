package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrdersDAOTest {
	
	private ItemsDAO itemDao;
	private CustomerDAO customerDao;
	private Customer customer;
	private List<Items> items = new ArrayList<>();

	private final OrdersDAO DAO = new OrdersDAO(itemDao , customerDao );

	@Before
	public void setup() {
		DBUtils.connect("src/test/resources/db.properties");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Orders created = new Orders(1);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Orders> expected = new ArrayList<>();
		expected.add(new Orders(1));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Orders((long) 1, customer, items), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1;
		assertEquals(new Orders(ID, customer, items), DAO.readOrder(ID));
	}

	@Test
	public void testUpdate() {
		final Orders updated = new Orders((long) 1, customer, items);
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}