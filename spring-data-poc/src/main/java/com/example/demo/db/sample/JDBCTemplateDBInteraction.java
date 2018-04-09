package com.example.demo.db.sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Component;

@Component(value = "JDBC")
public class JDBCTemplateDBInteraction implements VehicleDao {

	DataSource dataSource;
	JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		// as a best practice jdbcTemplate object is initialized inside setter method
		// so that it happens after dataSource has been initialized

		// jdbcTemplate is a thread-safe class
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void update(Vehicle vehicle) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(final Vehicle vehicle) {

		// option - 1 : in following implementation, prepared statement had to be
		// created and parameterized
		// jdbcTemplate.update(new PreparedStatementCreator() {
		//
		// @Override
		// public PreparedStatement createPreparedStatement(Connection conn) throws
		// SQLException {
		//
		// // construct string
		// String str = "INSERT INTO VEHICLE " + "(VEHICLE_NO, COLOR, WHEEL, SEAT) " +
		// "VALUES (?, ?, ?, ?)";
		//
		// // create prepared statement
		// PreparedStatement preparedStatement = conn.prepareStatement(str);
		// preparedStatement.setString(1, vehicle.getVehicleNo());
		// preparedStatement.setString(2, vehicle.getColor());
		// preparedStatement.setInt(3, vehicle.getWheel());
		// preparedStatement.setInt(4, vehicle.getSeat());
		//
		// return preparedStatement;
		// }
		// });

		// option - 2 : in the following implementation, preparedStatement is already
		// created, all we need to do is set the values

		// jdbcTemplate.update("INSERT INTO VEHICLE " + "(VEHICLE_NO, COLOR, WHEEL,
		// SEAT) " + "VALUES (?, ?, ?, ?)",
		// new PreparedStatementSetter() {
		//
		// @Override
		// public void setValues(PreparedStatement preparedStatement) throws
		// SQLException {
		// preparedStatement.setString(1, vehicle.getVehicleNo());
		// preparedStatement.setString(2, vehicle.getColor());
		// preparedStatement.setInt(3, vehicle.getWheel());
		// preparedStatement.setInt(4, vehicle.getSeat());
		//
		// }
		// });

		// option - 3 :

		String insertStr = "INSERT INTO VEHICLE " + "(VEHICLE_NO, COLOR, WHEEL, SEAT) " + "VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(insertStr, vehicle.getVehicleNo(), vehicle.getColor(), vehicle.getWheel(),
				vehicle.getSeat());

	}

	@Override
	public void delete(Vehicle vehicle) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vehicle findByVehicleNo(String vehicleNo) {
		// TODO Auto-generated method stub
		return null;
	}

	// example - 1:
	@Override
	public int countVehicle() {
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM VEHICLE", Integer.class);

	}

	// example - executing statement
	
	
	
	
	// exmaple - updating database
	// example - running query
	// example - MappingSqlQuery
	// exmaple - SimpleJdbcInsert
	// example - SqlUpdate
	// exmaple - SqlQuery
	// example - NamedParameterJdbcTemplate
	
	
	
}
