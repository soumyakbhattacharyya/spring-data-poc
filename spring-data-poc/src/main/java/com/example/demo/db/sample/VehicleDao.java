package com.example.demo.db.sample;

// a simple interface that is used to interact with database
public interface VehicleDao {
	public void insert(Vehicle vehicle);

	public void update(Vehicle vehicle);

	public void delete(Vehicle vehicle);

	public Vehicle findByVehicleNo(String vehicleNo);
}