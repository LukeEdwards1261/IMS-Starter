package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrdersDAO implements Dao<Orders> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public Orders modelFromResultSet (ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("order_id");
		Long customerId = resultSet.getLong("customer_id");
		Long orderedProduct = resultSet.getLong("ordered_products");
		Long productQuantity = resultSet.getLong("product_quantity");
		return new Orders(orderId, customerId, orderedProduct, productQuantity);
	}

	@Override
	public List<Orders> readAll() {
		
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from orders");) {
			List<Orders> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	
	public Orders readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Orders create(Orders orders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("INSERT INTO orders(customer_id, ordered_products, product_quantity) values('" + orders.getCustomer_id()
					+ "','" + orders.getOrdered_products() + "','" + orders.getProduct_quantity() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public Orders readOrder(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders where order_id = " + id);) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Orders update(Orders orders) {
			try (Connection connection = DBUtils.getInstance().getConnection();
					Statement statement = connection.createStatement();) {
				statement.executeUpdate("update orders set customer_id ='" + orders.getCustomer_id() + "', ordered_products ='"
						+ orders.getOrdered_products() +  "', product_quantity ='" + orders.getProduct_quantity() + "' where order_id =" + orders.getOrder_id());
				return readOrder(orders.getOrder_id());
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
			return statement.executeUpdate("delete from orders where order_id = " + id);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

}
