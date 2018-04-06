package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.db.sample.Vehicle;
import com.example.demo.db.sample.VehicleDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearningHibernateApplicationTests {

	@Autowired
	private VehicleDao dao;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testPersistence() {

		dao.insert(new Vehicle("123", "red", 1, 1));
	}

}
