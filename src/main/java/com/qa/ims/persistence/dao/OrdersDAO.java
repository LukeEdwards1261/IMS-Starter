package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrdersDAO implements Dao<Orders> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	private ItemsDAO itemDao;
	private CustomerDAO customerDao;
	
	public OrdersDAO(ItemsDAO itemDao, CustomerDAO customerDao) {
		super();
		this.itemDao = itemDao;
		this.customerDao = customerDao;
	}

	@Override
	public Orders modelFromResultSet (ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("order_id");
		Customer customer = customerDao.readCustomer((resultSet.getLong("customer_id")));
		List<Items> items = getItems(orderId);
		return new Orders(orderId, customer, items);
	}
	
//	get price print out: select orderitems.orderitems_id, orderitems.order_id, orderitems.product_id, items.product_name, items.product_type, items.product_price from orderitems,items where orderitems.product_id = items.product_id;

	@Override
	public List<Orders> readAll() {
		List<Orders> orders = new ArrayList<>();
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from orders");){
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return orders;
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
				PreparedStatement statement = connection.prepareStatement("INSERT INTO orders(customer_id) VALUES (?)");) {
			statement.setLong(1, orders.getCust().getId());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public Orders readOrder(Long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from orders where order_id =" + orderId);) {
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
				statement.executeUpdate("update orders set customer_id ='" + orders.getCust().getId() + "' where order_id =" + orders.getOrderId()); //THIS IS WHERE THE ERROR IS
				return readOrder(orders.getOrderId());
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
	
	
	public Orders add(Long order_id, Long product_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("INSERT INTO orderitems(order_id,product_id) values ('" + order_id + "','" + product_id + "')");
			
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return readOrder(order_id);
		
	}
	
	public Orders remove(Long order_id, Long product_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from orderitems where order_id = '" + order_id + "' and '" + product_id + "')");
			
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return readOrder(order_id);
	
	}

	public List<Items> getItems(Long orderId){
		List<Long> itemIds = new ArrayList<>();
		try(Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from orderitems where order_id = " + orderId);
		){
			while (resultSet.next()) {
				itemIds.add(resultSet.getLong("product_id"));
			}
		} catch(SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return itemIds.stream().map(this.itemDao::readItem).collect(Collectors.toList());
	}
	
}
