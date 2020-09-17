package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;

public class ItemsDAOTest {

	private final ItemsDAO DAO = new ItemsDAO();

	@Before
	public void setup() {
		DBUtils.connect("src/test/resources/db.properties");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Items created = new Items((long)21,"strawberry","drink",(float) 2.5);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Items> expected = new ArrayList<>();
		expected.add(new Items((long) 22, "strawberry", "drink",(float) 2.5));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Items((long) 22, "strawberry", "drink",(float) 2.5), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 24;
		assertEquals(new Items(ID, "blackcurrent", "drink",(float) 2.5), DAO.readItem(ID));
	}

	@Test
	public void testUpdate() {
		final Items updated = new Items((long) 25, "peach", "drink",(float) 2.5);
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}