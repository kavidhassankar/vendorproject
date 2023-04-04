package com.vendorspringboot.vendorboot.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.vendorspringboot.vendorboot.DTO.Vendor;

@Repository
public class VendorRepository {

	private Connection connection;

	public Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		connection = DriverManager.getConnection("jdbc:mysql://101.53.155.156:3306/mysql_demo_tnj", "mysql_demo_tnj",
				"Ebrain@20");

		return connection;

	}

	public void save(Vendor vendor) throws ClassNotFoundException, SQLException {

		Connection connection = getConnection();

		PreparedStatement preparedStatement = connection
				.prepareStatement("insert into tb_kavidhass_vendor values(?,?,?,?,?)");

		preparedStatement.setInt(1, vendor.getId());
		preparedStatement.setString(2, vendor.getName());
		preparedStatement.setString(3, vendor.getEmail());
		preparedStatement.setString(4, vendor.getAddress());
		preparedStatement.setString(5, vendor.getMobile());

		preparedStatement.executeUpdate();
	}

	public List<Vendor> getAll() throws ClassNotFoundException, SQLException {

		Connection connection = getConnection();

		String selectQuery = "select * from tb_kavidhass_vendor";

		PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

		ResultSet resultSet = preparedStatement.executeQuery();

		List<Vendor> obj = new ArrayList<Vendor>();

		Vendor vendor = null;

		while (resultSet.next()) {

			vendor = new Vendor();

			vendor.setId(resultSet.getInt(1));
			vendor.setName(resultSet.getString(2));
			vendor.setEmail(resultSet.getString(3));
			vendor.setMobile(resultSet.getString(4));
			vendor.setAddress(resultSet.getString(5));

			obj.add(vendor);

		}
		return obj;
	}

	public List<Vendor> findById(int id) throws ClassNotFoundException, SQLException {

		Connection connection = getConnection();

		String selectId = " select * from tb_kavidhass_vendor where id='" + id + "'";

		PreparedStatement preparedStatement = connection.prepareStatement(selectId);

		ResultSet resultSet = preparedStatement.executeQuery();

		List<Vendor> dd = new ArrayList<Vendor>();

		Vendor ug = null;

		while (resultSet.next()) {
			ug = new Vendor();
			ug.setId(resultSet.getInt(1));
			ug.setName(resultSet.getString(2));
			ug.setEmail(resultSet.getString(3));
			ug.setMobile(resultSet.getString(4));
			ug.setAddress(resultSet.getString(5));

			dd.add(ug);
		}

		return dd;
	}

	public void update(Vendor vendor) throws ClassNotFoundException, SQLException {

		Connection connection = getConnection();
		String update = "update tb_kavidhass_vendor set vendor_name=?,vendor_email=?,vendor_mobile=?,vendor_address=? where id=?";

		PreparedStatement preparedStatement = connection.prepareStatement(update);

		preparedStatement.setString(1, vendor.getName());
		preparedStatement.setString(2, vendor.getEmail());
		preparedStatement.setString(3, vendor.getMobile());
		preparedStatement.setString(4, vendor.getAddress());
		preparedStatement.setInt(5, vendor.getId());
		preparedStatement.executeUpdate();
	}

	public void deleteById(Vendor vendor) throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();

		String delete = "delete from tb_kavidhass_vendor where id=?";

		PreparedStatement preparedStatement = connection.prepareStatement(delete);

		preparedStatement.setInt(1, vendor.getId());

		preparedStatement.executeUpdate();

		preparedStatement.close();

		connection.close();

	}

}
