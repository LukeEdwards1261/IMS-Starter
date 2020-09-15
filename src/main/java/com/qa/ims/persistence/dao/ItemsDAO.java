package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;

public class ItemsDAO implements Dao<Items> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public Items modelFromResultSet (ResultSet resultSet) throws SQLException {
		Long productId = resultSet.getLong("product_id");
		String productName = resultSet.getString("product_name");
		String productType = resultSet.getString("product_type");
		float productPrice = resultSet.getFloat("product_price");
		return new Items(productId, productName, productType, productPrice);
	}

	@Override
	public List<Items> readAll() {
		
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from items");) {
			List<Items> items = new ArrayList<>();
			while (resultSet.next()) {
				items.add(modelFromResultSet(resultSet));
			}
			return items;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	
	public Items readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items ORDER BY product_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Items create(Items items) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("INSERT INTO items(product_name, product_type, product_price) values('" + items.getProduct_name()
					+ "','" + items.getProduct_type() + "','" + items.getProduct_price() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public Items readItem(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items where product_id = " + id);) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Items update(Items items) {
			try (Connection connection = DBUtils.getInstance().getConnection();
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("update items set product_name ='" + items.getProduct_name() + "', product_type ='"
						+ items.getProduct_type() +  "', product_price ='" + items.getProduct_price() + "' where product_id =" + items.getProduct_id());
				return readItem(items.getProduct_id());
			} catch (Exception e) {
				LOGGER.debug(e);
				LOGGER.error(e.getMessage());
			}
			return null;
		
	}

	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			return statement.executeUpdate("delete from items where product_id = " + id);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	

}
