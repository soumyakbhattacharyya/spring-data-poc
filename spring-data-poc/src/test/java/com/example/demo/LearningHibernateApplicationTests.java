package com.example.demo;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.db.sample.Vehicle;
import com.example.demo.db.sample.VehicleDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearningHibernateApplicationTests {

	@Autowired
	@Qualifier("JDBC")
	private VehicleDao dao;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testInsertion() {

		dao.insert(new Vehicle(UUID.randomUUID().toString().substring(1, 3), "red", 1, 1));
	}

	@Test
	public void testFinder() {

		dao.findByVehicleNo("123");
		System.out.println("number of vehicle is : " + dao.countVehicle());
	}

}
